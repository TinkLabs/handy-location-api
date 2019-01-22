package com.tinklabs.common;

/**
 * @description:
 * @author: Landin
 * @date: 2019-01-15
 **/
public enum LocationCodeEnum {
    LOCATION_EXCEPTION("302101","System exception happened , please try again."),
    COUNTRY_CODE_EMPTY("302102", "The countryCode can't be empty,  please fill in."),
    COUNTRY_CODE_NOT_EXIST("302103", "The countryCode doesn't exist, please input a valid one.");
    private String code;
    private String message;
    LocationCodeEnum(String code, String message){
        this.code = code;
        this.message = message;
    }
    public String getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }
}
