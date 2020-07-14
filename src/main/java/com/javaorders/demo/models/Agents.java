package com.javaorders.demo.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agents")
public class Agents {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentcode;

    @Column(unique = true, nullable = false)
    public String name;

    public double comission;
    public String agentcountry;
    public String phone;
    public String workarea;


    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Customers> customers = new ArrayList<>();


    public Agents(String name, double comission, String agentcountry, String phone, String workarea) {
        this.name = name;
        this.comission = comission;
        this.agentcountry = agentcountry;
        this.phone = phone;
        this.workarea = workarea;
    }

    public long getAgentcode() {
        return agentcode;
    }

    public void setAgentcode(long agentcode) {
        this.agentcode = agentcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getComission() {
        return comission;
    }

    public void setComission(double comission) {
        this.comission = comission;
    }

    public String getAgentcountry() {
        return agentcountry;
    }

    public void setAgentcountry(String agentcountry) {
        this.agentcountry = agentcountry;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkarea() {
        return workarea;
    }

    public void setWorkarea(String workarea) {
        this.workarea = workarea;
    }

    @Override
    public String toString() {
        return "Agents{" +
                "name='" + name + '\'' +
                ", comission=" + comission +
                ", agentcountry='" + agentcountry + '\'' +
                ", phone='" + phone + '\'' +
                ", workarea='" + workarea + '\'' +
                '}';
    }
}
