package com.example.watch_shop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ManageWatchBranchID implements Serializable {
    @Column(name = "id_branch")
    private Integer idBranch;
    @Column(name = "id_watch")
    private Integer idWatch;

    public ManageWatchBranchID() {
    }

    public ManageWatchBranchID(Integer idBranch, Integer idWatch) {
        this.idBranch = idBranch;
        this.idWatch = idWatch;
    }

    public Integer getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Integer idBranch) {
        this.idBranch = idBranch;
    }

    public Integer getIdWatch() {
        return idWatch;
    }

    public void setIdWatch(Integer idWatch) {
        this.idWatch = idWatch;
    }

}
