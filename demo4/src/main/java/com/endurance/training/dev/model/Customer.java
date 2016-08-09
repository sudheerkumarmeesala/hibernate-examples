package com.endurance.training.dev.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")
public class Customer
{

    private int customerId;
    private String name;

    private Set<Hobby> hobbies = new HashSet<Hobby>(0);

    public Customer()
    {
    }

    public Customer(String name)
    {
        this.setName(name);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int getCustomerId()
    {
        return customerId;
    }

    public void setCustomerId(int customerId)
    {
        this.customerId = customerId;
    }

    @Column(name = "NAME", nullable = false)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "CUSTOMER_HOBBY",
            joinColumns = @JoinColumn(name = "CUSTOMERID"),
            inverseJoinColumns = @JoinColumn(name = "HOBBYID"))
    public Set<Hobby> getHobbies()
    {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies)
    {
        this.hobbies = hobbies;
    }
}
