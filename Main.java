import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // all commands are stored in an arraylist of command objects
        ArrayList<Command> code = new ArrayList<Command>();
        // adds commands from files.txt to the arraylist of commands
        try {
            File myFileObj = new File("C:\\Users\\sidha\\compiler\\file\\files.txt");
            Scanner file = new Scanner(myFileObj);

            while (file.hasNextLine()) {
                Command temp = new Command(file.nextLine());
                code.add(temp);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
            e.getStackTrace();
        }
        //goes through the code arraylist of commands and runs each command
        for (Command cmd : code) {
            cmd.run();
        }


    }
}
