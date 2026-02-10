package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchEngine {
    List<Searchable> searchableElements = new ArrayList<>();

    public SearchEngine() {
    }

    public List<Searchable> search(String searchString) {
        List<Searchable> searchResalt = new ArrayList<>();
        Iterator<Searchable> iterator = searchableElements.iterator();
        if (searchableElements.isEmpty()) {
            throw new NullPointerException("Список объектов для поиска содержит Null");
        }
        while (iterator.hasNext()){
            Searchable s = iterator.next();
            if(s.getSearchTerm().contains(searchString)){
                searchResalt.add(s);
            }
        }
        return searchResalt;
    }

    public void add(Searchable searchElement) {
        if(searchElement == null){
            throw new NullPointerException("Элемент для поиска не может быть Null");
        }
        searchableElements.add(searchElement);
    }

    public Searchable singleElementSearch(String searchString) throws BestResultNotFound {

        int countBest = 0;
        Searchable bestResult = null;
        for (Searchable s : searchableElements) {
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
