public class UnsortedDate212List extends Date212List {

// default constructor invoking super class constructor

public UnsortedDate212List() {

super();

}

// method to add a Date

public void add(Date212 date) {

// just invoking super class append method

super.append(date);

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