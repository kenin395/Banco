package org.example;

/*
 * Author: Kenin Cusme
 * Fecha: 23/10/2025
 * Descripción: Esta clase denominada CuentaCorriente modela una cuenta bancaria
 * que es una subclase de Cuenta. Tiene un nuevo atributo denominado "sobregiro",
 * el cual representa el dinero prestado al cliente cuando su saldo es insuficiente.
 */

public class CuentaCorriente extends Cuenta {

    /*
     * Atributo que almacena el valor del sobregiro.
     * Representa el dinero adicional que el banco permite usar cuando el saldo es insuficiente.
     */
    private float sobregiro;

    /*
     * Constructor de la clase CuentaCorriente.
     * @param saldo Parámetro que define el saldo inicial de la cuenta corriente.
     * @param tasa  Parámetro que define la tasa anual de interés de la cuenta corriente.
     */
    public CuentaCorriente(float saldo, float tasa) {
        super(saldo, tasa);
        sobregiro = 0;
    }

    /*
     * Método que realiza un retiro de la cuenta corriente.
     * Si el saldo no es suficiente, se activa el sobregiro para cubrir la diferencia.
     * @param cantidad Cantidad de dinero que el cliente desea retirar.
     */
    public void retirar(float cantidad) {
        float resultado = saldo - cantidad;
        if (resultado < 0) { // Si el retiro excede el saldo disponible
            sobregiro += Math.abs(resultado); // Se incrementa el sobregiro
            saldo = 0; // El saldo queda en cero
        } else {
            super.retirar(cantidad); // Si hay saldo suficiente, se retira normalmente
        }
    }

    /*
     * Método que realiza un depósito en la cuenta corriente.
     * Si existe sobregiro, el depósito se usa primero para cubrirlo.
     * @param cantidad Cantidad de dinero que el cliente deposita.
     */
    @Override
    public void depositar(float cantidad) {
        if (sobregiro > 0) { // Si hay sobregiro pendiente
            if (cantidad > sobregiro) { // Si el depósito cubre el sobregiro
                cantidad -= sobregiro;
                sobregiro = 0;
                super.depositar(cantidad); // El excedente se deposita como saldo
            } else { // Si el depósito no alcanza a cubrir el sobregiro
                sobregiro -= cantidad;
            }
        } else {
            super.depositar(cantidad); // Si no hay sobregiro, se deposita normalmente
        }
    }

    /*
     * Método que imprime en pantalla los detalles de la cuenta corriente:
     * saldo actual, comisión mensual, número de transacciones y valor de sobregiro.
     */
    public void imprimir() {
        System.out.println("Saldo: $ " + saldo);
        System.out.println("Cargo mensual: $ " + comisionMensual);
        System.out.println("Número de transacciones: " + (numeroDepositos + numeroRetiro));
        System.out.println("Valor de sobregiro: $ " + sobregiro);
        System.out.println();
    }
}
