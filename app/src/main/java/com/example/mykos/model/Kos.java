package com.example.mykos.model;

public class Kos {
    private String id, name, city, country, price, image_url, rating, address, phone, map_url, number_of_kitchens, number_of_bedrooms, number_of_cupboards;

    public Kos(String id, String name, String city, String country, String price, String image_url, String rating, String address, String phone, String map_url, String number_of_kitchens, String number_of_bedrooms, String number_of_cupboards) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.price = price;
        this.image_url = image_url;
        this.rating = rating;
        this.address = address;
        this.phone = phone;
        this.map_url = map_url;
        this.number_of_kitchens = number_of_kitchens;
        this.number_of_bedrooms = number_of_bedrooms;
        this.number_of_cupboards = number_of_cupboards;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMap_url() {
        return map_url;
    }

    public void setMap_url(String map_url) {
        this.map_url = map_url;
    }

    public String getNumber_of_kitchens() {
        return number_of_kitchens;
    }

    public void setNumber_of_kitchens(String number_of_kitchens) {
        this.number_of_kitchens = number_of_kitchens;
    }

    public String getNumber_of_bedrooms() {
        return number_of_bedrooms;
    }

    public void setNumber_of_bedrooms(String number_of_bedrooms) {
        this.number_of_bedrooms = number_of_bedrooms;
    }

    public String getNumber_of_cupboards() {
        return number_of_cupboards;
    }

    public void setNumber_of_cupboards(String number_of_cupboards) {
        this.number_of_cupboards = number_of_cupboards;
    }
}
