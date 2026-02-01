package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private String articleName;
    private String articleText;

    public Article(String articleName, String articleText) {
        this.articleName = articleName;
        this.articleText = articleText;
    }

    @Override
    public String toString() {
        return String.format("%s\n\r%s", articleName, articleText);
    }

    @Override
    public String getSearchTerm() {
        return this.toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }
}
