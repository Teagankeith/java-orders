package com.javaorders.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custcode;

    @Column(unique = true, nullable = false)
    private String custname;

    private String custcity;
    private String workingarea;
    private String custcountry;
    private String grade;
    private double openingamt;
    private double recieveamt;
    private double paymentamt;
    private double outstandingamt;
    private String phone;

    @OneToMany(mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("customer")
    private List<Orders> orders = new ArrayList<>();



    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    private Agents agent;

    public Customers(String custname, String custcity, String workingarea, String custcountry,
                     String grade, double openingamt, double recieveamt, double paymentamt, double
                             outstandingamt, String phone) {
        this.custname = custname;
        this.custcity = custcity;
        this.workingarea = workingarea;
        this.custcountry = custcountry;
        this.grade = grade;
        this.openingamt = openingamt;
        this.recieveamt = recieveamt;
        this.paymentamt = paymentamt;
        this.outstandingamt = outstandingamt;
        this.phone = phone;
    }

    public Customers() {
    }

    public long getCustcode() {
        return custcode;
    }

    public void setCustcode(long custcode) {
        this.custcode = custcode;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCustcity() {
        return custcity;
    }

    public void setCustcity(String custcity) {
        this.custcity = custcity;
    }

    public String getWorkingarea() {
        return workingarea;
    }

    public void setWorkingarea(String workingarea) {
        this.workingarea = workingarea;
    }

    public String getCustcountry() {
        return custcountry;
    }

    public void setCustcountry(String custcountry) {
        this.custcountry = custcountry;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpeningamt() {
        return openingamt;
    }

    public void setOpeningamt(double openingamt) {
        this.openingamt = openingamt;
    }

    public double getRecieveamt() {
        return recieveamt;
    }

    public void setRecieveamt(double recieveamt) {
        this.recieveamt = recieveamt;
    }

    public double getPaymentamt() {
        return paymentamt;
    }

    public void setPaymentamt(double paymentamt) {
        this.paymentamt = paymentamt;
    }

    public double getOutstandingamt() {
        return outstandingamt;
    }

    public void setOutstandingamt(double outstandingamt) {
        this.outstandingamt = outstandingamt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "custname='" + custname + '\'' +
                ", custcity='" + custcity + '\'' +
                ", workingarea='" + workingarea + '\'' +
                ", custcountry='" + custcountry + '\'' +
                ", grade='" + grade + '\'' +
                ", openingamt=" + openingamt +
                ", recieveamt=" + recieveamt +
                ", paymentamt=" + paymentamt +
                ", outstandingamt=" + outstandingamt +
                ", phone='" + phone + '\'' +
                '}';
    }
}
