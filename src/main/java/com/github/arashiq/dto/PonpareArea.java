package com.github.arashiq.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by arashiQ on 2016/03/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PonpareArea {
    private String code;
    private String name;

    public PonpareArea(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public PonpareArea() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PonpareArea{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
