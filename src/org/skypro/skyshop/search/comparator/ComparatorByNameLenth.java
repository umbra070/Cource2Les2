package org.skypro.skyshop.search.comparator;

import org.skypro.skyshop.search.Searchable;

import java.util.Comparator;

public class ComparatorByNameLenth implements Comparator<Searchable> {

    @Override
    public int compare(Searchable s1, Searchable s2) {
        int cmprtr = Integer.compare(s2.getName().length(), s1.getName().length());
        if(cmprtr != 0){
            return cmprtr;
        }
        return s1.getName().compareTo(s2.getName());
    }
}
