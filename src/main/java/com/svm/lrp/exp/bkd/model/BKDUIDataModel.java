/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.exp.bkd.model;

import com.svm.lrp.exp.kmn.vo.BkdVo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kavithanjali.M
 */
public class BKDUIDataModel implements Serializable {
//value="#{BKDCbean.model.BKDUIDataModel.booknumber}"

//001 book number tharan athu data model setter poy store agitum  athunama ctrl use panrom  and frontend la kodukura value data model la poy store agum
    //anga iruthu edukumpothu get
    //value anga poy podrathuku set 
    private String booknumber;
    private String containerno;
    private String Package;
    private String commodity;
    private int amount;
    private String paytype;
    private String paymode;
    private String prepaid;
    private List DefaultColumnModel;

    public BkdVo getVo() {
        return vo;
    }

    public void setVo(BkdVo vo) {
        this.vo = vo;
    }
    private List<BkdVo> getdatalist = new ArrayList<BkdVo>();

    public List<BkdVo> getSelecteddataList() {
        return SelecteddataList;
    }

    //private List getdatalist;
    public void setSelecteddataList(List<BkdVo> SelecteddataList) {
        this.SelecteddataList = SelecteddataList;
    }
    private List<BkdVo> SelecteddataList= new ArrayList<BkdVo>();;
    private int totalprepaidcount;
    private int totalcollectcount;
    private int totalpayatcount;
    private int totalAmount;
    private ArrayList datatable;
    private BkdVo vo;
    private List columnModelList;//
    private String paylocation;
    private String Export;
    private String Import;

    

    public List<BkdVo> getGetdatalist() {
        return getdatalist;
    }

    public void setGetdatalist(List<BkdVo> getdatalist) {
        this.getdatalist = getdatalist;
    }

    

    public List getDefaultColumnModel() {
        return DefaultColumnModel;
    }

    public void setDefaultColumnModel(List DefaultColumnModel) {
        this.DefaultColumnModel = DefaultColumnModel;
    }

    public String getPayat() {
        return payat;
    }

    public void setPayat(String payat) {
        this.payat = payat;
    }
    private String collect;
    private String payat;

    public String getBooknumber() {
        return booknumber;
    }

    public void setBooknumber(String booknumber) {
        this.booknumber = booknumber;
    }

    public int getTotalprepaidcount() {
        return totalprepaidcount;
    }

    public void setTotalprepaidcount(int totalprepaidcount) {
        this.totalprepaidcount = totalprepaidcount;
    }

    public int getTotalcollectcount() {
        return totalcollectcount;
    }

    public void setTotalcollectcount(int totalcollectcount) {
        this.totalcollectcount = totalcollectcount;
    }

    public int getTotalpayatcount() {
        return totalpayatcount;
    }

    public void setTotalpayatcount(int totalpayatcount) {
        this.totalpayatcount = totalpayatcount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ArrayList getDatatable() {
        return datatable;
    }

    public void setDatatable(ArrayList datatable) {
        this.datatable = datatable;
    }

    public List getColumnModelList() {
        return columnModelList;
    }

    public void setColumnModelList(List columnModelList) {
        this.columnModelList = columnModelList;
    }

    public String getContainerno() {
        return containerno;
    }

    public void setContainerno(String containerno) {
        this.containerno = containerno;
    }

    public String getPackage() {
        return Package;
    }

    public void setPackage(String Package) {
        this.Package = Package;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getPaymode() {
        return paymode;
    }

    public void setPaymode(String paymode) {
        this.paymode = paymode;
    }

    public String getPrepaid() {
        return prepaid;
    }

    public void setPrepaid(String prepaid) {
        this.prepaid = prepaid;
    }

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

    public String getPaylocation() {
        return paylocation;
    }

    public void setPaylocation(String paylocation) {
        this.paylocation = paylocation;
    }

    public String getExport() {
        return Export;
    }

    public void setExport(String Export) {
        this.Export = Export;
    }

    public String getImport() {
        return Import;
    }

    public void setImport(String Import) {
        this.Import = Import;
    }

    public void setTotalAmount(List dataa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setTotalprepaidcount(List dataa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setTotalcollectcount(ArrayList<BkdVo> dataa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setTotalpayatcount(List dataa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
