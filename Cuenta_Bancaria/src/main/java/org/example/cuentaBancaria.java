package org.example;

/*
 * Author: Kenin Cusme
 * Fecha: 23/10/2025
 * Descripción: Esta clase denominada cuentaBancaria modela una cuenta de ahorros
 * que es una subclase de Cuenta. Tiene un atributo adicional llamado "activa",
 * que indica si la cuenta se encuentra operativa según su saldo.
 */

public class cuentaBancaria extends Cuenta {

    /*
     * Atributo que identifica si una cuenta está activa.
     * Una cuenta se considera activa si su saldo es superior a 10 dólares.
     */
    private boolean activa;

    /*
     * Constructor de la clase cuentaBancaria.
     * @param saldo Parámetro que define el saldo inicial de la cuenta de ahorros.
     * @param tasa  Parámetro que define la tasa anual de interés de la cuenta de ahorros.
     */
    public cuentaBancaria(float saldo, float tasa) {
        super(saldo, tasa);
        if (saldo < 10) {
            activa = false;
        } else {
            activa = true;
        }
    }

    /*
     * Método que recibe una cantidad de dinero a consignar o depositar y actualiza
     * el saldo de la cuenta.
     * @param cantidad Parámetro que define la cantidad a consignar en una cuenta de ahorros.
     */
    @Override
    public void depositar(float cantidad) {
        if (activa) {
            super.depositar(cantidad);
        } else {
            System.out.println("La cuenta no está activa. No se puede realizar el depósito.");
        }
    }

    /*
     * Método que recibe una cantidad de dinero a retirar y actualiza el saldo de la cuenta.
     * @param cantidad Parámetro que define la cantidad a retirar de una cuenta de ahorros.
     */
    @Override
    public void retirar(float cantidad) {
        if (activa) {
            super.retirar(cantidad);
        } else {
            System.out.println("La cuenta no está activa. No se puede realizar el retiro.");
        }
    }

    /*
     * Método que genera el extracto mensual de una cuenta de ahorros.
     * Si el número de retiros supera 4, se aplica una comisión adicional de $1 por cada retiro extra.
     */
    @Override
    public void extractoMensual() {
        if (numeroRetiro > 4) {
            comisionMensual = comisionMensual + ((numeroRetiro - 4) * 1);
        }
        super.extractoMensual();
        if (saldo <= 10) {
            activa = false;
        }
    }

    /*
     * Método que muestra en pantalla los datos de una cuenta de ahorros,
     * incluyendo el saldo, la comisión mensual y el total de transacciones realizadas.
     */
    public void imprimir() {
        System.out.println("Saldo = $ " + saldo);
        System.out.println("Comisión mensual = $ " + comisionMensual);
        System.out.println("Número de transacciones: " + (numeroDepositos + numeroRetiro));
        System.out.println();
    }
}
