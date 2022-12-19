/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juilliardwu.homework4;

import com.juilliardwu.homework4.MyDate;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author juilliardwu
 */
/**
 * class definition
 * declare first name, hours and rate, hire date 
 */
public class Worker {
    @SerializedName("name")
    protected String name;
    @SerializedName("hours")
    protected double hours;
    @SerializedName("rate")
    protected double rate;
    @SerializedName("hireDate")
    protected MyDate hireDate;
    

    /**
     * Default constructor sets all value to default
     */
    public Worker() {
        this.name = "NONAME";
        this.hours = 0.00;
        this.rate = 0.00;
        this.hireDate =  new MyDate();
    }

    /**
     * set worker name according to the method argument
     *
     * @param n string
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * set hour according to the method argument
     *
     * @param h double
     */

    public void setHour(double h) {
        hours = h;
    }

    /**
     * set rate according to the method argument
     *
     * @param r double
     */
    public void setRate(double r) {
        rate = r;
    }

    /**
     * getName sting variable and return name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getHour value and return hours
     *
     * @return hours
     */
    public double getHour() {
        return hours;
    }

    /**
     * getRate value and return rate
     *
     * @return rate
     */
    public double getRate() {
        return rate;
    }
    /**
     * gets the hire date
     * @return hireDate
     */
    public MyDate gethireDate(){
        return hireDate;
    }
    /**
     * sets the hire date
     * @param hireDate 
     */
    public void sethireDate(MyDate hireDate){
        this.hireDate = hireDate;
    }
}