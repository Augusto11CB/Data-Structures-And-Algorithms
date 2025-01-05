package com.buenosdev.filter.criteria;

import java.io.File;
import java.util.List;

public class AndCriteria implements SearchCriteria {
    private List<SearchCriteria> criteriaList;

    public AndCriteria(List<SearchCriteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Override
    public boolean matches(File file) {
        for (SearchCriteria criteria : criteriaList) {
            if (!criteria.matches(file)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean matches(com.buenosdev.filter.File file) {
        for (SearchCriteria criteria : criteriaList) {
            if (!criteria.matches(file)) {
                return false;
            }
        }
        return true;
    }
}
