package project.ashkmr574.auto.complete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.ashkmr574.auto.complete.dto.SearchResult;
import project.ashkmr574.auto.complete.service.SearchService;

@RestController
public class AutoCompleteController {

    @Autowired
    private SearchService nameSearchService;

    public AutoCompleteController(SearchService nameSearchService) {
        this.nameSearchService = nameSearchService;
    }

    @PostMapping(value = "/search", consumes = "text/plain", produces = "application/json")
    public SearchResult search(@RequestBody  String searchKey) {
        return nameSearchService.search(searchKey);
    }
}
