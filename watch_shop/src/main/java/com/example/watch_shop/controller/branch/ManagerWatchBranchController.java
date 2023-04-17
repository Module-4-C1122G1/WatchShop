package com.example.watch_shop.controller.branch;

import com.example.watch_shop.dto.BranchDTO;
import com.example.watch_shop.model.Branch;
import com.example.watch_shop.model.Employee;
import com.example.watch_shop.model.Watch;
import com.example.watch_shop.service.IWatchService;
import com.example.watch_shop.service.manager_watch_branch.IBranchService;
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
@RequestMapping("/branch")
public class ManagerWatchBranchController {
    @Autowired
    private IBranchService branchService;
    @Autowired
    private IWatchService watchService;

    @GetMapping("")
    public String showStore(@PageableDefault(size = 3) Pageable pageable, @RequestParam(defaultValue = "") String name, Model model) {
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("name", name);
        Pageable sortedPage = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        Page<Branch> branchPage = branchService.findAll(name, sortedPage);
        model.addAttribute("branchPage", branchPage);
        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 0; i < branchPage.getTotalPages(); i++) {
            pageNumberList.add(i);
        }
        model.addAttribute("pageNumberList", pageNumberList);
        return "/admin/branch/list";
    }

    @GetMapping("/employee/{id}")
    public String showEmployee(@PathVariable("id") int id, Model model) {
        List<Employee> employeePage = branchService.findAllEmployee(id);
        model.addAttribute("employeePage", employeePage);
        return "/admin/branch/list-employee";
    }

    @GetMapping("/watch/{idBranch}")
    public String showWatch(@PathVariable("idBranch") int idBranch, Model model) {
        List<Watch> watchList = branchService.findAllWatch(idBranch);
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
        model.addAttribute("branch", new BranchDTO());
        return "/admin/branch/create";
    }

    @PostMapping("/create")
    public String createBranch(@ModelAttribute BranchDTO branch) {
        branchService.create(branch);
        return "redirect:/branch";
    }

    @GetMapping("/update")
    public String showUpdateSoccerPlayer(@RequestParam int id, Model model) {
        model.addAttribute("branch", branchService.findById(id));
        return "/admin/branch/update";
    }

    @PostMapping("/update")
    public String updateSoccerPlayer(@ModelAttribute BranchDTO branch) {
        branchService.update(branch, branch.getIdBranch());
        return "redirect:/branch";
    }
}
