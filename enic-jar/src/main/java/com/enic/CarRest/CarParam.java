package com.enic.CarRest;



public class CarParam {
    private String keyWord;
    private String cityName;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public CarParam(String keyWord, String cityName) {
        this.keyWord = keyWord;
        this.cityName = cityName;
    }
}
