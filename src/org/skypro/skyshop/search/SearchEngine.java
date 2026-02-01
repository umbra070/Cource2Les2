package org.skypro.skyshop.search;

public class SearchEngine {
    Searchable[] searchableElements;

    public SearchEngine(int searchableCount){
        searchableElements = new Searchable[searchableCount];
    }

    public Searchable[] search(String searchString){
        Searchable[] searchResalt = new Searchable[5];
        int i = 0;
        for(Searchable s: searchableElements){
            if(s.getSearchTerm().contains(searchString)){
                searchResalt[i] = s;
                i++;
                if(i >= searchResalt.length){
                    break;
                }
            }
        }
        return  searchResalt;
    }

    public void add(Searchable searchElement){
        for(int i = 0; i < searchableElements.length; i++){
            if(searchableElements[i] == null){
                searchableElements[i] = searchElement;
                break;
            }
        }
    }
}
