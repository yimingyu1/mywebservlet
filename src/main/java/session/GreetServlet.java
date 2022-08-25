package session;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: GreetServlet
 */
public class GreetServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");
        if (null == user) {
            resp.sendRedirect("login");
            return;
        }
        resp.setContentType("text/html;charset=utf8");
        PrintWriter out=resp.getWriter();
        out.println("<html><head><title>欢迎页面</title></head>");
        out.println("<body>");
        SessionInfo.printSessionInfo(out,session);
        out.println("<p>");
        out.println("欢迎你，"+user+"</p>");
        out.println("<a href=login>重新登录</a>");
        out.println("<a href=logout>注销</a>");
        out.println("</body></html>");
        out.close();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
