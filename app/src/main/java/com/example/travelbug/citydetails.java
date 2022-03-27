package com.example.travelbug;

public class citydetails {

    private String id;
    private String place_name;
    private String description;
    private String image_url,url="http://192.168.43.96/mcad/cityimages/";

    public  citydetails(){
        this.id = id;
        this.place_name = place_name;
        this.image_url = image_url;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = url + image_url;
    }
}
