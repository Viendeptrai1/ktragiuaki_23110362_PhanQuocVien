package org.example.ktragiuaki_23110362_phanquocvien.controller;

import org.example.ktragiuaki_23110362_phanquocvien.entity.User_23110362;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AdminGuard_23110362 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if (!uri.startsWith("/admin")) {
            return true;
        }
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("/login");
            return false;
        }
        Object principal = session.getAttribute("CURRENT_USER");
        if (principal instanceof User_23110362) {
            User_23110362 user = (User_23110362) principal;
            if (user.getRole() != null && "ADMIN".equalsIgnoreCase(user.getRole().getRoleName())) {
                return true;
            }
        }
        response.sendRedirect("/login");
        return false;
    }
}


