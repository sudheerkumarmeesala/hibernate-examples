package com.endurance.training.dev.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HOBBY")
public class Hobby
{

    private int hobbyId;
    private String description;

    private Set<Customer> customers = new HashSet<Customer>(0);

    public Hobby()
    {
    }

    public Hobby(String description)
    {
        this.setDescription(description);
    }

    @Column(name = "DESCRIPTION")
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int getHobbyId()
    {
        return hobbyId;
    }

    public void setHobbyId(int hobbyId)
    {
        this.hobbyId = hobbyId;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "hobbies")
    public Set<Customer> getCustomers()
    {
        return customers;
    }

    public void setCustomers(Set<Customer> customers)
    {
        this.customers = customers;
    }

}
