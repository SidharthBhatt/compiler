import java.util.ArrayList;
import java.util.Scanner;

public class Command {


    //There is a static arraylist of variables objects that may be edited by certain commands

    private static ArrayList<Variables> variables = new ArrayList<>();

    ////Each command is a string

    private String command = "";

    //constructor that initiates a command
    public Command(String str){
        command = str;
    }

    //returns a command

    public String getCommand(){
        return command;
    }
    //edits a command
    public void setCommand(String str){
        command = str;
    }

    //returns the string version of a command without the semicolon
    public String toString(){
        return command.substring(0, command.length()- 1);
    }

    //where each command is run

    public void run() {
        //checks if command is a comment
        if(command.substring(0,3).equals("||")){
            return;
        }
        //all valid commands similar syntax and all contain (
        int start = toString().indexOf("(");
        String name = toString().substring(0, start);

        try {
            //initializes a integer variable with the formula startInt(name,value);
            if (name.equals("startInt")) {
                //breaks up each command into parts, first is from ( to the comma  which is the first paramater
                //second parameter is from the comma to the (
                int mid = toString().indexOf(",");
                String param1 = toString().substring(start + 1, mid);
                int end = toString().indexOf(")");
                String param2 = toString().substring(mid + 1, end);
                //creates a int object with the parameters
                Int temp = new Int(param1, param2);
                //adds the int object to the variables arraylist
                variables.add(temp);

            }
            //initializes a string variable with the formula startStr(name,value);
            if (name.equals("startStr")) {

                int mid = toString().indexOf(",");
                String param1 = toString().substring(start + 1, mid);
                int end = toString().indexOf(")");
                String param2 = toString().substring(mid + 1, end);
                Str temp = new Str(param1, param2);
                variables.add(temp);

            }
            //initializes a default variable with a value from scanner; Formula: input(name);
            if (name.equals("input")) {

                int end = toString().indexOf(")");
                String param1 = toString().substring(start + 1, end);
                Scanner sc = new Scanner(System.in);
                String param2 = sc.nextLine();
                //if the first parameter, the name of the variable, is found in the arraylist of variables,-
                //-it sets the value to the second parameter, if not it will throw a not found variable error
                boolean notFound = true;
                for (int i = 0; i < variables.size(); i++) {
                    if (variables.get(i).getName().equals(param1)) {
                        variables.get(i).setValue(param2);
                        notFound = false;
                    }
                }
                //if the variable name is not found in the array of initiated variables, it throws an error. Similar code is present in many of the following commands
                if (notFound){
                    System.out.println("ERROR: variable not found!");
                }

            }
            //changes the value of a variable given the variables name and the value to be changed to; Formula: set(name,value);
            else if (name.equals("set")) {

                int mid = toString().indexOf(",");
                String param1 = toString().substring(start + 1, mid);
                int end = toString().indexOf(")");
                String param2 = toString().substring(mid + 1, end);
                Int temp = new Int(param1, param2);
                boolean notFound = true;
                for (int i = 0; i < variables.size(); i++) {
                    if (variables.get(i).getName().equals(param1)) {
                        (variables.get(i)).setValue(param2);
                        notFound = false;
                    }
                }
                if (notFound){
                    System.out.println("ERROR: variable not found!");
                }

            }
            //prints the value of variable name
            else if (name.equals("print")) {

                int end = toString().indexOf(")");
                String param1 = toString().substring(start + 1, end);

                boolean notFound = true;
                for (int i = 0; i < variables.size(); i++) {
                    if (variables.get(i).getName().equals(param1)) {
                        System.out.println(variables.get(i));
                        notFound = false;
                    }
                }
                if (notFound){
                    System.out.println("ERROR: variable not found!");
                }
            }
            //adds a the value of var2 to var1 Forumula: addVar(var1,var2);
            else if (name.equals("addVar")) {
                int mid = toString().indexOf(",");
                int end = toString().indexOf(")");
                String param1 = toString().substring(start + 1, mid);
                String param2 = toString().substring(mid + 1, end);
                int numOne = 0;
                int numTwo = 0;
                int num = -1;

                boolean notFound1 = true;
                boolean notFound2 = true;
                for (int i = 0; i < variables.size(); i++) {
                    if (variables.get(i).getName().equals(param1)) {
                        numOne = Integer.parseInt(variables.get(i).getValue());
                        num = i;
                        notFound1 = false;
                    }
                    else if (variables.get(i).getName().equals(param2)) {
                        numTwo = Integer.parseInt(variables.get(i).getValue());
                        notFound2 = false;
                    }
                    if (notFound1 || notFound2){
                        System.out.println("ERROR: variable not found!");
                    }

                }
                variables.get(num).setValue("" + (numOne + numTwo));
            }
            //adds the value of the first parameter to the second parameter
            else if (name.equals("addNum")) {

                int mid = toString().indexOf(",");
                int end = toString().indexOf(")");
                String param1 = toString().substring(start + 1, mid);
                String param2 = toString().substring(mid + 1, end);
                int numOne = 0;
                int numTwo = Integer.parseInt(param2);
                int num = -1;
                boolean notFound = true;
                for (int i = 0; i < variables.size(); i++) {
                    if (variables.get(i).getName().equals(param1)) {
                        notFound = false;
                        numOne = Integer.parseInt(variables.get(i).getValue());
                        num = i;
                    }
                }
                variables.get(num).setValue("" + (numOne + numTwo));
                if (notFound){
                    System.out.println("ERROR: variable not found!");
                }
            }
            //subtracts the value of the second parameter from the first
            else if (name.equals("subVar")) {
                int mid = toString().indexOf(",");
                int end = toString().indexOf(")");
                String param1 = toString().substring(start + 1, mid);
                String param2 = toString().substring(mid + 1, end);
                int numOne = 0;
                int numTwo = 0;
                int num = -1;
                boolean notFound1 = true;
                boolean notFound2 = true;
                for (int i = 0; i < variables.size(); i++) {
                    if (variables.get(i).getName().equals(param1)) {
                        numOne = Integer.parseInt(variables.get(i).getValue());
                        num = i;
                        notFound1 = false;
                    }
                    else if (variables.get(i).getName().equals(param2)) {
                        numTwo = Integer.parseInt(variables.get(i).getValue());
                        notFound2 = false;
                    }

                }
                variables.get(num).setValue("" + (numOne - numTwo));
                if (notFound1 || notFound2){
                    System.out.println("ERROR: variable not found!");
                }
            }
            //subtracts the value of the second variable from the first number
            else if (name.equals("subNum")) {
                int mid = toString().indexOf(",");
                int end = toString().indexOf(")");
                String param1 = toString().substring(start + 1, mid);
                String param2 = toString().substring(mid + 1, end);
                int numOne = 0;
                int numTwo = Integer.parseInt(param2);
                int num = -1;
                boolean notFound = true;
                for (int i = 0; i < variables.size(); i++) {
                    if (variables.get(i).getName().equals(param1)) {
                        numOne = Integer.parseInt(variables.get(i).getValue());
                        num = i;
                        notFound = false;
                    }

                }
                variables.get(num).setValue("" + (numOne - numTwo));
                if (notFound){
                    System.out.println("ERROR: variable not found!");
                }
            }
            //multiples the first varuable by the second
            else if (name.equals("mulVar")) {
                int mid = toString().indexOf(",");
                int end = toString().indexOf(")");
                String param1 = toString().substring(start + 1, mid);
                String param2 = toString().substring(mid + 1, end);
                int numOne = 0;
                int numTwo = 0;
                int num = -1;
                boolean notFound1 = true;
                boolean notFound2 = true;
                for (int i = 0; i < variables.size(); i++) {
                    if (variables.get(i).getName().equals(param1)) {

                        numOne = Integer.parseInt(variables.get(i).getValue());

                        num = i;
                        notFound1 = false;
                    }
                    else if (variables.get(i).getName().equals(param2)) {
                        numTwo = Integer.parseInt(variables.get(i).getValue());
                        notFound2 = false;
                    }
                }
                variables.get(num).setValue("" + (numOne * numTwo));
                if (notFound1 || notFound2){
                    System.out.println("ERROR: variable not found!");
                }
            }
            //multiplies the first variable by the second number
            else if (name.equals("mulNum")) {
                int mid = toString().indexOf(",");
                int end = toString().indexOf(")");
                String param1 = toString().substring(start + 1, mid);
                String param2 = toString().substring(mid + 1, end);
                int numOne = 0;
                int numTwo = Integer.parseInt(param2);
                int num = -1;
                boolean notFound = true;
                for (int i = 0; i < variables.size(); i++) {
                    if (variables.get(i).getName().equals(param1)) {
                        numOne = Integer.parseInt(variables.get(i).getValue());
                        num = i;
                        notFound = false;
                    }

                }

                variables.get(num).setValue("" + (numOne * numTwo));
                if (notFound){
                    System.out.println("ERROR: variable not found!");
                }
            }
            //divides the first variable from the second variable
            else if (name.equals("divVar")) {
                int mid = toString().indexOf(",");
                int end = toString().indexOf(")");
                String param1 = toString().substring(start + 1, mid);
                String param2 = toString().substring(mid + 1, end);
                int numOne = 0;
                int numTwo = 0;
                int num = -1;

                boolean notFound1 = true;
                boolean notFound2 = true;
                for (int i = 0; i < variables.size(); i++) {
                    if (variables.get(i).getName().equals(param1)) {

                        numOne = Integer.parseInt(variables.get(i).getValue());

                        num = i;
                        notFound1 = false;
                    }
                    else if (variables.get(i).getName().equals(param2)) {
                        numTwo = Integer.parseInt(variables.get(i).getValue());
                        notFound2 = false;
                    }
                }
                variables.get(num).setValue("" + (numOne / numTwo));
                if (notFound1 || notFound2){
                    System.out.println("ERROR: variable not found!");
                }
            }
            //divides the first variable by the second number
            else if (name.equals("divNum")) {
                int mid = toString().indexOf(",");
                int end = toString().indexOf(")");
                String param1 = toString().substring(start + 1, mid);
                String param2 = toString().substring(mid + 1, end);
                int numOne = 0;
                int numTwo = Integer.parseInt(param2);
                int num = -1;
                boolean notFound = true;
                for (int i = 0; i < variables.size(); i++) {
                    if (variables.get(i).getName().equals(param1)) {
                        numOne = Integer.parseInt(variables.get(i).getValue());
                        num = i;
                        notFound = false;
                    }

                }
                variables.get(num).setValue("" + (numOne / numTwo));
                if (notFound){
                    System.out.println("ERROR: variable not found!");
                }
            }
            //preforms the modulu operation on the first variable with the second variable
            else if (name.equals("modVar")) {
                int mid = toString().indexOf(",");
                int end = toString().indexOf(")");
                String param1 = toString().substring(start + 1, mid);
                String param2 = toString().substring(mid + 1, end);
                int numOne = 0;
                int numTwo = 0;
                int num = -1;
                boolean notFound1 = true;
                boolean notFound2 = true;
                for (int i = 0; i < variables.size(); i++) {
                    if (variables.get(i).getName().equals(param1)) {

                        numOne = Integer.parseInt(variables.get(i).getValue());

                        num = i;
                        notFound1 = false;
                    }
                    else if (variables.get(i).getName().equals(param2)) {
                        numTwo = Integer.parseInt(variables.get(i).getValue());
                        notFound2 = false;
                    }
                }

                variables.get(num).setValue("" + (numOne % numTwo));
                if (notFound1||notFound2){
                    System.out.println("ERROR: variable not found!");
                }
            }
            //preforms the modulo operation on the first variable with the second number
            else if (name.equals("modNum")) {
                int mid = toString().indexOf(",");
                int end = toString().indexOf(")");
                String param1 = toString().substring(start + 1, mid);
                String param2 = toString().substring(mid + 1, end);
                int numOne = 0;
                int numTwo = Integer.parseInt(param2);
                int num = -1;
                boolean notFound = true;
                for (int i = 0; i < variables.size(); i++) {
                    if (variables.get(i).getName().equals(param1)) {
                        numOne = Integer.parseInt(variables.get(i).getValue());
                        num = i;
                        notFound = false;
                    }

                }
                variables.get(num).setValue("" + (numOne % numTwo));
                if (notFound){
                    System.out.println("ERROR: variable not found!");
                }
            }
            //checks if the first variable equals the second, and if so, runs the third command
            else if (name.equals("if")) {
                int mid1 = command.indexOf(",");
                String param1 = command.substring(start + 1, mid1);
                int mid2 = command.indexOf(";");
                String param2 = command.substring(mid1 + 1, mid2);
                int end = command.indexOf("}");
                String cmd = command.substring(mid2 + 1, end);
                Variables var1 = null;
                Variables var2 = null;
                for (Variables var : variables) {
                    if (var.getName().equals(param1)) {
                        var1 = var;
                    }
                    if (var.getName().equals(param2)) {
                        var2 = var;
                    }
                }
                if (var1 != null && var2 != null) {
                    if (var1.getValue().equals(var2.getValue())) {
                        Command CMD = new Command(cmd);
                        CMD.run();
                    }
                }
                else {
                    System.out.println("ERROR: variable not found!");
                }
            }
            //preforms the second command the first number of times
            else if (name.equals("loop")) {
                int mid = command.indexOf(",");
                String param1 = command.substring(start + 1, mid);
                int end = command.indexOf("}");
                String cmd = command.substring(mid + 1, end);
                Variables var1 = null;
                Variables var2 = null;
                Command CMD = new Command(cmd);
                for (int i = 0; i < Integer.parseInt(param1); i++) {
                    CMD.run();
                }
            }


        }
        //if a command is run, but has an error, this throws an error
        catch (Exception e){
            System.out.println("ERROR: command found but syntax is incorrect");
        }



    }
}