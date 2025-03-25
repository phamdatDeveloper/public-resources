package com.wave225.search.model;

import com.azure.search.documents.indexes.SearchableField;
import com.azure.search.documents.indexes.SimpleField;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    @SimpleField(isKey = true)
    private String id;

    @SearchableField
    private String name;

    @SearchableField
    private String description;

    @SimpleField
    private double price;

    public Product(String id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
