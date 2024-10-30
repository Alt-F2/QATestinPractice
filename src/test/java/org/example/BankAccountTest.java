package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    @Test
    public void onConstruction_verify_object_initialised_correctly(){
        // arrange
        double expectedResult = 34.75;
        BankAccount cut = new BankAccount(expectedResult);

        // act
        double actualResult = cut.getBalance();

        // assert
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void onCredit_verify_money_is_credited_to_bank_account_correctly(){
        // arrange
        double startingBalance = 10.00;
        BankAccount cut = new BankAccount(startingBalance);
        double expectedResult = 20.00;

        // act
        cut.credit(10.00);
        double actualResult = cut.getBalance();

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void onCredit_verify_negative_amount_cannot_be_credited(){
        // arrange
        double startingBalance = 10.00;
        BankAccount cut = new BankAccount(startingBalance);
        double expectedResult = 10.00;

        // act
        cut.credit(-10.00);
        double actualResult = cut.getBalance();

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void onDebit_verify_money_is_removed_from_bank_account_correctly(){
        // arrange
        double startingBalance = 10.00;
        BankAccount cut = new BankAccount(startingBalance);
        double expectedResult = 5.00;

        // act
        cut.debit(5.00);
        double actualResult = cut.getBalance();

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void onDebit_of_account_is_rejected_if_deduction_is_subZero(){
        // arrange
        double startingBalance = 10.00;
        BankAccount cut = new BankAccount(startingBalance);
        double expectedResult = 10.00;

        // act
        cut.debit(11.00);
        double actualResult = cut.getBalance();

        // assert
        assertEquals(expectedResult, actualResult);
    }
}
