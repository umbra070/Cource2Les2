

package org.skypro.skyshop.product;

//Модель, описывающая продукт
public abstract class Product {
    private String productName = "";

    public Product() {

    }

    public Product(String productName) {
        this.productName = productName;
    }

    public abstract int getProductPrice();

    public String getProductName() {
        return productName;
    }

    public abstract boolean isSpecial();
}
