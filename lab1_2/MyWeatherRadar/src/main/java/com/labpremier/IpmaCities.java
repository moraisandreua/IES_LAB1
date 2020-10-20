package com.labpremier;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class IpmaCities{
    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("data")
    @Expose
    private List<Cidade> cities = null;

    public String getOwner(){
        return this.owner;
    }
    public String getCountry(){
        return this.owner;
    }
    public List<Cidade> getCities(){
        return this.cities;
    }

    public void setOwner(String owner){
        this.owner=owner;
    }
    public void setCountry(String country){
        this.country=country;
    }
    public void setCities(List<Cidade> cities){
        this.cities=cities;
    }
}