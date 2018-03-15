import java.nio.file.*;
import java.util.ArrayList;

import static java.nio.file.Files.exists;

public class Book extends Document {
    private String publisher;


    public Book(String title, String path, int year, String... authors) throws IncorrectParameterException
    {
        this.authors=new ArrayList<>();
        if(year<1600 || year> 2018)
            throw new IncorrectParameterException("The year provided for " +title +" is not valid.");
        Path pathVerification = Paths.get(path);
        if(!exists(pathVerification))
            throw  new IncorrectParameterException("The path provided for " +title +" is not valid.");
        this.title=title;
        this.path=path;
        this.year=year;
        for(String author : authors)
            this.authors.add(author);
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public String toString() {
        StringBuilder book = new StringBuilder(title);
        book.append(" - Author(s): ");
        for (String author : authors)
        {
            book.append(author);
            book.append("  ");
        }
        book.append("  Year: ");
        book.append(year);
        return book.toString();
    }
}
