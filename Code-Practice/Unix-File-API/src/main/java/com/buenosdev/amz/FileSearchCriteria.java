package com.buenosdev.amz;

import java.util.Optional;

public class FileSearchCriteria {
    private Optional<String> name;
    private Optional<String> extension;
    private Optional<Long> minSize;
    private Optional<Long> maxSize;


    private Optional<Long> size;
    private Optional<String> operator;

    public FileSearchCriteria(String name, String extension, Long minSize, Long maxSize) {
        this.name = Optional.ofNullable(name);
        this.extension = Optional.ofNullable(extension);
        this.minSize = Optional.ofNullable(minSize);
        this.maxSize = Optional.ofNullable(maxSize);
        this.operator = Optional.empty();
        this.size = Optional.empty();
    }

    public FileSearchCriteria(String name, String extension, Long size, String operator) {
        this.name = Optional.ofNullable(name);
        this.extension = Optional.ofNullable(extension);
        this.operator = Optional.ofNullable(operator);
        this.size = Optional.ofNullable(size);
    }

    public Optional<String> getName() {
        return name;
    }

    public Optional<String> getExtension() {
        return extension;
    }

    public Optional<Long> getMinSize() {
        return minSize;
    }

    public Optional<Long> getMaxSize() {
        return maxSize;
    }

    public Optional<Long> getSize() {
        return size;
    }

    public Optional<String> getOperator(){
        return operator;
    }

}

