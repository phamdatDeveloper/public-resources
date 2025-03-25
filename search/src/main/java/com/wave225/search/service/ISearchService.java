package com.wave225.search.service;

import com.azure.search.documents.models.IndexDocumentsResult;
import com.wave225.search.model.Product;

import java.util.List;

public interface ISearchService {

    IndexDocumentsResult pushDataToIndex(List<Product> products) ;
}
