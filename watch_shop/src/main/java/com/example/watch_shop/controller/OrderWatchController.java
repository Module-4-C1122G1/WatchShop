package com.example.watch_shop.controller;

import com.example.watch_shop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("order")
public class OrderWatchController {
    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private ICartService iCartService;
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public String findAll(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page) {
        model.addAttribute("listOrder", iOrderService.findAll(PageRequest.of(page, 4)));
        List<Customer> list = new ArrayList<>();
        for (Integer id:iCartService.selectIdCustomer()){
            Customer customer=iCustomerService.findByIdCustomer(id);
            list.add(customer);
        }
        model.addAttribute("customer",list);
        model.addAttribute("price",iCartService.selectTotalPriceMax());
        model.addAttribute("totalPrice",iOrderService.totalPrice());
        return "admin/cart/list";
    }

    @GetMapping("delete")
    public String delete(@RequestParam("orderId") Integer id) {
        iOrderService.delete(id);
        return "redirect:/order";
    }



}
