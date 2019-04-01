package com.xiaofangfang.lib.area;

import java.util.List;

public class States {
    private String name;

    private String code;

    private List<Citys> citys ;

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
    public void setCitys(List<Citys> citys){
        this.citys = citys;
    }
    public List<Citys> getCitys(){
        return this.citys;
    }

}