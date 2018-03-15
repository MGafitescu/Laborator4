import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Catalog catalog = new Catalog();
            catalog.add(new Book("The Art of Computer Programming", "C:\\Users\\Marian Gafitescu\\Desktop\\Stuff\\American Gods - Neil Gaiman.mobi", 1978,  "Neil Gaiman"));
            catalog.add(new Article("Mastering the Game of Go without Human Knowledge", "C:\\Users\\Marian Gafitescu\\Desktop\\Stuff\\Regulament-burse-uaic2.pdf", 2017, "David Silver", "Julian Schrittwieser", "Karen Simonyan"));
            catalog.add(new Manual("Cookbook", "C:\\Users\\Marian Gafitescu\\Downloads\\Sapiens.epub"));
            catalog.save("C:\\Users\\Marian Gafitescu\\Desktop\\PA\\Laborator 4\\catalog.dat");
            Catalog catalog1 = Catalog.load("C:\\Users\\Marian Gafitescu\\Desktop\\PA\\Laborator 4\\catalog.dat");
            catalog1.list();
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
