package com.example.watch_shop.controller;

import com.example.watch_shop.model.*;
import com.example.watch_shop.repository.IOrderDetailRepository;
import com.example.watch_shop.service.ICartService;
import com.example.watch_shop.service.ICustomerService;
import com.example.watch_shop.service.IOrderDetailService;
import com.example.watch_shop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("carts")
public class CartController {
    @Autowired
    ICartService iCartService;
    @Autowired
    IOrderService iOrderService;
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    IOrderDetailService iOrderDetailService;

    @GetMapping("")
    public String list(Model model,@RequestParam("idCus") Integer id) {
        model.addAttribute("list", iCartService.findByCusId(id));
        model.addAttribute("total", iCartService.totalPrice(id));
        return "cart";
    }

    @GetMapping("delete")
    public String delete(@RequestParam Integer idWatch, @RequestParam Integer idCus) {
        CartID id = new CartID(idCus, idWatch);
        iCartService.deleteById(id);
        return "redirect:/carts";
    }

    @GetMapping("buy")
    public String buy(Integer idCus) {
        Customer customer=iCustomerService.findByIdCustomer(idCus);
        List<Cart> list=iCartService.findByCusId(idCus);
        Integer price=iCartService.totalPrice(idCus);
        iOrderService.save(new OrderWatch(LocalDate.now(),price,customer));

        for (Cart cart:list){
//            iOrderDetailService.save(new OrderDetail(new OrderDetailID(idCus,cart.getCartID().getIdWatch()),cart.getQuantity(),cart.getPrice(),cart.getWatch().getImage(),));
        }
        return "index";
    }
}
