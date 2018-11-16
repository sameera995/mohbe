package com.sam.moh.entity.payload;


import java.util.ArrayList;
import java.util.List;

public class DataSet {

    private List<Integer> data = new ArrayList<>();
    private String label;

    public DataSet(String label) {
        this.label = label;
    }

    public DataSet() {
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
