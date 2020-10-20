package com.labpremier;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cidade {
    @SerializedName("globalIdLocal")
    @Expose
    private Integer globalIdLocal;

    @SerializedName("local")
    @Expose
    private String cityName;

    public Integer getGlobalIdLocal(){
        return this.globalIdLocal;
    }
    public String getCityName(){
        return this.cityName;
    }

    public void setGlobalIdLocal(Integer globalIdLocal){
        this.globalIdLocal=globalIdLocal;
    }
    public void setCityName(String cityName){
        this.cityName=cityName;
    }
}
