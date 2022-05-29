package project.ashkmr574.auto.complete.util;

import project.ashkmr574.auto.complete.domain.Name;
import project.ashkmr574.auto.complete.exception.DataNotLoadedException;
import project.ashkmr574.auto.complete.repository.NameRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public final class InitialDataLoader {

    public static void loadDataIntoDatabase(InputStream stream, NameRepository nameRepository) {

        List<Name> names = new ArrayList<>();
        String line;
        try (InputStreamReader streamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            while ((line = reader.readLine()) != null) {
                names.add(new Name(line));
            }

        } catch (IOException e) {
            throw new DataNotLoadedException(e.getMessage());
        }
        nameRepository.saveAll(names);
    }
}
