package work04;

public class BankAccount {
    // fields
    private int number;
    private Person owner;
    private double balance;

    // constructor number & owner
    public BankAccount(int number, Person owner) {
        this.number = number;
        this.owner = owner;
    }

    // getter owner & balance
    public Person getOwner() {
        return owner;
    }
    public double getBalance() {
        return balance;
    }

    // deposit method
    public double deposit(double amount){
        balance += amount;
        return balance;
    }

    // withdraw method
    public double withdraw(double amount){
        balance -= amount;
        return balance;
    }

    // transfer method
    public void transfer(double amount, BankAccount account){
        withdraw(amount);
        account.deposit(amount);
    }

    @Override
    public String toString() {
        return "BankAccount{" + "number=" + number + ", owner=" + owner + ", balance=" + balance + '}';
    }
}
