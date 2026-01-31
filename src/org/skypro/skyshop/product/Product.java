

package org.skypro.skyshop.product;
//Модель, описывающая продукт
public class Product {
    private String productName = "";
    private int productCoast;

    public Product() {

    }
    public Product(String productName, int productCoast){
        this.productName = productName;
        this.productCoast = productCoast;
    }

    public int getProductCoast() {
        return productCoast;
    }

    public String getProductName() {
        return productName;
    }
}
