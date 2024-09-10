/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.modelo;

/**
 *
 * @author yefre
 */
public class SavingsAccount extends Account {

    private double interest;

    public SavingsAccount(int a) {
        super(a);
        this.interest = 5;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    @Override
    public void deposit(double monto) {
        double suma = monto + ((getBalance() * getInterest()) / 100);
        super.deposit(suma);
    }

    @Override
    public void withdraw(double monto) {
        if(monto <= getBalance())
            super.withdraw(monto);
    }

}
