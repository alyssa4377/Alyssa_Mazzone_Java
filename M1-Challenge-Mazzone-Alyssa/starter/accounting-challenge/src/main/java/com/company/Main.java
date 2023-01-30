package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );
    public static void main(String[] args) {

        // List of customers names to avoid duplication
        List<String> names = new ArrayList<>();

        // List of customers
        List<Customer> list = new ArrayList<>();

        // Iterates through customer data
        for (int i = 0; i < customerData.size(); i++){
            if(!names.contains(customerData.get(i)[1])) {
                // Makes new customer
                Customer temp = new Customer();

                // Sets customer name
                temp.setName(customerData.get(i)[1]);

                // Sets customer id
                temp.setId(Integer.parseInt(customerData.get(i)[0]));

                // Adds customer name to names list
                names.add(temp.getName());

                // Adds customer to customer list
                list.add(temp);

                // Creates a new account record
                AccountRecord rec = new AccountRecord();

                // Sets charge
                rec.setCharge(Integer.parseInt(customerData.get(i)[2]));

                // Sets charge date
                rec.setChargeDate(customerData.get(i)[3]);

                // Adds a charge to account
                temp.addCharges(rec);
            } else {
                // Finds the object character obj needed
                for (int j = 0; j < list.size(); j++){
                    if (list.get(j).getId() == Integer.parseInt(customerData.get(i)[0])){
                        // Creates a new account record
                        AccountRecord rec = new AccountRecord();

                        // Sets charge
                        rec.setCharge(Integer.parseInt(customerData.get(i)[2]));

                        // Sets charge date
                        rec.setChargeDate(customerData.get(i)[3]);

                        // Adds a charge to account
                        list.get(j).addCharges(rec);
                        break;
                    }
                }
            }
        }

        System.out.println("Positive accounts:");

        // Iterates through all accounts to find positive balances
        for (int j = 0; j < list.size(); j++){
            if (list.get(j).getBalance() >= 0){
                System.out.println(list.get(j).toString());
            }
        }

        System.out.println("\nNegative accounts:");
        // Iterates through all accounts
        for (int j = 0; j < list.size(); j++){
            if (list.get(j).getBalance() < 0){
                System.out.println(list.get(j).toString());
            }
        }
    }
}