package com.example.blockhunter;

/*Product Object Class*/

import java.io.Serializable;

public class Product implements Serializable {

    public Product(String productName, String productDescription) {
        this.productName = productName;
        this.productDescription = productDescription;
    }

    private String productName;
    private String productDescription;



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
