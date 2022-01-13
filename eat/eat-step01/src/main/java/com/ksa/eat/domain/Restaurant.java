package com.ksa.eat.domain;

public class Restaurant {

    private String name;
    private String address;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurant(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return "Bob zip";
    }

    public String getInformation() {
        return name + " in " + address;
    }

    public Object getAddress() {
        return address;
    }
    
}
