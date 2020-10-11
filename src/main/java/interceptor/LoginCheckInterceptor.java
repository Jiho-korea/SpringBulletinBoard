package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import springBulletinBoard.vo.Student;

public class LoginCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session != null) {
			Student student = (Student) session.getAttribute("login");
			if (student != null) {
				return true;
			}
		}
		response.sendRedirect(request.getContextPath() + "/login/login");
		return false;
	}

}
