/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.exp.bkd.model;

import java.io.Serializable;

/**
 *
 * @author Kavithanjali.M
 */
public class BKDUIStateModel implements Serializable{

    private boolean Booknumber;
    private boolean containerno;
    private boolean Package;
    private boolean commodity;
    private boolean amount;
    private boolean paytype;
    private boolean paymode;
    private boolean prepaid;
    private boolean collect;

    public boolean isPayat() {
        return payat;
    }

    public void setPayat(boolean payat) {
        this.payat = payat;
    }
    private boolean payat;
    private boolean paylocation;
    private boolean Export;
    private boolean Import;
    private boolean Totalprepaidcount;
    private boolean Totalcollectcount;
    private boolean Totalpayatcount;
    private boolean TotalAmount;
    private boolean Add;
    private boolean Remove;
    private boolean clear;
      //kodukura value default enable pannanuma or disable pannanuma nu statemodel ku tha therium  ctrl iruka enable disable la kodukura boolean value vachi work agum

    public boolean isAdd() {
        return Add;
    }

    public void setAdd(boolean Add) {
        this.Add = Add;
    }

    public boolean isRemove() {
        return Remove;
    }

    public void setRemove(boolean Remove) {
        this.Remove = Remove;
    }

    public boolean isClear() {
        return clear;
    }

    public void setClear(boolean clear) {
        this.clear = clear;
    }

    public boolean isBooknumber() {
        return Booknumber;
    }

    public void setBooknumber(boolean Booknumber) {
        this.Booknumber = Booknumber;
    }

   

    public boolean isContainerno() {
        return containerno;
    }

    public void setContainerno(boolean containerno) {
        this.containerno = containerno;
    }

    public boolean isPackage() {
        return Package;
    }

    public void setPackage(boolean Package) {
        this.Package = Package;
    }

    public boolean isCommodity() {
        return commodity;
    }

    public void setCommodity(boolean commodity) {
        this.commodity = commodity;
    }

    public boolean isAmount() {
        return amount;
    }

    public void setAmount(boolean amount) {
        this.amount = amount;
    }

    public boolean isPaytype() {
        return paytype;
    }

    public void setPaytype(boolean paytype) {
        this.paytype = paytype;
    }

    public boolean isPaymode() {
        return paymode;
    }

    public void setPaymode(boolean paymode) {
        this.paymode = paymode;
    }

    public boolean isPrepaid() {
        return prepaid;
    }

    public void setPrepaid(boolean prepaid) {
        this.prepaid = prepaid;
    }

    public boolean isCollect() {
        return collect;
    }

    public void setCollect(boolean collect) {
        this.collect = collect;
    }

   

    public boolean isPaylocation() {
        return paylocation;
    }

    public void setPaylocation(boolean paylocation) {
        this.paylocation = paylocation;
    }

    public boolean isExport() {
        return Export;
    }

    public void setExport(boolean Export) {
        this.Export = Export;
    }

    public boolean isImport() {
        return Import;
    }

    public void setImport(boolean Import) {
        this.Import = Import;
    }

    public boolean isTotalprepaidcount() {
        return Totalprepaidcount;
    }

    public void setTotalprepaidcount(boolean Totalprepaidcount) {
        this.Totalprepaidcount = Totalprepaidcount;
    }

    public boolean isTotalcollectcount() {
        return Totalcollectcount;
    }

    public void setTotalcollectcount(boolean Totalcollectcount) {
        this.Totalcollectcount = Totalcollectcount;
    }

    public boolean isTotalpayatcount() {
        return Totalpayatcount;
    }

    public void setTotalpayatcount(boolean Totalpayatcount) {
        this.Totalpayatcount = Totalpayatcount;
    }

    public boolean isTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(boolean TotalAmount) {
        this.TotalAmount = TotalAmount;
    }
}
