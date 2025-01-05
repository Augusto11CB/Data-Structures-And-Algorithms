package com.buenosdev.filter.criteria;

import java.io.File;

public class SizeCriteria implements SearchCriteria {
    private long size;

    private String operator;


    public SizeCriteria(long size, String operator) {
        this.size = size;
        this.operator = operator;
    }

    @Override
    public boolean matches(File file) {
        return file.length() == size;
    }

    @Override
    public boolean matches(com.buenosdev.filter.File file) {


        switch (this.operator) {
            case ">":
                return file.getSize() > this.size;
            case ">=":
                return file.getSize() >= this.size;
            case "<":
                return file.getSize() < this.size;
            case "<=":
                return file.getSize() <= this.size;
            case "==":
                return file.getSize() == this.size;
            default:
                return false;
        }
    }
}
