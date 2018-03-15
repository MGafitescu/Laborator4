import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Catalog catalog = new Catalog();
            catalog.add(new Book("American Gods", "C:\\Users\\Marian Gafitescu\\Desktop\\Stuff\\American Gods - Neil Gaiman.mobi", 2001,  "Neil Gaiman"));
            catalog.add(new Article("Regulations", "C:\\Users\\Marian Gafitescu\\Desktop\\Stuff\\Regulament-burse-uaic2.pdf", 2017, "David Silver", "Julian Schrittwieser", "Karen Simonyan"));
            catalog.add(new Manual("Sapiens", "C:\\Users\\Marian Gafitescu\\Downloads\\Sapiens.epub"));
            catalog.save("C:\\Users\\Marian Gafitescu\\Desktop\\PA\\Laborator 4\\catalog.dat");
            Catalog catalog1 = Catalog.load("C:\\Users\\Marian Gafitescu\\Desktop\\PA\\Laborator 4\\catalog.dat");
            catalog1.list();
            catalog.open("Sapiens");
        } catch (IncorrectParameterException e) {
            System.out.println(e);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
