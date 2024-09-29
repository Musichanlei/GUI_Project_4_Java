public class Date212Exception extends Exception {

//constructor taking an error message

public Date212Exception(String msg) {

super(msg);

}

//default constructor

public Date212Exception() {

super("Invalid Date!");

}

}