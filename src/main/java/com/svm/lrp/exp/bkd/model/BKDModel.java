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
public class BKDModel implements Serializable {

     BKDUIDataModel BKDUIDataModel;
     BKDUIStateModel BKDUIStateModel;
  
    public BKDModel() {
        BKDUIDataModel = new BKDUIDataModel();
        BKDUIDataModel = new BKDUIDataModel();
    }

    public BKDUIDataModel getBKDUIDataModel() {
        return BKDUIDataModel;
    }

    public void setBKDUIDataModel(BKDUIDataModel BKDUIDataModel) {
        this.BKDUIDataModel = BKDUIDataModel;
    }

    public BKDUIStateModel getBKDUIStateModel() {
        return BKDUIStateModel;
    }

    public void setBKDUIStateModel(BKDUIStateModel BKDUIStateModel) {
        this.BKDUIStateModel = BKDUIStateModel;
    }
}
