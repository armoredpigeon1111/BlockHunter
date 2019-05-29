package com.example.blockhunter;

/*Product Object Class*/

import java.io.Serializable;

public class Product implements Serializable {


    private String mediumImage;
    private String productName;
    private String productDescription;
    private String productThumbnail;

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



}
