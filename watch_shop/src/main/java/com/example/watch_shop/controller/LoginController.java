package com.example.watch_shop.controller;

import com.example.watch_shop.dto.CustomerDTO;
import com.example.watch_shop.model.AppRole;
import com.example.watch_shop.model.AppUser;
import com.example.watch_shop.model.Customer;
import com.example.watch_shop.model.UserRole;
import com.example.watch_shop.service.ICustomerService;
import com.example.watch_shop.service.ICustomerTypeService;
import com.example.watch_shop.service.IUserRoleService;
import com.example.watch_shop.utils.WebUtils;
import org.attoparser.dom.Document;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class LoginController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;
    @Autowired
    private IUserRoleService userRoleService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("customerDto", new CustomerDTO());
        model.addAttribute("customerType", customerTypeService.findAllCustomerType());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("customerDto") CustomerDTO customerCreateDTO, BindingResult bindingResult, Model model, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerType", customerTypeService.findAllCustomerType());
            return "register";
        } else if (customerService.existsByEmail(customerCreateDTO.getEmail())) {
            model.addAttribute("message", "Email đã tồn tại, vui lòng nhập email khác");
            model.addAttribute("customerType", customerTypeService.findAllCustomerType());
            return "register";
        } else if (customerService.existsByPhone(customerCreateDTO.getPhone())) {
            model.addAttribute("message", "Số điện thoại đã tồn tại, vui lòng nhập số điện thoại khác");
            model.addAttribute("customerType", customerTypeService.findAllCustomerType());
            return "register";
        } else if (customerService.existsByAppUser_UserName(customerCreateDTO.getAppUser().getUserName())) {
            model.addAttribute("message", "Tài khoản đã tồn tại, vui lòng nhập tài khoản khác");
            model.addAttribute("customerType", customerTypeService.findAllCustomerType());
            return "register";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerCreateDTO, customer);
            customerService.saveCustomer(customer);
            AppUser appUser = customer.getAppUser();
            AppRole appRole = new AppRole(2, "ROLE_USER");
            userRoleService.saveUserRole(new UserRole(appUser, appRole));
            redirect.addFlashAttribute("msg", "Đăng ký thành công");
            return "redirect:/login";
        }
    }


    @GetMapping(value = {"/", "/welcome"})
    public String welcomePage() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String loginPage(Model model) {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String logoutSuccessfulPage(Model model, RedirectAttributes redirect) {
//        model.addAttribute("message", "Đăng xuất thành công");
        redirect.addFlashAttribute("message", "Đăng xuất thành công");
        return "redirect:/login";
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
    @GetMapping("/about")
    public String about(){
        return "about";
    }
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

}
