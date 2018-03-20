import java.io.IOException;

public class LoadCommand implements GenericCommand {
    public LoadCommand()
    {

    }
    public void execute(Catalog catalog, String... arguments)throws IncorrectParameterException, IOException, ClassNotFoundException {
        String path = arguments[1];
        Catalog catalog1 = Catalog.load(path);
        catalog.removeAll();
        for (Document document : catalog1.getAll())
            catalog.add(document);
    }
}
