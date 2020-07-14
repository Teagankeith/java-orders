package com.javaorders.demo.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "payments")
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentid;


    @Column(nullable = false)
    private String type;

    @ManyToMany(mappedBy= "payments")
    private List<Orders> orders = new ArrayList<>();
    public Payments(long paymentid, String type) {
        this.paymentid = paymentid;
        this.type = type;
    }

    public long getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(long paymentid) {
        this.paymentid = paymentid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
