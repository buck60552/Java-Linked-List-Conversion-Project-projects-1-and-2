package customerRecords;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RecordDriver {

	char input;
	public static void main(String[] args) throws IOException {

		CustomerList list = new CustomerList();
		
		list.getCustomerList("C:\\Users\\bioni\\Desktop\\database.txt");
		
		File file = new File("C:\\Users\\bioni\\Desktop\\database.txt");
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			System.out.println(scan.nextLine());
		}
		scan.close();
		Scanner sc = new Scanner(System.in);
		
		char trueSelect;
		trueSelect = menu(sc);
		
		while (true) {
			
			switch (trueSelect) {
			
			case 'A' : // creates new customer record and adds it to the end of the list
				System.out.println("enter number");
				int customerNum = (sc.nextInt());
				System.out.println("enter first name");
				String firstName = sc.next();
				System.out.println("enter last name");
				String lastName = sc.next();
				System.out.println("enter balance");
				double balance = sc.nextDouble();
				CustomerRecord cr = new CustomerRecord(customerNum, firstName, lastName, balance);
				list.enterCustomerRecord(cr);
				break;
				
			case 'D' : //delete a record from the list
				System.out.println("enter the Number of the Record you wish to delete.");
				int num = sc.nextInt();
				list.deleteCustomerRecord(num);
				break;
				
			case 'C' : //calls a record from the list
				System.out.println("enter the number of the record you want to view.");
				num = sc.nextInt();
				System.out.println(list.getCustomerRecord(num));
				break;
				
			case 'S' : // saves to pathed location
				list.saveCustomerList("C:\\Users\\bioni\\Desktop\\database.txt");
				break;
				
			case 'Q' : //terminates program
					
					System.out.println("Bye!");
					System.exit(0);
					break;
				
			}
			trueSelect = menu(sc);
		}
		
	}

	private static char menu(Scanner sc) {
		System.out.println("|----------------------------|");
		System.out.println("Welcome to this Database.");
		System.out.println("Please select a command.");
		System.out.println("A: Add Record");
		System.out.println("D: Delete Record");
		System.out.println("C: Call Record");
		System.out.println("S: Save to Original File");
		System.out.println("U: Save to New File");
		System.out.println("Q: Quit");
		System.out.println("|----------------------------|");
		char trueSelect;

		do {
			System.out.print("Enter command ( a, d, c, s, u or q): ");

			trueSelect = Character.toUpperCase(sc.next().trim().charAt(0));

			if (trueSelect == 'A' || trueSelect == 'D' || trueSelect == 'C' || trueSelect == 'S' || trueSelect == 'U' || trueSelect == 'Q')

				return trueSelect;

			System.out.println("Command was not recognized; please try again.");

		} while (true);
	}
}
