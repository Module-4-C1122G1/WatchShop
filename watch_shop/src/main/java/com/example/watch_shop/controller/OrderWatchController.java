package com.example.watch_shop.controller;

import com.example.watch_shop.model.Customer;
import com.example.watch_shop.model.OrderWatch;
import com.example.watch_shop.service.*;
import com.example.watch_shop.service.employeeService.IBranchEService;
import com.example.watch_shop.service.manager_watch_branch.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderWatchController {
    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private ICartService iCartService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IOrderDetailService iOrderDetailService;
    @Autowired
    private IWatchService iWatchService;

    @GetMapping("")
    public String findAll(Model model, @PageableDefault(size = 6) Pageable page) {
        Page<OrderWatch> orderWatchPage = iOrderService.findAll(page);
        model.addAttribute("listOrder", orderWatchPage);
        List<Customer> list = new ArrayList<>();
        for (Integer id : iCartService.selectIdCustomer()) {
            Customer customer = iCustomerService.findByIdCustomer(id);
            list.add(customer);
        }
        model.addAttribute("customer", list);
        model.addAttribute("price", iCartService.selectTotalPriceMax());
        String[] a;
        if (iWatchService.findByNameContainingOrderBy()!=null){
            a=iWatchService.findByNameContainingOrderBy().split(",");
            model.addAttribute("nameWatch",a[0]);
            model.addAttribute("qttWatch",a[1]);
        }
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i < orderWatchPage.getTotalPages(); i++) {
            integerList.add(i);
        }
        integerList.add(integerList.size() + 1);
        model.addAttribute("integerList" , integerList);
        model.addAttribute("totalPrice", iOrderService.totalPrice());
        return "admin/cart/list";
    }

    @GetMapping("delete")
    public String delete(@RequestParam("orderId") Integer id) {
        iOrderService.delete(id);
        return "redirect:/order";
    }

    @GetMapping("detail")
    public String detail(@RequestParam("id") Integer id, Model model, @RequestParam(name = "page", defaultValue = "0") Integer page) {
        model.addAttribute("list", iOrderDetailService.findByIdOrder(id, PageRequest.of(page, 5)));
        return "admin/cart/detail";
    }


}
