/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juilliardwu.homework4;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author juilliardwu
 */
public class WorkerWithInsurance extends Worker {

    /**
     * member variable healthInsCos contain cost of insurance
     */
    @SerializedName("healthInsCost")
    protected double HealthInsCost;

    /**
     * initialize the new member variable
     */
    public WorkerWithInsurance() {
        super();
        this.HealthInsCost = 0.0;
    }

    /**
     * set insurance cost according the method argument
     *
     * @param HealthInsCost
     */
    public void setHealthInsCost(double HealthInsCost) {
        this.HealthInsCost = HealthInsCost;

    }

    /**
     * get the insurance cost
     *
     * @return HealthInsCost
     */
    public double getHealthInsCost() {
        return HealthInsCost;
    }
}
