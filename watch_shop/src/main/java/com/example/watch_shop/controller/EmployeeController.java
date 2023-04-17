package com.example.watch_shop.controller;

import com.example.watch_shop.dto.EmployeeDTO;
import com.example.watch_shop.service.employeeService.IBranchService;
import com.example.watch_shop.service.employeeService.IDiplomaService;
import com.example.watch_shop.service.employeeService.IEmployeeService;
import com.example.watch_shop.service.employeeService.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IBranchService iBranchService;
    @Autowired
    private IDiplomaService iDiplomaService;
    @Autowired
    private IPositionService iPositionService;

    @GetMapping("")
    public String list(Model model, @RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(required = false, defaultValue = "") String name) {
        Sort sort = Sort.by("name").descending();
        model.addAttribute("employee", employeeService.findByAll(name, PageRequest.of(page, 3, sort)));
        return "admin/employee/list";
    }

    @GetMapping("/create")
    public String add(Model model) {
        model.addAttribute("employeeDTO", new EmployeeDTO());
        model.addAttribute("position", iPositionService.list());
        model.addAttribute("diploma", iDiplomaService.list());
        model.addAttribute("branch", iBranchService.list());
        return "admin/employee/create";
    }

    @PostMapping("/create")
    public String add(@Valid @ModelAttribute EmployeeDTO employeeDTO, BindingResult bindingResult,
                      RedirectAttributes redirectAttributes,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("position", iPositionService.list());
            model.addAttribute("diploma", iDiplomaService.list());
            model.addAttribute("branch", iBranchService.list());
            return "admin/employee/create";
        }else {
            redirectAttributes.addFlashAttribute("msg","thêm mới thành công");
            employeeService.save(employeeDTO);
            return "redirect:/employee";
        }

    }
    @GetMapping("create1")
    public String pr(){
        return "admin/employee/update2";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id,Model model){
        model.addAttribute("employeeDTO",employeeService.findById(id));
        model.addAttribute("position", iPositionService.list());
        model.addAttribute("diploma", iDiplomaService.list());
        model.addAttribute("branch", iBranchService.list());
        return "admin/employee/update";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam(required = false) Integer deleteId){
        employeeService.delete(deleteId);
        return "redirect:/employee";
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
