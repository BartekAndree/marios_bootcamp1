package com.deloitte.ads;

public class Marios {

    public String mariosType;
    public String mariosDescription;
    public static String[] mariosTypes = new String[]{
            "Dziękuję Za Pomoc",
            "Doceniam Twoją Pracę",
            "Twoje Umiejętności Programistyczne Są Niesamowite",
            "Cieszę Si ęŻe Mogę Pracować Z Takim Utalentowanym Programistą",
            "Twoje Rozwiązania Są Zawsze Innowacyjne I Skuteczne",
    };

    public Marios(String mariosType, String mariosDescription) {
        this.mariosType = mariosType;
        this.mariosDescription = mariosDescription;
    }

    @Override
    public String toString() {
        return this.mariosDescription;
    }



}