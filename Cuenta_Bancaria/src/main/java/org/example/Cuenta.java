package org.example;

/*
 * Author: Kennin Cusme
 * Fecha y versión: 23/10/2025 - Versión 1.0
 * Descripción: Se implementa una clase denominada Cuenta que modela una cuenta bancaria básica.
 * Esta clase posee los siguientes atributos:
 *  - saldo (float): representa el dinero disponible en la cuenta.
 *  - número de depósitos (int).
 *  - número de retiros (int).
 *  - tasa anual de interés (float).
 *  - comisión mensual (float).
 */

public class Cuenta {

    // Atributo que representa el saldo actual de la cuenta
    protected float saldo;

    // Atributo que almacena el número total de depósitos realizados
    protected int numeroDepositos = 0;

    // Atributo que almacena el número total de retiros realizados
    protected int numeroRetiro = 0;

    // Atributo que representa la tasa anual de interés de la cuenta
    protected float tasaAnual;

    // Atributo que almacena el valor de la comisión mensual aplicada a la cuenta
    protected float comisionMensual = 0;

    /*
     * Constructor de la clase Cuenta.
     * @param saldo      Parámetro que define el saldo inicial de la cuenta.
     * @param tasaAnual  Parámetro que define la tasa anual de interés de la cuenta.
     */
    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    /*
     * Método que permite realizar un depósito en la cuenta.
     * Recibe una cantidad de dinero y actualiza el saldo.
     * @param cantidad Cantidad a depositar.
     */
    public void depositar(float cantidad) {
        // Actualiza el saldo sumando la cantidad depositada
        saldo += cantidad;

        // Incrementa el número de depósitos
        numeroDepositos++;
    }

    /*
     * Método que permite realizar un retiro de la cuenta.
     * Verifica si hay suficiente saldo antes de descontar la cantidad solicitada.
     * @param cantidad Cantidad de dinero a retirar.
     */
    public void retirar(float cantidad) {
        float nuevoSaldo = saldo - cantidad;

        // Verifica que el saldo no quede en negativo
        if (nuevoSaldo >= 0) {
            saldo = nuevoSaldo;
            numeroRetiro++;
        } else {
            System.out.println("Saldo insuficiente. No se puede realizar el retiro.");
        }
    }

    /*
     * Método que calcula el interés mensual basado en la tasa anual y lo suma al saldo.
     * La tasa anual se convierte a tasa mensual dividiéndola entre 12.
     */
    public void calcularInteresMensual() {
        // Convierte la tasa anual a tasa mensual (porcentaje)
        float tasaMensual = tasaAnual / 12;

        // Calcula el interés mensual y lo añade al saldo
        float interes = saldo * (tasaMensual / 100);
        saldo += interes;
    }

    /*
     * Método que genera el extracto mensual de la cuenta.
     * Aplica la comisión mensual y luego calcula el interés correspondiente.
     */
    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteresMensual();
    }

    /*
     * Método que imprime la información principal de la cuenta.
     */
    public void imprimir() {
        System.out.println("Saldo actual: $" + saldo);
        System.out.println("Número de depósitos: " + numeroDepositos);
        System.out.println("Número de retiros: " + numeroRetiro);
        System.out.println("Tasa anual: " + tasaAnual + "%");
        System.out.println("Comisión mensual: $" + comisionMensual);
        System.out.println();
    }
}
