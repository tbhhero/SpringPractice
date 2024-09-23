package com.cls.mapping;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "std_data")
public class Student {
    @Id
    private int id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL) // Correct mappedBy
    @JoinColumn(name = "std_fk")
    private List<Address> addressList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Student(int id, List<Address> addressList, String name) {
        this.id = id;
        this.addressList = addressList;
        this.name = name;
    }

    public Student() {
        super();
    }
}
