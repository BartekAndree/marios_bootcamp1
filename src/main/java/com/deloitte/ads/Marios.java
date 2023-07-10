package com.deloitte.ads;

public class Marios {

    public MariosType mariosType;
    public String mariosDescription;
    public enum MariosType {
        MARIOS1,
        MARIOS2,
        MARIOS3,
        MARIOS4,
        MARIOS5;
    }

    public Marios(MariosType mariosType, String mariosDescription) {
        this.mariosType = mariosType;
        this.mariosDescription = mariosDescription;
    }

    @Override
    public String toString() {
        return this.mariosDescription;
    }
}
