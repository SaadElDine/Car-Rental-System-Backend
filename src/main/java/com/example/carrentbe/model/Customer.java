package com.example.carrentbe.model;



import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    private String name;
    private String contactInfo;
    private String address;
    private String accountInfo;


    // Getters
    public Integer getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getAddress() {
        return address;
    }

    public String getAccountInfo() {
        return accountInfo;
    }

    // Setters
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAccountInfo(String accountInfo) {
        this.accountInfo = accountInfo;
    }

    // toString Method
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", address='" + address + '\'' +
                ", accountInfo='" + accountInfo + '\'' +
                '}';
    }
}
