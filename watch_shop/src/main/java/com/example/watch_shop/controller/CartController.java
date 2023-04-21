package com.example.watch_shop.controller;

import com.example.watch_shop.dto.CartDTO;
import com.example.watch_shop.model.*;
import com.example.watch_shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private ICartService iCartService;
    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IOrderDetailService iOrderDetailService;
    @Autowired
    private IWatchService iWatchService;

    @GetMapping("")
    public String list(Model model, @RequestParam(value = "name", required = false) String nameAcc) {
        Customer customer=iCustomerService.findByNameAccount(nameAcc);
        model.addAttribute("nameAcc", nameAcc);
        model.addAttribute("list", iCartService.findByCusId(customer.getIdCustomer()));
        model.addAttribute("total", iCartService.totalPrice(customer.getIdCustomer()));
        return "cart";
    }
    @GetMapping("pay")
    public String pay(Model model,@RequestParam("nameAcc")String name){
        Customer customer=iCustomerService.findByNameAccount(name);
        model.addAttribute("total",iCartService.totalPrice(customer.getIdCustomer()));
        return "pay";
    }
    @GetMapping("add")
    private String addCart(@RequestParam("nameAccount")String nameAcc,
                       @RequestParam("qtt")Integer qtt,
                       @RequestParam("idWatch") Integer idWatch,
                       @RequestParam("price") Integer price){
        iCartService.addCart(nameAcc,idWatch,price,qtt);
        return "redirect:/watch/index";
    }

    @GetMapping("/delete")
    public RedirectView deleteCart(@RequestParam String nameAcc,@RequestParam Integer idWatch, @RequestParam Integer idCus, RedirectAttributes redirectAttributes) {
        CartID id = new CartID(idCus, idWatch);
        iCartService.deleteById(id);
        redirectAttributes.addAttribute("name",nameAcc);
        return new RedirectView("/carts");
    }

    @GetMapping("buys")
    public String buy(@RequestParam("name") String nameAcc) {
        Customer customer=iCustomerService.findByNameAccount(nameAcc);
        iCartService.addOrder(customer.getIdCustomer());
        iCartService.updateCheck(customer.getIdCustomer());
        return "redirect:/watch/index";
    }
    @GetMapping("order")
    private String orderOneProduct(@RequestParam("nameAccount")String nameAcc,
                                   @RequestParam("qtt")Integer qtt,
                                   @RequestParam("idWatch") Integer idWatch,
                                   @RequestParam("price") Integer price){

        iCartService.addOneOrder(nameAcc,idWatch,qtt,price);
        return "redirect:/watch/index";

    }
}
