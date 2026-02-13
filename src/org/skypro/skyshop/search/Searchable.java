package org.skypro.skyshop.search;

public interface Searchable {

    String getSearchTerm();

    String getContentType();

    String getName();

    default String getStringRepresentation() {
        return String.format("%s - %s", this.getSearchTerm(), this.getContentType());
    }
}
