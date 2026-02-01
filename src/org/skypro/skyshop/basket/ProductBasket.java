package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Objects;


public class ProductBasket {
    //Корзина
    private Product[] basket = new Product[5];

    public ProductBasket() {

    }

    //Добавляет продукт в корзину. Принимает Product, ни чего не возвращает.
    public void addProductToBasket(Product product) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                //System.out.println(String.format("Товар %s добавлен в корзину", product.getProductName()));
                break;
            }
            if (i == basket.length - 1 && basket[i] != null) {
                System.out.println("Невозможно добавить продукт");
                System.out.println(String.format("Не удалось добавить товар  %s в корзину", product.getProductName()));
            }
        }
    }

    //Возвращает общую стоимость товаров из корзины. Ни чего не принимает, возвращает boolean.
    public int getTotalBasketCoast() {
        int totalCoast = 0;
        for (Product p : basket) {
            if (p == null) {
                continue;
            }
            totalCoast += p.getProductPrice();
        }
        return totalCoast;
    }

    //Выводит на экран список товаров из корзины с их стоимостью. Если корзина пуста, выводит соответствующее сообщение. Ни чего не принимает и не возвращает.
    public void printBasket() {
        int totalCoast = 0;
        int specialProductsCount = 0;
        boolean isBasketEmpty = true;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                continue;
            }
            if (basket[i].isSpecial()) {
                specialProductsCount++;
            }
            System.out.println(basket[i]);
            totalCoast += basket[i].getProductPrice();
            System.out.println(String.format("Специальных товаров в корзине: %d", specialProductsCount));
            isBasketEmpty = false;
        }
        System.out.println(String.format("Итоговая стоимость: %d", totalCoast));
        if (isBasketEmpty) {
            System.out.println("в корзине пусто");
        }
    }

    //Проверяет наличие товара в корзине по его названию. Принимает значение String, возвращает boolean.
    public boolean checkProductByName(String productName) {
        for (Product p : basket) {
            if (p == null) {
                continue;
            }
            if (Objects.equals(p.getProductName(), productName)) {
                return true;
            }
        }
        return false;
    }

    //Очищает корзину. Ни чего не принимает и ни чего не возвращает.
    public void cleanBasket() {
        for (int i = 0; i < basket.length; i++) {
            basket[i] = null;
        }
    }
}
