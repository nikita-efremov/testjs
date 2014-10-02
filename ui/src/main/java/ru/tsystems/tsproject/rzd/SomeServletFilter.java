package ru.tsystems.tsproject.rzd;

import javax.servlet.*;

/**
 * Created by Марина on 02.10.14.
 */
public class SomeServletFilter implements Filter {
    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;


    }
    public void destroy() {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        servletRequest.setAttribute("attributeFromFilter", "Hello, i am filter");
        System.out.println("filter setted attribute");
        System.out.println("filter init param: " + filterConfig.getInitParameter("filterParam1Name"));
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
