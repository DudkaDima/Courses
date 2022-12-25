package com.dudka.courses.setvlet;

import com.dudka.courses.entity.Person;
import com.dudka.courses.service.PersonService;
import com.dudka.courses.service.personServiceImplementation.PersonServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    PersonService personService = new PersonServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        Optional<Person> person = personService.findByLogin(request.getParameter("login"));

        if(person.isPresent()) {
            if (person.get().getPassword().equals(request.getParameter("password"))) {
                person.get().setAuth(true);
                request.getSession().setAttribute("person", person);
                response.sendRedirect("/servlets/personWelcome");
            } else {
                response.setStatus(402);
                request.setAttribute("error", "Sorry, something went wrong with your login or password," +
                        " check one more time your login and password");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
                requestDispatcher.include(request, response);
            }
        }

    }

}
