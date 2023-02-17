import java.util.ArrayList;

public class Bank {
	
	ArrayList<Account> A;
	ArrayList<Person> P;
	
	Bank()
	{
		A=new ArrayList<Account>();
		P=new ArrayList<Person>();
	}
	
	//Checking if the logged in account is available or not
	boolean isLoggedin(int Account_no,String pin )
	{
		
		boolean exist=false;
		for(int i=0;i<A.size();i++)
		{
			if(A.get(i).getAccountNo()==Account_no && pin.equals(A.get(i).getPin()))
			{
				exist=true;
				break;
			}
		}
		
		if(exist)
		{
			return true;			
		}
		else
		{
			return false;
		}
	}
	
	//Creating Saving account
	boolean Create_SavingAccount(String id, int Account_no, String pin,String Address)
	{
		Account A1=new SavingAccount();
		A1.setId1(id);
		A1.setAccountNo(Account_no);
		A1.setPin(pin);
		A1.setAccounttype("Saving");
		
		Person P1=new Person();
		P1.setId(id);
		P1.setAddress(Address);
		P1.setAccount(A1);
		A1.addPerson(P1);
		
		//checking whether this id has made more than 3 accounts
		int count=0;
		for(int i=0;i<A.size();i++)
		{
			if(id.equals(A.get(i).getId1()))
			{
				count++;
				//System.out.println(count);
			}
		}
		if(count==3)
		{
			return false;
			
		}
		else
		{
			A.add(A1);
			P.add(P1);
			return true;
			
		}
		
	}
	
	//Creating CurrentAccount for two or one owner
	boolean Create_CurrentAccount1(String id1,String id2, int Account_no, String pin,String Address1,String Address2)
	{
		Account A1=new CurrentAccount();
		A1.setId1(id1);
		A1.setId2(id2);
		
		
		A1.setAccountNo(Account_no);
		A1.setPin(pin);
		A1.setAccounttype("Current");
		
		Person P1=new Person();
		P1.setId(id1);
		P1.setAddress(Address1);
		P1.setAccount(A1);
		A1.addPerson(P1);
		
		Person P2=new Person();
		if(id2.equals(""))//if second owner exists for the account
		{
			
			P2.setId(id1);
			P2.setAddress(Address2);
			P2.setAccount(A1);
			A1.addPerson(P2);
		}
		
		//checking whether id1 has made more than 3 accounts
		int count1=0,count2=0;
		//boolean limit=false;
		
		for(int i=0;i<A.size();i++)//checking account limit of Id1
		{
			if(id1.equals(A.get(i).getId1()))
			{
				count1++;
			//	System.out.println(count1);
			}
		}
		for(int i=0;i<A.size();i++)//checking account limit of id2
		{
			if(id2.equals(A.get(i).getId2()))
			{
				count2++;
				//System.out.println(count2);
			}
		}
		
		if(count1==3 || count2==3)
		{
			return false;
			
		}
		else
		{
			A.add(A1);
			P.add(P1);
			P.add(P2);
			return true;			
		}
		
	}
	
	//deposit function in Current account	
	boolean deposit_Account(int Account_no,double amount,String pin)
	{
		int index=0;
		boolean exist=false;
		for(int i=0;i<A.size();i++)
		{
			if(A.get(i).getAccountNo()==Account_no && pin.equals(A.get(i).getPin()))
			{
				exist=true;
				index=i;
				break;
			}
		}
		
		if(exist)
		{
			A.get(index).setBalance(amount);//adding amount into the account			
			A.get(index).add_DepositRecord(amount,"DEPOSIT");//sending record into ledger class
			return true;			
		}
		else
		{
			return false;
		}
				
	}
	
	double checkBalance(int Account_no,String pin)
	{
		int index=0;
		boolean exist=false;
		for(int i=0;i<A.size();i++)
		{
			if(A.get(i).getAccountNo()==Account_no && pin.equals(A.get(i).getPin()))
			{
				exist=true;
				index=i;
				break;
			}
		}
		
		if(exist)
		{
			
			return A.get(index).getBalance();
			
		}
		else
		{
			return -1000;
		}
			
	}
	
	void TransactionDetail(int Account_no,String pin)
	{
		int index=0;
		boolean exist=false;
		for(int i=0;i<A.size();i++)
		{
			if(A.get(i).getAccountNo()==Account_no && pin.equals(A.get(i).getPin()))
			{
				exist=true;
				index=i;
				break;
			}
		}
		
		if(exist)
		{
			
			 A.get(index).displayTransaction();
			
		}
		else
		{
			System.out.println("\t\t\t\t\tAccount not found!");
		}
	}
	
	boolean isSaving(int Account_no)
	{
		int index=0;
		for(int i=0;i<A.size();i++)
		{
			if(A.get(i).getAccountNo()==Account_no)
			{
				index=i;
				break;
			}
		}	
			
		if(A.get(index).getAccounttype().equals("Saving"))
			
		{
				return true;
			
		}
			
		else
			return false;	
		
	}
	
	boolean isCurrent(int Account_no)
	{
		int index=0;
		for(int i=0;i<A.size();i++)
		{
			if(A.get(i).getAccountNo()==Account_no)
			{
				index=i;
				break;
			}
		}	
			
		if(A.get(index).getAccounttype().equals("Current"))
			
		{
				return true;
			
		}
			
		else
			return false;
	}
	void withdraw_SavingAccount(int Account_no,double amount,String pin)
	{
		int index=0;
		boolean exist=false;
		for(int i=0;i<A.size();i++)
		{
			if(A.get(i).getAccountNo()==Account_no && pin.equals(A.get(i).getPin()))
			{
				exist=true;
				index=i;
				break;
			}
		}
		
		if(exist)
		{
			if(A.get(index).getBalance()<100)
			{
				System.out.println("\t\t\t\t\tYOUR ACCOUNT IS DORMANT!");
			}
			else
			{
				A.get(index).withdraw(amount);
				A.get(index).add_WithdrawRecord(amount,"Withdraw");
				System.out.println("\t\t\t\t\tRs."+amount+" withdrawn");
			}
						
		}
		else
		{
			System.out.println("\t\t\t\t\tAccount Doesnot Exist!");
		}
	}
	
	void withdraw_CurrentAccount(int Account_no,double amount,String pin)
	{
		int index=0;
		boolean exist=false;
		for(int i=0;i<A.size();i++)
		{
			if(A.get(i).getAccountNo()==Account_no && pin.equals(A.get(i).getPin()))
			{
				exist=true;
				index=i;
				break;
			}
		}
		
		if(exist)
		{
			if(A.get(index).getBalance()<100)
			{
				System.out.println("\t\t\t\t\tYOUR ACCOUNT IS DORMANT!");
			}
			else
			{
				A.get(index).withdraw(amount);
				A.get(index).add_WithdrawRecord(amount,"Withdraw");
				System.out.println("\t\t\t\t\tRs."+amount+" withdrawn");
			}
						
		}
		else
		{
			System.out.println("\t\t\t\t\tAccount Doesnot Exist!");
		}
	}
		
	


		void removeAccount(int Account_no,String pin)
		{
			int index=0;
			boolean exist=false;
			for(int i=0;i<A.size();i++)
			{
				if(A.get(i).getAccountNo()==Account_no && pin.equals(A.get(i).getPin()))
				{
					exist=true;
					index=i;
					break;
				}
			}
			
			if(exist)
			{
			
				
					A.remove(index);
				
							
			}
			else
			{
				System.out.println("\t\t\t\t\tAccount Doesnot Exist!");
			}
		}
}






