package com.example.watch_shop.controller;

import com.example.watch_shop.service.employeeService.IBranchService;
import com.example.watch_shop.service.employeeService.IDilomaService;
import com.example.watch_shop.service.employeeService.IEmployeeService;
import com.example.watch_shop.service.employeeService.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class EmployController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IBranchService iBranchService;
    @Autowired
    private IDilomaService iDilomaService;
    @Autowired
    private IPositionService iPositionService;
    @GetMapping("")
    public String list(Model model, @RequestParam(defaultValue = "0")Integer page,
                       @RequestParam(required = false,defaultValue = "")String name){
        Sort sort=Sort.by("name").descending();
        model.addAttribute("employee",employeeService.findByAll(name, PageRequest.of(page,3,sort)));
        return "admin/employee/list";
    }
//    @GetMapping("")
//    public String list(Model model){
//        model.addAttribute("position",iPositionService.list());
//        model.addAttribute("diloma",iDilomaService.list());
//        model.addAttribute("branch",iBranchService.list());
//        model.addAttribute("employee",employeeService.list());
//        return "admin/employee/list";
//    }
}
