public class AddCommand implements GenericCommand {
    public AddCommand()
    {

    }
    @Override
    public void execute(Catalog catalog, String... arguments) throws IncorrectParameterException {
        String[] type = arguments[0].split(" ");
        String title = arguments[1];
        String path = arguments[3];
        if (type[1].equals("manual")) {
            Manual manual = new Manual(title, path);
            catalog.add(manual);
            System.out.println("Manual added.");
        } else {
            int year = Integer.parseInt(arguments[4].trim());
            String[] authors = new String[arguments.length - 5];
            for (int i = 5; i < arguments.length; i++)
                authors[i - 5] = arguments[i];
            if (type[1].equals("book")) {
                Book book = new Book(title, path, year, authors);
                catalog.add(book);
                System.out.println("Book added");
            } else {
                Article article = new Article(title, path, year, authors);
                catalog.add(article);
                System.out.println("Article added");
            }
        }


    }
}
