import java.util.Scanner;
import java.io.*;
interface Accountable{
	public abstract void Withdraw();
	public abstract void Deposit();
	public abstract void Details();
}
abstract class Account implements Accountable{
	public String AccountHolders_name;
	public String Sex;
	public int AccountNumber;
	public String AccountType;
	public long PhoneNo;
	public String Address;
	public String Dob;
	public double balance;
	public String IFSC;
	public String Branch_name;
	public void Check_Balance() {
		System.out.println("Your Current Balance is: Rs "+balance);
	}
	
}
class SavingsAccount extends Account {
	public final int RateOfInterest=3;
	public final String AccountType="Savings Account";
	double temp;
	Scanner sc=new Scanner(System.in);
	public void Withdraw() {
		System.out.print("Enter Amount to be Withdrawn: ");
		temp=sc.nextDouble();
		if(temp>balance) {
			System.out.println("Insufficient Balance..!!");
			return;
		}
		else if(temp>20000){
			System.out.println("Withdraw Amount Exceeded, must be below 20,000" );
			return;
		}
		else {
			balance-=temp;
			System.out.println("Withdrawn Successfully..!!  Rs"+temp+" Debited from your Account");
		}
	}
	public void Deposit() {
		System.out.print("Enter Amount to Deposit: " );
		temp=sc.nextDouble();
		balance+=temp;
		System.out.println("Deposited Successfully...!!   Rs"+temp+" Credited to your Account.");
	}
	public void Details() {
		System.out.println("Name: "+AccountHolders_name);
		System.out.println("Account Number: "+AccountNumber);
		System.out.println("AccountType: "+AccountType);
		System.out.println("Sex: "+Sex);
		System.out.println("Address: "+Address);
		System.out.println("Phone Number: "+PhoneNo);
		System.out.println("Branch Name: "+Branch_name);
		System.out.println("IFSC: "+IFSC);
	}
}
class CurrentAccount extends Account {
	public final int RateOfInterest=5;
	public final String AccountType="Current Account";
	double temp;
	Scanner sc=new Scanner(System.in);
	public void Withdraw() {
		System.out.print("Enter Amount to be Withdrawn: ");
		temp=sc.nextDouble();
		if(temp>balance) {
			System.out.println("Insufficient Balance..!!");
			return;
		}
		else if(temp>50000){
			System.out.println("Withdraw Amount Exceeded, must be below 50,000" );
			return;
		}
		else {
			balance-=temp;
			System.out.println("Withdrawn Successfully..!!");
		}
	}
	public void Deposit() {
		System.out.print("Enter Amount to Deposit: " );
		temp=sc.nextDouble();
		balance+=temp;
	}
	public void Details() {
		System.out.println("Name: "+AccountHolders_name);
		System.out.println("Account Number: "+AccountNumber);
		System.out.println("AccountType: "+AccountType);
		System.out.println("Sex: "+Sex);
		System.out.println("Address: "+Address);
		System.out.println("Phone Number: "+PhoneNo);
		System.out.println("Branch Name: "+Branch_name);
		System.out.println("IFSC: "+IFSC);
	}
}
class Customer extends SavingsAccount {
	public Customer() {
		System.out.println("----------------------Please Enter the Following Details----------------------------");
		System.out.println("");
		System.out.print("Enter Your Name: ");
		AccountHolders_name=sc.nextLine();
		System.out.print("Date Of Birth(dd/mm/yyyy): ");
		Dob=sc.nextLine();
		System.out.print("Enter Your Address: ");
		Address=sc.nextLine();
		System.out.print("Phone Number: ");
		PhoneNo=sc.nextLong();
		System.out.print("Initial Balance: ");
		balance=sc.nextDouble();
		
	}
}
class Customer2 extends CurrentAccount {
	public Customer2() {
		System.out.println("----------------------Please Enter the Following Details----------------------------");
		System.out.println("");
		System.out.print("Enter Your Name: ");
		AccountHolders_name=sc.nextLine();
		System.out.print("Date Of Birth(dd/mm/yyyy): ");
		Dob=sc.nextLine();
		System.out.print("Enter Your Address: ");
		Address=sc.nextLine();
		System.out.print("Phone Number: ");
		PhoneNo=sc.nextLong();
		System.out.print("Initial Balance: ");
		balance=sc.nextDouble();
		
	}
}
public class BankingSystem {
	static final String KOL_IFSC;
	static final String SRP_IFSC;
	static final String RIS_IFSC;
	static final String BAN_IFSC;
	static {
		KOL_IFSC="KOL0076341";
		SRP_IFSC="SRP70048353";
		RIS_IFSC="RIS0037462";
		BAN_IFSC="BAN00087945";
	}
	public static void main(String...args) throws IOException {
		Scanner sc=new Scanner(System.in);
		InputStreamReader is=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(is);
		int top=0,top2=0,index=-1,flag=0,flag2=0;
		int i,t_index,trans;
		int accnum=647386532,accnum2=38273925;
		boolean b=true,c,d=false;
		String user,pass;
		Customer[] cs=new Customer[10];
		String[] UserName=new String[10];
		String[] password=new String[10];
		Customer2[] cs2=new Customer2[10];
		String[] UserName2=new String[10];
		String[] password2=new String[10];
		while(b) {
			index=-1;
			d=true;
			flag2=0;
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.println("                            WELCOME TO THE BANK OF GCETTS                         ");
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.println();
			System.out.println("1. New User Registration ");
			System.out.println("2. Old User Login ");
			System.out.println("3. Exit.");
			System.out.print("Enter Your Choice: ");
			i=sc.nextInt();
			switch(i) {
		
				case 1: System.out.println("Which Account Would You Like to Open   1. Savings   2. Current");
						System.out.print("Enter Your Choice: ");
						i=sc.nextInt();
						switch(i) {
							case 1: cs[top]=new Customer();
									System.out.println("1. Kolkata");
									System.out.println("2. Sermpore");
									System.out.println("3. Rishra");
									System.out.println("4. bandel");
									System.out.print("Enter your choice of Branch: ");
									i=sc.nextInt();
									switch(i) {
									case 1: cs[top].IFSC=KOL_IFSC;
											cs[top].Branch_name="Kolkata";
										break;
									case 2: cs[top].IFSC=SRP_IFSC;
										cs[top].Branch_name="Serampore";
							        	break;
									case 3: cs[top].IFSC=RIS_IFSC;
										cs[top].Branch_name="Rishra";
										break;
									case 4: cs[top].IFSC=BAN_IFSC;
										cs[top].Branch_name="Bandel";
										break;
									default:System.out.println("Wrong Choice..!! you are implicitly placed in APM");
										cs[top].IFSC=BAN_IFSC;
										cs[top].Branch_name="Bandel";
										break;
									}
									System.out.println("1. MALE       2. FEMALE       3.OTHERS");
									System.out.print("Enter your choice of Gender: ");
									i=sc.nextInt();
									switch(i) {
										case 1: cs[top].Sex="MALE";
											break;
										case 2: cs[top].Sex="FEMALE";
											break;
										case 3: cs[top].Sex="OTHERS";
											break;
										default:cs[top].Sex="OTHERS";
											break;
									}
									while(d) {
										flag2=0;
										System.out.print("Enter Your Username: ");
										user=br.readLine();
										System.out.print("Create Your Password: ");
										pass=br.readLine();
										for(i=0;i<top;i++) {
											if(user.equals(UserName[i])) {
												flag2=1;
												break;
											}
										}
										for(i=0;i<top2;i++) {
											if(user.equals(UserName2[i])) {
												flag2=1;
												break;
											}
										}
										if(flag2==1) {
											System.out.println("This Username Already Exists... Please Try Again..!!");
											continue;
										}
										else {
											UserName[top]=user;
											password[top]=pass;
											break;
										}
									}	
									cs[top].AccountNumber=accnum+top;
									System.out.println("Your Account has been Successfully Created...!!");
									top++;
									continue;
									
							case 2: cs2[top2]=new Customer2();
									System.out.println("1. Computer science");
									System.out.println("2. Textile Technology");
									System.out.println("3. Information Technology");
									System.out.println("4. Apparel Production and Management");
									System.out.print("Enter your choice of Branch: ");
									i=sc.nextInt();
									switch(i) {
										case 1: cs2[top2].IFSC=KOL_IFSC;
												cs2[top2].Branch_name="Kolkata";
											break;
										case 2: cs2[top2].IFSC=SRP_IFSC;
												cs2[top2].Branch_name="Serampore";
											break;
										case 3: cs2[top2].IFSC=RIS_IFSC;
										        cs2[top2].Branch_name="Rishra";
											break;
										case 4: cs2[top2].IFSC=BAN_IFSC;
												cs2[top2].Branch_name="Bandel";
											break;
										default:System.out.println("Wrong Choice..!! you are implicitly placed in APM");
												cs2[top2].IFSC=BAN_IFSC;
												cs2[top2].Branch_name="Bandel";
												break;
									}
									System.out.println("1. MALE       2. FEMALE       3.OTHERS");
									System.out.print("Enter your choice of Gender: ");
									i=sc.nextInt();
									switch(i) {
									case 1: cs2[top2].Sex="MALE";
										break;
									case 2: cs2[top2].Sex="FEMALE";
										break;
									case 3: cs2[top2].Sex="OTHERS";
										break;
									default:cs2[top2].Sex="OTHERS";
										break;
									}
									while(d) {
										flag2=0;
										System.out.print("Enter Your Username: ");
										user=br.readLine();
										System.out.print("Create Your Password: ");
										pass=br.readLine();
										for(i=0;i<top;i++) {
											if(user.equals(UserName[i])) {
												flag2=1;
												break;
											}
										}
										for(i=0;i<top2;i++) {
											if(user.equals(UserName2[i])) {
												flag2=1;
												break;
											}
										}
										if(flag2==1) {
											System.out.println("This Username Already Exists... Please Try Again..!!");
											continue;
										}
										else {
											UserName2[top2]=user;
											password2[top2]=pass;
											break;
										}
									}	
									cs2[top2].AccountNumber=accnum2+top;
									System.out.println("Your Account has been Successfully Created...!!");
									top2++;
									continue;
							default: System.out.println("You have Entered the Wrong choice...!!");
									 continue;
							
						}
					
				case 2: System.out.print("Username: ");
						user=br.readLine();
						System.out.print("Password: ");
						pass=br.readLine();
						
						for(i=0;i<=top;i++) {
							if(user.equals(UserName[i])) {
								index=i;
								flag=0;
								break;
							}
						}
						for(i=0;i<=top2;i++) {
							if(user.equals(UserName2[i])) {
								index=i;
								flag=1;
								break;
							}
						}
						if(flag==0) {
							if(index!=-1 && pass.equals(password[index])) {
								System.out.println("You Have Successfully logged in...");
								break;
							}
							else {
								System.out.println("Incorrect Username or password...!!");
								System.out.println("Please Login Again..");
								continue;
							}
						}
						else {
							if(index!=-1 && pass.equals(password2[index])) {
								System.out.println("You Have Successfully logged in...");
								break;
							}
							else {
								System.out.println("Incorrect Username or password...!!");
								System.out.println("Please Enter Again..");
								continue;
							}
						}
				case 3: System.out.println("Good byee.... Thanks For Using Our Banking System...Please visit again..!!");
						b=false;
						continue;
						
				default: System.out.println("You have Entered the Wrong Choice...Please Enter Again..!!");
						continue;
				
			}
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.println("                            WELCOME TO THE BANK OF GCETTS                         ");
			System.out.println("-------------------------------------------------------------------------------------------");
			if(flag==0) {
				System.out.print("Name: "+cs[index].AccountHolders_name+"        ");
				System.out.print("Account Number: "+cs[index].AccountNumber+"        ");
				System.out.print("IFSC: "+cs[index].IFSC+"        ");
				System.out.println();
				c=true;
				while(c) {
					t_index=-1;
					System.out.println();
					System.out.println("1. Withdraw    2. Deposit        3. Transfer           4. Check Balance       ");
					System.out.println("5. Details     6. Change pin     7. Close Account      8. Logout ");
					System.out.println();
					System.out.print("Please Enter your Choice :  ");
					i=sc.nextInt();
					switch(i) {
				
						case 1: cs[index].Withdraw();
								break;
						case 2: cs[index].Deposit();
								break;
						case 3: System.out.print("Enter the Username of that Acccount: ");
								user=br.readLine();
								System.out.print("Enter Amount to be Transferred: ");
								trans=sc.nextInt();
								for(i=0;i<=top;i++) {
									if(user.equals(UserName[i])) {
										t_index=i;
										flag=0;
										break;
									}
								}
								for(i=0;i<=top2;i++) {
									if(user.equals(UserName2[i])) {
										t_index=i;
										flag=1;
										break;
									}
								}
								if(t_index!=-1 && flag==0) {
									if(cs[index].balance<trans) {
										System.out.println("Insufficient Balance to Transfer...!!!");
										continue;
									}
									else {
										cs[index].balance=cs[index].balance-trans;
										cs[t_index].balance=cs[t_index].balance+trans;
										System.out.println("Successfully Transfered Rs"+trans+" to "+cs[t_index].AccountHolders_name);
										continue;
									}
								}
								else if(t_index!=-1 && flag==1) {
									if(cs[index].balance<trans) {
										System.out.println("Insufficient Balance to Transfer...!!!");
										continue;
									}
									else {
										cs[index].balance=cs[index].balance-trans;
										cs2[t_index].balance=cs2[t_index].balance+trans;
										System.out.println("Successfully Transfered Rs."+trans+" to "+cs2[t_index].AccountHolders_name);
										continue;
									}
								}
								else {
									System.out.println("The Account with Username "+user+" does not exists..!!");
									continue;
								}
								
						case 4: cs[index].Check_Balance();
								break;
						case 5: cs[index].Details();
								break;
						case 6: System.out.print("Create Your Password: ");
								password[index]=br.readLine();
								System.out.println("Password Changed Successfully...!!");
								break;
						case 7: cs[index]=null;
								UserName[index]=null;
								password[index]=null;
								System.out.println("Account Closed Successfully...!!");
								c=false;
								break;
						case 8: System.out.println("Logged Out Successfully...!!");
								c=false;
								break;
						default:System.out.println("You Have Entered the Wrong Choice..!!  Please Enter Again..");
								break;
						
					}
				}
			}
			else {
				System.out.print("Name: "+cs2[index].AccountHolders_name+"        ");
				System.out.print("Account Number: "+cs2[index].AccountNumber+"        ");
				System.out.print("IFSC: "+cs2[index].IFSC+"        ");
				System.out.println();
				c=true;
				while(c) {
					t_index=-1;
					System.out.println();
					System.out.println("1. Withdraw    2. Deposit        3. Transfer           4. Check Balance       ");
					System.out.println("5. Details     6. Change pin     7. Close Account      8. Logout ");
					System.out.println();
					System.out.println("Please Enter your Choice :  ");
					i=sc.nextInt();
					switch(i) {
				
						case 1: cs2[index].Withdraw();
								break;
						case 2: cs2[index].Deposit();
								break;
						case 3: System.out.print("Enter the Username of that Acccount: ");
								user=br.readLine();
								System.out.print("Enter Amount to be Transferred: ");
								trans=sc.nextInt();
								for(i=0;i<=top;i++) {
									if(user.equals(UserName[i])) {
										t_index=i;
										flag=0;
										break;
									}
								}
								for(i=0;i<=top2;i++) {
									if(user.equals(UserName2[i])) {
										t_index=i;
										flag=1;
										break;
									}
								}
								if(t_index!=-1 && flag==0) {
									if(cs2[index].balance<trans) {
										System.out.println("Insufficient Balance to Transfer...!!!");
										continue;
									}
									else {
										cs2[index].balance=cs2[index].balance-trans;
										cs[t_index].balance=cs[t_index].balance+trans;
										System.out.println("Successfully Transfered Rs"+trans+" to "+cs[t_index].AccountHolders_name);
										continue;
									}
								}
								else if(t_index!=-1 && flag==1) {
									if(cs2[index].balance<trans) {
										System.out.println("Insufficient Balance to Transfer...!!!");
										continue;
									}
									else {
										cs2[index].balance=cs[index].balance-trans;
										cs2[t_index].balance=cs2[t_index].balance+trans;
										System.out.println("Successfully Transfered Rs."+trans+" to "+cs2[t_index].AccountHolders_name);
										continue;
									}
								}
								else {
									System.out.println("The Account with Username "+user+" does not exists..!!");
									continue;
								}
						case 4: cs2[index].Check_Balance();
								break;
						case 5: cs2[index].Details();
								break;
						case 6: System.out.print("Create Your Password: ");
								password2[index]=br.readLine();
								System.out.println("Password Changed Successfully...!!");
								break;
						case 7: cs2[index]=null;
								UserName2[index]=null;
								password2[index]=null;
								System.out.println("Account Closed Successfully...!!");
								c=false;
								break;
						case 8: System.out.println("Logged Out Successfully...!!");
								c=false;
								break;
						default:System.out.println("You Have Entered the Wrong Choice..!!  Please Enter Again..");
								break;
						
					}
				}
			}
			
		}
		
		
	}

}

