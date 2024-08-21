/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.exp.bkdcbean;

import com.svm.lrp.exp.bkd.bkdLocal;
import com.svm.lrp.exp.bkd.ctrl.BKDCtrl;
import com.svm.lrp.exp.bkd.model.BKDModel;
import com.svm.lrp.nfr.jsf.utils.AbsToolBarUtils;
import com.svm.lrp.nfr.jsf.utils.ILogger;
import com.svm.lrp.nfr.jsf.utils.ISearch;
import com.svm.lrp.nfr.jsf.utils.IToolBar;
import com.svm.lrp.nfr.jsf.utils.SMDialogUtil;
import com.svm.lrp.nfr.main.bean.ToolbarCBean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.CreateException;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.NamingException;
import org.primefaces.component.toolbar.Toolbar;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Kavithanjali.M
 */
@Named(value = "BKDCbean")
@ViewScoped
public class BKDCbean implements Serializable, IToolBar, ISearch {

    private BKDCtrl ctrl;
    private BKDModel model;
private bkdLocal remote;
    private SMDialogUtil util;
    @javax.inject.Inject
    ToolbarCBean toolBar;
    @Inject
    ILogger logger;

    @PostConstruct
    public void init() throws NamingException {
        try {

            this.model = new BKDModel();
            this.remote = lookupbean();
            this.util = new SMDialogUtil();
            this.ctrl = new BKDCtrl(model, remote, util, logger, toolBar);
           
            System.out.println("----------------------Remote lookup------------------------ " + remote);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public bkdLocal lookupbean() throws NamingException {
        try {
            javax.naming.Context con = new javax.naming.InitialContext();
            bkdLocal remote = (bkdLocal) con.lookup("java:global/bkdejb/bkdBean!com.svm.lrp.exp.bkd.bkdBean");
            return remote;
        } catch (javax.naming.NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
            
        }
    }

    public bkdLocal getRemote() {
        return remote;
    }

    public void setRemote(bkdLocal remote) {
        this.remote = remote;
    }
    

    public BKDCtrl getCtrl() {
        return ctrl;
    }

    public void setCtrl(BKDCtrl ctrl) {
        this.ctrl = ctrl;
    }

    public BKDModel getModel() {
        return model;
    }

    public void setModel(BKDModel model) {
        this.model = model;
    }

 
    public SMDialogUtil getUtil() {
        return util;
    }

    public void setUtil(SMDialogUtil util) {
        this.util = util;
    }

    public ToolbarCBean getToolBar() {
        return toolBar;
    }

    public void setToolBar(ToolbarCBean toolBar) {
        this.toolBar = toolBar;
    }

    public ILogger getLogger() {
        return logger;
    }

    public void setLogger(ILogger logger) {
        this.logger = logger;
    }

    @Override
    public boolean btnNewActionPerformed(ActionEvent ae) {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnSaveActionPerformed(ActionEvent ae) {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnEditActionPerformed(ActionEvent ae) {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnDeleteActionPerformed(ActionEvent ae) {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnCancelActionPerformed(ActionEvent ae) {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnToolBarSearchActionPerformed(ActionEvent ae) {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnSaveReturn(SelectEvent se) {

        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnToolBarSearchReturn(SelectEvent se) {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnSaveAsActionPerformed(ActionEvent ae) {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnExportActionPerformed(ActionEvent ae) {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnMoveLastActionPerformed(ActionEvent ae) {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnMoveFirstActionPerformed(ActionEvent ae) {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnForwardActionPerformed(ActionEvent ae) {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnBackwardFirstActionPerformed(ActionEvent ae) {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnPrintActionPerformed(ActionEvent ae) {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AbsToolBarUtils getToolBarBean() {
//        Ctrl.toolBarState("Default"); //To change body of generated methods, choose Tools | Templates.
        return toolBar;
    }

    public BKDCbean getObject() {
        return this;
    }

    @Override
    public void getSearchData(String string, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
