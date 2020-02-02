package com.atguigu.springboot.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ImitationDataUtil {

    Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 日期循环加一天
     * @param count     循环次数
     * @param intDate   初始日期
     * @param format    日期格式
     * @return["20190101","20190102","20190103","20190101","20190104"]
     */
    public List<String> loopDateaddOne(Integer count, String intDate, String format) {
        List<String> dateArray = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        java.util.Date dt = null;
        for (int i=0;i<count;i++){
            try{
                dt = sdf.parse(intDate);
            }catch (ParseException e){
                log.error("日期转换错误");
                e.printStackTrace();
            }
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(dt);

            rightNow.add(Calendar.DAY_OF_YEAR, 1);// 日期加1天
            intDate=sdf.format(rightNow.getTime());          //相当于日期++
            dateArray.add(sdf.format(rightNow.getTime()));  //list赋值
        }
        return dateArray;
    }

    /**
     * Rocky 生成指定范围的随机数
     * @param count         随机数个数
     * @param maxNumber     随机数最大值
     * @param minNumber     随机数最小值
     * @param suffix        随机数单位 没有空字符串
     * @return              List<String>
     */
    public List<String> RandomData(Integer count, Integer maxNumber,Integer minNumber,String suffix) {
        List<String> dateArray = new ArrayList<>();
        Random random = new Random();
        for (int i=0;i<count;i++){
            Integer randNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            dateArray.add(randNumber.toString()+suffix);
        }
        return dateArray;
    }

    /**
     * rocky
     * @param count         次数
     * @param maxNumber     最大值
     * @param minNumber     最小值
     * @return  List<Map<String,Integer>>   {汤杜潘殷凤=237},{和钱麻熊钱=368}
     */
    public List<Map<String,Object>> RandomDataKeyValue(Integer count, Integer maxNumber,Integer minNumber){
        List<Map<String,Object>> datakv = new ArrayList<>();
        Random random = new Random();
        String[] nameBaseList = { "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈"
                , "韩", "杨", "朱", "秦", "尤", "许", "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶"
                , "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎"
                , "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费"
                , "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐", "于"
                , "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和", "穆", "萧"
                , "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴"
                , "谈", "宋", "茅", "庞", "熊", "纪", "舒", "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席"
                , "季", "麻", "强", "贾", "路", "娄", "危"};
        int a = nameBaseList.length-1;
        for (int i=0;i<count;i++){
            Integer nameNumber = random.nextInt(4 ) + 2;
            Integer randNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            StringBuffer tenname = new StringBuffer();
            for(int j=0;j<nameNumber;j++){
                tenname.append(nameBaseList[random.nextInt(a)]);
            }
            Map<String,Object> map = new HashMap();
            map.put("name",tenname.toString());
            map.put("value",randNumber);
            datakv.add(map);
        }
        return datakv;
    }
}
