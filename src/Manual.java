import java.nio.file.*;
import java.util.ArrayList;

import static java.nio.file.Files.exists;

public class Manual extends Document {

    public Manual(String title, String path, int year, String... authors) throws IncorrectParameterException {
        this.authors = new ArrayList<>();
        if (year < 1600 || year > 2018)
            throw new IncorrectParameterException("The year provided for " + title + "  is not valid.");
        Path pathVerification = Paths.get(path);
        if (!exists(pathVerification))
            throw new IncorrectParameterException("The path provided  for " + title + " is not valid.");
        this.title = title;
        this.path = path;
        this.year = year;
        for (String author : authors)
            this.authors.add(author);
    }

    public Manual(String title, String path) throws IncorrectParameterException {
        this.authors = new ArrayList<>();
        Path pathVerification = Paths.get(path);
        if (!exists(pathVerification))
            throw new IncorrectParameterException("The path provided for " + title + " is not valid.");
        this.title = title;
        this.path = path;
    }

    @Override
    public String toString() {
        StringBuilder manual = new StringBuilder(title);
        if (!authors.isEmpty()) {
            manual.append(" - Author(s): ");
            for (String author : authors) {
                manual.append(author);
                manual.append("  ");
            }
        }
        if(year !=0 ) {
            manual.append("  Year: ");
            manual.append(year);
        }
        return manual.toString();
    }
}
