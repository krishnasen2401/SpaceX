package com.lingamworks.spacex.Data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.lingamworks.spacex.DAO.Converters;

import java.util.List;
@Entity
public class Crew {
    @ColumnInfo(name = "name")
    @SerializedName("name")
    @Expose
    private String name;
    @ColumnInfo(name = "agency")
    @SerializedName("agency")
    @Expose
    private String agency;
    @ColumnInfo(name = "image")
    @SerializedName("image")
    @Expose
    private String image;
    @ColumnInfo(name = "wikipedia")
    @SerializedName("wikipedia")
    @Expose
    private String wikipedia;
    @SerializedName("launches")
    @Expose
    @ColumnInfo(name = "launches")
    @TypeConverters(Converters.class)
   // @Ignore
    private List<String> launches = null;
    @ColumnInfo(name = "status")
    @SerializedName("status")
    @Expose
    private String status;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    private String id;
    private boolean expanded;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public List<String> getLaunches() {
        return launches;
    }

    public void setLaunches(List<String> launches) {
        this.launches = launches;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
