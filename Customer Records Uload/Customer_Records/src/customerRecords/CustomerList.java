package customerRecords;

import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CustomerList {
	// array of customer records (database.txt)

	//private variables
	private CustomerRecord[] data;
	private int numRecords;

	//constant variables
	
    
    public final int MAX_RECORDS = 100;
	
	public CustomerRecord[] list = new CustomerRecord[numRecords];

	public CustomerList() {
		data = new CustomerRecord[MAX_RECORDS];
		numRecords = 0;
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

		
		for (int i = 0; i < numRecords; ++i) {
			if (customerNum == data[i].getCustomerNum())
				return data[i];

		}
		return null;
	}

	// Name: enterCustomerRecord
	// Behavior: Add new records to the end of the array
	// Parameter: CustomerRecord
	// Return: None

	public void enterCustomerRecord(CustomerRecord record) {
		
		// database not full
		if (numRecords < data.length) {
			// add new record
			data[numRecords] = record;
			numRecords += 1;
		}
		// database is full
		// create new array twice the size
		// place contents of old array and the new record into new array
		else {

			CustomerRecord[] list = new CustomerRecord[numRecords * 2];

			for (int i = 0; i < numRecords; ++i)
				list[i] = data[i];
			list[numRecords + 1] = record;
			++numRecords;
		}

}
	// Name: deleteCustomerRecord
	// Behavior: and delete record
	// Parameter: an int
	// Return: none

	public void deleteCustomerRecord(int customerNum) {
		
		
		for (int i = 0; i < numRecords; ++i) {
			if (customerNum == data[i].getCustomerNum()) {
				data[i] = data[numRecords - 1];
				--numRecords;
			}
		}

	}

	// Name: saveCustomerList
	// Behavior: save updated record
	// Parameter: CustomerRecord
	// return none

	public void saveCustomerList(String filename) throws IOException {
		
		PrintWriter out = new PrintWriter(new FileWriter(filename));
		for (int i = 0; i < numRecords; i++) {
			out.println(data[i]);
		}
	out.close();
	}
}