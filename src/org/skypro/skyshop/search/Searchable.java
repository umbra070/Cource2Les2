package org.skypro.skyshop.search;

public interface Searchable {

    String getSearchTerm();

    String getContentType();

    default String getStringRepresentation(String objectName, String objectType) {
        return String.format("%s - %s", objectName, objectType);
    }
}
