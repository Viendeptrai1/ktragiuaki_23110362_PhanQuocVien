package org.example.ktragiuaki_23110362_phanquocvien.controller;

import org.example.ktragiuaki_23110362_phanquocvien.entity.User_23110362;
import org.example.ktragiuaki_23110362_phanquocvien.service.AuthService_23110362;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping
public class AuthController_23110362 {
    private final AuthService_23110362 authService;

    public AuthController_23110362(AuthService_23110362 authService) {
        this.authService = authService;
    }

    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin/index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpSession session,
                          Model model) {
        Optional<User_23110362> userOpt = authService.login(username, password);
        if (userOpt.isPresent()) {
            User_23110362 user = userOpt.get();
            session.setAttribute("CURRENT_USER", user);
            String roleName = user.getRole() != null ? user.getRole().getRoleName() : "USER";
            if ("ADMIN".equalsIgnoreCase(roleName)) {
                return "redirect:/admin";
            }
            return "redirect:/home";
        }
        model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");
        return "auth/login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "auth/register";
    }

    @PostMapping("/register")
    public String doRegister(@RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String fullname,
                             @RequestParam(required = false) String email,
                             @RequestParam(required = false, defaultValue = "false") boolean seller,
                             Model model) {
        try {
            authService.register(username, password, fullname, email, seller);
            model.addAttribute("msg", "Đăng ký thành công. Vui lòng đăng nhập.");
            return "auth/login";
        } catch (Exception ex) {
            model.addAttribute("error", "Đăng ký thất bại: " + ex.getMessage());
            return "auth/register";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
