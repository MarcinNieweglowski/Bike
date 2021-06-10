package com.marcin.bike.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String email;

    private String phone;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE},
            fetch = FetchType.LAZY)
    private BikeModel model;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    private boolean contact;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JoinTable(name = "bike_to_extras",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "extra_id")})
    private Set<BikeExtras> bikeExtras = new HashSet<>();

    @Override
    public String toString() {
        return "Bike id:" + this.id + " name:" + this.userName;
    }

    @Override
    public int hashCode () {
        return this.userName.hashCode() * this.email.hashCode() * this.phone.hashCode();
    }
}
