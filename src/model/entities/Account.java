package model.entities;

import model.CustomExceptions;

/**
 *
 * @author caiqu
 */
public class Account {

    private Integer number;
    private String holder;
    private double balance;
    private double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, double balance, double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws CustomExceptions {
        if (amount > withdrawLimit) {
            throw new CustomExceptions("the amount exceeds withdraw limit");
        } else {
            this.balance -= amount;
        }

        if (amount > this.balance) {
            throw new CustomExceptions("Not enough balance");
        } else {
            this.balance -= amount;
        }
    }
}
