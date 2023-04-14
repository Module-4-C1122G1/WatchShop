package com.example.watch_shop.controller;

import com.example.watch_shop.dto.CustomerDTO;
import com.example.watch_shop.model.Customer;
import com.example.watch_shop.repository.ICustomerTypeRepository;
import com.example.watch_shop.service.ICustomerService;
import com.example.watch_shop.service.ICustomerTypeService;
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
    ICustomerService customerService;
    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String showListCustomer(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("customerList", customerService.findAllCustomer(PageRequest.of(page, 2)));
        model.addAttribute("customerTypeList", customerTypeService.findAllCustomerType());
        return "admin/customer/list";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam(name = "delete") Integer idCustomer) {
        customerService.deleteCustomer(idCustomer);
        return "redirect:/customer";
    }

    @GetMapping("/type/{id}")
    public String searchByCustomerType(@PathVariable Integer id, Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("customerList", customerService.findByCustomerType(id, PageRequest.of(page, 2)));
        model.addAttribute("customerTypeList", customerTypeService.findAllCustomerType());
        return "admin/customer/list";
    }

    @GetMapping("/search")
    public String searchByCustomerName(@RequestParam String name, Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("customerList", customerService.findByNameCustomer(name, PageRequest.of(page, 2)));
        return "admin/customer/list";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("customerDto", new CustomerDTO());
        model.addAttribute("customerType", customerTypeService.findAllCustomerType());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("customerDto") CustomerDTO customerCreateDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerType", customerTypeService.findAllCustomerType());
            return "register";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerCreateDTO, customer);
            customerService.saveCustomer(customer);
            return "redirect:/customer";
        }
    }

    @GetMapping("/update/{idCustomer}")
    public String showUpdateRegisterForm(@PathVariable Integer idCustomer, Model model){
        model.addAttribute("customerDto", customerService.findByIdCustomer(idCustomer));
        model.addAttribute("customerType", customerTypeService.findAllCustomerType());
        return "register_update";
    }
    @PostMapping("/update")
    public String updateRegister(@Valid @ModelAttribute("customerDto") CustomerDTO customerUpdateDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerType", customerTypeService.findAllCustomerType());
            return "register_update";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerUpdateDTO, customer);
            customerService.saveCustomer(customer);
            return "redirect:/customer";
        }
    }
}
