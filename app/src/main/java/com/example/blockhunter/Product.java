package com.example.blockhunter;

/*Product Object Class*/

import java.io.Serializable;

public class Product implements Serializable {

    public Product(String productName, String productDescription, String thumbnail) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productThumbnail =  thumbnail;
    }

    private String productName;
    private String productDescription;

    public String getProductThumbnail() {
        return productThumbnail;
    }

    public void setProductThumbnail(String productThumbnail) {
        this.productThumbnail = productThumbnail;
    }

    private String productThumbnail;


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
