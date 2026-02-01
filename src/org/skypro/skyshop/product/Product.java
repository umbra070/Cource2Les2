

package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

//Модель, описывающая продукт
public abstract class Product implements Searchable {
    private String productName = "";

    public Product() {

    }

    public Product(String productName) {
        this.productName = productName;
    }

    public String getContentType() {
        return "PRODUCT";
    }

    public String getProductName() {
        return productName;
    }

    public String getSearchTerm() {
        return productName;
    }

    public abstract boolean isSpecial();

    public abstract int getProductPrice();


}
