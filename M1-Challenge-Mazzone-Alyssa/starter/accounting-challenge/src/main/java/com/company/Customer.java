package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public void addCharges(AccountRecord charge){
        charges.add(charge);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        // Creates a integer to return
        int sum = 0;

        // Iterates through account records
        for (int i = 0; i < charges.size(); i++) {

            // Adds money to sum
            sum += charges.get(i).getCharge();
        }

        // Returns sum in account
        return sum;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        return "\nId: " + this.getId() + "\nName: " + this.getName()  + "\nRemaining Balance: " + this.getBalance();
    }
}
