//variables makeup a static arraylist in the Command class
//they have a name and a value
class Variables {
    private String name;
    private String value;
    //constructs a variable object with a given name

    public Variables(String name) {
        this.name = name;
    }

    //constructs a variable object with a name and value
    public Variables(String name, String value) {
        this.name = name;
        this.value = value;
    }
    //returns the name
    public String getName() {
        return name;
    }
    //changes the name of a variable
    public void setName(String name) {
        this.name = name;
    }
    //returns the name of the variable
    @Override
    public String toString() {
        return name;
    }
    //used to set the value of a variable
    public void setValue(String value) {
        this.value = value;
    }
    //gets the value of a variable
    public String getValue() {
        return value;
    }
}

class Int extends Variables {
    //the value is stoed as a integer in this subclass
    private int value;
    //in order to override the other constructor, the constructor in the int class must return a string

    public Int(String name, String value) {
        super(name); // Call the superclass constructor, passing an empty string as name
        this.value = Integer.parseInt(value);
    }
    //in order to override the other getValue, getValue in the int class must return a string
    public String getValue() {
        return "" + value;
    }

    public void setValue(String value) {
        this.value = Integer.parseInt(value);
    }


    public String toString() {
        String temp = "";
        temp+= value;
        return temp;
    }
}

class Str extends Variables {
    private String value;

    public Str(String name, String value) {
        super(name); // Call the superclass constructor, passing an empty string as name
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
