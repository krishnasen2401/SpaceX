package com.lingamworks.spacex.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Flickr {
    @SerializedName("small")
    @Expose
    private List<Object> small = null;
    @SerializedName("original")
    @Expose
    private List<String> original = null;

    public List<Object> getSmall() {
        return small;
    }

    public void setSmall(List<Object> small) {
        this.small = small;
    }

    public List<String> getOriginal() {
        return original;
    }

    public void setOriginal(List<String> original) {
        this.original = original;
    }
}
