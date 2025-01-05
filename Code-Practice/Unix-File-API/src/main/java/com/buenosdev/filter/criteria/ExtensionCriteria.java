package com.buenosdev.filter.criteria;

import java.io.File;

public class ExtensionCriteria implements SearchCriteria {
    private String extension;

    public ExtensionCriteria(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean matches(File file) {
        return file.getName().endsWith("." + extension);
    }

    @Override
    public boolean matches(com.buenosdev.filter.File file) {
        return extension.equals(file.getExtension());
    }
}
