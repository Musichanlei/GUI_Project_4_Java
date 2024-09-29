import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Date212GUI extends JFrame {

// defining all required components

// declaring one UnsortedDate212List and one SortedDate212List

private UnsortedDate212List unsortedList;

private SortedDate212List sortedList;

private JMenuItem search;

private JMenuBar menuBar;
// text areas to display unsorted and sorted texts

JTextArea unsortedText, sortedText;

// new variables for menu components

JMenuItem openFile, quit;



 //method to load dates from an input file, and fill the two lists, and then

 //update the text areas



public void loadFromFile(String filename) {

// initializing lists

unsortedList = new UnsortedDate212List();

sortedList = new SortedDate212List();

try {

// using scanner to read file line by line

Scanner scanner = new Scanner(new File(filename));

while (scanner.hasNext()) {

// using StringTokenizer to split line by comma

StringTokenizer line = new StringTokenizer(scanner.nextLine(),

",");

while (line.hasMoreTokens()) {

// getting a token

String dateToken = line.nextToken();

try {

// trying to create a Date212

Date212 date = new Date212(dateToken);

// adding to the lists

unsortedList.add(date);

sortedList.add(date);

} catch (Date212Exception e) {

// date creation failed, invalid date, printing to

// console

System.out.println(e.getMessage());

}

}

}

} catch (FileNotFoundException e) {

// file not found

System.out.println("Input data file not found!");

}

// appending all dates to the both text fields

unsortedText.setText(unsortedList.toString());

sortedText.setText(sortedList.toString());

//menuBar = new JMenuBar();
// Adding the Edit menu with Search option
JMenu editMenu = new JMenu("Edit");
search = new JMenuItem("Search");
editMenu.add(search);
menuBar.add(editMenu);

// Creating an EditMenuHandler, setting this object as the event handler for the Search option
EditMenuHandler editHandler = new EditMenuHandler();
search.addActionListener(editHandler);


}

public Date212GUI(String inputFileName) {

/**

* using a GridLayout with 1 row and 2 columns to display elements

*/

setLayout(new GridLayout(1, 2, 10, 10));

// initializing ui components

unsortedText = new JTextArea();

unsortedText.setLineWrap(true);

// using a bigger font size

unsortedText.setFont(new Font("SansSerif", Font.PLAIN, 30));

sortedText = new JTextArea();

sortedText.setLineWrap(true);

sortedText.setFont(new Font("SansSerif", Font.PLAIN, 30));

add(unsortedText);

add(sortedText);



//setting up menu bar


menuBar = new JMenuBar();

JMenu fileMenu = new JMenu("File");

openFile = new JMenuItem("Open");

quit = new JMenuItem("Quit");

fileMenu.add(openFile);

fileMenu.add(quit);

menuBar.add(fileMenu);

setJMenuBar(menuBar);



//Creating a FileMenuHandler, setting this object as the event handler

//for opening file option and quit option

FileMenuHandler handler = new FileMenuHandler();

openFile.addActionListener(handler);

quit.addActionListener(handler);

setSize(600, 400);

setDefaultCloseOperation(EXIT_ON_CLOSE);

setTitle("Dates");

setVisible(true);

// loading dates from file, adding to lists, displaying on text fields

loadFromFile(inputFileName);

}

class EditMenuHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(search)) {
            // Prompt the user to enter a year
            String input = JOptionPane.showInputDialog(Date212GUI.this, "Enter a year:");

            try {
                int year = Integer.parseInt(input);

                // Filter and display dates with the specified year
                unsortedText.setText(unsortedList.filterByYear(year));
                sortedText.setText(sortedList.filterByYear(year));
            } catch (NumberFormatException ex) {
                // Handle invalid input
                JOptionPane.showMessageDialog(Date212GUI.this, "Invalid input. Please enter a valid year.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

class FileMenuHandler implements ActionListener {

public void actionPerformed(ActionEvent e) {

// finding source of action

if (e.getSource().equals(openFile)) {

// creating and displaying a file opening dialog

JFileChooser fileChooser = new JFileChooser(

System.getProperty("user.dir"));

int choice = fileChooser.showOpenDialog(Date212GUI.this);

// checking if a file has been chosen correctly

if (choice == JFileChooser.APPROVE_OPTION) {

// getting selected file

File f = fileChooser.getSelectedFile();

// loading data from file

loadFromFile(f.getAbsolutePath());

}

} else if (e.getSource().equals(quit)) {

System.exit(0);

}

}

}

} 