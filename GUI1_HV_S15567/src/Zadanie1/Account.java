/**
 *
 *  @author Hravchenko Vladyslav S15567
 *
 */

package Zadanie1;

public class Account {
	double saldo;
	static double rate;
	
	public Account(){
		this.saldo = 0;
	}
	
	void transfer(Account account, double count){
		if(this.saldo - count > 0 && count > 0){
			this.saldo -= count;
			account.saldo += count;
		}else{
			System.out.println("Error");}
	}
	
	void deposit(double count){
		if(count > 0)
			this.saldo += count;
		else 
			System.out.println("Error");
	}
	
	void withdraw(double count){
		if(this.saldo - count > 0 && count > 0)
			this.saldo -= count;
		else
			System.out.println("Error");
	}
	
	void addInterest(){
		this.saldo += (this.saldo/100)*rate;
	}
	
	 static void setInterestRate(double r){
		rate = r;
	}
}
