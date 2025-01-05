package com.buenosdev.filter.criteria;

import java.io.File;

public class NotCriteria implements SearchCriteria {
    private SearchCriteria criteria;

    public NotCriteria(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public boolean matches(File file) {
        return !criteria.matches(file);
    }

    @Override
    public boolean matches(com.buenosdev.filter.File file) {
        return !criteria.matches(file);
    }
}
