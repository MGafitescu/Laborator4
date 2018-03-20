public class ListCommand implements GenericCommand {
    public ListCommand()
    {

    }

    @Override
    public void execute(Catalog catalog, String... arguments) {
        System.out.println(catalog);
    }
}
