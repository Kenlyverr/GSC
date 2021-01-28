package com.example.gsce;

public class custom {
    private int image;
    private String spelling;
    private String vocabulary;
    private String mean;


    public custom(int image, String spelling, String vocabulary, String mean) {
        this.image = image;
        this.spelling = spelling;
        this.vocabulary = vocabulary;
        this.mean = mean;
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    public String getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(String vocabulary) {
        this.vocabulary = vocabulary;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
