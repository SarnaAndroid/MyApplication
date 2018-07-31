package com.myapplication.models;

/**
 * Created by root on 9/7/18.
 */

public class ProductsData {

    private int productId;
    private String productName;
    private String productQuantity;
    private String productBrand;
    private String productSphericalPower;
    private String productCyclendricalPower;
    private int productMinQuantity;

    public ProductsData() {
    }

    public ProductsData(int productId, String productName, String productQuantity,
                        String productBrand, String productSphericalPower,
                        String productCyclendricalPower, int productMinQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productBrand = productBrand;
        this.productSphericalPower = productSphericalPower;
        this.productCyclendricalPower = productCyclendricalPower;
        this.productMinQuantity = productMinQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductSphericalPower() {
        return productSphericalPower;
    }

    public void setProductSphericalPower(String productSphericalPower) {
        this.productSphericalPower = productSphericalPower;
    }

    public String getProductCyclendricalPower() {
        return productCyclendricalPower;
    }

    public void setProductCyclendricalPower(String productCyclendricalPower) {
        this.productCyclendricalPower = productCyclendricalPower;
    }

    public int getProductMinQuantity() {
        return productMinQuantity;
    }

    public void setProductMinQuantity(int productMinQuantity) {
        this.productMinQuantity = productMinQuantity;
    }
}
