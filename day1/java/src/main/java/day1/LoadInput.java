package day1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class LoadInput {

    public List<String> load(String filename) {
        try {
            return Files.readAllLines(filenameToPath(filename));

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException();
        }
    }

    private Path filenameToPath(String filename) throws URISyntaxException {
        return getFileUri(filename).map(fileUri -> {
            try {
                return Paths.get(fileUri.toURI());
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }).orElseThrow(() -> new RuntimeException("File not found"));
    }

    private Optional<URL> getFileUri(String filename) {
        return Optional.ofNullable(this.getClass().getResource(filename));
    }

}
