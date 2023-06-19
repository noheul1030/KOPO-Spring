package utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

public class JSFunction {

	// 메시지 창을 띄우고 특정 URL로 이동하는 함수
	public static void alertLocation(String msg, String url, JspWriter out) {
		try {
			String script = 
					"" 
					+ "<script>" 
					+ "    alert('" + msg + "');" 
					+ "    location.href='" + url + "';" 
					+ "</script>";
			out.println(script);
		} catch (Exception e) {

		}
	}

	// 메시지 알림창을 띄운 후 이전 페이지로 돌아갑니다.
	public static void alertBack(String msg, JspWriter out) {
		try {
			String script = "" + "<script>" + "    alert('" + msg + "');" + "    history.back();" + "</script>";
			out.println(script);
		} catch (Exception e) {
		}
	}

	// 메시지 알림창을 띄운 후 명시한 URL로 이동합니다.
	public static void alertLocation(HttpServletResponse resp, String msg, String url) {
		try {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = resp.getWriter();
			String script = "" + "<script>" + "    alert('" + msg + "');" + "    location.href='" + url + "';"
					+ "</script>";
			writer.print(script);
		} catch (Exception e) {
		}
	}

	// 메시지 알림창을 띄운 후 이전 페이지로 돌아갑니다.
	public static void alertBack(HttpServletResponse resp, String msg) {
		try {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = resp.getWriter();
			String script = "" + "<script>" + "    alert('" + msg + "');" + "    history.back();" + "</script>";
			writer.print(script);
		} catch (Exception e) {
		}
	}
}