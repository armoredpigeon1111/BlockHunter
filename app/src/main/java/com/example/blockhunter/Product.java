package com.example.blockhunter;

import java.io.Serializable;

public class Product implements Serializable {

    private String mediumImage;
    private String productName;
    private String productDescription;
    private String productThumbnail;
    private String msrp;
    private String walmartPrice;
    private String bbPrice;



    private String upc;

    public Product(String productName, String productDescription, String thumbnail, String mediumImage) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productThumbnail =  thumbnail;
        this.mediumImage = mediumImage;
    }

    public String getMediumImage() {
        return mediumImage;
    }
    public void setMediumImage(String mediumImage) {
        this.mediumImage = mediumImage;
    }

    public String getProductThumbnail() {
        return productThumbnail;
    }

    public void setProductThumbnail(String productThumbnail) {
        this.productThumbnail = productThumbnail;
    }

    public String getProductDescription(){
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductName(){
        return this.productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public String getMsrp() {
        return msrp;
    }

    public void setMsrp(String msrp) {
        this.msrp = msrp;
    }

    public String getWalmartPrice() {
        return walmartPrice;
    }

    public void setWalmartPrice(String walmartPrice) {
        this.walmartPrice = walmartPrice;
    }

    public String getBbPrice() {
        return bbPrice;
    }

    public void setBbPrice(String bbPrice) {
        this.bbPrice = bbPrice;
    }
    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

}
