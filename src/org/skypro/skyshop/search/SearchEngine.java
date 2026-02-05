package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

public class SearchEngine {
    Searchable[] searchableElements;

    public SearchEngine(int searchableCount) {
        searchableElements = new Searchable[searchableCount];
    }

    public Searchable[] search(String searchString) {
        Searchable[] searchResalt = new Searchable[10];
        int i = 0;
        for (Searchable s : searchableElements) {
            if (s == null) {
                throw new NullPointerException("Список объектов для поиска содержит Null");
            }
            if (s.getSearchTerm().contains(searchString)) {
                searchResalt[i] = s;
                i++;
                if (i >= searchResalt.length) {
                    break;
                }
            }
        }
        return searchResalt;
    }

    public void add(Searchable searchElement) {
        for (int i = 0; i < searchableElements.length; i++) {
            if (searchableElements[i] == null) {
                searchableElements[i] = searchElement;
                break;
            }
        }
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
