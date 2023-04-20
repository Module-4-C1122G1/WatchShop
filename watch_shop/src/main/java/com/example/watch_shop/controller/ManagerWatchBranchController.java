package com.example.watch_shop.controller;

import com.example.watch_shop.dto.BranchDTO;
import com.example.watch_shop.model.Branch;
import com.example.watch_shop.model.Employee;
import com.example.watch_shop.model.Watch;
import com.example.watch_shop.service.employeeService.IDomainService;
import com.example.watch_shop.service.manager_watch_branch.IBranchService;
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
@RequestMapping("/branch")
public class ManagerWatchBranchController {
    @Autowired
    private IBranchService branchService;
    @Autowired
    private IDomainService domainService;
    @GetMapping("")
    public String showStore(@PageableDefault(size = 4) Pageable pageable, @RequestParam(defaultValue = "") String name, Model model) {
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("name", name);
        Pageable sortedPage = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        Page<Branch> branchPage = branchService.findAll(name, sortedPage);
        model.addAttribute("branchPage", branchPage);
        List<Integer> integerList =new ArrayList<>();
        for (int i = 1; i <branchPage.getTotalPages() ; i++) {
            integerList.add(i);
        }
        integerList.add(integerList.size() + 1);
        model.addAttribute("list" , branchPage.getTotalElements());
        model.addAttribute("integerList",integerList);
        return "/admin/branch/list";
    }

    @GetMapping("/employee")
    public String showEmployee(@RequestParam(name = "id" , required = false) Integer id, @PageableDefault(size = 5) Pageable pageable, Model model) {
        Branch branch = branchService.findById(id);
        model.addAttribute("id" , branch.getIdBranch());
        model.addAttribute("nameEmployee" , branch.getName());
        Page<Employee> employeePage = branchService.findAllEmployee(id , pageable);
        model.addAttribute("employeePage", employeePage);
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i < employeePage.getTotalPages(); i++) {
            integerList.add(i);
        }
        integerList.add(integerList.size() + 1);
        model.addAttribute("integerList" , integerList);
        return "/admin/branch/list-employee";
    }

    @GetMapping("/watch")
    public String showWatch(@RequestParam(name = "id" , required = false) Integer id,@PageableDefault(size = 5) Pageable pageable , Model model) {
        Branch branch = branchService.findById(id);
        model.addAttribute("nameWatch" , branch.getName());
        model.addAttribute("id" , branch.getIdBranch());
        Page<Watch> watchList = branchService.findAllWatch(id , pageable);
        model.addAttribute("idBranch" , id);
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i < watchList.getTotalPages(); i++) {
            integerList.add(i);
        }
        integerList.add(integerList.size() + 1);
        model.addAttribute("integerList" , integerList);
        model.addAttribute("watchList", watchList);
        return "/admin/branch/list-watch";
    }

    @GetMapping("/delete")
    public String deleteBranch(@RequestParam int deleteId , Model model , RedirectAttributes redirectAttributes) {
        branchService.delete(deleteId);
        Branch branch = branchService.findById(deleteId);
        redirectAttributes.addFlashAttribute("msg" , "Xoá " + branch.getName() + " thành công");
        return "redirect:/branch";
    }
    @GetMapping("/create")
    public String showCreateBranch(Model model) {
        model.addAttribute("domains" , domainService.findAll());
        model.addAttribute("branchDTO", new BranchDTO());
        return "/admin/branch/create";
    }

    @PostMapping("/create")
    public String createBranch(@Valid @ModelAttribute BranchDTO branchDTO , BindingResult bindingResult , Model model , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            model.addAttribute("domains" , domainService.findAll());
            return "/admin/branch/create";
        }
        redirectAttributes.addFlashAttribute("msg" , "Thêm mới thành công");
        branchService.create(branchDTO);
        return "redirect:/branch";
    }

    @GetMapping("/update")
    public String showUpdateSoccerPlayer(@RequestParam int id, Model model) {
        model.addAttribute("domains" , domainService.findAll());
        model.addAttribute("branchDTO", branchService.findById(id));
        return "/admin/branch/update";
    }

    @PostMapping("/update")
    public String updateSoccerPlayer(@Valid @ModelAttribute BranchDTO branchDTO , BindingResult bindingResult , Model model , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            model.addAttribute("domains" , domainService.findAll());
            return "/admin/branch/update";
        }
        redirectAttributes.addFlashAttribute("msg" , "Chỉnh sửa thành công");
        branchService.update(branchDTO, branchDTO.getIdBranch());
        return "redirect:/branch";
    }
}
