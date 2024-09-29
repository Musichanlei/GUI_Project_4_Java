public abstract class Date212List { 

//attributes

protected Date212Node first;

protected Date212Node last;

protected int length;

//default constructor

public Date212List() {

first = null;

last = null;

length = 0;

}



public void append(Date212 date) {

//creating a new node

Date212Node newNode = new Date212Node(date);

//adding to first if length is 0

if (length == 0) {

first = newNode;

last = first;

} else {

//otherwise, appending at the last

last.next = newNode;

last = newNode;

}

length++; //incrementing size

}

@Override

public String toString() {

//returns a String containing all dates on the list

String data = "";

Date212Node temp = first;

while (temp != null) {

data += temp.data.toString();

temp = temp.next;

if (temp != null) {

data += "\n";

}

}

return data;

}

int size() {

return length;

}

public abstract String filterByYear(int year);

}