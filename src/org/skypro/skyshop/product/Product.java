

package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

//Модель, описывающая продукт
public abstract class Product implements Searchable {
    private String productName = "";

    public Product(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        this.productName = productName;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getSearchTerm() {
        return productName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        return this.getName().equals(((Product) obj).getName());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public abstract boolean isSpecial();

    public abstract int getProductPrice();

    @Override
    public String getName() {
        return productName;
    }
}
