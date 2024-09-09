/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.controlador;

import javax.swing.JOptionPane;
import ufps.poo2.ejercicio.banco.modelo.Bank;
import ufps.poo2.ejercicio.banco.vista.BancoVista;

/**
 *
 * @author Boris Perez
 */
public class BancoControlador {
    private BancoVista frame;
    private Bank b;
    
    public BancoControlador(BancoVista frame){
        this.frame = frame;
        b = new Bank();
    }
    
    public void abrir(){
        String textId = frame.getTxtNumeroCuenta().getText();
        String textSaldo  = frame.getTxtSaldoCuenta().getText();
        char tipo = frame.getRbAhorros().isSelected() ? 'A' : 'C'; 
        
        int id = Integer.parseInt(textId);
        double saldo = Double.parseDouble(textSaldo);
        
        try{
            b.openAccount(tipo,id);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }finally{
            cancelar();
        }
    }
    
    public void cancelar(){
        frame.getTxtNumeroCuenta().setText("");
        frame.getTxtSaldoCuenta().setText("");
        frame.getButtonGroup1().clearSelection();
    }
    
    public void aplicar(){
        String textId = frame.getTxtNumeroCuentaAcciones().getText();
        String textSaldo = frame.getTxtValor().getText();
        
        int id = Integer.parseInt(textId);
        double saldo = Double.parseDouble(textSaldo);
        
        if(b.buscarCuenta(id) == null)
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: Cuenta Inexistente", "Error", JOptionPane.ERROR_MESSAGE);
        else {
            try{
                if(frame.getRbRetirar().isSelected()) b.withdrawAccount(id, saldo);
                else if(frame.getRbDividendos().isSelected()) b.payDividend(id, saldo);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }finally{
                cancelarAcciones();
            }
        }
    }
        
    public void cancelarAcciones(){
        frame.getTxtNumeroCuentaAcciones().setText("");
        frame.getTxtValor().setText("");
        frame.getButtonGroupAcciones().clearSelection();
    }
        
}
    
    

