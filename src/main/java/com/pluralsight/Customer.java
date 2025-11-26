package com.pluralsight;

public class Customer {
    private String contactName;
    private String companyName;
    private String city;
    private String country;
    private String phone;


    public Customer(String contactName, String city, String companyName, String country, String phone) {
        this.contactName = contactName;
        this.city = city;
        this.companyName = companyName;
        this.country = country;
        this.phone = phone;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "contactName='" + contactName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phone=" + phone +
                '}';
    }
}

