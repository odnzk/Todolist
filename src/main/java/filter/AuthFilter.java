package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;

// 1 кнопка фойти - появляютс] рtml окошко с формой ввода
// по нажатию сразу запрос??
// display = none -> js: change display: block
// centered css position: absolute
// table ONLY in bode, not in div body and etc

// 2 сколько сиволов осталось ввести в textarea
// подпсика на внесение изменениия
// сиполдьзовать inner text а не Inner html
// + ввести изначально играничения на максимум

@WebFilter("/*")
public class AuthFilter implements Filter {
    private final String[] secretPages = {"/profile", "/todoList", "/logout", "/detailedTodo"};
    private ServletContext servletContext;


    public void init(FilterConfig config) throws ServletException {
        servletContext = config.getServletContext();
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);
        String contextPath = httpRequest.getContextPath();

        boolean isSecretPage = false;
        for (String page : secretPages) {
            isSecretPage |= httpRequest.getRequestURI().equals(contextPath + page);
        }

        // ??
//        boolean isStaticResource =httpRequest.getRequestURI().startsWith(contextPath + "/static/") ||
//                request.getRequestURI().startsWith(contextPath + "/js/");

        boolean isAuthenticated = false;
        if (session != null) {
            isAuthenticated = session.getAttribute("isAuthenticated") != null;
        }

        if (!isAuthenticated && isSecretPage /*&& !isStaticResource*/) {
            httpResponse.sendRedirect(contextPath + "/signIn");
        } else if (isAuthenticated && !isSecretPage/*&& !isStaticResource*/) {
            // ??
            User user = (User) session.getAttribute("user");
            httpResponse.sendRedirect(contextPath + "/profile?user=" + user.getId());
        } else {
            chain.doFilter(request, response);
        }
    }
}
