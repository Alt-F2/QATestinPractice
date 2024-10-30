package org.example;

public class App {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount(33.33);
        System.out.println(ba.getBalance());

        ba.credit(10);
        System.out.println(ba.getBalance());


    }
}
