
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		

	    
	    Bank B=new Bank();

		int account_count=0;
		int option;
		
		
		do {
			
			
		System.out.println("\t\t\t\t\t---------------------------------");
		System.out.println("\t\t\t\t\tFIRST SDA FINANCIALS Ltd");
		System.out.println("\t\t\t\t\t---------------------------------");
		System.out.println("\t\t\t\t\t1.Login to your Account");
		System.out.println("\t\t\t\t\t2.Create New Saving Account");
		System.out.println("\t\t\t\t\t3.Create New Current Account");
		System.out.println("\t\t\t\t\t4.EXIT");
		
		Scanner sc= new Scanner(System.in); 
		option= sc.nextInt();  
		
		switch(option)
		{
			case 1:
			{
				System.out.println("\t\t\t\t\tEnter your Account number: ");
				Scanner sc1= new Scanner(System.in);  
				int acc_no =sc1.nextInt();  
				
				System.out.println("\t\t\t\t\tEnter your Pin: ");
				Scanner sc2= new Scanner(System.in);  
				String pin= sc2.nextLine(); 
				
				if(B.isLoggedin( acc_no,pin))
				{
					System.out.println("\t\t\t\t\tYou are Successfully Logged In! ");
					
					String choice="";
					Here:
					do {
						
						System.out.println("\n\t\t\t\t\ta.Deposit Amount ");
						System.out.println("\t\t\t\t\tb.Withdraw Amount");
						System.out.println("\t\t\t\t\tc.Check Balance");
						System.out.println("\t\t\t\t\td.Get Transaction Statement");
						System.out.println("\t\t\t\t\te.Remove Account");
						System.out.println("\t\t\t\t\tf.Exit");
						
						Scanner sc3= new Scanner(System.in); 
						choice= sc3.nextLine();  
						
						switch(choice)
						{
						case "a":
							{
								Scanner sc4= new Scanner(System.in); 
								System.out.println("\t\t\t\t\tEnter the amount to be deposited");
								double amount= sc4.nextInt(); 
								if(B.deposit_Account(acc_no,amount,pin))
								{
									System.out.println("\t\t\t\t\tAmount Successfully Deposited!");
									
								}
								else
								{
									System.out.println("\t\t\t\t\tAmount couldn't get deposited!");
								}
								break;
							}
							
						case "b": 
							{
								Scanner sc4= new Scanner(System.in); 
								System.out.println("\t\t\t\t\tEnter the amount to be Withdrawn");
								double amount= sc4.nextInt();
								
								if(B.isCurrent(acc_no))
								{
									B.withdraw_CurrentAccount(acc_no, amount, pin);
								}
								else if(B.isSaving(acc_no))
								{
									B.withdraw_SavingAccount(acc_no, amount, pin);
								}
								
								break;
							}
							
						case "c":
							{
								System.out.println("BALANCE: Rs."+B.checkBalance(acc_no, pin));
								break;
							}
							
						case "d":
							{
								B.TransactionDetail(acc_no, pin);
								break;
							}
						
						case "e":
							{
								B.removeAccount(acc_no, pin);
								break;
							}	
							
						case "f":
						{
							break Here;
						}	
						
						}
						
					}while(choice!="f");
										
				}
				else
				{
					System.out.println("\t\t\t\t\tWrong Credentials Added! ");
				}
				
				break;
			}
			
			case 2:
			{
				System.out.println("\t\t\t\t\tEnter your University id: ");
				Scanner sc1= new Scanner(System.in);  
				String uni_id= sc1.nextLine();  
				
				System.out.println("\t\t\t\t\tSet a pin for your Account: ");
				Scanner sc2= new Scanner(System.in);  
				String pin= sc2.nextLine(); 
				
				account_count++;
				int acc_no=account_count;
				
				if(B.Create_SavingAccount(uni_id, acc_no,pin,""))
				{
					System.out.println("\t\t\t\t\tAccount Created! with Account no: "+acc_no);
					
				}
				else
				{
					System.out.println("\t\t\t\t\tAccount Limit Exceeded!");
				}
				
				break;
			}
			
			case 3:
			{
				
				System.out.println("\t\t\t\t\ta. Single Account(One user only)");
				System.out.println("\t\t\t\t\tb. Joint Account(Two users only) ");
				Scanner sc5= new Scanner(System.in);  
				String choice= sc5.nextLine();
				
				
				System.out.println("\t\t\t\t\tEnter University id: ");
				Scanner sc3= new Scanner(System.in);  
				String uni_id1= sc3.nextLine();  
				
				String uni_id2="";
				if(choice.equals("b"))
				{
					System.out.println("\t\t\t\t\tEnter University id of second user: ");
					Scanner sc4= new Scanner(System.in);  
					uni_id2= sc4.nextLine();  
				}
				
				System.out.println("\t\t\t\t\tSet a pin for your Account: ");
				Scanner sc6= new Scanner(System.in);  
				String pin= sc6.nextLine(); 
				
				account_count++;
				int acc_no=account_count;
				if(B.Create_CurrentAccount1(uni_id1,uni_id2, acc_no,pin,"",""))
				{
					System.out.println("\t\t\t\t\tAccount Created! with Account no: "+acc_no);
				}
				else 
				{
					System.out.println("\t\t\t\t\tAccount Limit Exceeded for any of the two Ids!");
				}
				break;
			}
			
			case 4:
			{
				break;
			}
		}
		
		}while(option!=4);
			
	}
	
}


















