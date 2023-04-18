package com.example.watch_shop.service.impl;

import com.example.watch_shop.model.*;
import com.example.watch_shop.repository.ICartRepository;
import com.example.watch_shop.repository.IWatchRepository;
import com.example.watch_shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository iCartRepository;
    @Autowired
    private IWatchRepository iWatchRepository;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private IOrderDetailService iOrderDetailService;
    @Autowired
    private IWatchService iWatchService;

    @Override
    public List<Cart> findAll() {
        return (List<Cart>) iCartRepository.findAll();
    }


    @Override
    public void update(CartID cartID, Integer qtt) {
        Cart cart = findById(cartID);
        Watch watch = iWatchRepository.findById(cartID.getIdWatch()).get();
        Integer price = watch.getPrice() * qtt;
        if (qtt <= watch.getQuantity()) {
            cart.setQuantity(qtt);
            cart.setPrice(price);
            iCartRepository.save(cart);
        }

    }

    public void updateCheck(Integer idCus) {
        List<Cart> list = findByCusId(idCus);
        for (Cart cart : list) {
            cart.setCheck(1);
        }
    }

    @Override
    public void save(Cart cart) {
        boolean flag = true;
        for (Cart cart1 : findByCusId(cart.getCartID().getIdCustomer())) {
            if (cart.getCartID().getIdWatch().equals(cart1.getCartID().getIdWatch())) {
                update(cart1.getCartID(), (cart1.getQuantity() + cart.getQuantity()));
                flag = false;
                break;
            }
        }
        if (flag) {
            iCartRepository.save(cart);
        }
    }

    public void addOrder(Integer idCus) {
        Customer customer = iCustomerService.findByIdCustomer(idCus);
        List<Cart> list = findByCusId(idCus);
        Integer price = totalPrice(idCus);
        OrderWatch orderWatch = new OrderWatch(LocalDate.now(), price, customer);
        iOrderService.save(orderWatch);
        for (Cart cart : list) {
            iOrderDetailService.save(new OrderDetail(new OrderDetailID(idCus, cart.getCartID().getIdWatch())
                    , cart.getQuantity(), cart.getPrice(), cart.getWatch().getImage(), orderWatch, cart.getWatch()));
            iWatchService.updateQuantity((cart.getWatch().getQuantity()-cart.getQuantity()), cart.getWatch().getIdWatch());
            System.out.println(cart.getWatch().getQuantity()-cart.getQuantity());
        }
    }

    @Override
    public Integer totalPrice(Integer idCus) {
        return iCartRepository.totalPriceOrder(idCus);
    }

    @Override
    public void deleteById(CartID id) {
        Cart cart = findById(id);
        cart.setCheck(1);
        iCartRepository.save(cart);
    }

    @Override
    public Cart findById(CartID cartID) {
        return iCartRepository.findById(cartID).get();
    }

    @Override
    public List<Cart> findByCusId(Integer id) {
        List<Cart> list = iCartRepository.findByCustomer(id);
        for (Cart cart : list) {
            if (cart.getQuantity() > iWatchService.findById(cart.getWatch().getIdWatch()).getQuantity()) {
                cart.setQuantity(iWatchService.findById(cart.getWatch().getIdWatch()).getQuantity());
            }
        }
        return list;
    }
}
