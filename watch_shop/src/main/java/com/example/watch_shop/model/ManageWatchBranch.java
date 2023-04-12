package com.example.watch_shop.model;

import javax.persistence.*;

@Entity
@Table(name = "manage_product_branch")
public class ManageWatchBranch {

    @EmbeddedId
    private ManageWatchBranchID manageWatchBranchID;
    @ManyToOne
    @MapsId("idBranch")
    @JoinColumn(name = "id_branch")
    private Branch branch;
    @ManyToOne
    @MapsId("idWatch")
    @JoinColumn(name = "id_watch")
    private Watch watch;


    public ManageWatchBranch() {
    }

    public ManageWatchBranch(ManageWatchBranchID manageWatchBranchID, Branch branch, Watch watch) {
        this.manageWatchBranchID = manageWatchBranchID;
        this.branch = branch;
        this.watch = watch;
    }

    public ManageWatchBranchID getManageWatchBranchID() {
        return manageWatchBranchID;
    }

    public void setManageWatchBranchID(ManageWatchBranchID manageWatchBranchID) {
        this.manageWatchBranchID = manageWatchBranchID;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Watch getWatch() {
        return watch;
    }

    public void setWatch(Watch watch) {
        this.watch = watch;
    }
}
