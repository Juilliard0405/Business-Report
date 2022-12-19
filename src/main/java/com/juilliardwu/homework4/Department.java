package com.juilliardwu.homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.stage.FileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juilliardwu
 */
public class Department {
    /**
     * class department declare member variable name and array list of workers
     */
    
    private String name;
    private WorkerWithInsurance[] workers;
    /**
     * Default constructor initializes member variables.
     */

    public Department() {
        this.name = null;
        this.workers = null;
    }
    /**
     * set name equal to n
     * @param n 
     */

    public void setName(String n) {
        this.name = n;

    }
    /**
     * get name 
     * @return name
     */

    public String getName() {
        return name;
    }
    /**
     * get workers
     * @return workers
     */

    public WorkerWithInsurance[] getWorkers() {
        return workers;
    }
    /**
     * Searches the array for the instance that has the most hours and returns it from the method
     * @return 
     */

    public WorkerWithInsurance getMostHoursWorker() {
        WorkerWithInsurance temp = new WorkerWithInsurance();
        for(WorkerWithInsurance w: workers){
            if(w.getHour()>temp.getHour()){
                temp = w;
            }
        }
        return temp;
    }
    /**
     * Open a PrintStream to filename.
     * write the report with worker
     * @param file
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void report(String file) throws FileNotFoundException, IOException{
        
            PrintWriter pw = new PrintWriter(file);
            pw.print("Department Name: "+ name + "\n");
            pw.printf("%s%26s%10s%10s%10s%10s%10s%10s\n%s%26s%10s%10s%10s%10s%10s%10s\n",
                    "Name", "Hours", "Rate", "Ins", "Pay", "Month", "Day", "Year",
                    "----", "-----", "----", "---", "---", "-----", "---", "----");

            double pay, r, h, c;
            double total = 0;
            MyDate d;
            String n;
            // set up the varible for a worker method 
            for (WorkerWithInsurance wrk : workers) {
                r = wrk.getRate();
                h = wrk.getHour();
                c = wrk.getHealthInsCost();
                d = wrk.gethireDate();
                
                
                // pay = hour * rate - insurance cost 
                pay = h * r - c;
                pw.printf("%-13s%17.2f%11.2f%9.2f%10.2f%10d%10d%10d\n", wrk.getName(), h, r, c, pay, d.getMonth(), d.getDay(), d.getYear());
                total += h;
            }
            pw.printf("Total Hour: %.2f", total);
            pw.close();
        }
    }


