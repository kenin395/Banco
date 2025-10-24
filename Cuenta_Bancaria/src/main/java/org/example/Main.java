package org.example;

/*
 * Author = Kenin Cusme
 * Fecha: 23/10/2025
 * Descripción: Programa principal que permite al usuario crear una cuenta bancaria
 * de tipo Ahorros o Corriente, y realizar operaciones básicas como depositar,
 * retirar y generar extracto mensual mediante un menú interactivo.
 */

import java.io.BufferedReader;    // Para leer texto desde la consola
import java.io.IOException;       // Para manejar errores de entrada/salida
import java.io.InputStreamReader; // Para conectar el BufferedReader con la entrada estándar (teclado)

public class Main {  // Clase principal del programa

    /*
     * Método principal main: punto de inicio del programa.
     * Puede lanzar una excepción IOException por errores de entrada/salida.
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Variables comunes
        float saldo, tasa, cantidad;
        int opcion;

        System.out.println("======================================");
        System.out.println("      SISTEMA DE CUENTAS BANCARIAS");
        System.out.println("======================================");
        System.out.println("Seleccione el tipo de cuenta:");
        System.out.println("a) Cuenta de Ahorros");
        System.out.println("b) Cuenta Corriente");
        System.out.print("Opción: ");
        String tipoCuenta = br.readLine();

        // Solicitar datos iniciales
        System.out.print("Ingrese el saldo inicial: $");
        saldo = Float.parseFloat(br.readLine());

        System.out.print("Ingrese la tasa de interés anual (%): ");
        tasa = Float.parseFloat(br.readLine());

        // Variables para las cuentas
        cuentaBancaria cuentaAhorros = null;
        CuentaCorriente cuentaCorriente = null;

        // Crear el tipo de cuenta según la elección
        if (tipoCuenta.equalsIgnoreCase("a")) {
            cuentaAhorros = new cuentaBancaria(saldo, tasa);
            System.out.println("\n✅ Cuenta de Ahorros creada exitosamente.");
        } else if (tipoCuenta.equalsIgnoreCase("b")) {
            cuentaCorriente = new CuentaCorriente(saldo, tasa);
            System.out.println("\n✅ Cuenta Corriente creada exitosamente.");
        } else {
            System.out.println("❌ Opción inválida. Finalizando programa.");
            return;
        }

        // Menú de operaciones
        do {
            System.out.println("\n========== MENÚ DE OPERACIONES ==========");
            System.out.println("1) Depositar");
            System.out.println("2) Retirar");
            System.out.println("3) Generar extracto mensual");
            System.out.println("4) Mostrar información de la cuenta");
            System.out.println("5) Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad a depositar: $");
                    cantidad = Float.parseFloat(br.readLine());
                    if (cuentaAhorros != null)
                        cuentaAhorros.depositar(cantidad);
                    else
                        cuentaCorriente.depositar(cantidad);
                    System.out.println("✅ Depósito realizado con éxito.");
                    break;

                case 2:
                    System.out.print("Ingrese la cantidad a retirar: $");
                    cantidad = Float.parseFloat(br.readLine());
                    if (cuentaAhorros != null)
                        cuentaAhorros.retirar(cantidad);
                    else
                        cuentaCorriente.retirar(cantidad);
                    break;

                case 3:
                    if (cuentaAhorros != null)
                        cuentaAhorros.extractoMensual();
                    else
                        cuentaCorriente.extractoMensual();
                    System.out.println("✅ Extracto mensual generado correctamente.");
                    break;

                case 4:
                    if (cuentaAhorros != null)
                        cuentaAhorros.imprimir();
                    else
                        cuentaCorriente.imprimir();
                    break;

                case 5:
                    System.out.println("👋 Gracias por utilizar el sistema bancario.");
                    break;

                default:
                    System.out.println("⚠️ Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 5);
    }
}
