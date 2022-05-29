package project.ashkmr574.auto.complete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import project.ashkmr574.auto.complete.dto.SearchResult;
import project.ashkmr574.auto.complete.exception.InvalidInputException;
import project.ashkmr574.auto.complete.repository.NameRepository;
import project.ashkmr574.auto.complete.util.InitialDataLoader;
import project.ashkmr574.auto.complete.util.Trie;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class NameSearchService  implements SearchService {

    @Value("${fileLocation}")
    private String path;

    @Autowired
    private final NameRepository nameRepository;

    private final Trie names = new Trie();

    public NameSearchService(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    @PostConstruct
    public void init() {
        InitialDataLoader.loadDataIntoDatabase(getFileFromResourceAsStream(), nameRepository);
        nameRepository.findAll().forEach(name -> names.insert(name.getName()));
    }

    @Override
    public SearchResult search(String name) {
        validate(name);
        List<String> searchResponse = names.searchNames(name.trim());
        SearchResult result = new SearchResult();
        result.setNames(searchResponse);

        return result;
    }

    private InputStream getFileFromResourceAsStream() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(path);

        if (inputStream == null) {
            throw new IllegalArgumentException("The provided file is not found! " + path);
        } else {
            return inputStream;
        }
    }

    private void validate(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new InvalidInputException("Passed Input should not be empty");
        }

        if(!Pattern.matches("[a-zA-Z]+", name.trim())) {
            throw new InvalidInputException("Passed Input should only contain lower and upper case letters");
        }
    }
}
