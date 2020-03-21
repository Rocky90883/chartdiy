package com.atguigu.springboot.mytest;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;

/**
 * MultiValueMap可以让一个key对应多个value，感觉是value产生了链表结构，
 * 这里可以很好的解决一些不好处理的字符串问题。
 * 当然你也可以用stringBuffer去拼，我觉得这个效果更好，效率更高。
 */
public class MultiValueMapTest {

    public static void main(String[] args){


        multiValueMapTest();

        //map的sort
        map_sort();

        //遍历map的几种method
        iterator();
    }

    public static void multiValueMapTest(){

        MultiValueMap<String, String> stringMultiValueMap = new LinkedMultiValueMap<>();

        stringMultiValueMap.add("早班 9:00-11:00", "周一");
        stringMultiValueMap.add("早班 9:00-11:00", "周二");
        stringMultiValueMap.add("中班 13:00-16:00", "周三");
        stringMultiValueMap.add("早班 9:00-11:00", "周四");
        stringMultiValueMap.add("测试1天2次 09:00 - 12:00", "周五");
        stringMultiValueMap.add("测试1天2次 09:00 - 12:00", "周六");
        stringMultiValueMap.add("中班 13:00-16:00", "周日");
        //打印所有值
        Set<String> keySet = stringMultiValueMap.keySet();
        for (String key : keySet) {
            List<String> values = stringMultiValueMap.get(key);
            System.out.println(StringUtils.join(values.toArray()," ")+":"+key);
        }
        System.out.println(stringMultiValueMap.getFirst("早班 9:00-11:00"));
        System.out.println(stringMultiValueMap.get("早班 9:00-11:00"));

    }

    /**
     * 如果不重复put某个key,其实也有有序的
     */
    public static void map_sort(){
        Map<String,String > map = new HashMap();
        map.put("单洛祺","单洛祺");
        map.put("ABC","ABC");
        map.put("123","123");
        map.put("###","###");
        for(String key : map.keySet()){
            System.out.println(map.get(key));
        }
    }

    /**
     * 遍历map的几种方法
     */
    public static void iterator(){

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "张三");
        map.put(2, "李四");
        map.put(3, "王五");
        map.put(4, "王五");
        map.put(4, "王五");
        System.out.println("map的大小：" + map.size());

        System.out.println();
        System.out.println("方式一：通过Map.keySet遍历key和value：");
        for (Integer key : map.keySet()) {
            String s = map.get(key);
            System.out.println(key + ": " + s);
        }
        System.out.println();

        System.out.println("方式二：通过Map.entrySet遍历key和value：");
        System.out.println("推荐，尤其是容量大时");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();

        System.out.println("方式三：通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();

        System.out.println("方式四：通过Map.values()遍历所有的value，但不能遍历key");
        for (String value : map.values()) {
            System.out.println(value);
        }
    }
}
