package filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listener.InitListener;
import services.AuthService;

import java.io.IOException;

@WebFilter("/*")
public class AuthFilter extends HttpFilter {
    private final String[] secretPages = {"/profile", "/home", "/achievements",
            "/addItem", "/add", "/clear", "/delete/*", "/updateProjectItem/*"};
    private AuthService service;


    @Override
    public void init() throws ServletException {
        super.init();
        service = (AuthService) getServletContext().getAttribute(InitListener.KEY_AUTH_SERVICE);
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String contextPath = req.getContextPath();
        boolean isSecretPage = false;

        for (String page : secretPages) {
            isSecretPage |= req.getRequestURI().equals(contextPath + page);
        }

        if (isSecretPage && !service.isAuth(req)) {
            res.sendRedirect(contextPath + "/login");
        } else {
            chain.doFilter(req, res);
        }
    }

}
