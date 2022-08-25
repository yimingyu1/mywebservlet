package session;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: LogoutServlet
 */
public class LogoutServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getco
        resp.setContentType("text/html;charset=utf8");
        HttpSession session = req.getSession();
        session.invalidate();
        PrintWriter out=resp.getWriter();
        out.println("<html><head><title>退出登录</title></head>");
        out.println("<body>");
        out.println("已退出登录<br>");
        out.println("<a href=login>重新登录</a>");
        out.println("</body></html>");
        out.close();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
