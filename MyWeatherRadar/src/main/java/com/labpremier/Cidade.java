package com.labpremier;

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
    public Integer getCityName(){
        return this.cityName;
    }

    public void setGlobalIdLocal(Integer globalIdLocal){
        this.globalIdLocal=globalIdLocal;
    }
    public void setCityName(Integer cityName){
        this.cityName=cityName;
    }
}
