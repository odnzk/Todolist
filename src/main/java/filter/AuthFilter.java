package filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import listener.InitListener;
import model.User;
import services.AuthService;

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
public class AuthFilter extends HttpFilter {
    private final String[] secretPages = {"/profile", "home", "/achievements"};
    //    private ServletContext servletContext;
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

        if(isSecretPage && !service.isAuth(req, res)){
            res.sendRedirect(contextPath + "/login");
        }else{
            chain.doFilter(req, res);
        }
    }

//    public void init(FilterConfig config) throws ServletException {
//        servletContext = config.getServletContext();
//        service = (AuthService) servletContext.getAttribute(InitListener.KEY_AUTH_SERVICE);
//    }

//    public void destroy() {
//    }

//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        HttpSession session = httpRequest.getSession(false);
//        String contextPath = httpRequest.getContextPath();
//
//        boolean isSecretPage = false;
//        for (String page : secretPages) {
//            isSecretPage |= httpRequest.getRequestURI().equals(contextPath + page);
//        }
//
//        boolean isAuthenticated = false;
//        if (session != null) {
//            isAuthenticated = session.getAttribute("isAuthenticated") != null;
//        }
//
//        if (!isAuthenticated && isSecretPage /*&& !isStaticResource*/) {
//            httpResponse.sendRedirect(contextPath + "/signIn");
//        } else if (isAuthenticated && !isSecretPage/*&& !isStaticResource*/) {
//            // ??
//            User user = (User) session.getAttribute("user");
//            httpResponse.sendRedirect(contextPath + "/profile?user=" + user.getId());
//        } else {
//            chain.doFilter(request, response);
//        }
//    }
}
