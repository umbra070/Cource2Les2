package org.skypro.skyshop.product;

public class DiscountProduct extends Product {
    private int productPrice;
    private int discount;

    public DiscountProduct(String productName, int productPrice, int discount) {
        super(productName);
        this.productPrice = productPrice;
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return String.format("%s : %d(%d%%)", this.getProductName(), this.getProductPrice(), this.getDiscount());
    }

    @Override
    public int getProductPrice() {
        return productPrice - (productPrice * discount / 100);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}
