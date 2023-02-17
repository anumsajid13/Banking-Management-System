
import java.time.LocalDateTime;


public class SavingAccount extends Account {
	Person P;
	
	
	void addPerson(Person P)
	{
		this.P=P;
	}
	
	void addRecord(double amount)
	{
		TransactionLedger T1=new TransactionLedger();
		T1.setAccount_no(Account_no);
		T1.setBalance(amount);
		
		
		LocalDateTime myObj = LocalDateTime.now();
		
			T1.setDate(myObj);
		    
		T1.setId(id1,id2);
		
	}
	
	void withdraw(double amount) 
	{
		double penalty=(0.01/100)*amount;
		balance=balance-(amount+penalty);
	}
}
