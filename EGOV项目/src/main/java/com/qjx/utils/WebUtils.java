package com.qjx.utils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;

//这是给java bean对象的属性赋值的工具类
public class WebUtils {

    /**
     * @param request request域，需要从request域中获取对应的javaBean的属性和属性值
     * @param object  需要给属性赋值的对象
     *                <p>
     *                使用前提：
     *                javaBean的对象的属性名称必须和input标签的name属性值一样
     *                javaBean中的对象必须有set方法
     *                set方法的参数必须是String类型
     *                <p>
     *                此方法类似spring的ioc和springmvc的Controller接收用户请求的参数，自动设置的方式
     */
    public static void setJavaBeanFieldVal(HttpServletRequest request, Object object) {

        //从request域中获取input标签的所有name属性的值
        //name="username";
        Enumeration<String> parameterNames = request.getParameterNames();

        //获取obeject的字节码文件
        Class c = object.getClass();

        //遍历
        while (parameterNames.hasMoreElements()) {
            //将获取到的name属性的值当作是javaBean对象的属性
            String filedName = parameterNames.nextElement();
            //进行拼接set方法
            String methoName = "set" + filedName.toUpperCase().charAt(0) + filedName.substring(1);
            //反射获取javaBean对象的set方法
            Method setMethod = null;
            try {//将try的范围放在while里面，是因为当发生异常的时候，能够让while正常结束
                setMethod = c.getDeclaredMethod(methoName, String.class);
                //调用set方法
                setMethod.invoke(object, request.getParameter(filedName));
            } catch (Exception e) {//不需要打印异常信息，出现方法不存在这个异常很正常。
                //e.printStackTrace();
            }
        }
    }


}
