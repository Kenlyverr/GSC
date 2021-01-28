package com.example.gsce;

public class customFindImage {

    private int image;
    private String mean;
    private String vocabulary;

    public customFindImage(int image, String mean, String vocabulary) {
        this.image = image;
        this.mean = mean;
        this.vocabulary = vocabulary;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(String vocabulary) {
        this.vocabulary = vocabulary;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
