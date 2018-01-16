package com.taobao.rigel.rap.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class DomainEquals {

    /**
     * 日志操作类
     */
    private static Logger logger = Logger.getLogger(DomainEquals.class);

    public DomainEquals() {
    }

    /**
     * 比较两个BEAN或MAP对象的值是否相等
     * 如果是BEAN与MAP对象比较时MAP中的key值应与BEAN的属性值名称相同且字段数目要一致
     * @param source
     * @param target
     * @return
     */
    public static List<Map<String,String>> domainEquals(Object source, Object target) {
        if (source == null || target == null) {
            return null;
        }
        List<Map<String,String>> rv=new ArrayList<Map<String,String>>();
        if (source instanceof Map) {
            rv = mapOfSrc(source, target);
        } else {
            rv = classOfSrc(source, target);
        }
        return rv;
    }

    /**
     * 源目标为MAP类型时
     * @param source
     * @param target
     * @return
     */
    private static List<Map<String,String>> mapOfSrc(Object source, Object target) {
        List<Map<String,String>> rv=new ArrayList<Map<String,String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        map = (HashMap) source;
        Map<String,String> item;
        for (String key : map.keySet()) {
            if (target instanceof Map) {
                HashMap<String, String> tarMap = new HashMap<String, String>();
                tarMap = (HashMap) target;
                if(tarMap.get(key)==null){
                    continue;
                }
                if (!map.get(key).equals(tarMap.get(key))) {
                    item=new HashMap<>();
                    item.put("itemName",key);
                    item.put("oldValue",map.get(key));
                    item.put("newValue",tarMap.get(key));
                    rv.add(item);
                    continue;
                }
            }
        }
        return rv;
    }

    /**
     * 源目标为非MAP类型时
     * @param source
     * @param target
     * @return
     */
    private static List<Map<String,String>> classOfSrc(Object source, Object target) {
        List<Map<String,String>> rv=new ArrayList<Map<String,String>>();
        Class<?> srcClass = source.getClass();
        Field[] fields = srcClass.getDeclaredFields();
        for (Field field : fields) {
                String nameKey = field.getName();
                Map<String,String> item;
                String srcValue = getClassValue(source, nameKey) == null ? "" : getClassValue(source, nameKey)
                        .toString();
                String tarValue = getClassValue(target, nameKey) == null ? "" : getClassValue(target, nameKey)
                        .toString();
                if (!srcValue.equals(tarValue)) {
                    item=new HashMap<>();
                    item.put("itemName",nameKey);
                    item.put("oldValue",srcValue);
                    item.put("newValue",tarValue);
                    rv.add(item);
                    continue;
                }
        }
        return rv;
    }

    /**
     * 根据字段名称取值
     * @param obj
     * @param fieldName
     * @return
     */
    public static Object getClassValue(Object obj, String fieldName) {
        if (obj == null) {
            return null;
        }
        try {
            Class beanClass = obj.getClass();
            Method[] ms = beanClass.getMethods();
            for (int i = 0; i < ms.length; i++) {
                // 非get方法不取
                if (!ms[i].getName().startsWith("get")) {
                    continue;
                }
                Object objValue = null;
                try {
                    objValue = ms[i].invoke(obj, new Object[] {});
                } catch (Exception e) {
                    logger.info("反射取值出错：" + e.toString());
                    continue;
                }
                if (objValue == null) {
                    continue;
                }
                if (ms[i].getName().toUpperCase().equals(fieldName.toUpperCase())
                        || ms[i].getName().substring(3).toUpperCase().equals(fieldName.toUpperCase())) {
                    return objValue;
                } else if (fieldName.toUpperCase().equals("SID")
                        && (ms[i].getName().toUpperCase().equals("ID") || ms[i].getName().substring(3).toUpperCase()
                        .equals("ID"))) {
                    return objValue;
                }
            }
        } catch (Exception e) {
            // logger.info("取方法出错！" + e.toString());
        }
        return null;
    }

    public static void main(String args[]) {
    }

}
