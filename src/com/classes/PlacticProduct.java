package com.classes;

public class PlacticProduct {
    private String rank;
    private String polymerProducer;
    private String numOfAssets;
    private String flexible_SUP_waste;
    private String rigid_SUP_waste;
    private String total_SUP_waste;

    public PlacticProduct(String rank, String polymerProducer, String numOfAssets, String flexible_SUP_waste, String rigid_SUP_waste, String total_SUP_waste) {
        this.rank = rank;
        this.polymerProducer = polymerProducer;
        this.numOfAssets = numOfAssets;
        this.flexible_SUP_waste = flexible_SUP_waste;
        this.rigid_SUP_waste = rigid_SUP_waste;
        this.total_SUP_waste = total_SUP_waste;
    }

    public String getRank() {
        return rank;
    }

    public String getPolymerProducer() {
        return polymerProducer;
    }

    public String getNumOfAssets() {
        return numOfAssets;
    }

    public String getFlexible_SUP_waste() {
        return flexible_SUP_waste;
    }

    public String getRigid_SUP_waste() {
        return rigid_SUP_waste;
    }

    public String getTotal_SUP_waste() {
        return total_SUP_waste;
    }

    @Override
    public String toString() {
        return "PlacticProduct{" +
                "rank='" + rank + '\'' +
                ", polymerProducer='" + polymerProducer + '\'' +
                ", numOfAssets='" + numOfAssets + '\'' +
                ", flexible_SUP_waste='" + flexible_SUP_waste + '\'' +
                ", rigid_SUP_waste='" + rigid_SUP_waste + '\'' +
                ", total_SUP_waste='" + total_SUP_waste + '\'' +
                '}';
    }
}
