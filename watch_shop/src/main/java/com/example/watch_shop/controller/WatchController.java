package com.example.watch_shop.controller;

import com.example.watch_shop.dto.CartDTO;
import com.example.watch_shop.model.Cart;
import com.example.watch_shop.model.OrderDetail;
import com.example.watch_shop.model.Watch;
import com.example.watch_shop.repository.PostCommentSummary;
import com.example.watch_shop.service.IManufactureService;
import com.example.watch_shop.service.ITypeWatchService;
import com.example.watch_shop.service.IWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("watch")
public class WatchController {
    @Autowired
    IWatchService iWatchService;
    @Autowired
    IManufactureService iManufactureService;
    @Autowired
    private ITypeWatchService iTypeWatchService;

    @GetMapping("/detail/{idWatch}")
    public String detail(@PathVariable int idWatch, Model model) {
        model.addAttribute("typeWatchList", iTypeWatchService.findAll());
        model.addAttribute("manufactureList", iManufactureService.findAll());
        model.addAttribute("watch", iWatchService.findByIdWatch(idWatch));
        return "detail";
    }

    @GetMapping("type")
    public String type(Model model, @RequestParam(name = "id", required = false) Integer id, @PageableDefault(size = 4) Pageable pageable) {
        Page<Watch> watchPage = iWatchService.findByType(id, pageable);
        model.addAttribute("list", watchPage);
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i < watchPage.getTotalPages(); i++) {
            integerList.add(i);
        }
        integerList.add(integerList.size() + 1);
        model.addAttribute("integerList", integerList);
        model.addAttribute("listManu", iManufactureService.findAll());
        model.addAttribute("id", id);
        model.addAttribute("check", 1);
        return "watches";
    }


    @GetMapping("watches")
    public String watches(Model model, @PageableDefault(size = 6) Pageable pageable) {
        Page<Watch> watchPage = iWatchService.findAllWhereIsDelete(pageable);
        model.addAttribute("list", watchPage);
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i < watchPage.getTotalPages(); i++) {
            integerList.add(i);
        }
        integerList.add(integerList.size() + 1);
        model.addAttribute("integerList", integerList);
        model.addAttribute("listManu", iManufactureService.findAll());
        model.addAttribute("check", 0);
        return "watches";
    }

    @GetMapping("register")
    public String register() {
        return "register";
    }

    @GetMapping("search")
    public String searchByName(Model model, @PageableDefault(size = 2) Pageable pageable, @RequestParam(name = "name", required = false) String name) {
        Page<Watch> watchPage = iWatchService.findByName(name, pageable);
        if (watchPage.isEmpty()) {
            String msg = "Không tìm thấy sản phẩm";
            model.addAttribute("msg", msg);
            System.out.println(msg);
        }
        model.addAttribute("list", watchPage);
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i < watchPage.getTotalPages(); i++) {
            integerList.add(i);
        }
        integerList.add(integerList.size() + 1);
        model.addAttribute("integerList", integerList);
        model.addAttribute("listManu", iManufactureService.findAll());
        model.addAttribute("check", 2);
        model.addAttribute("name", name);
        return "watches";
    }

    @GetMapping("index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page) {
        model.addAttribute("list", iWatchService.findAll(PageRequest.of(page, 12)));
        return "index";
    }
}