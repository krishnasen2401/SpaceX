package com.lingamworks.spacex.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Core {
    @SerializedName("core")
    @Expose
    private String core;
    @SerializedName("flight")
    @Expose
    private Integer flight;
    @SerializedName("gridfins")
    @Expose
    private Boolean gridfins;
    @SerializedName("legs")
    @Expose
    private Boolean legs;
    @SerializedName("reused")
    @Expose
    private Boolean reused;
    @SerializedName("landing_attempt")
    @Expose
    private Boolean landingAttempt;
    @SerializedName("landing_success")
    @Expose
    private Boolean landingSuccess;
    @SerializedName("landing_type")
    @Expose
    private String landingType;
    @SerializedName("landpad")
    @Expose
    private String landpad;

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public Integer getFlight() {
        return flight;
    }

    public void setFlight(Integer flight) {
        this.flight = flight;
    }

    public Boolean getGridfins() {
        return gridfins;
    }

    public void setGridfins(Boolean gridfins) {
        this.gridfins = gridfins;
    }

    public Boolean getLegs() {
        return legs;
    }

    public void setLegs(Boolean legs) {
        this.legs = legs;
    }

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
    }

    public Boolean getLandingAttempt() {
        return landingAttempt;
    }

    public void setLandingAttempt(Boolean landingAttempt) {
        this.landingAttempt = landingAttempt;
    }

    public Boolean getLandingSuccess() {
        return landingSuccess;
    }

    public void setLandingSuccess(Boolean landingSuccess) {
        this.landingSuccess = landingSuccess;
    }

    public String getLandingType() {
        return landingType;
    }

    public void setLandingType(String landingType) {
        this.landingType = landingType;
    }

    public String getLandpad() {
        return landpad;
    }

    public void setLandpad(String landpad) {
        this.landpad = landpad;
    }
}
