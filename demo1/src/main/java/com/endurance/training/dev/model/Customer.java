package com.endurance.training.dev.model;

public class Customer
{

    private int customerId;
    private String name;

    public Customer(String name){
        this.setName(name);
    }

    public int getCustomerId()
    {
        return customerId;
    }

    public void setCustomerId(int customerId)
    {
        this.customerId = customerId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
