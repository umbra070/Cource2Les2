/*
Условия домашки
Что нужно сделать
Ваша задача — создать структуру классов для интернет-магазина. Над этой структурой вы будете работать еще в нескольких домашках, поэтому сохраните этот проект.

Создайте обычное Java-приложение с одним классом App и методом main().
Сделайте коммит в ветку main(master).
После этого создайте новую ветку и выполните в ней домашнее задание.
Описание структуры
Пока наш интернет-магазин будет содержать только классы товаров и корзины для товаров. Эти классы нужно создать с учетом принципа инкапсуляции и разнести по пакетам.

Выполняйте задание строго по шагам. Пока не сделали предыдущий шаг — не приступайте к следующему.

Создание корневого пакета
Создайте в папке src пакет с названием org.skypro.skyshop. Этот пакет будет корневым для всех остальных пакетов в нашем приложении.
Перенесите в этот пакет класс App с методом main. Его нужно обязательно перенести, а не копировать. Для переноса можно использовать Drag and Drop или комбинацию клавиш «Вырезать»/«Вставить». Для последующих домашних заданий этого курса вам нужно создавать корневой пакет, иначе работа не будет принята.

Создание класса товара
Создайте в пакете org.skypro.skyshop.product класс товара Product, который будет содержать два значения:
название продукта в виде строки,
стоимость продукта в виде целого числа.
Эти значения должны быть немодифицируемыми после создания объекта, но должна быть возможность получить эти значения в других классах.

Создание класса корзины для товаров
Создайте простой класс корзины ProductBasket в пакете org.skypro.skyshop.basket.

Этот класс содержит в себе одну корзину с продуктами, которые купил один пользователь. Вам нужно реализовать следующие публичные методы:

Метод добавления продукта в корзину: метод принимает в себя продукт и ничего не возвращает.
Метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
Метод, который печатает содержимое корзины: метод ничего не принимает и не возвращает, но печатает в консоль сообщение вида:
<имя продукта>: <стоимость>
<имя продукта>: <стоимость>
<имя продукта>: <стоимость>
Итого: <общая стоимость корзины>
Если в корзине ничего нет, нужно напечатать фразу «в корзине пусто».

Метод, проверяющий продукт в корзине по имени: метод принимает в себя строку имени и возвращает boolean
 в зависимости от того, есть продукт в корзине или его нет.
Метод очистки корзины: метод ничего не принимает и очищает массив, проставляя всем его элементам null.
Обратите внимание!

В качестве хранилища для объектов product используйте массив из пяти элементов, однако прямой доступ к этому массиву должен быть невозможен.
Если в массиве не хватает места на следующий продукт, то метод добавления продукта должен выводить в консоль сообщение вида: «Невозможно добавить продукт».
Демонстрация классов
Создайте в классе App в методе main несколько продуктов и продемонстрируйте работу всех методов корзины по следующему сценарию:

Добавление продукта в корзину.
Добавление продукта в заполненную корзину, в которой нет свободного места.
Печать содержимого корзины с несколькими товарами.
Получение стоимости корзины с несколькими товарами.
Поиск товара, который есть в корзине.
Поиск товара, которого нет в корзине.
Очистка корзины.
Печать содержимого пустой корзины.
Получение стоимости пустой корзины.
Поиск товара по имени в пустой корзине.
Рекомендации по выполнению работы
Используйте модификатор static только в методе main, а модификатор public— только для методов и конструкторов.
Для демонстрации классов можно создать несколько корзин.
 */

package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        //Тестирование добавления в корзину
        System.out.println("\n\r******************* Тестирование добавления в корзину\n\r");
        SimpleProduct product1 = new SimpleProduct("Samsung Galaxy S22+", 50000);
        DiscountProduct product2 = new DiscountProduct("Чехол для Samsung Galaxy S22+", 5000, 40);
        FixPriceProduct product3 = new FixPriceProduct("Беспроводное зарядное устройство Samsung BXH2890");
        SimpleProduct product4 = new SimpleProduct("Кабель USB Type-A USB Type-C 3.1", 890);
        SimpleProduct product5 = new SimpleProduct("Набор беспроводной клавиатура + мышь Logitech CPD3918", 7000);
        SimpleProduct product6 = new SimpleProduct("IPhone 16+", 90000);
        basket.addProductToBasket(product1);
        basket.addProductToBasket(product2);
        basket.addProductToBasket(product3);
        basket.addProductToBasket(product4);
        basket.addProductToBasket(product5);
        basket.addProductToBasket(product6);
        basket.addProductToBasket(product4);
        basket.printBasket();
        System.out.println("\n\r******************* Тестирование удаления элементов\n\r");
        List<Product> removedProducts = basket.removeProductByName("Кабель USB Type-A USB Type-C 3.1");
        System.out.println(removedProducts.toString());
        basket.printBasket();
        removedProducts = basket.removeProductByName("Жареные гвозди");
        System.out.println(removedProducts.toString());
        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        }
        basket.printBasket();
        System.out.println("\n\r******************* Тестирование очищения корзины\n\r");
        basket.cleanBasket();
        basket.printBasket();
        //***************************************
        System.out.println("\n\r******************* Testing Exceptions\n\r");
        ProductBasket testingBasket = new ProductBasket();
        SimpleProduct product7 = null;
        SimpleProduct product8 = null;
        SimpleProduct product9 = null;
        SimpleProduct product10 = null;
        SimpleProduct product11 = null;
        DiscountProduct product12 = null;
        DiscountProduct product13 = null;
        DiscountProduct product14 = null;
        DiscountProduct product15 = null;
        try {
            product7 = new SimpleProduct("", 120000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            product8 = new SimpleProduct(null, 200000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            product9 = new SimpleProduct(" ", 500000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            product10 = new SimpleProduct("Test simplProduct10", -600);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            product11 = new SimpleProduct("Test simpleProduct11", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            product12 = new DiscountProduct("Test discountProduct12", 0, 90);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            product13 = new DiscountProduct("Test discountProduct13", -1, 90);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            product14 = new DiscountProduct("Test discountProduct14", 10, 110);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            product15 = new DiscountProduct("Test discontProduct15", 110, 200);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("\n\r******************* Testing Exceptions\n\r");
        Article article1 = new Article("iPhone 16 Plus: кратко о главном", "iPhone 16 Plus получил обновлённый дизайн с алюминиевой рамкой и керамическим стеклом, которое в два раза устойчивее к царапинам, чем у конкурентов.\n" +
                "\n" +
                "Устройство оснащено мощным процессором Apple A18 на 3 нм техпроцессе, обеспечивающим на 30 % более высокую производительность CPU и на 40 % — графического ускорителя по сравнению с предыдущим поколением.\n" +
                "\n" +
                "Среди ключевых нововведений — сенсорная кнопка Camera Control для управления камерой, поддержка пространственной съёмки фото и видео, а также увеличенное время автономной работы (до 27 часов воспроизведения видео).");
        Article article2 = new Article("Что важно знать о Galaxy S22 +", """
                Samsung Galaxy S22 + сочетает элегантный дизайн с прочным корпусом из стекла Gorilla Glass Victus Plus
                120‑Гц Dynamic AMOLED 2X‑экран диагональю 6,6 дюйма обеспечивает плавное изображение и отличную читаемость даже при ярком солнце (пиковая яркость — до 1750 нит).
                Производительность базируется на процессоре Exynos 2200 с графикой Xclipse 920, 8 ГБ ОЗУ и накопителем UFS 3.1, а тройная камера (50 Мп + 10 Мп с 3× зумом + 12 Мп ультраширик) позволяет снимать детализированные фото и видео в разных сценариях.""");
        Article article3 = new Article("Samsung BXH2890: три факта о новинке", """
                Samsung BXH2890 — компактное беспроводное зарядное устройство с поддержкой стандарта Qi, обеспечивающее безопасную и эффективную зарядку смартфонов и других совместимых гаджетов.
                
                Устройство выдаёт мощность до 20 Вт, что позволяет быстро восполнять заряд батареи: смартфон с ёмкостью 4000 мА·ч заряжается до 50 % всего за 30 минут.
                
                Стильный минималистичный дизайн, противоскользящее покрытие и встроенная система защиты (от перегрева, перенапряжения и короткого замыкания) делают BXH2890 удобным и надёжным решением.""");
        Article article4 = new Article("Три причины выбрать Logitech CPD3918", """
                Logitech CPD3918 — удобный комплект из беспроводной клавиатуры и мыши, совместимый с Windows и macOS, который подключается через USB‑ресивер или Bluetooth и работает на расстоянии до 10 м.
                
                Клавиатура с мембранным механизмом и 104 клавишами обеспечивает мягкий, тихий ход и комфортную печать, а мышь с оптическим сенсором на 1600 dpi гарантирует точное управление курсором и плавное скольжение.
                При цене в 7000 рублей набор предлагает хорошую автономность (до 12 месяцев от одной батарейки для клавиатуры и до 6 месяцев для мыши), эргономичный дизайн и надёжную сборку — оптимальное решение для дома и офиса.""");
        Article article5 = new Article("Быстрый взгляд на чехол для Galaxy S22+", """
                Чехол для Samsung Galaxy S22+ за 5000 рублей обеспечивает надёжную защиту смартфона от царапин, сколов и небольших падений благодаря прочным материалам и продуманной конструкции с усиленными углами.
                
                Модель точно повторяет контуры устройства, сохраняет доступ ко всем портам и кнопкам, а тактильно приятное покрытие предотвращает скольжение в руке и снижает риск случайного выпадения.
                Дополнительно чехол придаёт смартфону стильный внешний вид — доступен в нескольких цветовых решениях, которые подчеркнут индивидуальность владельца без ущерба для функциональности.""");
        Article article6 = new Article("Кабель Type-A – Type-C 3.1 за 890: стоит ли брать?", """
                Кабель USB Type-A – USB Type-C 3.1 за 890 рублей поддерживает скорость передачи данных до 5 Гбит/с, что позволяет быстро копировать файлы и синхронизировать устройства.
                
                Модель рассчитана на зарядку с током до 3 А и мощностью до 60 Вт — подходит для смартфонов, планшетов и ноутбуков с разъёмом Type-C, обеспечивая эффективное восполнение заряда.
                Прочная оплётка и усиленные разъёмы повышают износостойкость, а длина в 1 м делает кабель удобным для повседневного использования дома и в дороге.""");
        basket.addProductToBasket(product1);
        basket.addProductToBasket(product2);
        basket.addProductToBasket(product3);
        basket.addProductToBasket(product4);
        basket.addProductToBasket(product5);
        basket.addProductToBasket(product4);
        basket.printBasket();
        System.out.println(basket.getTotalBasketCoast());
        System.out.println(String.format("Товар %s есть в корзине: %s", product4.getName(), basket.checkProductByName(product4.getName())));
        System.out.println(String.format("Товар %s есть в корзине: %s", product6.getName(), basket.checkProductByName(product6.getName())));
        basket.cleanBasket();
        basket.printBasket();
        basket.getTotalBasketCoast();
        System.out.println(String.format("Товар %s есть в корзине: %s", product4.getName(), basket.checkProductByName(product4.getName())));
        //***************************************
        System.out.println("\n\r******************* Testing search\n\r");
        Searchable[] searchItems = new Searchable[]{
                product1,
                product2,
                product3,
                product4,
                product5,
                product6,
                article1,
                article2,
                article3,
                article4,
                article5,
                article6
        };
        Searchable[] testingExceptions = new Searchable[]{
                product7,
                product8,
                product9,
                product10,
                product11,
                product12,
                product13,
                product14,
                product15
        };
        SearchEngine searchWithExceptions = new SearchEngine();
        SearchEngine search = new SearchEngine();
        for (Searchable s : searchItems) {
            search.add(s);
        }
        for (Searchable s : search.search("Samsung").values()) {
            if (s == null) {
                continue;
            }
            System.out.println("*******************");
            System.out.println(s.getStringRepresentation());
            System.out.println("*******************");
        }
        System.out.println("\n\rTesting search 2\n\r");
        for (Searchable s : search.search("Кабель").values()) {
            if (s == null) {
                continue;
            }
            System.out.println("*******************");
            System.out.println(s.getStringRepresentation());
            System.out.println("*******************");
        }
        System.out.println("\n\rTesting search 3\n\r");
        for (Searchable s : search.search("890").values()) {
            if (s == null) {
                continue;
            }
            System.out.println("*******************");
            System.out.println(s.getStringRepresentation());
            System.out.println("*******************");
        }
        System.out.println("\n\rTesting search 4\n\r");
        try {
            for (Searchable s : searchWithExceptions.search("жареные гвозди").values()) {
                if (s == null) {
                    continue;
                }
                System.out.println("*******************");
                System.out.println(s.getStringRepresentation());
                System.out.println("*******************");
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("******************* тестирование одиночной выдачи");
        try {
            System.out.println(search.singleElementSearch("amsung").getStringRepresentation());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("*******************");

        System.out.println("******************* тестирование одиночной выдачи с исключением");
        try {
            System.out.println(search.singleElementSearch("жареные гвозди").getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        System.out.println("*******************");
        System.out.println("******************* тестирование одиночной выдачи с исключением 2");
        try {
            System.out.println(searchWithExceptions.singleElementSearch("жареные гвозди").getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        System.out.println("*******************");
    }
}