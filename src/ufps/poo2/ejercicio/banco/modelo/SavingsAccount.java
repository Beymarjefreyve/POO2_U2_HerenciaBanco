/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.modelo;

/**
 *
 * @author yefre
 */
public class SavingsAccount extends Account{
    
    private double interest;
    
    public SavingsAccount(int a) {
        super(a);
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
    
    @Override
    public void deposit(double sum) {
	if(sum < 0)
            throw new RuntimeException("Cuenta de Ahorros: "+getAccountNumber()+" no puedes depositar un monto negativo");
        double suma = getInterest() * getBalance();
	set += sum;
	
    
}
