package clases;

import interfaces.ISaldos;

public class Policia extends Persona implements ISaldos {
    private int edad;
    private int rango;
    private double saldo;

    public Policia(String nombres, String apellidos, String codigo, String DNI, int edad, int rango) {
        super(codigo, nombres, apellidos, DNI);
        this.edad=edad;
        this.rango=rango;
    }

    public int getEdad() {
        return edad;
    }
   
    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public void calcularS() {
        saldo = 120 * rango;
    }

    @Override
    public String toString() {
        return super.toString()
              +"\nEdad: "+edad
              +"\nRango: "+rango
              +"\nSaldo: "+saldo;
    }
}