package com.kien.service;

import java.util.ArrayList;
import java.util.List;

public class Page<E>{
    private int pageNumber;
    private int pagesAvailable;
    private List<E> pageItems = new ArrayList<>();

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPagesAvailable(int pagesAvailable) {
        this.pagesAvailable = pagesAvailable;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPagesAvailable() {
        return pagesAvailable;
    }

    public List<E> getPageItems() {
        return pageItems;
    }

    public void setPageItems(List<E> pageItems) {
        this.pageItems = pageItems;
    }
}
