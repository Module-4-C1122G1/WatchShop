package com.example.watch_shop.controller;

import com.example.watch_shop.model.AppUser;
import com.example.watch_shop.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
public class LoginController {

    @GetMapping(value = { "/", "/welcome" })
    public String welcomePage() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String loginPage(Model model) {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("message", "Đăng xuất thành công");
        return "login";
    }


    @GetMapping(value = "/userInfo")
    public String userInfo(Model model, Principal principal) {

        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();


        System.out.println("User Name: " + userName);

        User loginUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginUser);
        model.addAttribute("userInfo", userInfo);
        return "userInfoPage";
    }


    @GetMapping(value = "/admin")
    public String adminPage(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "adminPage";
    }

    @GetMapping(value = "/403")
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }

//    @Autowired
//    IAppUserService appUserService;
//
//    @ModelAttribute("appUser")
//    public AppUser setUpAccountForm() {
//        return new AppUser();
//    }
//
//    @GetMapping("/login")
//    public String login(@CookieValue(value = "setAppUser", defaultValue = "") String setAppUser, Model model) {
//        Cookie cookie = new Cookie("setAppUser", setAppUser);
//        model.addAttribute("cookieValue", cookie);
//        return "login";
//    }
//
//    @PostMapping("/doLogin")
//    public String login(@ModelAttribute("appUser") AppUser appUser, Model model,
//                        @CookieValue(value = "setAppUser", defaultValue = "") String setAppUser,
//                        HttpServletRequest request, HttpServletResponse response) {
//        if (appUserService.findAppUserByUserName(appUser.getUserName()) != null) {
//            Cookie cookie = new Cookie("userName", appUser.getUserName());
//            cookie.setMaxAge(24 * 60 * 60);
//            response.addCookie(cookie);
//
//            Cookie cookie1 = new Cookie("encrytedPassword", appUser.getEncrytedPassword());
//            cookie.setMaxAge(24 * 60 * 60);
//            response.addCookie(cookie1);
//            Cookie[] cookies = request.getCookies();
//            for (Cookie ck : cookies) {
//                if (ck.equals(appUser.getUserName())) {
//                    model.addAttribute("cookieValueUserName", ck);
//                }
//                if (ck.equals(appUser.getEncrytedPassword())) {
//                    model.addAttribute("cookieValueencrytedPassword", ck);
//                }
//            }
//            model.addAttribute("message", "Login success. Welcome ");
//
//        } else {
//            model.addAttribute("message", "Login failed. Try again.");
//        }
//        return "login";
//    }
//    @GetMapping("/logoutSuccessful")
//    public String
}
