/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bank;
import java.util.Scanner; 

/**
 *
 * @author khaya
 */
public class Bank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       int option;
        Scanner user = new Scanner(System.in);
        Atm RMB = new Atm(1500);
        Bankaccount Fnb = new Bankaccount(RMB);
        boolean loggedOn = true;
   
   
   System.out.println("........Welcom to capitec bank.......");
        System.out.println("what would you like to do today");
        System.out.println("***********************");

   
   while(loggedOn){
       int newBalance ;
  Fnb.DisplayMenu();
   option = user.nextInt();
    switch(option){
        case 1 -> {
            System.out.println("Amount :");
            int depositAmount = user.nextInt();
            if(depositAmount<=0){
            System.out.println("Invalid amount");
            depositAmount = 0;
            
            } 
            newBalance = Fnb.userDeposit(depositAmount);
            System.out.println("Balance is ="+ newBalance );
            System.out.println("Anything else?");
            
         System.out.println("Anything else? press 0 if you are done else 1");
             
         int   question = user.nextInt();
         if(question<=0){
         loggedOn = false;
         }
            
            
            }
        case 2 -> {
            System.out.println("Amount :");
            int withdrawAmount = user.nextInt();
            
            if(withdrawAmount>RMB.getBalance()){
            System.out.println("insufficient balance for withdrawal,try again");
            withdrawAmount = 0;
            }
            newBalance = Fnb.userWithdraw(withdrawAmount);
            System.out.println("Balance is ="+ newBalance );
            
             System.out.println("Anything else? press 0 if you are done else 1");
             
         int   question = user.nextInt();
         if(question<=0){
         loggedOn = false;
         }
            
            }
        case 3 -> {System.out.println("Your balance :"+RMB.getBalance());
         System.out.println("Anything else? press 0 if you are done else 1");
             
         int   question = user.nextInt();
         if(question<=0){
         loggedOn = false;
         }
        }
        
        case 4 -> {
            System.out.println("Thank you for using the ATM. Goodbye!");
            
            user.close();
            return;
        }
        default -> System.out.println("Invalid choice");
    }
   }
   
   System.out.println("Have a good day");
    }
    
}
class Atm{
    private int balance;
    
    public Atm(int balance){
        this.balance = balance;
    }
    
    public int withdraw(int amount){
     return  balance-= amount;
        
    }
    
    public int deposit(int amount){
    return balance+=amount;
    }
    
    public int getBalance(){
    return balance;
    }
}
class Bankaccount{
    private final Atm atm;
    
    public Bankaccount(Atm atm){
        this.atm = atm;
    }
    
    public int userWithdraw(int amount){
        return atm.withdraw(amount);
    }
    public int userDeposit(int amount){
        return atm.deposit(amount);
    }
    
    public void userBalance(){
        System.out.println("Your balance : "+atm.getBalance());
    }
    
    public void DisplayMenu(){
       
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }
}
