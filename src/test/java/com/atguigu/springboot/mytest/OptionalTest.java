package com.atguigu.springboot.mytest;

import org.apache.poi.ss.formula.functions.T;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

/**
 *
 empty	        放回一个值为空的Optional实例
 filter	        如果值存在并且满足提供的谓词，就返回包含该Optional对象；否则返回一个空的Optional对象
 flatMap	    如果值存在，就对该值执行提供的mapping函数，将mapping函数返回值用Optional封装并返回，否则就返回一个空的Optional对象
 get	        如果值存在就返回该Optional对象，否则就抛出一个 NoSuchElementException异常
 ifPresent	    如果值存在就对该值执行传入的方法，否则就什么也不做
 isPresent	    如果值存在就返回true，否则就返回false
 map	        如果值存在，就对该值执行提供的mapping函数调用，将mapping函数返回值用Optional封装并返回
 of	            如果传入的值存在，就返回包含该值的Optional对象，否则就抛出NullPointerException异常
 ofNullable	    如果传入的值存在，就返回包含该值的Optional对象，否则返回一个空的Optional对象
 orElse	        如果值存在就将其值返回，否则返回传入的默认值
 orElseGet	    如果值存在就将其值返回，否则返回一个由指定的Supplier接口生成的值
 orElseThrow    如果值存在就将其值返回，否则返回一个由指定的Supplier接口生成的异常
 */

public class OptionalTest {

    public static void main(String[] args){

        //判断非空
        util();

        //对象的filter
        //optional_filter();

        //不是想要的直接输出另外的值
        //optional_orelse();
    }

    /**
     * 判断非空
     */
    public static void util(){
        //Optional得ifPresent于isPresent
        Usernew usernew = new Usernew(1);

        Optional<String> roleOpt = Optional.ofNullable(usernew).map(u->u.getName());
        if(roleOpt.isPresent()){
            System.out.println("不为空");
        }else{
            System.out.println("为空");
        }


        Optional.ofNullable(usernew).ifPresent(u->{
            usernew.setName("梁光春");
        });

        System.out.println(usernew.getName());
    }


    /**
     * startsWith实例:  判断String是否以指定的String开头.是返回Optional[String],否放回 Optional.empty.
     * endsWith实例:  判断String是否以指定的String结束.是返回Optional[String],否放回 Optional.empty.
     */
    public static void optional_filter(){
        System.out.println("........startsWith..........");
        String str = "rocky i love you";
        Optional<String> optional=Optional.of(str);
        Optional<String> optionalResult=optional.filter(s -> s.startsWith("rocky"));
        System.out.println(optionalResult);
        System.out.println("........startsWith..........");

        System.out.println();

        System.out.println("=========endsWith实例==========");
        String sttr = "xxx i love rocky";
        Optional<String> opt=Optional.of(sttr);
        Optional<String> optResult=opt.filter(e -> e.endsWith("rocky"));
        if(optResult.isPresent()){
            System.out.println("不为空值为: "+optResult.get());
        }else{
            System.out.println("为空");
        }
        System.out.println("=========endsWith实例==========");

        System.out.println();

        System.out.println("........多重过滤..........");
        String stt = "Rocky xx Rocky";
        Optional<String> optt = Optional.of(stt);
        Optional<String> opttResult = optt.filter(e -> e.length()==14).filter(e->e.endsWith("Rocky"));
        if(opttResult.isPresent()){
            System.out.println(opttResult.get());
        }else{
            System.out.println("空");
        }
        System.out.println("........多重过滤..........");

        System.out.println();

        System.out.println("........多种类型过滤..........");
        Map<String,String> map = new HashMap();
        map.put("name","单洛祺");
        Optional<Map<String,String>> opttt = Optional.of(map);
        Optional<Map<String,String>> optttResult = opttt.filter(m->m.size()==1).filter(m->m.get("name").equals("单洛祺"));
     if(optttResult.isPresent()){
            System.out.println("map"+optttResult.get());
        }else{
            System.out.println("map为null");
        }
        System.out.println("........多种类型过滤..........");

    }

    /**
     * orelse: 如果值存在就将其值返回，否则返回传入的默认值
     */
    public static void optional_orelse(){
            String str = "rock-vicky-pocky";
            Optional<String> optional=Optional.of(str);
            Optional<String> optResult = optional.filter(s->s.startsWith("rockyxx"));
            System.out.println(optResult.orElse("c"));

            Optional<String> optional1=Optional.ofNullable(null);
            optional1.ifPresent(u->{

            });
            System.out.println(optional1.orElse("接口数据为空"));
    }
}
