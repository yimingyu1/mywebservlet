import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: DHttpServlet
 */
public class DHttpServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        resp.setContentType("text/html;charset=utf-8");
        if ("zhangsan".equals(name) && "1234".equals(pwd)) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/welcome");
            requestDispatcher.forward(req, resp);
        } else {
            req.getRequestDispatcher("Login1").include(req, resp);
        }
    }
}
