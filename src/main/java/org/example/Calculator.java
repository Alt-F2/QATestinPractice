package org.example;

public class Calculator {
    private float total = 0.0f;

    public void add(float a){
        total += a;
    }
    public void subtract(float a){
        total -= a;
    }
    public void multiply(float a){
        total *= a;
    }
    public void divide(float a){
        total /= a;
    }

    public float getTotal(){
        return total;
    }
}
