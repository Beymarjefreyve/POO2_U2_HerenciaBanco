package ufps.poo2.ejercicio.banco.modelo;

import java.util.ArrayList;

public class Bank {
    
    private ArrayList<Account> cuentas;
    
    public Bank(){
        cuentas = new ArrayList<>();
    }
    
    public void addCuentas(Account c){
        cuentas.add(c);
    }
    
    public double conocerBalance(int numero){
        return buscarCuenta(numero).getBalance();
    }
    
    public void withdrawAccount(int numero, double monto){
        buscarCuenta(numero).withdraw(monto);
    }
    
    public void payDividend(int numero, double monto){
        buscarCuenta(numero).deposit(monto);
    }
    
    public void openAccount(char tipo, int numero) throws Exception{
        if(buscarCuenta(numero) != null)
            throw new Exception("Ya existe una cuenta con este número");
       
        Account c;
        if(tipo == 'A'){
           c = new SavingsAccount(numero);
           cuentas.add(c);
        }else if(tipo == 'C'){
            c = new CurrentAccount(numero);
            cuentas.add(c);
        }
    }
    
    public String imprimirSobreGiro(){
        String rta = "";
        for(Account c : this.cuentas){
            if(c instanceof CurrentAccount){
                if(((CurrentAccount) c).getLimite() == 0) rta += "Cuenta "+c.getAccountNumber()+" esta en Sobre Giro";
            } 
        }
        if(rta.equals("")) return "Ninguna cuenta en Sobre giro :)";
        return rta;
    }
    
    public Account buscarCuenta(int numero){
        for(Account c : this.cuentas){
            if(c.getAccountNumber() == numero) return c;
        }
        return null;
    }
    
    public double getBalance(int numero){
        return buscarCuenta(numero).getBalance();
    }
  
    
}
