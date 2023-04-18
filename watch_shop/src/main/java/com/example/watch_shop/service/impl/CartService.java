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

    public void addCart(String nameAcc, Integer idWatch, Integer price, Integer qtt) {
        Customer customer = iCustomerService.findByNameAccount(nameAcc);
        Watch watch = iWatchService.findByIdWatch(idWatch);
        int totalPrice;
        totalPrice = qtt * price;
        Cart cart;
        if (watch.getQuantity() < qtt) {
            cart = new Cart(new CartID(customer.getIdCustomer(), idWatch), totalPrice, watch.getQuantity(), 0,0, customer, watch);
        } else {
            cart = new Cart(new CartID(customer.getIdCustomer(), idWatch), totalPrice, qtt, 0,0, customer, watch);
        }
        save(cart);
    }

    public void updateCheck(Integer idCus) {
        List<Cart> list = findByCusId(idCus);
        for (Cart cart : list) {
            cart.setCheck(1);
            iCartRepository.save(cart);
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

    @Override
    public void addOneOrder(String nameAcc, Integer idWatch, Integer qtt, Integer price) {
        Customer customer = iCustomerService.findByNameAccount(nameAcc);
        Watch watch = iWatchService.findById(idWatch);
        OrderWatch orderWatch = new OrderWatch(LocalDate.now(), price, customer);
        iOrderService.save(orderWatch);
        OrderDetail orderDetail = new OrderDetail(new OrderDetailID(customer.getIdCustomer(), idWatch), qtt, price, watch.getImage(), orderWatch, watch);
        iOrderDetailService.save(orderDetail);
    }

    public void addOrder(Integer idCus) {
        Customer customer = iCustomerService.findByIdCustomer(idCus);
        List<Cart> list = findByCusId(idCus);
        Integer price = totalPrice(idCus);
        OrderWatch orderWatch = new OrderWatch(LocalDate.now(), price, customer);
        iOrderService.save(orderWatch);
        for (Cart cart : list) {
            OrderDetail orderDetail = new OrderDetail(new OrderDetailID(idCus, cart.getCartID().getIdWatch())
                    , cart.getQuantity(), cart.getPrice(), cart.getWatch().getImage(), orderWatch, cart.getWatch());

            iOrderDetailService.save(orderDetail);
            iWatchService.updateQuantity((cart.getWatch().getQuantity() - cart.getQuantity()), cart.getWatch().getIdWatch());
        }
    }


    @Override
    public Integer totalPrice(Integer idCus) {
        return iCartRepository.totalPriceOrder(idCus);
    }

    @Override
    public void deleteById(CartID id) {
        Cart cart = findById(id);
        cart.setCheck_delete(1);
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
                Watch watch = iWatchService.findById(cart.getWatch().getIdWatch());
                cart.setQuantity(watch.getQuantity());
                cart.setPrice(watch.getPrice() * watch.getQuantity());
                iCartRepository.save(cart);
            }
        }
        return list;
    }
}
