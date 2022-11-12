package validators;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ErrorHandler {
    public void handle(HttpServletResponse resp, HttpServletRequest req, String errorMessage, int statusCode) throws ServletException, IOException {
        resp.setStatus(statusCode);
        req.setAttribute("message", errorMessage);
        req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
    }
}
