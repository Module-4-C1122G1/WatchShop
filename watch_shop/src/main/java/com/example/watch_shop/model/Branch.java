package com.example.watch_shop.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_branch")
    private Integer idBranch;
    @Pattern(regexp = "^(([a-zA-Z\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]*)([a-zA-Z\\s\\'ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]*)([a-zA-Z\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]))*$" , message = "Không chứa kí tự số và kí tự đặc biệt")
    @NotBlank(message = "Không được để trống")
    @Column(name = "name_branch")
    private String name;
    @NotBlank(message = "Không được để trống")
    @Column(name = "address_branch")
    private String address;
    @NotNull(message = "Không được để trống")
    @Column(name = "area_branch")
    private double area;
    @Column(name = "is_delete" , nullable = false)
    private boolean isDelete;
    @OneToMany(cascade = CascadeType.ALL)
    Set<Employee> employeeSet;
    @ManyToMany(mappedBy = "branchSet")
    private Set<Watch> watchSet;
    @ManyToOne
    @JoinColumn(name = "id_domain")
    private Domain domain;
    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public Branch() {
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public Branch(Integer idBranch, String name, String address, double area) {
        this.idBranch = idBranch;
        this.name = name;
        this.address = address;
        this.area = area;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Integer getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Integer idBranch) {
        this.idBranch = idBranch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Watch> getWatchSet() {
        return watchSet;
    }

    public void setWatchSet(Set<Watch> watchSet) {
        this.watchSet = watchSet;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
    public void removeWatch(Set<Watch> watches) {
        this.watchSet.removeAll(watches);
    }
    public void removeEmployee(Set<Employee> employees){
        this.employeeSet.remove(employees);
    }
}