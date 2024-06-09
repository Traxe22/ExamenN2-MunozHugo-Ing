/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2muñozhugotesting;

/**
 *
 * @author munoz
 */
public class Cuenta {
    private int nroCuenta;
    private double saldo=2000;
    
    public Cuenta(){
    }
    public Cuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double retirarDinero(double monto) throws Exception{
        if (monto>saldo){
            throw new Exception("OJO!, No hay saldo suficiente.");
        }else{
            this.saldo-=monto;
        }
        return saldo;
    }
    public void depositarDinero(Cuenta c,double monto){
        c.saldo+=monto;
    }
    public void transferirDinero(Cuenta c2, double monto) throws Exception{
        this.retirarDinero(monto);
        depositarDinero(c2, monto);
    }
    public boolean CuentasDiferentes(Cuenta c2){
        return !this.equals(c2);
    }
    public void OperacionTildada(int mili){
        try {
            Thread.sleep(mili);
            System.out.println("El tiempo operacion es coherente");
        } catch(InterruptedException ex){
            System.out.println("Teimpo de espera excedido...!! "+mili+" milisegundos.");
        }
    }
}
