package int101.homework02;

import work01.Utilitor;
import work02.Person;
import work03.Account;

public class Int101Homework02 {

    public static void main(String[] args) {
       work01Utilitor();
       work02Person();
       work03Account();
    }

    static void work01Utilitor() {

        System.out.println("Test String value : " + Utilitor.testString("Best"));
        System.out.println("Test positive : " + Utilitor.testPositive(22));
        System.out.println("Check-digit for isbn10 : " + Utilitor.computeIsbn10(974472362));

        /*
       1.1 Create a public utility class named "Utilitor" in package named "work01".
       1.2 Create a public method named "testString" in "Utilitor" class.
           This method receives a parameter of type "String"
           named "value" and it returns the "value" if nothing is wrong.
           However, if the "value" is null, it throws NullPointerException.
           If the "value" is a blank string, it throws IllegalArgumentException.
       1.3 Create a public method named "testPositive" in "Utilitor" class.
           This method receives a parameter of type "double" named "value"
           and it returns the "value" if this "value" is a positive value.
           Otherwise, it throws IllegalArgumentException.
       1.4 Create a public method named "computeIsbn10" in "Utilitor" class.
           This method recieves a parameter of type "long" named "isbn10", which
           consists of 9 digits from position 10 (leftmost) to position 2
           (rightmost). This method returns a value of type "long" that is
           the check-digit for "isbn10". All possible returned values are 0 to 10.
           See https://en.wikipedia.org/wiki/Check_digit for ISBN-10 calculation.
           ** You must use loop to calculate the ISBN-10 check-digit. **
       1.5 Show in this "work01Utilitor" method how to
           use 1.2-1.4 and check their correctness. */
    }
    

    static void work02Person() {
        Person p1 = new Person("Varinporn","Kiratipattanakorn");
        System.out.println(p1);
        Person p2 = new Person("Varin","Kira");
        System.out.println(p2);

        p1.setFirstname("Best");
        System.out.println("Change person1's firstname : " + p1.getFirstname());
        p1.setLastname("Varinporn");
        System.out.println("Change person1's lastname : " + p1.getLastname());
        System.out.println(p1);

        System.out.println("person 1 equal person 2 : " + p1.equals(p2));
        System.out.println("");

    /*
       2.1 Create a public class named "Person" in package named "work02".
           This class contains the following fields and methods.
       2.2 a private static field of type "int" named "nextId" initialized to 1.
       2.3 a private final field of type "int" named "id".
       2.4 a private field of type "String" named "firstname".
       2.5 a private field of type "String" named "lastname".
       2.6 a public constructor that receives "firstname" and "lastname"
           parameters to set the values of "firstname" and "lastname" fields.
           Check the correctness of the values of "firstname" and "lastname"
           parameters with "Utilitor.testString" method first.
           If nothing is wrong, set the value of "id" field to be the value
           of "nextId" field and increment the value of "nextId" by 1.
       2.7 @Override a public "toString" method that returns
           "Person(id,firstname,lastname)" where id, firstname, and lastname
           are the values of the coresponding fields of this "Person" object.
           Use "StringBuilder" to build the output string.
       2.8 public getters for "id", "firstname", and "lastname" fields.
       2.9 public setters for "firstname" and "lastname" fields.
           Use the "Utilitor.testString" method to check
           the correctness of the parameters first.
       2.10 @Override a public "equals" method that returns true
            if this object is the same as the object in the parameter
            (i.e., the same reference). Otherwise, it returns false.
       2.11 Show in this "work02Person" method how to
            use 2.6-2.10 and check their correctness. */
    }

    static void work03Account() {
        Person owner1 = new Person("Varinporn", "Kiratipattanakorn");
        Person owner2 = new Person("Best", "Varinporn");
        Account account1 = new Account(owner1);
        Account account2 = new Account(owner2);
        System.out.println("Account1 deposits 15000 baht");
        account1.deposit(15000);
        System.out.println(account1);

        System.out.println("Account2 deposits 25000 baht");
        account2.deposit(25000);
        System.out.println(account2);

        System.out.println("Account1 withdraws 1200 baht");
        account1.withdraw(1200);
        System.out.println(account1);

        System.out.println("Account2 withdraws 800 baht");
        account2.withdraw(800);
        System.out.println(account2);

        System.out.println("Account1 transfer to account2 50 baht");
        account1.transfer(50, account2);

        System.out.println(account1);
        System.out.println(account2);
       /*
       3.1 Create a public class named "Account" in package named "work03".
           This class contains the following fields and methods.
       3.2 a private static field of type "long" named "nextNo"
           initialized to 100_000_000.
       3.3 a private final "no" field of type "long".
       3.4 a private "owner" field of type "Person".
       3.5 a private "balance" field of type "double".
       3.6 a public constructor that receives an "owner" parameter of
           type "Person" to set the "owner" field. This method throws
           NullPointerException if the "owner" parameter is null.
           This method sets the value of "balance" to 0.0 and sets
           the value of "no" field as follows.
           1) Let result = Utilitor.computeIsbn10(nextNo).
           2) If result is 10, increment the value of "nextNo" by 1
              and try Step 1) again until the result is not 10.
           3) Set the value of "no" filed to be 10 * nextNo + the result.
           4) Increment the value of "nextNo" by 1.
       3.7 public getters for "no", "owner", and "balance".
       3.8 a public method named "deposit" that receives a "double" parameter
           named "amount". This method throws IllegalArgumentException
           if "amount" cannot pass "Utilitor.testPositive" method.
           Otherwise, the method adds the "amount" to "balance"
           and then returns the new "balance".
       3.9 a public method named "withdraw" that receives a "double" parameter
           named "amount". This method throws IllegalArgumentException
           if "amount" does not pass "Utilitor.testPositive" method.
           Otherwise, the method subtracts the "amount" from "balance"
           and then returns the new "balance".  However, this method will not
           do so if the new "balance" cannot pass "Utilitor.testPositive" method.
       3.10 a public method named "transfer" that recieves a "double" parameter
            named "amount" and an "Account" parameter named "account".
            This method throws IllegalArgumentException if "account" is null
            or it cannot "withdraw" the "amount" from this object. Otherwise,
            this method "withdraw" the "amount" from this object and "deposit"
            the "amount" to the "account" object.  This method returns nothing.
       3.11 @Override a public "toString" method that returns
            "Account(no,balance)" where "no" and "balance" are
            the "no" and "balance" fields of this object.
       3.12 @Override a public "equals" method that returns true
            if this object is the same as the object in the parameter
            (i.e., the same reference). Otherwise, it returns false.
       3.13 Show in this "work03Account" method how to
            use 3.6-3.12 and check their correctness. */
    }
}
