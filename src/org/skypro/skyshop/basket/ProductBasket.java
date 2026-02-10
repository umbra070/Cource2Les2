package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


public class ProductBasket {
    //Корзина
    //private Product[] basket = new Product[5];
    List<Product> basket = new ArrayList<Product>();

    public ProductBasket() {

    }

    //Добавляет продукт в корзину. Принимает Product, ни чего не возвращает.
    public void addProductToBasket(Product product) {
        basket.add(product);
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
        for (int i = 0; i < basket.size(); i++) {
            if (basket.get(i) == null) {
                continue;
            }
            if (basket.get(i).isSpecial()) {
                specialProductsCount++;
            }
            System.out.println(basket.get(i));
            totalCoast += basket.get(i).getProductPrice();
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

    public List<Product> removeProductByName(String productName) {
        List<Product> productsForRemove = new ArrayList<Product>();
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            //System.out.println(p);
            if (p.getProductName().equals(productName)) {
                productsForRemove.add(p);
                iterator.remove();
            }
        }
//        for (Product p : basket) {
//            if(p.getProductName().equals(productName)){
//                productsForRemove.add(p);
//                basket.remove(p);
//            }
//        }
        return productsForRemove;
    }

    //Очищает корзину. Ни чего не принимает и ни чего не возвращает.
    public void cleanBasket() {
        basket.clear();
    }
}
