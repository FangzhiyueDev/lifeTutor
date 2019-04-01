package com.xiaofangfang.lib.area;

import java.util.List;

public class CountryRegions {
    private String name;

    private String code;

    private List<States> states ;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }
    public void setStates(List<States> states){
        this.states = states;
    }
    public List<States> getStates(){
        return this.states;
    }

}