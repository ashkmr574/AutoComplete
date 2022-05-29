package project.ashkmr574.auto.complete.service;

import project.ashkmr574.auto.complete.dto.SearchResult;

public interface SearchService {

    /**
     * It searches if values exist with the given searchKey
     * as prefix and returns all matching words.
     *
     * @param name the prefix to search
     * @return List of matching words with the given searchKey as prefix
     */
    SearchResult search(String name);
}
