
class Account {
private int regNumber;
private String name;
private int balance;

public String getName(){        return name;}
public void setName(String name){        this.name = name;}
public int getBalance() { return balance;}
public void setBalance(int balance){        this.balance = balance;}

}



public class AccountTest{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account obj = new Account();
		obj.setName("Tom");
		obj.setBalance(100000);
		System.out.println("이름은" + obj.getName() + "통장 잔고는" 
		+ obj.getBalance() + "입니다.");
	}
}
