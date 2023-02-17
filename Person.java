import java.util.ArrayList;

public class Person {

	String id;
	String Address;
	ArrayList<Account> A;
	
	Person()
	{
		A=new ArrayList<Account>();
	}
	
	void setId(String id){this.id=id;}
	String getId(){return id;}
	void setAddress(String Address){this.Address=Address;}
	String getAddress(){return Address;}
	
	void setAccount(Account A1)
	{
		A.add(A1);
	}

	
}
