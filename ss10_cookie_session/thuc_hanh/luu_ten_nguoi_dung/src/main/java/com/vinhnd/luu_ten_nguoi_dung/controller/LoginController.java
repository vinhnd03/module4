package com.vinhnd.luu_ten_nguoi_dung.controller;

import com.vinhnd.luu_ten_nguoi_dung.entity.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class LoginController {

    /*add user in model attribute*/
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @RequestMapping("/login")
    public String Index(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
//        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", setUser);
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@ModelAttribute("user") User user, Model model,
                          @CookieValue(value = "setUser", defaultValue = "") String setUser,
                          HttpServletResponse response, HttpServletRequest request) {
        // implement business logic
        if (user.getEmail().equals("admin@gmail.com")
                && user.getPassword().equals("123456")) {
            if (user.getEmail() != null) {
                setUser = user.getEmail();
            }

            // create cookie and set it in response
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);

            // get all cookies
//            Cookie[] cookies = request.getCookies();
            model.addAttribute("cookieValue", setUser);
            model.addAttribute("message", "Login success. Welcome!");
        } else {
            user.setEmail("");
            model.addAttribute("cookieValue", setUser);
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "/login";
    }
}
