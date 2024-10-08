/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.modelo;

/**
 *
 * @author yefre
 */
public class CurrentAccount extends Account {

    private double limite;

    public CurrentAccount(int a) {
        super(a);
        this.limite = 50;
    }

    public double getLimite() {
        return this.limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public void withdraw(double monto) {
        if(monto <= getBalance() + getLimite())
            super.withdraw(monto);

    }

    @Override
    public void deposit(double monto) {
        super.deposit(monto);
    }
}
