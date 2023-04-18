package com.example.watch_shop.controller;

import com.example.watch_shop.dto.WatchDTO;
import com.example.watch_shop.model.Watch;
import com.example.watch_shop.service.IManufactureService;
import com.example.watch_shop.service.ITypeWatchService;
import com.example.watch_shop.service.IWatchService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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

//    @GetMapping("")
//    public String showList(@RequestParam(required = false, defaultValue = "") String name, @PageableDefault(sort = {"idWatch"}, direction = Sort.Direction.DESC, size = 5) Pageable pageable, Model model) {
//        model.addAttribute("name", name);
//        model.addAttribute("watchList", iWatchService.findAllWatch(name, pageable));
//        List<Integer> integerList = new ArrayList<>();
//        for (int i = 0; i < iWatchService.findAllWatch(name, pageable).getTotalPages(); i++) {
//            integerList.add(i);
//        }
//        model.addAttribute("countPages", integerList);
//        return "/admin/product/list";
//    }


    @GetMapping("")
    public String list(Model model, @PageableDefault(size = 5)Pageable pageable,
                       @RequestParam(defaultValue = "") String name) {
        Sort sort= Sort.by("idWatch").descending();
        Pageable sortedPage = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(),sort);
        Page<Watch> watchPage=iWatchService.findAllWatch(name, (PageRequest) sortedPage);
        model.addAttribute("watchList",watchPage);
        List<Integer> integerList =new ArrayList<>();
        for (int i = 1; i <watchPage.getTotalPages() ; i++) {
            integerList.add(i);
        }
        model.addAttribute("integerList",integerList);
        return "/admin/product/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("typeWatchList", iTypeWatchService.findAll());
        model.addAttribute("manufactureList", iManufactureService.findAll());
        model.addAttribute("watch", new WatchDTO());
        return "/admin/product/create";
    }

    @PostMapping("/create")
    public String performCreate(@Valid @ModelAttribute("watch") WatchDTO watchDTO,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("watchDTO", watchDTO);
            return "/admin/product/create";
        } else {
            Watch watch = new Watch();
            BeanUtils.copyProperties(watchDTO, watch);
            iWatchService.save(watch);
            redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
            return "redirect:/adminWatch";
        }
    }

    @GetMapping("/update/{idWatch}")
    public String showUpdate(@PathVariable int idWatch, Model model) {
        model.addAttribute("typeWatchList", iTypeWatchService.findAll());
        model.addAttribute("manufactureList", iManufactureService.findAll());
        model.addAttribute("watch", iWatchService.findByIdWatch(idWatch));
        return "admin/product/update";
    }

    @PostMapping("/update")
    public String performUpdate(@Valid @ModelAttribute("watch") WatchDTO watchDTO,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("watchDTO", watchDTO);
            return "admin/product/update";
        } else {
            Watch watch = new Watch();
            BeanUtils.copyProperties(watchDTO, watch);
            iWatchService.save(watch);
            redirectAttributes.addFlashAttribute("msg", "Cập nhập thành công");
            return "redirect:/adminWatch";
        }
    }

    @GetMapping("/delete")
    public String performDelete(@RequestParam(required = false) Integer deleteId) {
        iWatchService.delete(deleteId);
        return "redirect:/adminWatch";
    }
}
