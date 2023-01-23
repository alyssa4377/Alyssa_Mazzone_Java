package test.java;

import org.jetbrains.annotations.TestOnly;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @TestOnly
    public String testString(){
        Customer temp = new Customer();

        // Sets customer name
        temp.setName("Alyssa Mazzone");

        // Sets customer id
        temp.setId(1);

        // Creates a new account record
        AccountRecord rec1 = new AccountRecord();
        rec1.setCharge(1000);
        rec1.setChargeDate("01-03-2022");
        temp.charges.add(rec1);

        // Creates a new account record
        AccountRecord rec2 = new AccountRecord();
        rec2.setCharge(-500);
        rec2.setChargeDate("01-05-2022");
        temp.charges.add(rec2);

        // Creates a new account record
        AccountRecord rec3 = new AccountRecord();
        rec3.setCharge(50);
        rec3.setChargeDate("01-11-2022");
        temp.charges.add(rec3);

        return temp.toString();
    }

    @TestOnly
    public int testBalance(){
        Customer temp = new Customer();

        // Sets customer name
        temp.setName("Alyssa Mazzone");

        // Sets customer id
        temp.setId(1);

        // Creates a new account record
        AccountRecord rec1 = new AccountRecord();
        rec1.setCharge(1000);
        rec1.setChargeDate("01-03-2022");
        temp.charges.add(rec1);

        // Creates a new account record
        AccountRecord rec2 = new AccountRecord();
        rec2.setCharge(-500);
        rec2.setChargeDate("01-05-2022");
        temp.charges.add(rec2);

        // Creates a new account record
        AccountRecord rec3 = new AccountRecord();
        rec3.setCharge(50);
        rec3.setChargeDate("01-11-2022");
        temp.charges.add(rec3);

        return temp.getBalance();
    }
}