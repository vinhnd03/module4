package com.vinhnd.hom_thu_dien_tu.entity;

public class Email {
    private int id;
    private String language;
    private int pageSize;
    private boolean filter;
    private String signature;

    private static int counter = 1;

    public Email() {
        this.id = counter++;
    }

    public Email(String language, int pageSize, boolean filter, String signature) {
//        this.id = counter++;
        this.language = language;
        this.pageSize = pageSize;
        this.filter = filter;
        this.signature = signature;
    }

    public Email(int id, String language, int pageSize, boolean filter, String signature) {
        this.id = id;
        this.language = language;
        this.pageSize = pageSize;
        this.filter = filter;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
