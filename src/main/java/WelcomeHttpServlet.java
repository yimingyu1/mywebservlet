import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: WelcomeHttpServlet
 */
public class WelcomeHttpServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        PrintWriter writer = resp.getWriter();
        writer.println("你好，" + name + ". welcome to chine");
        writer.close();
    }
}
