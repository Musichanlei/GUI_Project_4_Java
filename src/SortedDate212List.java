public class SortedDate212List extends Date212List {

// default constructor

public SortedDate212List() {

// initializing super class constructor

super();

}


public void add(Date212 date) {

// creating a new node

Date212Node newNode = new Date212Node(date);

// if empty, calling append method of super class

if (first == null) {

super.append(date);

} else {

// checking if new node can be added before the first node

if (date.compareTo(first.data) < 0) {

newNode.next = first;

first = newNode;

length++;

return;// returning from function

}

Date212Node temp = first;

Date212Node next = first.next;

// iterating through each pair of nodes

while (next != null) {

// checking if new node can be added in the middle of temp and next

if (date.compareTo(temp.data) >= 0

&& date.compareTo(next.data) < 0) {

// adding to the middle

temp.next = newNode;

newNode.next = next;

length++;

return; // returning from function

}

next = next.next;

temp = temp.next;

}

//  invoking append method

super.append(date);

}

}

public String filterByYear(int year) {
    StringBuilder result = new StringBuilder();
    Date212Node temp = first;

    while (temp != null) {
        if (temp.data.getYear() == year) {
            result.append(temp.data.toString()).append("\n");
        }
        temp = temp.next;
    }

    return result.toString();
}

}