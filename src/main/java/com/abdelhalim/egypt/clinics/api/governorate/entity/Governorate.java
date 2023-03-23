package com.abdelhalim.egypt.clinics.api.governorate.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Governorate {
    //    @OneToMany
//    @JoinColumn(name = "address_id")
//    private List<Address> addressSet;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String name_ar;

    public Governorate() {

    }

    public Governorate(Long id, String name, String name_ar) {
        this.id = id;
        this.name = name;
        this.name_ar = name_ar;
    }

//    public List<Address> getAddressSet() {
//        return addressSet;
//    }
//
//    public void setAddressSet(List<Address> addressSet) {
//        this.addressSet = addressSet;
//    }

    public String getName_ar() {
        return name_ar;
    }

    public void setName_ar(String name_ar) {
        this.name_ar = name_ar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
