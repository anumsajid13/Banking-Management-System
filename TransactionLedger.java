
import java.time.LocalDateTime;

public class TransactionLedger {
	
	int Account_no;
	String user_id1;
	String user_id2;
	LocalDateTime Date;
	String month;
	int year;
	double balance;
	double amount;//amount deposited or withdrawn
	double penalty;
	String type;//Withdraw or Deposit
	String AccountType;
	
   void setAccount_no(int Account_no) {this.Account_no=Account_no;}
   void setId(String id1,String id2){this.user_id1=id1; this.user_id2=id2;}
   void setDate(LocalDateTime i) {this.Date=i;}
   void setMonth(String month) {this.month=month;}
   void setYear(int year) {this.year=year;}
   void setAmount(double amount){this.amount=amount;}
   void setBalance(double balance){this.balance=balance;}
   void setType(String Type) {this.type=Type;}
   void setAccountType(String AccountType) {this.AccountType=AccountType;}
   
   void to_string()
   {
	   if(user_id2==null)
	   {
		   user_id2="";
	   }
	   if(AccountType=="Saving")
	   {
		   penalty=0.01;
	   }
	   
	   System.out.println("\tTransactional Date and Time:\t\t\t"+Date);
	   System.out.println("\tAccount Type:\t\t\t\t"+AccountType);
	   System.out.println("\tTransactional Type:\t\t\t"+type);
	   System.out.println();
	   System.out.println("\tAccount_no:\t\t\t\t"+Account_no);
	   System.out.println("\tUser ID:\t\t\t\t"+user_id1+"	"+user_id2);
	   System.out.println("\tAmount"+type +":\t\t\t\t"+"Rs."+amount);
	   if(type=="Withdraw")
	   {
		   System.out.println("\tPenalty(only for Saving Account users): "+penalty+"%");
	   }	   
	   System.out.println("\tBalance:\t\t\t\t"+"Rs."+balance);
	   
	   
   }
}




















