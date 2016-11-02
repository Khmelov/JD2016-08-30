package by.it.tsydzik.project.java.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    public RequestDispatcher disp(Action action) {
        return getServletContext().getRequestDispatcher(action.getJsp());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action = Actions.defineFrom(req);
        action.execute(req);
        disp(action).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action = Actions.defineFrom(req);
        Action redirectAction = action.execute(req);
        if (redirectAction != null) {
            resp.sendRedirect("do?command=" + redirectAction);
        } else {
            disp(action).forward(req, resp);
        }
    }
}