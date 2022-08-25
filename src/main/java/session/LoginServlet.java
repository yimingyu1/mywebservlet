package session;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: LoginServlet
 */
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf8");
        HttpSession session = req.getSession();
        String user = (String)session.getAttribute("user");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<meta  http-equiv=\"Pragma\"  content=\"no-cache\">");
        writer.println("<head><title>登录页面</title></head>");
        writer.println("<body>");
        SessionInfo.printSessionInfo(writer, session);
        writer.println("<p>");
        writer.println("<form method=post action=loginchk>");
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<td>请输入用户名：</td>");
        if (null == user) {
            writer.println("<td><input type=text name=user></td>");
        } else {
            writer.println("<td><input type=text name=user value=" + user + "></td>");
        }
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>请输入密码</td>");
        writer.println("<td><input type=password name=pwd></td>");
        writer.println("</tr>");
        writer.println("<tr>");              
        writer.println("<td><input type=reset value=重填></td>");         
        writer.println("<td><input type=submit value=登录></td>");          
        writer.println("</tr>");             
        writer.println("</table>");             
        writer.println("</form>");          
        writer.println("</p>");
        writer.println("</body>");
        writer.println("</html>");          
        writer.close();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }

}
