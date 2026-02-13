package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    //Набор данных, в котором будет производиться поиск
    private Map<String, Searchable> searchableElements = new TreeMap<>();

    public SearchEngine() {
    }

    //Метод поиска вхождения поисковой строки в объект для поиска.
    // Принимает поисковую строку String и возвращает объект типа Map, содержащий результаты поиска
    public Map<String, Searchable> search(String searchString) {
        Map<String, Searchable> searchResalt = new TreeMap<>();
        if (searchableElements.isEmpty()) {
            throw new NullPointerException("Список объектов для поиска содержит Null");
        }
        for (Searchable s : searchableElements.values()) {
            if (s.getSearchTerm().contains(searchString)) {
                searchResalt.put(s.getName(), s);
            }
        }
        return searchResalt;
    }

    //Добавляет данные в мапу, в которой будет производиться поиск.
    //Принимает Searchable объект и ни чего не возвращает
    public void add(Searchable searchElement) {
        if (searchElement == null) {
            throw new NullPointerException("Элемент для поиска не может быть Null");
        }
        searchableElements.put(searchElement.getName(), searchElement);
    }

    //Метод для выдачи единственного найденного элемента. Принимает поисковую строку, возвращает Searchable объект
    public Searchable singleElementSearch(String searchString) throws BestResultNotFound {
        int countBest = 0;
        Searchable bestResult = null;
        for (Searchable s : searchableElements.values()) {
            int index = 0;
            int indexOfSearchString;
            int countTemp = 0;
            if (s == null) {
                break;
            }
            while (true) {
                indexOfSearchString = s.getSearchTerm().indexOf(searchString, index);
                if (indexOfSearchString == -1) {
                    break;
                }
                index = indexOfSearchString + searchString.length();
                countTemp++;
            }
            if (bestResult == null && countTemp != 0) {
                bestResult = s;
                countBest = countTemp;
                continue;
            }
            if (countTemp > countBest) {
                bestResult = s;
                countBest = countTemp;
            }
        }
        if (bestResult == null) {
            throw new BestResultNotFound();
        }
        return bestResult;
    }
}
