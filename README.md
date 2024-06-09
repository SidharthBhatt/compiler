# Flat Compiler
fun Java based compiler that actually works!

# Intro:
Goal is to be very simple
Please do not include spaces between lines
Comment out lines with ||
Only int and String types are supported
 
# Syntax:

**Variable Basics**
startInt(name,value);
initializes a integer variable

startStr(name,value);
Initializes a String variable

input(name);
Sets variable name to the value specified by scanner

set(name, value);
Sets variable name to the value specified by value

print(name);
Prints the value of variable name

# For Int Variables where the result is stored in var1
addVar(var1,var2);
Adds the value of var2 to var1

addNum(var1,num2);
Adds the value of num2 to var1

subVar(var1,var2);
Subtracts the value of var2 from var1

subNum(var1,num2);
Subtracts the value of num2 from var1

mulVar(var1,var2);
Multiples the value of var1 by var2

mulNum(var1,num2);
Multiples the value of var1 by num2

divVar(var1,var2);
Divides the value of var1 by var2

divNum(var1,num2);
Divides the value of var1 by num2

modVar(var1,var2);
Performs the modulo operator on var1 with var2

modNum(var1,num2);
Performs the modulo operator on var1 with num2

# Other
if(var1,var2;command3;};
Checks if var1 is equal to var2 and if so runs command3
Does not work for greater than or less than
Supports both int and string

loop(num1,command2;)}
Runs command2 num1 number of times
Command2 has to be exactly one command

# Errors:
Error: File not found
compiler  can’t find the program file

"ERROR: variable not found!"
The variable referenced has not been initialized
Check for typos

ERROR: command found but syntax is incorrect
Name of the command is correct but check everything else
