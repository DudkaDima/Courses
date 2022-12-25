package com.dudka.courses.filter;

import com.dudka.courses.entity.Person;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebFilter({"/servlets/personList", "/personList"})
public class FilterLogin implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        ServletContext servletContext = filterConfig.getServletContext();
        servletContext.log("AuthFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Optional<Person> person = (Optional<Person>) request.getSession().getAttribute("person");
        if (request.getSession() == null || person.isEmpty()) {
            response.sendRedirect("/servlets/login");
        } else if (person.get().isAuth()) {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
