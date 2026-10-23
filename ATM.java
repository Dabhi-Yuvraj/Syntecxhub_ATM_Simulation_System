import java.util.Scanner;

public class ATM
{
    private int balance;
    private int pinCode;
    public ATM(int initialBalance, int pincode)
    {
        this.balance = initialBalance;
        this.pinCode = pincode;
    }
    public int getBalance()
    {
        return this.balance;
    }
    public boolean withdraw(int amount, int pin)
    {
        if(pin != this.pinCode)
        {
            return false;
        }
        if(amount > this.balance)
        {
            return false;
        }
        this.balance -= amount;
        return true;
    }
    public void deposite(int amount)
    {
        this.balance += amount;
    }
    public boolean transfer(int amount, ATM recevier, int pin)
    {
        if(pin != this.pinCode)
        {
            return false;
        }
        boolean success = this.withdraw(amount, pin);
        if(success)
        {
            recevier.deposite(amount);
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void waitForWnter()
    {
        Scanner ins = new Scanner(System.in);
        ins.nextLine();
    }
    public static void main(String[] args)
    {
        Scanner ins = new Scanner(System.in);
        ATM atm = new ATM(1000,1234);


        while(true)
        {
            System.out.println("\n1. View Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposite");
            System.out.println("4. Transefer");
            System.out.println("5. Exit");
            System.out.println("Enter your Choice");
            int choice = ins.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.println("Your Balance is : "+atm.getBalance());
                    waitForWnter();
                    break;
                case 2:
                    System.out.println("Enter the amount to Withdraw : ");
                    int wdAmount = ins.nextInt();
                    boolean success = atm.withdraw(wdAmount,1234);
                    if(success)
                    {
                        System.out.println("Withdraw Succesfull!");
                    }
                    else
                    {
                        System.out.println("Insufficient Balance...");
                    }
                    waitForWnter();
                    break;
                case 3:
                    System.out.println("Enter the amount to deposite : ");
                    int dpAmount = ins.nextInt();
                    atm.deposite(dpAmount);
                    System.out.println("Deposite Successfull..");
                    waitForWnter();
                    break;
                case 4:
                    System.out.println("Enter the amount to transfer : ");
                    int tsAmount = ins.nextInt();
                    System.out.println("Enter the receiver pin Code: ");
                    int rPin = ins.nextInt();
                    ATM recevier = new ATM(0,rPin);
                    boolean transeferSuccess = atm.transfer(tsAmount, recevier, rPin);
                    if(transeferSuccess)
                    {
                        System.out.println("Transfer Succesfully...");
                    }
                    else
                    {
                        System.out.println("Invalid pin or insufficient ballance.");
                    }
                    waitForWnter();
                    break;
                case 5:
                    System.out.println("Thanks of using ATM...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    waitForWnter();
            }
        }
    }
}