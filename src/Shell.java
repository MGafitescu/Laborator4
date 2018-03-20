import java.util.Scanner;

public class Shell {
    private Catalog catalog;
    public Shell()
    {
    catalog=new Catalog();
    }

    public void readCommand()
    {
        Scanner scan= new Scanner(System.in);
        System.out.printf(">");
        String command = scan.nextLine();
        while (!command.equals("exit"))
        {
            try {
                processCommand(command);
            }
            catch (InvalidCommandException e)
            {
                System.out.println(e);
            }
            System.out.printf(">");
            command = scan.nextLine();
        }
    }

    public void processCommand(String command) throws InvalidCommandException
    {
        String[] parts=command.split("\"");
        if(parts[0].contains("add"))
            catalog.executeCommand(new AddCommand(),parts);
        else
            if (parts[0].contains("list"))
                catalog.executeCommand(new ListCommand(),parts);
        else
            if (parts[0].contains("save"))
                catalog.executeCommand(new SaveCommand(), parts);
        else
            if(parts[0].contains("load"))
                catalog.executeCommand(new LoadCommand(),parts);
        else
            throw new InvalidCommandException("Comanda "+parts[0]+" este invalida" );
    }
}
