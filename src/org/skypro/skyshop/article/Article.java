package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private final String articleName;
    private final String articleText;

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
    public String getName() {
        return articleName;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }
}
