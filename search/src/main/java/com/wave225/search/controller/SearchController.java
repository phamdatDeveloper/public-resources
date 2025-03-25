package com.wave225.search.controller;

import com.wave225.search.model.Product;
import com.wave225.search.service.ISearchService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class SearchController {

    @Autowired
    private ISearchService searchService;


    @PostMapping("/push")
    public String pushData(@RequestBody List<Product> products) {
        searchService.pushDataToIndex(products);
        return "Data pushed successfully!";
    }
}
