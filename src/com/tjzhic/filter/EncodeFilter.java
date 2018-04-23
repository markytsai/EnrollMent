package com.tjzhic.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class EncodeFilter implements Filter {

    public void destroy() {
        // TODO Auto-generated method stub

    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");


        ServletRequest requestProxy = getHttpServletRequestProxy((HttpServletRequest)request);


        chain.doFilter(request, response);

    }

    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

    // 通过反射方法模式解决中文乱码问题
    private ServletRequest getHttpServletRequestProxy(final HttpServletRequest request) {
        ServletRequest proxy = (ServletRequest) Proxy.newProxyInstance(
                EncodeFilter.class.getClassLoader(),
                request.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
                        //如果请求方式是get并且调用的是getParameter方法
                        if (request.getMethod().equalsIgnoreCase("get") && method.getName().equals("getParameter")) {
                            //调用getParameter方法获取参数的值
                            String value = (String) method.invoke(request, args);
                            if (value == null) {
                                return null;
                            }
                            //解决以get方式提交的中文乱码问题
                            return new String(value.getBytes("iso8859-1"), "UTF-8");
                        } else {
                            //直接调用相应的方法进行处理
                            return method.invoke(request, args);
                        }
                    }
                });
        //返回HttpServletRequest对象的代理对象
        return proxy;
    }

}
