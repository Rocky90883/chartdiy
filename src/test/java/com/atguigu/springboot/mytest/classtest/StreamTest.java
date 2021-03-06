package com.atguigu.springboot.mytest.classtest;

import com.atguigu.springboot.mytest.Bean.Employee;
import com.atguigu.springboot.mytest.common.Data.DataUtils;
import io.swagger.models.auth.In;
import org.jsoup.select.Collector;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) throws Exception{

        util();

    }


    public static void util() throws Exception{

        //1.1 使用Collection下的 stream() 和 parallelStream() 方法
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream(); //获取一个顺序流
        Stream<String> parallelStream = list.parallelStream(); //获取一个并行流


        //虚拟数据
        List<Employee> listemp = DataUtils.getListEmployee();
        listemp.forEach(System.out::println);

        //筛选
        List<Employee> collect = listemp.stream()
                .filter(u -> u.getAget() > 20 && u.getMoney() > 10000)
                .collect(Collectors.toList());

        //排序
        List<Employee> listsoremp = listemp.stream()
                .sorted((e1, e2) -> e2.getAget() - e1.getAget())    //倒序
                .collect(Collectors.toList());
        System.out.println(listsoremp);

        //多条件排序
        List<Employee> listsortsemp = listemp.stream()
                .sorted(Comparator.comparing(Employee::getAget)                         //正序
                .thenComparing(Comparator.comparing(Employee::getMoney).reversed()))    //倒序
                .collect(Collectors.toList());
        System.out.println(listsortsemp);



        //终端操作 anyMatch、allMatch、noneMatch

        boolean b = listemp.stream()
                .anyMatch(employee -> employee.getAget() > 30);         //其中含有 年龄大于30
        System.out.println(b);

        boolean b1 = listemp.stream()
                .allMatch(employee -> employee.getAget() > 5);          //所有的对象 年龄都大于5
        System.out.println(b1);

        boolean b2 = listemp.stream()
                .noneMatch(employee -> employee.getAget() > 100 || employee.getMoney()>90001);      //所有对象都  年龄大于100  或  金额大于90001
        System.out.println(b2);
        System.out.println(listemp.stream().filter(employee -> employee.getMoney() >= 90000).collect(Collectors.toList()).get(0));


        //查找
        Optional<Employee> first = listemp.stream().findFirst();          //查找第一个
        if (first.isPresent()){
            System.out.println(first.get());
        }

        Optional<String> any = list.stream().findAny();                    //返回任意一个
        if(any.isPresent()){
            System.out.println(any.get());
        }


        //归约
        System.out.println("归约");
        Optional<Integer> sum = listemp.stream().map(Employee::getAget).reduce((e1, e2) -> e1 + e2);    //年龄全加在一起
        if(sum.isPresent()){
            System.out.println(sum.get());
        }

        Optional<Integer> sum2 = listemp.stream().map(Employee::getAget).reduce(Integer::sum);          //年龄全加在一起
        sum2.ifPresent(System.out::println);

        Integer sumby30 = listemp.stream().map(Employee::getAget).reduce(30, Integer::sum);     //以30开始
        System.out.println(sumby30);

        Optional<String> strjoin = listemp.stream().map(Employee::getName).reduce((e1, e2) -> e1 +" "+ e2);
        strjoin.ifPresent(System.out::println);


        //比较后得出
        Optional<Integer> max = listemp.stream()
                .map(Employee::getAget)
                .max((i1, i2) -> i1 - i2);                  //内部比较出最大的
        max.ifPresent(System.out::println);

        Optional<Integer> min = listemp.stream()            //内部比较出最小的
                .map(u -> u.getAget())
                .min((u1, u2) -> u1 - u2);
        min.ifPresent(System.out::println);

        long count = listemp.stream()                       //t统计数目（没啥用）
                .count();
        System.out.println(count+listemp.size());



        //Collectors  
        //1.收集    转换    统计
        List<Employee> collect1 = listemp.stream()
                .collect(Collectors.toList());
        collect1.forEach(System.out::println);

        ArrayList<Employee> collect2 = listemp.stream()
                .collect(Collectors.toCollection(() -> new ArrayList<>()));             //指定转换
        System.out.println(collect);

        Map<String, Double> map = listemp.stream()
                .collect(Collectors.toMap(Employee::getName, Employee::getMoney));       //转map
                map.forEach((key,value) -> {
                    System.out.println(key + " " + value);
                });

        Double avgmoney = listemp.stream()
                .collect(Collectors.averagingDouble(Employee::getMoney));               //算平均工资
        System.out.println(avgmoney);

        DoubleSummaryStatistics summmoney = listemp.stream()                            //最大、最小、平均、总和、数目，全部统计
                .collect(Collectors.summarizingDouble(Employee::getMoney));
        System.out.println(summmoney);

        //2。分块     分组
        //分块
        Map<Boolean, List<Employee>> partitioning = listemp.stream()
                .collect(Collectors.partitioningBy(e -> e.getAget() > 20));             //把符合条件的与不符合条件的，分别用true和false区分，组成两个list，存放在Map中
        System.out.println(partitioning);
        System.out.println(partitioning.size());

        //分组 根据年龄
        Map<Integer, List<Employee>> group = listemp.stream()
                .collect(Collectors.groupingBy(Employee::getAget));
        System.out.println(group);

        //指定条件与类型分组
        Map<String, Set<Employee>> groupbymoney = listemp.stream()
                .collect(Collectors.groupingBy(e -> e.getMoney() > 20000 ? "有钱" : "没钱", Collectors.toSet()));
        System.out.println(groupbymoney);

        //三个参数的
        TreeMap<Integer, Set<Employee>> treeMap = listemp.stream()
                .collect(Collectors.groupingBy(Employee::getAget, TreeMap::new, Collectors.toSet()));
        System.out.println(treeMap);


        //Collectors的归约
        Optional<Employee> collectReducing = listemp.stream()
                .collect(Collectors.reducing((e1, e2) -> e1.getMoney() > e2.getMoney() ? e1 : e2));
        collectReducing.ifPresent(System.out::println);

        Employee compara = new Employee("比较名",99999,99999.0,new BigDecimal("23424"));
        Employee collect3 = listemp.stream()
                .collect(Collectors.reducing(compara, (e1, e2) -> e1.getMoney() > e2.getMoney() ? e1 : e2));        //传入一个对象进行比较
        System.out.println(collect3);

        //不知道有什么用
        Double collect4 = listemp.stream()
                .collect(Collectors.reducing(compara.getMoney(), Employee::getMoney, Double::sum));
        System.out.println(collect4);



        //基本类型的流
        IntStream intStream = IntStream.of(1, 2, 3, 4);
        intStream.forEach(System.out::println);

        System.out.println("- - - - - - - - - - - - -");
        IntStream range = IntStream.range(1, 10);                   //不含10
        range.forEach(System.out::println);

        System.out.println("- -  - - - - - - - - -");
        IntStream rangeClosed = IntStream.rangeClosed(1, 10);        //含10
        rangeClosed.forEach(System.out::println);

        System.out.println("- -  - - - - - - - - -");           
        DoubleStream doubleStream = listemp.stream()
                .mapToDouble(Employee::getMoney);
        doubleStream.forEach(System.out::println);

        System.out.println("- -  - - - - - - - - -");
        IntSummaryStatistics intSummaryStatistics = IntStream.rangeClosed(1, 10).summaryStatistics();
        System.out.println(intSummaryStatistics);

        System.out.println(IntStream.rangeClosed(1, 10).max().getAsInt());
        System.out.println(IntStream.rangeClosed(1, 10).min());
        System.out.println(IntStream.rangeClosed(1, 10).average());
        System.out.println(IntStream.rangeClosed(1, 10).count());




//        System.out.println(listsoremp);
//       // 1.2 使用Arrays 中的 stream() 方法，将数组转成流
//        Integer[] nums = new Integer[10];
//        Stream<Integer> streamatt = Arrays.stream(nums);
//
//        //1.3 使用Stream中的静态方法：of()、iterate()、generate()
//        Stream<Integer> streamarray = Stream.of(1,2,3,4,5,6);
//        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 2).limit(6);
//        stream2.forEach(System.out::println); // 0 2 4 6 8 10
//        Stream<Double> stream3 = Stream.generate(Math::random).limit(2);
//        stream3.forEach(System.out::println);
//
//        //1.4 使用 BufferedReader.lines() 方法，将每行内容转成流
//        BufferedReader reader = new BufferedReader(new FileReader("F:\\test_stream.txt"));
//        Stream<String> lineStream = reader.lines();
//        lineStream.forEach(System.out::println);
//
//        //1.5 使用 Pattern.splitAsStream() 方法，将字符串分隔成流
//        Pattern pattern = Pattern.compile(",");
//        Stream<String> stringStream = pattern.splitAsStream("a,b,c,d");
//        stringStream.forEach(System.out::println);
//
//
//
////        2.1 筛选与切片
////        filter：过滤流中的某些元素
////        limit(n)：获取n个元素
////        skip(n)：跳过n元素，配合limit(n)可实现分页
////        distinct：通过流中元素的 hashCode() 和 equals() 去除重复元素
//        Stream<Integer> streamint = Stream.of(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 14);
//
//        Stream<Integer> newStream = streamint.filter(s -> s > 5) //6 6 7 9 8 10 12 14 14
//                .distinct() //6 7 9 8 10 12 14
//                .skip(2) //9 8 10 12 14
//                .limit(2); //9 8
//        newStream.forEach(System.out::println);
    }

    /**
     * map的流
     */
//    @Test
//    public static void mapSteam(){
//
//        Map map = new HashMap();
//        map.put("第一","迪士尼");
//        map.put("第一","肯德基");
//        map.put("第二","麦当劳");
////        map.entrySet().stream().collect(Collectors.toMap());
//
//        Map<String,Integer> mapsi = new HashMap();
//        mapsi.put("第一",12);
//        mapsi.put("第二",13);
//        mapsi.put("第三",20);
//
//    }

    @Test
    public  void leiji(){
        //虚拟数据
        List<Employee> listemp = DataUtils.getListEmployee();
//        listemp.forEach(System.out::println);

        //累计Integer
        Optional<Integer> optionalAdd = listemp.stream().map(Employee::getAget).reduce((a1, a2) -> a1 + a2);
        if(optionalAdd.isPresent()){
            System.out.println(optionalAdd.get());
        }

        //累计BigDecimal
        BigDecimal reduce = listemp.stream().map(Employee::getNumber).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(reduce);


        //找出BigDecimal最大的
        BigDecimal maxNumber = listemp.stream().filter(o -> o.getNumber() != null).map(Employee::getNumber).distinct().max((e1, e2) -> e1.compareTo(e2)).get();
        System.out.println(maxNumber);

        //找出double最大的
        Double aDouble = listemp.stream().filter(o -> o.getMoney() >= 0).map(Employee::getMoney).distinct().max((e1, e2) -> e1.compareTo(e2)).get();
        System.out.println(aDouble);

        //找出Integer最大的
        Integer maxAge = listemp.stream().filter(o -> o.getAget() >= 0).map(Employee::getAget).distinct().max((e1, e2) -> e1.compareTo(e2)).get();
        System.out.println(maxAge);

        //找最小的
        Integer minAge = listemp.stream().filter(o -> o.getAget() >= 0).map(Employee::getAget).distinct().min((e1, e2) -> e1.compareTo(e2)).get();
        System.out.println("年龄最小"+minAge);

        //取名字长度最大
        Optional<String> reduce1 = listemp.stream().map(Employee::getName).reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
        if(reduce1.isPresent()){
            System.out.println(reduce1.get());
        }

        //取名字长度最短的
        Optional<String> reduce2 = listemp.stream().map(Employee::getName).reduce((s1, s2) -> s1.length() >= s2.length() ? s2 : s1);
        if(reduce1.isPresent()){
            System.out.println(reduce2.get());
        }

        //怪怪的但是很吊
        Integer nameLength = listemp.stream().map(Employee::getName).reduce(0, (max, str) -> max + str.length(), (a, b) -> a + b);
        System.out.println("所有名字长度总和："+nameLength);


        //list泛型中某元素转map
        Map<String, Integer> collect = listemp.stream().map(Employee::getName).collect(Collectors.toMap(Function.identity(), str -> str.length()));
        System.out.println(collect);

        Map<String, String> collect1 = listemp.stream().map(Employee::getName).collect(Collectors.toMap(Function.identity(), str -> str.length() == 2 ? "二" : "三"));
        System.out.println(collect1);


        //年龄大于18的
        Map<Boolean, List<Integer>> agetdayushiba = listemp.stream().map(Employee::getAget).collect(Collectors.partitioningBy(s -> s >= 18));
        System.out.println("年龄大于18的"+agetdayushiba);


        //这个种比较实用   对list 不同年龄的 进行分组
        Map<Integer, List<Employee>> collect2 = listemp.stream().collect(Collectors.groupingBy(Employee::getAget));
        System.out.println(collect2);

        //求出每个年龄段的人数
        Map<Integer, Long> collect3 = listemp.stream().collect(Collectors.groupingBy((Employee::getAget), Collectors.counting()));
        System.out.println("各年龄段人数");
        System.out.println(collect3);


    }




    @Test
    public void join(){
        //虚拟数据
        List<Employee> listemp = DataUtils.getListEmployee();

        String collect = listemp.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(collect);

        String collect1 = listemp.stream().map(Employee::getName).collect(Collectors.joining(",", "{", "}"));
        System.out.println(collect1);

    }

    @Test
    public void stringToList() {
        String strArr = "q,w,e,r";

        List<String> collect = Arrays.stream(strArr.split(",")).map(s -> s.trim()).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void guaiguai(){
        //虚拟数据
        List<Employee> listemp = DataUtils.getListEmployee();

        //超级怪
        Map<String, Map<Double, List<Employee>>> collect4 = listemp.stream().collect(Collectors.groupingBy((Employee::getName), Collectors.groupingBy((Employee::getMoney))));
        System.out.println(collect4);
    }



    //排序
    @Test
    public void sort(){
        List<Employee> listemp = DataUtils.getListEmployee();
        List<Map.Entry<Double, List<Employee>>> list = listemp.stream()
                .collect(Collectors.groupingBy(Employee::getMoney))
                .entrySet()
                .stream()
                .sorted((s1, s2) -> -Double.compare(s1.getKey(), s2.getKey()))
                .collect(Collectors.toList());
        int index = 1;
        for (Map.Entry<Double, List<Employee>> entry : list) {
            System.out.print("名次:" + index + "\t分数:" + entry.getKey() + "\t名字");
            entry.getValue().forEach((s) -> System.out.print("  " + s.getName()));
            System.out.println();
            index++;
        }
    }

    //并列排序
    /**
     * 按照money排序 --- 使用Java 8；并列排名跳到下一名
     */
    @Test
    public void doubleSort() {
        List<Employee> listemp = DataUtils.getListEmployee();
        List<Map.Entry<Double, List<Employee>>> list = listemp.stream()
                .collect(Collectors.groupingBy(Employee::getMoney))
                .entrySet()
                .stream()
                .sorted((s1, s2) -> -Double.compare(s1.getKey(), s2.getKey()))
                .collect(Collectors.toList());
        int index = 1;
        for (Map.Entry<Double, List<Employee>> entry : list) {
            System.out.print("名次:" + index + "\t分数:" + entry.getKey() + "\t名字");
            entry.getValue().forEach((s) -> System.out.print("  " + s.getName()));
            System.out.println();
            index = index + entry.getValue().size();
        }
    }


    /**
     * 按照多条件排序 --- 使用Java 8；并列排名跳到下一名
     */
    @Test
    public void func4() {
        List<Employee> listemp = DataUtils.getListEmployee();
        // students.sort((h1, h2) -> {
        //     // 排名相同，年龄正序排序
        //     if (Double.compare(h1.getScore(), h2.getScore()) == 0) {
        //         return Double.compare(h1.getAge(), h2.getAge());
        //     }
        //     return -Double.compare(h1.getScore(), h2.getScore());
        // });
        listemp.sort(Comparator.comparing(Employee::getMoney).reversed().thenComparing(Employee::getAget));
        // students.forEach(System.out::println);
        int index = 0;
        int count = 0;
        double lastScore = -1;
        Map<Integer, Employee> rankMap = new HashMap<>(5);
        for (int i = 0; i < listemp.size(); i++) {
            Employee s = listemp.get(i);
            System.out.println(s.toString() + "，lastScore：" + lastScore + "，count：" + count + "，index：" + index);
            // 如果成绩和上一名的成绩不相同,那么排名+1
            if (Double.compare(lastScore, s.getMoney()) != 0) {
                lastScore = s.getMoney();
                index = index + 1 + count;
                count = 0;
            } else {
                // 分数相同，如果年龄不同，排名+1
                if (Double.compare(listemp.get(i - 1).getAget(), s.getAget()) != 0) {
                    index = index + 1 + count;
                    count = 0;
                } else {
                    // 重复数+1
                    count++;
                }
            }
            s.setIndex(index);
            System.out.println(s.toString() + "，lastScore：" + lastScore + "，count：" + count + "，index：" + index);
            System.out.println("****************");
            rankMap.put(i, s);
        }
        for (Integer key : rankMap.keySet()) {
            System.out.println(rankMap.get(key));
        }
    }


    //简便排序
    @Test
    public void simple8sort(){
        List<Employee> listemp = DataUtils.getListEmployee();
        listemp.sort(Comparator.comparing(Employee::getMoney).reversed().thenComparing(Employee::getMoney));
        for(Employee e: listemp){
            System.out.println(e);
        }
    }




}










