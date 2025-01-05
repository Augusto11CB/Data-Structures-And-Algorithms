package com.buenosdev.filter.criteria;

import java.io.File;

public class NameCriteria implements SearchCriteria {
    private String name;
    // private boolean not = true;

    public NameCriteria(String name) {
        this.name = name;
    }

//    public NameCriteria(String name, boolean not) {
//        this.name = name;
//        this.not = not;
//    }

    @Override
    public boolean matches(File file) {
        return file.getName().equals(name);
    }

    @Override
    public boolean matches(com.buenosdev.filter.File file) {
        return  name.equals(file.getName());
    }
}
