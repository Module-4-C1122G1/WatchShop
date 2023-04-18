package com.example.watch_shop.controller;

import com.example.watch_shop.dto.EmployeeDTO;
import com.example.watch_shop.model.Employee;
import com.example.watch_shop.service.employeeService.IBranchEService;
import com.example.watch_shop.service.employeeService.IDiplomaService;
import com.example.watch_shop.service.employeeService.IEmployeeService;
import com.example.watch_shop.service.employeeService.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IBranchEService iBranchEService;
    @Autowired
    private IDiplomaService iDiplomaService;
    @Autowired
    private IPositionService iPositionService;

    @GetMapping("")
    public String list(Model model, @PageableDefault(size = 5)Pageable pageable,
                       @RequestParam(defaultValue = "") String name) {
        Sort sort = Sort.by("name").descending();
        Pageable sortedPage = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(),sort);
        Page<Employee> employeePage=employeeService.findByAll(name, (PageRequest) sortedPage);
        model.addAttribute("employee",employeePage);
        List<Integer> integerList =new ArrayList<>();
        for (int i = 1; i <employeePage.getTotalPages() ; i++) {
            integerList.add(i);
        }
        model.addAttribute("integerList",integerList);
//        model.addAttribute("employee", employeeService.findByAll(name, PageRequest.of(page, 3, sort)));
        return "admin/employee/list";
    }

    @GetMapping("/create")
    public String add(Model model) {
        model.addAttribute("employeeDTO", new EmployeeDTO());
        model.addAttribute("position", iPositionService.list());
        model.addAttribute("diploma", iDiplomaService.list());
        model.addAttribute("branch", iBranchEService.list());
        return "admin/employee/create";
    }

    @PostMapping("/create")
    public String add(@Valid @ModelAttribute EmployeeDTO employeeDTO, BindingResult bindingResult,
                      RedirectAttributes redirectAttributes,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("position", iPositionService.list());
            model.addAttribute("diploma", iDiplomaService.list());
            model.addAttribute("branch", iBranchEService.list());
            return "admin/employee/create";
        }else {
            redirectAttributes.addFlashAttribute("msg","thêm mới thành công");
            employeeService.save(employeeDTO);
            return "redirect:/employee";
        }
    }


//    @GetMapping("create1")
//    public String pr(){
//        return "admin/employee/update2";
//    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id,Model model){
        model.addAttribute("employeeDTO",employeeService.findById(id));
        model.addAttribute("position", iPositionService.list());
        model.addAttribute("diploma", iDiplomaService.list());
        model.addAttribute("branch", iBranchEService.list());
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
//        model.addAttribute("branch",iBranchEService.list());
//        model.addAttribute("employee",employeeService.list());
//        return "admin/employee/list";
//    }
}
