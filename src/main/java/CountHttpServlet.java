import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: CountHttpServlet
 */
public class CountHttpServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        ServletContext servletContext = req.getServletContext();
        synchronized (servletContext) {
            Integer count = (Integer)servletContext.getAttribute("count");
            if (count == null) {
                servletContext.setAttribute("count", 1);
            } else {
                servletContext.setAttribute( "count", (Integer) servletContext.getAttribute("count") + 1);
            }
        }
        PrintWriter writer = resp.getWriter();
        writer.println("浏览次数：" + servletContext.getAttribute("count"));
        writer.close();
    }
}
