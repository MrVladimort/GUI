/**
 *
 *  @author Hravchenko Vladyslav S15567
 *
 */

package Zadanie1;
public class BankCustomer {
	Person person;
	Account account;
	
	public BankCustomer(Person person){
		this.person = person;
	}

	 Account getAccount(){
		 if(this.account == null)
			 return this.account = new Account();
		 else
			 return this.account;
			
	}
	
	public String toString(){
		return "\n" + "Klient: " + this.person.name + " stan konta " + this.account.saldo;
	}
}
