package org.example.ktragiuaki_23110362_phanquocvien.controller;

import org.example.ktragiuaki_23110362_phanquocvien.entity.User_23110362;
import org.example.ktragiuaki_23110362_phanquocvien.service.UserService_23110362;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController_23110362 {
    private final UserService_23110362 userService;

    public AdminUserController_23110362(UserService_23110362 userService) {
        this.userService = userService;
    }

    @GetMapping
    public String list(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<User_23110362> p = userService.findPage(page, 5);
        model.addAttribute("page", p);
        return "admin/user/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("u", new User_23110362());
        return "admin/user/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("u") User_23110362 u) {
        userService.save(u);
        return "redirect:/admin/users";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        User_23110362 u = userService.findById(id).orElse(null);
        if (u == null) return "redirect:/admin/users";
        model.addAttribute("u", u);
        return "admin/user/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return "redirect:/admin/users";
    }
}


