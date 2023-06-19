package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {
	
	// 이름,value, 유지시간 설정한 쿠키
	
	public static void makeCookie(HttpServletResponse response, String cName,
			String cValue, int cTime) {
		Cookie cookie = new Cookie(cName,cValue);
		cookie.setPath("/"); // 경로를 "/" = 전체 경로 -> 전체 쿠키를 모두 사용하겠단 의미
		cookie.setMaxAge(cTime);
		response.addCookie(cookie);
	}
	
	// 생성된 쿠키 또는 이름으로 쿠키 찾기
	public static String readCookie(HttpServletRequest request, String cName) {
		String cookieValue = "";
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				String cookieName = c.getName();
				if(cookieName.equals(cName)) {
					cookieValue = c.getValue();// 리턴 값 업데이트
				}
			}
		}
		return cookieValue;
	}
	
	// 쿠키 제거
	public static void  deleteCookie(HttpServletResponse response,String cName) {
		// 쿠키의 삭제가 의미하는건 = 유지시간을 0으로 만드는 것
		makeCookie(response, cName, "", 0);
	}
}
