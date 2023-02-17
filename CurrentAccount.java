import java.util.ArrayList;


public class CurrentAccount extends Account{

	ArrayList<Person> P;
	
	CurrentAccount()
	{
		P=new ArrayList<Person>();
	}
	void addPerson(Person P1)
	{
		P.add(P1);
	}
	void withdraw(double amount) 
	{
		balance=balance-(amount);
	}
}
