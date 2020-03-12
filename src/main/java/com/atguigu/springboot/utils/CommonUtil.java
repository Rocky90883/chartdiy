package com.atguigu.springboot.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.util.StringUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CommonUtil {
    private static final Gson gson = new Gson();
    private static final Gson gson2 = new GsonBuilder().serializeNulls().create();
    private static final ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");

    /**
     * 对象转JSON字符串，属性为null时忽略该属性
     *
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * 对象转JSON字符串，属性为null时保留
     *
     * @param obj
     * @return
     */
    public static String toJsonIncludeNulls(Object obj) {
        return gson2.toJson(obj);
    }

    /**
     * 通过Class类型和方法名获取Method
     * @param c
     * @param methodName
     * @return
     */
    public static Method getMethodByClassAndName(Class<?> c, String methodName) {
        Method[] methods = c.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().equals(methodName)) {
                return methods[i];
            }
        }

        return null;
    }

    /**
     * 将值套入公式计算
     * @param formula
     * @param values
     * @return
     */
    public static Double calcFormula(String formula, Double[] values){

        //用实际值替换占位符{0}、{1}等
        for(int i=0;i<values.length;i++){
            if(null == values[i]){
                return null;
            }
            formula = formula.replace("{" + i + "}", String.valueOf(values[i]));
        }

        try {
            Object resultObj = scriptEngine.eval(formula);
            if(null != resultObj){
                return round3(Double.valueOf(resultObj.toString()));
            }
            return null;
        } catch (ScriptException e) {
            return null;
        }
    }

    /**
     * 四舍五入，保留3位小数
     * @param num
     * @return
     */
    public static double round3(double num){
        BigDecimal bd = new BigDecimal(String.valueOf(num));
        return bd.setScale(3, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 判断数组是否为空
     * @param arr
     * @return
     */
    public static boolean isEmptyArray(Object[] arr){
        if(null == arr || arr.length == 0){
            return true;
        }

        return false;
    }

    /***
     * 下划线命名转为驼峰命名
     *
     * @param param
     *            下划线命名的字符串
     */
    public static String underlineToHump(String param) {
        if(StringUtils.isEmpty(param)){
            return null;
        }

        StringBuilder result = new StringBuilder();
        String a[] = param.split("_");
        for (String s : a) {
            if (result.length() == 0) {
                result.append(s.toLowerCase());
            } else {
                result.append(s.substring(0, 1).toUpperCase());
                result.append(s.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    /***
     * 驼峰命名转为下划线命名
     *
     * @param para
     *            驼峰命名的字符串
     */
    public static String humpToUnderline(String param) {
        if(StringUtils.isEmpty(param)){
            return null;
        }

        StringBuilder sb = new StringBuilder(param);
        int temp = 0;// 定位
        for (int i = 0; i < param.length(); i++) {
            if (Character.isUpperCase(param.charAt(i))) {
                sb.insert(i + temp, "_");
                temp += 1;
            }
        }
        return sb.toString().toLowerCase();
    }

}
