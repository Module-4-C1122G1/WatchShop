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
    public String showStore(@PageableDefault(size = 2) Pageable pageable, @RequestParam(defaultValue = "") String name, Model model) {
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("name", name);
        Pageable sortedPage = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        Page<Branch> branchPage = branchService.findAll(name, sortedPage);
        model.addAttribute("branchPage", branchPage);
        List<Integer> integerList =new ArrayList<>();
        for (int i = 1; i <branchPage.getTotalPages() ; i++) {
            integerList.add(i);
        }
        model.addAttribute("integerList",integerList);
        return "/admin/branch/list";
    }

    @GetMapping("/employee/{id}")
    public String showEmployee(@PathVariable("id") int id, Model model) {
        Branch branch = branchService.findById(id);
        model.addAttribute("nameEmployee" , branch.getName());
        List<Employee> employeePage = branchService.findAllEmployee(id);
        model.addAttribute("employeePage", employeePage);
        return "/admin/branch/list-employee";
    }

    @GetMapping("/watch/{idBranch}")
    public String showWatch(@PathVariable("idBranch") int idBranch, Model model) {
        Branch branch = branchService.findById(idBranch);
        model.addAttribute("nameWatch" , branch.getName());
        List<Watch> watchList = branchService.findAllWatch(idBranch);
        model.addAttribute("idBranch" , idBranch);
        model.addAttribute("watchList", watchList);
        return "/admin/branch/list-watch";
    }

    @GetMapping("/delete")
    public String deleteBranch(@RequestParam int deleteId) {
        branchService.delete(deleteId);
        return "redirect:/branch";
    }
    @GetMapping("/create")
    public String showCreateBranch(Model model) {
        model.addAttribute("domains" , domainService.findAll());
        model.addAttribute("branchDTO", new BranchDTO());
        return "/admin/branch/create";
    }

    @PostMapping("/create")
    public String createBranch(@Valid @ModelAttribute BranchDTO branchDTO , BindingResult bindingResult , Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("domains" , domainService.findAll());
            return "/admin/branch/create";
        }
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
    public String updateSoccerPlayer(@Valid @ModelAttribute BranchDTO branchDTO , BindingResult bindingResult , Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("domains" , domainService.findAll());
            return "/admin/branch/update";
        }
        branchService.update(branchDTO, branchDTO.getIdBranch());
        return "redirect:/branch";
    }
}
