package session;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * ClassName: SessionInfo
 */
public class SessionInfo {

    private static final String YYYY_MM_DD = "yyyy-MM-dd HH:mm:ss";

    public static void printSessionInfo(PrintWriter printWriter, HttpSession httpSession) {
        printWriter.println("<table>");
        printWriter.println("<tr>");
        printWriter.println("<td>会话的状态：</td>");
        if (httpSession.isNew()) {
            printWriter.println("<td>新的会话</td>");
        } else {
            printWriter.println("<td>旧的会话</td>");
        }
        printWriter.println("</tr>");

        printWriter.println("<tr>");
        printWriter.println("<td>会话ID：</td>");
        printWriter.println("<td>" + httpSession.getId() +"</td>");
        printWriter.println("</tr>");

        printWriter.println("<tr>");
        printWriter.println("<td>创建时间：</td>");
        printWriter.println("<td>" + long2DateStr(httpSession.getCreationTime(), YYYY_MM_DD) +"</td>");
        printWriter.println("</tr>");

        printWriter.println("<tr>");
        printWriter.println("<td>上次访问时间：</td>");
        printWriter.println("<td>" + long2DateStr(httpSession.getLastAccessedTime(), YYYY_MM_DD) +"</td>");
        printWriter.println("</tr>");

        printWriter.println("<tr>");
        printWriter.println("<td>最大不活动时间间隔：</td>");
        printWriter.println("<td>" + httpSession.getMaxInactiveInterval() +"</td>");
        printWriter.println("</tr>");
        printWriter.println("</table>");
    }

    public static String long2DateStr(long timeStamp, String pattern){
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timeStamp), ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern(pattern));
    }

}
