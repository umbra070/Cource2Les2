package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    //Корзина
    private Map<String, List<Product>> basket = new HashMap<>();

    public ProductBasket() {

    }

    //Добавляет продукт в корзину. Принимает Product, ни чего не возвращает.
    public void addProductToBasket(Product product) {
        basket.computeIfAbsent(product.getName(), p -> new ArrayList<>()).add(product);
    }

    //Возвращает общую стоимость товаров из корзины. Ни чего не принимает, возвращает boolean.
    public int getTotalBasketCoast() {
        int totalCoast = 0;
        for (List<Product> lp : basket.values()) {
            if (lp == null) {
                continue;
            }
            for (Product p : lp) {
                if (p == null) {
                    continue;
                }
                totalCoast += p.getProductPrice();
            }
        }
        return totalCoast;
    }

    //Выводит на экран список товаров из корзины с их стоимостью. Если корзина пуста, выводит соответствующее сообщение. Ни чего не принимает и не возвращает.
    public void printBasket() {
        int totalCoast = 0;
        int specialProductsCount = 0;
        boolean isBasketEmpty = true;
        for (List<Product> lp : basket.values()) {
            for (Product p : lp) {
                if (p == null) {
                    continue;
                }
                if (p.isSpecial()) {
                    specialProductsCount++;
                }
                totalCoast += p.getProductPrice();
                System.out.println(p);
                isBasketEmpty = false;
            }
        }
        if (isBasketEmpty) {
            System.out.println("В корзине пусто");
        }
        System.out.println(String.format("Специальных товаров в корзине: %d", specialProductsCount));
        System.out.println(String.format("Итоговая стоимость: %d", totalCoast));
    }

    //Проверяет наличие товара в корзине по его названию. Принимает значение String, возвращает boolean.
    public boolean checkProductByName(String productName) {
        for (Map.Entry<String, List<Product>> me : basket.entrySet()) {
            if (me == null) {
                continue;
            }
            if (Objects.equals(productName, me.getKey())) {
                return true;
            }
        }
        return false;
    }

    //Удаляет товары из корзины по названию. Принимает строку названия товара, возвращает список удаленных товаров
    public List<Product> removeProductByName(String productName) {
        System.out.println(productName);
        List<Product> productsForRemove = basket.remove(productName);
        if (productsForRemove != null) {
            return productsForRemove;
        }
        basket.remove(productName);
        return new ArrayList<>();
    }

    //Очищает корзину. Ни чего не принимает и ни чего не возвращает.
    public void cleanBasket() {
        basket.clear();
    }
}
