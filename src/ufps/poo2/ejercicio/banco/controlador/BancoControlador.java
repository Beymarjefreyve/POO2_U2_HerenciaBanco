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

    public BancoControlador(BancoVista frame) {
        this.frame = frame;
        b = new Bank();
    }

    public void abrir() {
        String textId = frame.getTxtNumeroCuenta().getText();
        String textSaldo = frame.getTxtSaldoCuenta().getText();
        char tipo = frame.getRbAhorros().isSelected() ? 'A' : 'C';

        int id = Integer.parseInt(textId);
        double saldo = textSaldo.isEmpty() ? saldo = 0 : Double.parseDouble(textSaldo);

        try {
            if (!(frame.getRbAhorros().isSelected() || frame.getRbCorriente().isSelected())) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error: Debe seleccionar un tipo de cuenta", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                b.openAccount(tipo, id);
                b.buscarCuenta(id).deposit(saldo);
                frame.getTaMensajes().append("Se abrió la cuenta id: " + b.buscarCuenta(id).getAccountNumber() + " con incial: " + b.buscarCuenta(id).getBalance() + "\n");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            cancelar();
        }
    }

    public void cancelar() {
        frame.getTxtNumeroCuenta().setText("");
        frame.getTxtSaldoCuenta().setText("");
        frame.getButtonGroup1().clearSelection();
    }

    public void aplicar() {
        String textId = frame.getTxtNumeroCuentaAcciones().getText();
        String textSaldo = frame.getTxtValor().getText();

        int id = Integer.parseInt(textId);
        double saldo = textSaldo.isEmpty() ? saldo = 0 : Double.parseDouble(textSaldo);

        if (b.buscarCuenta(id) == null) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: Cuenta Inexistente", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                if (!(frame.getRbRetirar().isSelected() || frame.getRbDividendos().isSelected())) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error: Debe seleccionar una acción", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (frame.getRbRetirar().isSelected()) {
                    b.withdrawAccount(id, saldo);
                    frame.getTaMensajes().append("Retiró: $" + saldo + " la cuenta id: " + b.buscarCuenta(id).getAccountNumber() + "\n");
                } else if (frame.getRbDividendos().isSelected()) {
                    b.payDividend(id, saldo);
                    frame.getTaMensajes().append("Pagó: $" + saldo + " la cuenta id: " + b.buscarCuenta(id).getAccountNumber() + "\n");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                cancelarAcciones();
            }
        }
    }

    public void cancelarAcciones() {
        frame.getTxtNumeroCuentaAcciones().setText("");
        frame.getTxtValor().setText("");
        frame.getButtonGroupAcciones().clearSelection();
    }

    public void enviarCorreos() {
        String emailDestino = JOptionPane.showInputDialog(frame, "Introduce el correo destinatario: ");
        if (emailDestino == null || emailDestino.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe introducir un correo.", "Título del Cartel", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                //enviarCorreo();
                JOptionPane.showMessageDialog(frame, "Correo enviado correctamente.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error al enviar el correo: " + ex.getMessage());
            }
        }
    }

    public void enviarCorreo() {
        //Codigo falta hacer
    }

}
