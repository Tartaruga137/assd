package  entitites;

import exceptions.BusinessException;

public class Account {

    private int number;
    private String holder;
    private Double balance, withdrawLimit;

    public Account() {}

    public Account(int number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public int getNumber() {

        return number;
    }

    public void setNumber(int number) {

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

    public void setBalance(Double balance) {

        this.balance = balance;
    }

    public double getWithdrawLimit() {

        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        validateWithdraw(amount);
        balance -= amount;
    }

    protected void validateWithdraw(double amountWithdraw) {
        if (amountWithdraw > getWithdrawLimit()) {
            throw new BusinessException("Erro de saque. A quantia excede o limite de saque!") ;
        }
        if (amountWithdraw > getBalance()) {
            throw new BusinessException("Erro de saque. Saldo insuficiente!");
        }
    }
}
