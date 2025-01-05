package com.buenosdev.filter.criteria;

import java.io.File;
import java.util.List;

public class OrCriteria implements SearchCriteria {
    private List<SearchCriteria> criteriaList;

    public OrCriteria(List<SearchCriteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Override
    public boolean matches(File file) {
        for (SearchCriteria criteria : criteriaList) {
            if (criteria.matches(file)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean matches(com.buenosdev.filter.File file) {
        for (SearchCriteria criteria : criteriaList) {
            if (criteria.matches(file)) {
                return true;
            }
        }
        return false;
    }
}
