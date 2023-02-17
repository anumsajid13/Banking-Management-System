
import java.time.LocalDateTime;
import java.util.ArrayList;


public abstract class Account {

	ArrayList<TransactionLedger> T;
	String id1;
	String id2;
	int Account_no;
	String pin;
	double balance;
	boolean dormant;
	String Type;//account type
	
	Account()
	{
		T=new ArrayList<TransactionLedger>();
		dormant=false;
		balance=0;
	}
	
	//setters
	void setId1(String id1){this.id1=id1;}
	void setId2(String id2){this.id2=id2;}
	void setAccountNo(int Account_no){this.Account_no=Account_no;}
	void setPin(String pin){this.pin=pin;}
	void setBalance(double balance){this.balance=this.balance+balance;}
	void setAccounttype(String type) {Type=type;}
	//getters
	String getId1(){return id1;}
	String getId2(){return id2;}
	int getAccountNo(){return Account_no;}
	String getPin(){return pin;}
	double getBalance(){return balance;}
	String getAccounttype() {return Type;}
	
	void addPerson(Person P){}
	void add_DepositRecord(double amount, String type)
	{
		TransactionLedger T1=new TransactionLedger();
		T1.setAccount_no(Account_no);
		T1.setAmount(amount);
		T1.setBalance(balance);
		
		LocalDateTime myObj = LocalDateTime.now();
			T1.setDate(myObj);
		    
		
		T1.setId(id1,id2);
		T1.setType(type);
		T1.setAccountType(Type);
		T.add(T1);	
	}
	
	void withdraw(double amount) {}
	
	void add_WithdrawRecord(double amount, String type)
	{
		TransactionLedger T1=new TransactionLedger();
		T1.setAccount_no(Account_no);
		T1.setAmount(amount);
		T1.setBalance(balance);
		
		LocalDateTime myObj = LocalDateTime.now();
	 
		T1.setDate(myObj);
	    
		T1.setMonth("January");
		T1.setYear(2023);
		
		
		
		T1.setId(id1,id2);
		T1.setType(type);
		T1.setAccountType(Type);
		T.add(T1);	
	}
	
	void displayTransaction()
	{
		for(int i=0;i<T.size();i++)
		{
			T.get(i).to_string();
			System.out.println("\t--------------------------------------------------------");
			System.out.println();
			System.out.println("\t--------------------------------------------------------");
		}
	}
	
	
	

	
	
}
