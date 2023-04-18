package com.example.watch_shop.controller;

import com.example.watch_shop.dto.CustomerDTO;
import com.example.watch_shop.model.AppUser;
import com.example.watch_shop.model.Customer;
import com.example.watch_shop.model.UserRole;
import com.example.watch_shop.service.ICustomerService;
import com.example.watch_shop.service.ICustomerTypeService;
import com.example.watch_shop.service.IUserRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;
    @Autowired
    private IUserRoleService userRoleService;

    @GetMapping("")
    public String showListCustomer(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("customerList", customerService.findAllCustomer(PageRequest.of(page, 4)));
        model.addAttribute("customerTypeList", customerTypeService.findAllCustomerType());
        return "/admin/customer/list";
    }

    @GetMapping("/update/{idCustomer}")
    public String showUpdateRegisterForm(@PathVariable Integer idCustomer, Model model) {
        model.addAttribute("customerDto", customerService.findByIdCustomer(idCustomer));
        model.addAttribute("customerType", customerTypeService.findAllCustomerType());
        return "register_update";
    }

    @PostMapping("/update")
    public String updateRegister(@Valid @ModelAttribute("customerDto") CustomerDTO customerUpdateDTO, BindingResult bindingResult, Model model) {

        Integer id = customerUpdateDTO.getIdCustomer();
        Customer customerOld = customerService.findByIdCustomer(id);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerType", customerTypeService.findAllCustomerType());
            return "register_update";
        } else if (customerService.existsByEmail(customerUpdateDTO.getEmail()) && (!customerOld.getEmail().equals(customerUpdateDTO.getEmail()))) {
            model.addAttribute("message", "Email đã tồn tại, vui lòng nhập email khác");
            model.addAttribute("customerType", customerTypeService.findAllCustomerType());
            return "register_update";
        } else if (customerService.existsByPhone(customerUpdateDTO.getPhone()) &&(!customerOld.getPhone().equals(customerUpdateDTO.getPhone()))) {
            model.addAttribute("message", "Số điện thoại đã tồn tại, vui lòng nhập số điện thoại khác");
            model.addAttribute("customerType", customerTypeService.findAllCustomerType());
            return "register_update";
        } else if (customerService.existsByAppUser_UserName(customerUpdateDTO.getAppUser().getUserName()) &&(!customerOld.getAppUser().getUserName().equals(customerUpdateDTO.getAppUser().getUserName()))) {
            model.addAttribute("message", "Tài khoản đã tồn tại, vui lòng nhập tài khoản khác");
            model.addAttribute("customerType", customerTypeService.findAllCustomerType());
            return "register_update";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerUpdateDTO, customer);
            customerService.saveCustomer(customer);
            return "redirect:/customer";
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam(name = "delete") Integer idCustomer) {
        Customer customer = customerService.findByIdCustomer(idCustomer);
        AppUser appUser = customer.getAppUser();
        UserRole userRole = userRoleService.findUserRoleByAppUser(appUser);
        userRoleService.deleteUserRole(userRole);
        customerService.deleteCustomer(idCustomer);
        return "redirect:/customer";
    }

    @GetMapping("/type/{id}")
    public String searchByCustomerType(@PathVariable Integer id, Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("customerList", customerService.findByCustomerType(id, PageRequest.of(page, 4)));
        model.addAttribute("customerTypeList", customerTypeService.findAllCustomerType());
        return "/admin/customer/list";
    }

    @GetMapping("/search")
    public String searchByCustomerName(@RequestParam String name, Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("customerList", customerService.findByNameCustomer(name, PageRequest.of(page, 4)));
        return "/admin/customer/list";
    }

}
