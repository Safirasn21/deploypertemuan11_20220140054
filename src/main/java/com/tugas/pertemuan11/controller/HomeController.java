package com.tugas.pertemuan11.controller;

import com.tugas.pertemuan11.model.User;
import com.tugas.pertemuan11.service.ProfileService;
import com.tugas.pertemuan11.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final ProfileService profileService;
    private final UserService userService;

    public HomeController(ProfileService profileService, UserService userService) {
        this.profileService = profileService;
        this.userService = userService;
    }

    @GetMapping({"/", "/home"})
    public String home(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        model.addAttribute("username", username);
        model.addAttribute("profiles", profileService.getAllProfiles());
        return "home";
    }

    @GetMapping("/form")
    public String form(HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        return "form";
    }

    @PostMapping("/form")
    public String submitForm(@RequestParam String nama,
                             @RequestParam String nim,
                             @RequestParam String alamat,
                             @RequestParam String jenisKelamin,
                             HttpSession session,
                             Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        User user = userService.findByUsername(username);
        try {
            profileService.saveProfile(nama, nim, alamat, jenisKelamin, user);
            return "redirect:/home?success=input";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "form";
        }
    }
}
