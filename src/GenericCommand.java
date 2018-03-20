import java.io.IOException;

public interface GenericCommand  {
    void execute(Catalog catalog,String... arguments) throws IncorrectParameterException, IOException, ClassNotFoundException;
}
