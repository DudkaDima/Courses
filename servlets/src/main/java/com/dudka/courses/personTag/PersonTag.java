package com.dudka.courses.personTag;

import com.dudka.courses.dto.PersonDto;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class PersonTag extends TagSupport {
    private PersonDto person;

    public void setPerson(PersonDto p) {
        person = p;
    }

    public int doStartTag() {
        JspWriter out = pageContext.getOut();
        try {
            out.write("<td>" + person.getLogin() + "</td>");
            out.write("<td>" + person.getName() + "</td>");
            out.write("<td>" + person.getSurname() + "</td>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return SKIP_BODY;
    }
}
