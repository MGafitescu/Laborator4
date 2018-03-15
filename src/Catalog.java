import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

import static java.nio.file.Files.exists;
import static java.nio.file.Files.setOwner;

public class Catalog implements Serializable {
    private List<Document> documents;
    public Catalog()
    {
        documents =  new ArrayList<>();
    }

    public void add (Document document)
    {
        documents.add(document);
    }

    public void list()
    {
        System.out.println(this);
    }

    public void save(String filename) throws IncorrectParameterException, IOException
    {
        Path pathVerification = Paths.get(filename);
        if(!exists(pathVerification))
            throw  new IncorrectParameterException("The path provided for serialization is not valid.");
        FileOutputStream file = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(this);
        out.close();
        file.close();
        System.out.println("Serialization succeded.\n");
    }

    public void open(String title) throws  IOException
    {
     String path = null;
     for(Document document : documents)
     {
         if(document.getTitle().equals(title))
             path=document.getPath();
     }
     if(path!=null) {
         File file = new File(path);
         Desktop desktop = Desktop.getDesktop();
         desktop.open(file);
         System.out.println("Your file was opened succesfuly.");
     }
     else
     {
         System.out.println("Document not found in the catalog.\n");
     }
    }

    public static Catalog  load(String filename) throws IncorrectParameterException, IOException, ClassNotFoundException
    {
        Path pathVerification = Paths.get(filename);
        if(!exists(pathVerification))
            throw  new IncorrectParameterException("The path provided for deserialization is not valid.");
        FileInputStream file = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(file);
        Catalog catalog= (Catalog) in.readObject();
        in.close();
        file.close();
        System.out.println("Deserialization succeded.\n");
        return catalog;

    }

    @Override
    public String toString() {
        StringBuilder catalog = new StringBuilder();
        catalog.append("The contents of the catalog: \n");
        for(Document document :documents)
        {
            catalog.append(document);
            catalog.append("\n");
        }
        return catalog.toString();
    }
}
