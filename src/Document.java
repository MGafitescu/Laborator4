import java.io.Serializable;
import java.util.List;

abstract public class Document implements Serializable {
    protected String title;
    protected String path;
    protected int year;
    protected List<String> authors;

    public int getYear() {
        return year;
    }

    public String getPath() {
        return path;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }
}
