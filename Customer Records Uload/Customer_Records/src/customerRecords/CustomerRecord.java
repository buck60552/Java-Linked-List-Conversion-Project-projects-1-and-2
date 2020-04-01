package customerRecords;

public class CustomerRecord {

	//instance variables
	int customerNum;
	String firstName;
	String lastName;
	double balance;
	
	public CustomerRecord(int a , String b, String c, double d) {
		customerNum = a;
		firstName = b;
		lastName = c;
		balance = d;
	}

	public int getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
    public String toString()
    {
        String record;
        record = customerNum + " " + firstName + " " + lastName + " " + balance;
        return record;
    }
}
