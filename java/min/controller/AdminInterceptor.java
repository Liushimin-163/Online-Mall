package min.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


public class AdminInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if(uri.contains("css/") || uri.contains("js/") || uri.contains("img/")
                || uri.contains("login") || uri.contains("logout")) {
            return true; // 不拦截路径
        }
        Object username = request.getSession().getAttribute("username");
        if (Objects.nonNull(username) && !username.toString().trim().isEmpty()) {
            return true; // 登录验证通过
        }
        response.sendRedirect("login.jsp");
        return false; // 其他情况一律拦截
    }

}
