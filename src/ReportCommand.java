import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReportCommand implements GenericCommand {
    public ReportCommand()
    {

    }
    public void execute(Catalog catalog, String... arguments)throws IncorrectParameterException, IOException, ClassNotFoundException {

        StringBuilder catalogContent = new StringBuilder("<h2>The contents of the catalog are: </h2>\n");

        for(Document document : catalog.getAll())
        {
            catalogContent.append("<br> \n");
            catalogContent.append(document.toString());
        }
        StringBuilder content = new StringBuilder();
        content.append("<html>");
        content.append("<head> \n <title>\n Report Html \n </title>\n <style>\n div.caseta\n" +
                "{\n" +
                "\n" +
                "   background-color: CED9EB;\n" +
                "    width: 70%;\n" +
                "\tborder-radius: 25px;\n" +
                "    padding: 15px;\n" +
                "    border: 6px solid #233257;\n" +
                "    margin: 5px;\n" +
                "font-size: 1.3em;"+
                "font-family: Palatino Linotype, sans serif;"+
                "text-color: #233257;"+
                "}p\n" +
                "} </style> </head> \n <body bgcolor=#0a0642> <center> <div class=\"caseta\"><p>");
        content.append(catalogContent);
        content.append("</p> </div> </center>\n </body> \n </html>");
        BufferedWriter writer = new BufferedWriter(new FileWriter("report.html"));
        writer.write(content.toString());
        writer.close();
        System.out.println("Report created");
    }
}
