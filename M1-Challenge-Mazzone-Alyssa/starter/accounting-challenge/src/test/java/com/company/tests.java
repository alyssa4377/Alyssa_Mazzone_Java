package com.company;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
class tests {
    @Test
    public static String testString(){
        Customer temp = new Customer();

        // Sets customer name
        temp.setName("Alyssa Mazzone");

        // Sets customer id
        temp.setId(1);

        // Creates a new account record
        AccountRecord rec1 = new AccountRecord();
        rec1.setCharge(1000);
        rec1.setChargeDate("01-03-2022");
        temp.addCharges(rec1);

        // Creates a new account record
        AccountRecord rec2 = new AccountRecord();
        rec2.setCharge(-500);
        rec2.setChargeDate("01-05-2022");
        temp.addCharges(rec2);

        // Creates a new account record
        AccountRecord rec3 = new AccountRecord();
        rec3.setCharge(50);
        rec3.setChargeDate("01-11-2022");
        temp.addCharges(rec3);

        assertEquals(temp.toString(),"\nId: 1" + "\nName: Alyssa Mazzone" + "\nRemaining Balance: 550");
        return temp.toString();
    }

    @Test
    public static int testBalance(){
        Customer temp = new Customer();

        // Sets customer name
        temp.setName("Alyssa Mazzone");

        // Sets customer id
        temp.setId(1);

        // Creates a new account record
        AccountRecord rec1 = new AccountRecord();
        rec1.setCharge(1000);
        rec1.setChargeDate("01-03-2022");
        temp.addCharges(rec1);

        // Creates a new account record
        AccountRecord rec2 = new AccountRecord();
        rec2.setCharge(-500);
        rec2.setChargeDate("01-05-2022");
        temp.addCharges(rec2);

        // Creates a new account record
        AccountRecord rec3 = new AccountRecord();
        rec3.setCharge(50);
        rec3.setChargeDate("01-11-2022");
        temp.addCharges(rec3);


        assertEquals(temp.getBalance(), 550);
        return temp.getBalance();
    }

    public static void main(String[] args) {
        System.out.println("------------toString Test------------" + testString() + "\n");
        System.out.println("------------Balance Test------------\n" + testBalance());
    }
}