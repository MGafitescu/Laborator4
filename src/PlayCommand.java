import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PlayCommand implements GenericCommand {
    public PlayCommand()
    {

    }
    public void execute(Catalog catalog, String... arguments)throws IncorrectParameterException, IOException, ClassNotFoundException {
        String path = null;
        String title = arguments[1];
        for (Document document : catalog.getAll()) {
            if (document.getTitle().equals(title))
                path = document.getPath();
        }
        if (path != null) {
            File file = new File(path);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
            System.out.println("Your file was opened succesfuly.");
        } else {
            System.out.println("Document not found in the catalog.\n");
        }
    }
}
