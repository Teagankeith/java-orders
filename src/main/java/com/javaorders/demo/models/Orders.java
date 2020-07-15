package com.javaorders.demo.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;
    private double ordamount;
    private double advanceamount;

    //CUST KEY

    private String orderdescription;

    @ManyToOne
    @JoinColumn(name= "custcode", nullable = false)
    private Customers customer;


    @ManyToMany
    @JoinTable(name = "orderspayments", joinColumns = @JoinColumn(name="ordnum"), inverseJoinColumns = @JoinColumn(name="paymentid"))
    List<Payments> payments = new ArrayList<>();



    public Orders(long ordnum, double ordamount, double advanceamount, String orderdescription) {
        this.ordnum = ordnum;
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.orderdescription = orderdescription;
    }

    public long getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(long ordnum) {
        this.ordnum = ordnum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }


}
