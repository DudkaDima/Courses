package com.dudka.courses.listener;

import com.dudka.courses.entity.Person;
import com.dudka.courses.simulatingDb.PersonsList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        initServices(servletContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    private void initServices(ServletContext servletContext) {
        PersonsList.PERSON_LIST.add(new Person("nisssa", "121312", "Nika", "Johns"));
        PersonsList.PERSON_LIST.add(new Person("ssuss", "22231122aas", "Jotaro", "aSad"));
        PersonsList.PERSON_DTO_LIST = PersonsList.transferPersonListToDtoList(PersonsList.PERSON_LIST);
        servletContext.setAttribute("PERSON_LIST", PersonsList.PERSON_LIST);
        servletContext.setAttribute("PERSON_LIST_DTO", PersonsList.PERSON_LIST);

    }
}
