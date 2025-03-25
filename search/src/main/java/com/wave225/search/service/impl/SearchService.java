package com.wave225.search.service.impl;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.search.documents.SearchClient;
import com.azure.search.documents.SearchClientBuilder;
import com.azure.search.documents.indexes.models.IndexDocumentsBatch;
import com.azure.search.documents.models.IndexDocumentsOptions;
import com.azure.search.documents.models.IndexDocumentsResult;
import com.wave225.search.model.Product;
import com.wave225.search.service.ISearchService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SearchService implements ISearchService {

    private final SearchClient searchClient;

    public SearchService(
            @Value("${azure.search.endpoint}") String endpoint,
            @Value("${azure.search.api-key}") String apiKey,
            @Value("${azure.search.index-name}") String indexName) {
        this.searchClient = new SearchClientBuilder()
                .endpoint(endpoint)
                .credential(new AzureKeyCredential(apiKey))
                .indexName(indexName)
                .buildClient();
    }

    public IndexDocumentsResult pushDataToIndex(List<Product> products) {
        IndexDocumentsBatch<Product> batch = new IndexDocumentsBatch<>();
        products.forEach(batch::addUploadActions);

        return searchClient.indexDocuments(batch, new IndexDocumentsOptions());
    }
}
