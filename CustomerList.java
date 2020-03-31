package customerRecords;

import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CustomerList {
	//Variables

	private Node head;
	
	public CustomerList() {
		head = null;
		
	}

	// name: get customer list
	// behavior: read text file
	// parameter: file name (string)
	// return: none

	public void getCustomerList(String database) throws IOException {
		// file Scanner
		Scanner scan = new Scanner(new File(database));
		// iteration reads next line
		while (scan.hasNext()) {

			int customerNum = scan.nextInt();   // Customer Number
			String firstName = scan.next();     // First Name
			String lastName = scan.next();      // Last Name
			double balance = scan.nextDouble(); // Balance

			CustomerRecord cr = new CustomerRecord(customerNum, firstName, lastName, balance);
			enterCustomerRecord(cr);
		}
		scan.close();
	}

	// Name: getCustomerRecord
	// Behavior: given Customer number find and record
	// Parameter: integer customer number
	// return: customer

	public CustomerRecord getCustomerRecord(int customerNum) {

		Node next = head;
		while (next != null) {
			if (next.getElement().getCustomerNum() == customerNum)
				return next.getElement();
			
			next = next.getNext();
		}
		return null;
	}		
	
	// Name: enterCustomerRecord
	// Behavior: Add new records to the end of the array
	// Parameter: CustomerRecord
	// Return: None

	public void enterCustomerRecord(CustomerRecord record) {

		 Node v = new Node(record);
		{
			if (head == null)
				head = v;		//Inserts new node into list if list is empty
			else
			{					
				v.setNext(head);	//Sets next to the head of the list and replaces head with new node
				head = v;
			}
		}
}
	// Name: deleteCustomerRecord
	// Behavior: and delete record
	// Parameter: an int
	// Return: none

	public void deleteCustomerRecord(int customerNum) {
	
	        //Node variables to move through the list
	        Node current = head;
	        Node previous = null;

	        //Check for end of list
	        while ((current != null) && (current.getElement().getCustomerNum() != customerNum))
	        {
	            previous = current;
	            current = current.getNext();
	        }
	        if (current == null)       //Failed to find target Node
	            return;                //Stops method
	        if (previous == null)
	        {
	            Node t = head;
	            head = head.getNext();
	            t.setNext(null);
	            t = null;
	        }
	        else
	        {
	            previous.setNext(current.getNext());
	            current.setNext(null);
	            current = null;
	        }
	    }		
		
	// Name: saveCustomerList
	// Behavior: save updated record
	// Parameter: CustomerRecord
	// return none

	public void saveCustomerList(String filename) throws IOException {

		Node next = head;
		PrintWriter out = new PrintWriter(new FileWriter(filename));
		while(next != null) {
			out.println(next.getElement());
			next = next.getNext();
		}	
		out.close();
	}
}
