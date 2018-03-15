import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.Files.exists;

public class Article extends Document {
    private String journal;
    private String conference;
    public Article(String title, String path, int year, String... authors) throws IncorrectParameterException
    {
        this.authors=new ArrayList<>();
        if(year<1600 || year> 2018)
            throw new IncorrectParameterException("The year provided  for " +title +"  is not valid.");
        Path pathVerification = Paths.get(path);
        if(!exists(pathVerification))
            throw  new IncorrectParameterException("The path provided  for " +title +"  is not valid.");
        this.title=title;
        this.path=path;
        this.year=year;
        for(String author : authors)
            this.authors.add(author);
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getConference() {
        return conference;
    }

    public String getJournal() {
        return journal;
    }

    @Override
    public String toString() {
        StringBuilder article = new StringBuilder(title);
        if (!authors.isEmpty()) {
            article.append(" - Author(s): ");
            for (String author : authors) {
                article.append(author);
                article.append("  ");
            }
        }

            article.append("  Year: ");
            article.append(year);

        return article.toString();
    }
}
