/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.exp.bkd.ctrl;

import com.svm.lrp.exp.bkd.model.BKDModel;
import com.svm.lrp.exp.kmn.vo.BkdVo;
import com.svm.lrp.exp.bkd.bkdLocal;
import com.svm.lrp.nfr.jsf.utils.AbsToolBarUtils;
import com.svm.lrp.nfr.jsf.utils.ILogger;
import com.svm.lrp.nfr.jsf.utils.SMDialogUtil;
import com.svm.lrp.nfr.jsf.utils.ToolBarUtils;
import com.svm.lrp.nfr.jsf.utils.ToolbarButton;
import com.svm.lrp.nfr.jsf.utils.ToolbarState;
import com.svm.lrp.nfr.main.bean.ToolbarCBean;
import com.svm.nfr.component.datatable.DefaultColumnModel;
import static java.lang.System.exit;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;

public class BKDCtrl {

    public BKDModel getModel() {
        return model;
    }

    public void setModel(BKDModel model) {
        this.model = model;
    }

    BKDModel model;
    private ToolbarCBean toolbar;
    private SMDialogUtil util;
    private bkdLocal remote;
   int totalAmount = 0;

    int pcount = 0;
    int ccount = 0;
    int ptcount = 0;
    int amount =0;

    private Set<String> s = new HashSet<>();

    public BKDCtrl(BKDModel model, bkdLocal remote, SMDialogUtil util, ILogger logger, ToolbarCBean toolBar) {
        this.model = model;
        this.toolbar = toolBar;
        this.util = util;
        this.remote = remote;
        initialize();

    }

    public void initialize() {
        toolBarState("Default");

        model.getBKDUIDataModel().setBooknumber("");
        model.getBKDUIDataModel().setAmount(0);
        model.getBKDUIDataModel().setCommodity("");
        model.getBKDUIDataModel().setContainerno("");
        model.getBKDUIDataModel().setPaytype("Export");
        model.getBKDUIDataModel().setPaylocation("");
        model.getBKDUIDataModel().setPaymode("Collect");
        model.getBKDUIDataModel().setPackage("");
        model.getBKDUIDataModel().setTotalAmount(totalAmount);
        model.getBKDUIDataModel().setTotalcollectcount(ccount);
        model.getBKDUIDataModel().setTotalpayatcount(ptcount);
        model.getBKDUIDataModel().setTotalprepaidcount(pcount);
        columnModelList();
        System.out.println("showsdetails");
        showBookingDetails();
        System.out.println("inside initmethod");
        showBookingDetails1();
        System.out.println("outside initmethod");
    }

    public void toolBarState(String Button) {
        switch (Button) {
            case "Default": {
                ToolBarUtils.disableBtn(ToolbarButton.NEW, false, (AbsToolBarUtils) this.toolbar);
                ToolBarUtils.disableBtn(ToolbarButton.SAVE, true, (AbsToolBarUtils) this.toolbar);
                ToolBarUtils.disableBtn(ToolbarButton.CANCEL, true, (AbsToolBarUtils) this.toolbar);
                ToolBarUtils.disableBtn(ToolbarButton.EDIT, true, (AbsToolBarUtils) this.toolbar);
                ToolBarUtils.disableBtn(ToolbarButton.DELETE, true, (AbsToolBarUtils) this.toolbar);
                ToolBarUtils.disableBtn(ToolbarButton.SEARCH, true, (AbsToolBarUtils) this.toolbar);
                ToolBarUtils.disableBtn(ToolbarButton.EXPORT, true, (AbsToolBarUtils) this.toolbar);
                ToolBarUtils.disableBtn(ToolbarButton.PRINT, true, (AbsToolBarUtils) this.toolbar);
                break;
            }
        }
    }

    public ToolbarCBean getToolbar() {
        return toolbar;
    }

    public void setToolbar(ToolbarCBean toolbar) {
        this.toolbar = toolbar;
    }

    public SMDialogUtil getUtil() {
        return util;
    }

    public void setUtil(SMDialogUtil util) {
        this.util = util;
    }

    public void addaction1() {

        btwaddaction();
    }

    public void btwaddaction() {
        boolean flag = false;

        try {
            if (inputvalidation() && checkBookNumber1()) {
                System.out.println("condition true");

                BkdVo vo1 = new BkdVo();

                //data model la iruka value vo la set panran
                vo1.setBooknumber(nullCheck(model.getBKDUIDataModel().getBooknumber().toString().trim()));
                vo1.setAmount(nullCheckInteger(model.getBKDUIDataModel().getAmount()));
                System.out.println("--inside add2----" + model.getBKDUIDataModel().getAmount());
                vo1.setCommodity(nullCheck(model.getBKDUIDataModel().getCommodity().toString().trim()));
                System.out.println("--inside add4----" + model.getBKDUIDataModel().getCommodity());
                vo1.setContainernumber(nullCheck(model.getBKDUIDataModel().getContainerno().toString().trim()));
                System.out.println("--inside add5----" + model.getBKDUIDataModel().getContainerno());
                vo1.setPackage(nullCheck(model.getBKDUIDataModel().getPackage().toString().trim()));
                System.out.println("--inside add7--" + model.getBKDUIDataModel().getPackage());
                vo1.setPaylocation(nullCheck(model.getBKDUIDataModel().getPaylocation().toString().trim()));
                System.out.println("--inside add6---" + model.getBKDUIDataModel().getPaylocation());
                vo1.setPaymode(nullCheck(model.getBKDUIDataModel().getPaymode().toString().trim()));
                System.out.println("--inside add8--" + model.getBKDUIDataModel().getPaymode().trim());
                vo1.setPaytype(nullCheck(model.getBKDUIDataModel().getPaytype().toString().trim()));
                System.out.println("--inside add9--" + model.getBKDUIDataModel().getPaytype().trim());
                checkTotalAmount();

                vo1.setTotalAmount(nullCheckInteger(model.getBKDUIDataModel().getTotalAmount()));
                System.out.println("--inside add10---" + model.getBKDUIDataModel().getTotalAmount());
                countOfBookingDetails();
                vo1.setTotalcollectcount(nullCheckInteger(model.getBKDUIDataModel().getTotalcollectcount()));//doubt 
                System.out.println("--inside add11---" + model.getBKDUIDataModel().getTotalcollectcount());
                vo1.setTotalprepaidcount(nullCheckInteger(model.getBKDUIDataModel().getTotalprepaidcount()));// doubt
                System.out.println("--inside add12---" + model.getBKDUIDataModel().getTotalprepaidcount());
                vo1.setTotalpayatcount(nullCheckInteger(model.getBKDUIDataModel().getTotalpayatcount()));// doubt 
                System.out.println("--inside add13---" + model.getBKDUIDataModel().getTotalpayatcount());

                this.model.getBKDUIDataModel().getGetdatalist().add(vo1);

                System.out.println("Sout Executed");
                remote.save(vo1);
                System.out.println("Added successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Added  not successfully");
        }
        RequestContext.getCurrentInstance().update("Bkd-BKD_sample");
    }

    public void clearaction() {
        System.out.println("cleared successfully");

        this.model.getBKDUIDataModel().setBooknumber("");
        System.out.println("--inside add1----" + this.model.getBKDUIDataModel().getBooknumber());

        this.model.getBKDUIDataModel().setCommodity("");
        this.model.getBKDUIDataModel().setContainerno("");

        this.model.getBKDUIDataModel().setPackage("");
        this.model.getBKDUIDataModel().setPaylocation("");
        this.model.getBKDUIDataModel().setPaymode("Collect");

        this.model.getBKDUIDataModel().setPaytype("Export");

        this.model.getBKDUIDataModel().setAmount(0);

        // enableDisableComponents(true);
        RequestContext.getCurrentInstance().update("Bkd");
        System.out.println("details cleared");
    }

    public void enableDisableComponents(boolean input) {
        model.getBKDUIStateModel().setBooknumber(input);
        model.getBKDUIStateModel().setAmount(input);
        model.getBKDUIStateModel().setCollect(input);
        model.getBKDUIStateModel().setCommodity(input);
        model.getBKDUIStateModel().setContainerno(input);
        model.getBKDUIStateModel().setExport(input);
        model.getBKDUIStateModel().setImport(input);
        model.getBKDUIStateModel().setPackage(input);
        model.getBKDUIStateModel().setPaylocation(input);
        model.getBKDUIStateModel().setPaymode(input);
        model.getBKDUIStateModel().setPrepaid(input);
        model.getBKDUIStateModel().setPaytype(input);
        model.getBKDUIStateModel().setTotalAmount(input);
        model.getBKDUIStateModel().setTotalcollectcount(input);
        model.getBKDUIStateModel().setTotalprepaidcount(input);
        model.getBKDUIStateModel().setTotalpayatcount(input);
    }

    public boolean inputvalidation() {

        try {
            System.out.println("this.model.getBKDUIDataModel().getBooknumber()------=" + this.model.getBKDUIDataModel().getBooknumber());

            if ((this.model.getBKDUIDataModel().getBooknumber().length() == 0)
                    && (this.model.getBKDUIDataModel().getBooknumber().equalsIgnoreCase(""))) {
                System.out.println("Booknumber>>>>>>>>>>>>>>>>");
                FacesContext fm = FacesContext.getCurrentInstance();
                fm.addMessage(null, new FacesMessage("Enter the Booknumber"));

                return false;

            }

            if ((this.model.getBKDUIDataModel().getCommodity().length() == 0) && (this.model.getBKDUIDataModel().getCommodity().equalsIgnoreCase(""))) {
                FacesContext fm = FacesContext.getCurrentInstance();
                fm.addMessage(null, new FacesMessage("Enter the commodity"));

                return false;
            }
            if ((this.model.getBKDUIDataModel().getContainerno().length() == 0) && (this.model.getBKDUIDataModel().getContainerno().equalsIgnoreCase(""))) {
                FacesContext fm = FacesContext.getCurrentInstance();
                fm.addMessage(null, new FacesMessage("select the ContainerNumber"));

                return false;
            }
            if ((this.model.getBKDUIDataModel().getPaylocation().length() == 0) && (this.model.getBKDUIDataModel().getPaylocation().equalsIgnoreCase(""))) {
                FacesContext fm = FacesContext.getCurrentInstance();
                fm.addMessage(null, new FacesMessage("select the paylocation"));

                return false;
            }
            if ((this.model.getBKDUIDataModel().getPackage().length() == 0) && (this.model.getBKDUIDataModel().getPackage().equalsIgnoreCase(""))) {
                FacesContext fm = FacesContext.getCurrentInstance();
                fm.addMessage(null, new FacesMessage("Enter the Package"));

                return false;
            }
            if ((this.model.getBKDUIDataModel().getPaytype().length() == 0) && (this.model.getBKDUIDataModel().getPaytype().equalsIgnoreCase(""))) {
                FacesContext fm = FacesContext.getCurrentInstance();
                fm.addMessage(null, new FacesMessage("select the paytype"));

                return false;
            } else {
                System.out.println("inside else");
            }

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

        return true;

    }

    private void columnModelList() {
        try {

            List<DefaultColumnModel> header = new ArrayList();
            DefaultColumnModel dc;
            dc = new DefaultColumnModel();
            dc.setHeaderName("Select");
            dc.setCheckboxSelection(Boolean.valueOf(true));
            dc.setHeaderCheckboxSelection(Boolean.valueOf(true));
            // dc17.setWidth(100);
            header.add(dc);

            dc = new DefaultColumnModel();
            dc.setHeaderName("Book number");//column ku nama kodura name
            dc.setField("Booknumber");//vo iruthu above column ku value set panrom

            header.add(dc);
            dc = new DefaultColumnModel();
            dc.setHeaderName("Amount");
            dc.setField("amount");

            header.add(dc);

            dc = new DefaultColumnModel();
            dc.setHeaderName("Commodity");
            dc.setField("Commodity");

            header.add(dc);
            dc = new DefaultColumnModel();
            dc.setHeaderName("containernumber");
            dc.setField("containernumber");

            header.add(dc);
            dc = new DefaultColumnModel();
            dc.setHeaderName("paylocation");
            dc.setField("paylocation");

            header.add(dc);
            dc = new DefaultColumnModel();
            dc.setHeaderName("Package");
            dc.setField("Package");

            header.add(dc);
            dc = new DefaultColumnModel();
            dc.setHeaderName("paytype");
            dc.setField("paytype");

            header.add(dc);
            dc = new DefaultColumnModel();
            dc.setHeaderName("paymode");
            dc.setField("paymode");

            header.add(dc);

            model.getBKDUIDataModel().setDefaultColumnModel(header);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showBookingDetails() {
        System.out.println("inside showdetails");
        List data1 = remote.getdata();
        model.getBKDUIDataModel().setGetdatalist(new ArrayList());
        if (!data1.isEmpty()) {
            try {
                model.getBKDUIDataModel().getGetdatalist().addAll(data1);

            } catch (Exception e) {
                e.printStackTrace();
            }
            RequestContext.getCurrentInstance().update("Bkd-BKD_sample");

        }
    }
public void showBookingDetails1() {
    if(!model.getBKDUIDataModel().getGetdatalist().isEmpty()){
    System.out.println("inside showBookingDetails1");
    BkdVo v1=new BkdVo();
   
    for(int i=0;i<model.getBKDUIDataModel().getGetdatalist().size();i++){
       v1= (BkdVo)model.getBKDUIDataModel().getGetdatalist().get(i);
       
      amount=v1.amount+amount;
      model.getBKDUIDataModel().setTotalAmount(amount);
       if(v1.paymode.contains("Prepaid")){
      pcount++;
      model.getBKDUIDataModel().setTotalprepaidcount(pcount);
       }
       else if(v1.paymode.contains("Collect")){
      ccount++;
        
        model.getBKDUIDataModel().setTotalcollectcount(ccount);
       }
       else{
           
      ptcount++;
  
        model.getBKDUIDataModel().setTotalpayatcount(ptcount);
       }
       
      
       
    }
       RequestContext.getCurrentInstance().update("Bkd-TotalPrepaidCount1");
                RequestContext.getCurrentInstance().update("Bkd-TotalCollectCount1");
                RequestContext.getCurrentInstance().update("Bkd-TotalpaybyCount1");
                RequestContext.getCurrentInstance().update("Bkd-TotalAmount1"); 

        } }
    
    public void countOfBookingDetails() {

        if (model.getBKDUIDataModel().getPaymode().equalsIgnoreCase("prepaid")) {
            pcount++;
            model.getBKDUIDataModel().setTotalprepaidcount(pcount);
            RequestContext.getCurrentInstance().update("Bkd-TotalPrepaidCount1");
        } else if (model.getBKDUIDataModel().getPaymode().equalsIgnoreCase("Collect")) {
            ccount++;
            model.getBKDUIDataModel().setTotalcollectcount(ccount);
            RequestContext.getCurrentInstance().update("Bkd-TotalCollectCount1");
        } else {

            ptcount++;
            model.getBKDUIDataModel().setTotalpayatcount(ptcount);
            RequestContext.getCurrentInstance().update("Bkd-TotalpaybyCount1");
        }
    }

    public void checkTotalAmount() {

        System.out.println("totalAmount********* " + totalAmount);
        totalAmount = totalAmount + model.getBKDUIDataModel().getAmount();
        System.out.println("totalAmount***&&&&&&&&&***** " + totalAmount);
        model.getBKDUIDataModel().setTotalAmount(totalAmount);
        System.out.println("totalAmount*%%%%%%%%%%%%%%%%% " + totalAmount);
        RequestContext.getCurrentInstance().update("Bkd-TotalAmount1");

    }

    public void removeaction() {
        String a = "";
        BkdVo vo1 = new BkdVo();

        try {
            checktotalamount();
            for (int i = 0; i < model.getBKDUIDataModel().getSelecteddataList().size(); i++) {
                vo1 = (BkdVo) model.getBKDUIDataModel().getSelecteddataList().get(i);
                if (vo1.paymode.contains("Prepaid")) {
                int vv  = model.getBKDUIDataModel().getTotalprepaidcount();
                    model.getBKDUIDataModel().setTotalprepaidcount(--vv);

                } else if (vo1.paymode.contains("Collect")) {
                    model.getBKDUIDataModel().setTotalcollectcount(--ccount);

                } else {
                    model.getBKDUIDataModel().setTotalpayatcount(--ptcount);

                }

                a = remote.deleteaction(vo1.getBooknumber());

                model.getBKDUIDataModel().getGetdatalist().remove(vo1);

                RequestContext.getCurrentInstance().update("Bkd-TotalPrepaidCount1");
                RequestContext.getCurrentInstance().update("Bkd-TotalCollectCount1");
                RequestContext.getCurrentInstance().update("Bkd-TotalpaybyCount1");
                RequestContext.getCurrentInstance().update("Bkd-TotalAmount1");
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception when nullCheck :" + e);
        } finally {
            if (a.equalsIgnoreCase("sucessfully")) {
                util.showDialog("BKD", SMDialogUtil.type.INFO, "K11", "", null);
            } else {
                util.showDialog("BKD", SMDialogUtil.type.INFO, "K12", "", null);
            }

        }
        RequestContext.getCurrentInstance().update("Bkd-BKD_sample");
    }
  

    private String nullCheck(String value) {
        String retuser = "";
        try {

            if (value != null && value.trim().length() > 0) {
                retuser = value.trim();

            } else {
                retuser = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception when nullCheck :" + e);
        }
        return retuser;
    }

    public int nullCheckInteger(Integer value) {
        int retValue = 0; // Default return value
        try {
            if (value != null) {
                retValue = value;
            } else {
                retValue = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception when nullCheckInteger: " + e);
        }
        return retValue;
    }

    public boolean checkBookNumber1() {

        System.out.println("condition True");
        if (!model.getBKDUIDataModel().getGetdatalist().isEmpty()) {

            return checkBookNumber();

        }

        return true;

    }

    public boolean checkBookNumber() {

        System.out.println("Get the Book number:" + model.getBKDUIDataModel().getBooknumber());
        String k = model.getBKDUIDataModel().getBooknumber();
        System.out.println("K value" + k);
        for (int i = 0; i < model.getBKDUIDataModel().getGetdatalist().size(); i++) {
            System.out.println("outputttt" + model.getBKDUIDataModel().getGetdatalist().get(i).Booknumber);
            if (k.equalsIgnoreCase(model.getBKDUIDataModel().getGetdatalist().get(i).Booknumber)) {
                System.out.println("condition sa");
                FacesContext fm = FacesContext.getCurrentInstance();
                fm.addMessage(null, new FacesMessage("Book number already exists"));
                System.out.println("go to endsession");
                return false;// go to checkbooknumber option
            }
        }
        System.out.println("go to add method");
        return true;
    }

    public void checktotalamount() {


        System.out.println("checktotalamount inside" + totalAmount);
        for (int i = 0; i < model.getBKDUIDataModel().getSelecteddataList().size(); i++) {
            int n = model.getBKDUIDataModel().getSelecteddataList().get(i).amount;
          
            System.out.println("itrate amount" + n);

            totalAmount = totalAmount - n;
            System.out.println("checktotalamount endblock" + totalAmount);
            model.getBKDUIDataModel().setTotalAmount(totalAmount);
        }
        System.out.println("amoutttttttttt" + model.getBKDUIDataModel().getTotalAmount());
        

    }


}
