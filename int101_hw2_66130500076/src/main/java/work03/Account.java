package work03;

import work02.Person;
import work01.Utilitor;

import java.util.Objects;

public class Account {
    private static long nextNo = 1_000_000_000;
    private final long no;
    private Person owner;
    private double balance;

    public Account(Person owner) {
        if (owner == null) { throw new NullPointerException(); }
        this.owner = owner;
        this.balance = 0.0;
        do {
            long result = Utilitor.computeIsbn10(nextNo);
            if (result != 10) {
                this.no = 10 * nextNo + result;
                break;
            }
            nextNo++;
        } while (true);
        nextNo++;
    }

    public long getNo() {
        return no;
    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        this.balance += Utilitor.testPositive(amount);
        return this.balance;
    }

    public double withdraw(double amount) {
        this.balance = Utilitor.testPositive(this.balance) - Utilitor.testPositive(amount);
        return this.balance;
    }

    public void transfer(double amount, Account account) {
        if (account == null) throw new IllegalArgumentException();
        this.withdraw(amount);
        account.deposit(amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Account(");
        sb.append(this.no);
        sb.append(",");
        sb.append(this.balance);
        sb.append(")");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return no == account.no && Double.compare(balance, account.balance) == 0 && Objects.equals(owner, account.owner);
    }
}
