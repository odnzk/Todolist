package servlets;

import exceptions.ConnectingDbException;
import exceptions.LoadingDbException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listener.InitListener;
import model.User;
import services.AuthService;
import util.AppDatabase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private AuthService service;

    @Override
    public void init() throws ServletException {
        super.init();
        service = (AuthService) getServletContext().getAttribute(InitListener.KEY_AUTH_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        try(Connection conn = AppDatabase.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("select * from users where username = ?");
        ){
            preparedStatement.setString(1, "usertest");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet != null) {
                    while (resultSet.next()){
                        resp.getWriter().println(resultSet.toString());
                    }
                }
            }
        } catch (SQLException |ConnectingDbException e) {

        }


        try {
            resp.getWriter().println("??");
            Optional<User> user = service.findUser(username);
            if(user.isEmpty()){
                resp.getWriter().println("There is no user with this username");
//                req.setAttribute("message", "There is no user with this username");
            }else{
                resp.getWriter().println("?");
                if(service.login(username, password)){
                    resp.getWriter().println("mdaaaa");
                    service.auth(user.get(), req);
                    resp.getWriter().println("mda");
                    resp.setContentType("text/html;charset=UTF-8");
                    req.getRequestDispatcher("/WEB-INF/jsp/main_page.jsp").forward(req, resp);
                }else{
                    resp.getWriter().println("Wrong password");
//                    req.setAttribute("message", "Wrong password");
                }
            }
        } catch (ConnectingDbException|LoadingDbException e) {
            e.printStackTrace();
        }
    }
}
