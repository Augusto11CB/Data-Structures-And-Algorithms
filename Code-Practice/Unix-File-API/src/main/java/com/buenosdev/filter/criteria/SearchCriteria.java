package com.buenosdev.filter.criteria;

import java.io.File;

public interface SearchCriteria {
    boolean matches(File file);
    boolean matches(com.buenosdev.filter.File file);
}
