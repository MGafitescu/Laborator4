import java.io.IOException;

public class SaveCommand implements GenericCommand{
    public SaveCommand()
    {

    }

    @Override
    public void execute(Catalog catalog, String... arguments)throws IncorrectParameterException, IOException {
        String path = arguments[1];
        catalog.save(path);
    }
}
