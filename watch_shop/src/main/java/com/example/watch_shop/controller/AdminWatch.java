package com.example.watch_shop.controller;

import com.example.watch_shop.model.Watch;
import com.example.watch_shop.service.IManufactureService;
import com.example.watch_shop.service.ITypeWatchService;
import com.example.watch_shop.service.IWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/adminWatch")
public class AdminWatch {
    @Autowired
    @Qualifier("watchService")
    private IWatchService iWatchService;
    @Autowired
    private ITypeWatchService iTypeWatchService;
    @Autowired
    private IManufactureService iManufactureService;

    @GetMapping("")
    public String showList(@RequestParam(required = false, defaultValue = "") String name, @PageableDefault(sort = {"idWatch"}, direction = Sort.Direction.DESC, size = 5) Pageable pageable, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("watchList", iWatchService.findAllWatch(name, pageable));
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < iWatchService.findAllWatch(name, pageable).getTotalPages(); i++) {
            integerList.add(i);
        }
        model.addAttribute("countPages", integerList);
        return "/admin/product/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("typeWatchList",iTypeWatchService.findAll());
        model.addAttribute("manufactureList",iManufactureService.findAll());
        model.addAttribute("watch",new Watch());
        return "/admin/product/create";
    }
    @PostMapping("/create")
    public String performCreate(@ModelAttribute Watch watch) {
        iWatchService.save(watch);
        return "redirect:/adminWatch";
    }
    @GetMapping("/update/{idWatch}")
    public String showUpdate(@PathVariable int idWatch, Model model) {
        model.addAttribute("typeWatchList", iTypeWatchService.findAll());
        model.addAttribute("manufactureList",iManufactureService.findAll());
        model.addAttribute("watch", iWatchService.findByIdWatch(idWatch));
        return "admin/product/update";
    }

    @PostMapping("/update")
    public String performUpdate(@ModelAttribute Watch watch) {
        iWatchService.save(watch);
        return "redirect:/adminWatch";
    }

    @GetMapping("/delete")
    public String performDelete(@RequestParam(required = false) Integer deleteId){
        iWatchService.delete(deleteId);
        return "redirect:/adminWatch";
    }
}
