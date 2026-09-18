
package logica;

import Modelo.Agente;
import Modelo.Caso;
import Modelo.Sospechoso;
import java.util.Scanner;

public class MotorDecisiones {

    private static final double INVESTIGACION_MINIMA = 60.0;

    private static final int ACUSAR_CORRECTAMENTE = 100;
    private static final int ACUSAR_SIN_EVIDENCIA = -40;

    private Caso caso;
    private Agente agente;

    private int evidenciasAnalizadas;

    private static Scanner tc = new Scanner(System.in);


    // =========================
    // CONSTRUCTOR
    // =========================

    public MotorDecisiones(Caso caso, Agente agente, int evidenciasAnalizadas) {

        this.caso = caso;
        this.agente = agente;
        this.evidenciasAnalizadas = evidenciasAnalizadas;
    }


    // =========================
    // ACTUALIZAR EVIDENCIAS
    // =========================

    public void actualizarEvidenciasAnalizadas(int cantidad) {

        this.evidenciasAnalizadas = cantidad;
    }


    // =========================
    // DECISION FINAL
    // =========================

    public boolean decisionFinal() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("        DECISIÓN FINAL");
        System.out.println("=================================");

        System.out.println();
        System.out.println("La evidencia analizada apunta hacia:");
        System.out.println();

        for (int i = 0; i < caso.getSospechosos().size(); i++) {

            Sospechoso sospechoso =
                    caso.getSospechosos().get(i);

            System.out.println(
                    "[" + (i + 1) + "] "
                    + sospechoso.getNombre().toUpperCase()
            );
        }

        int opcion = leerEntero("\nIngrese su decisión: ");

        if (opcion < 1 || opcion > caso.getSospechosos().size()) {

            System.out.println("Opción inválida.");

            return false;
        }

        Sospechoso acusado =
                caso.getSospechosos().get(opcion - 1);

        return procesarAcusacion(acusado.getNombre());
    }


    // =========================
    // PROCESAR ACUSACION
    // =========================

    private boolean procesarAcusacion(String acusado) {

        int totalEvidencias = caso.getEvidencias().size();

        double porcentajeInvestigado;

        if (totalEvidencias == 0) {

            porcentajeInvestigado = 0;

        } else {

            porcentajeInvestigado =
                    (evidenciasAnalizadas * 100.0)
                    / totalEvidencias;
        }


        boolean acusacionCorrecta =
                acusado.equalsIgnoreCase(
                        caso.getSospechosoCorrecto()
                );

        boolean investigacionSuficiente =
                porcentajeInvestigado >= INVESTIGACION_MINIMA;


        if (acusacionCorrecta && investigacionSuficiente) {

            agente.ganarExperiencia(ACUSAR_CORRECTAMENTE);
            agente.aumentarReputacion(10);
            agente.registrarDecision(true);

            caso.resolverCaso();

            finalPerfecto(porcentajeInvestigado);

            return true;


        } else if (acusacionCorrecta) {

            agente.ganarExperiencia(
                    ACUSAR_CORRECTAMENTE / 2
            );

            agente.registrarDecision(true);

            caso.resolverCaso();

            finalParcial(porcentajeInvestigado);

            return true;


        } else {

            agente.ganarExperiencia(
                    ACUSAR_SIN_EVIDENCIA
            );

            agente.reducirReputacion(35);
            agente.registrarDecision(false);

            finalIncorrecto();

            return false;
        }
    }


    // =========================
    // FINAL PERFECTO
    // =========================

    private void finalPerfecto(double porcentaje) {

        System.out.println();
        System.out.println("=================================");
        System.out.println("       OPERACIÓN COMPLETADA");
        System.out.println("=================================");

        System.out.println();
        System.out.println("¡Excelente trabajo, agente!");
        System.out.println("El responsable fue identificado.");
        System.out.println();

        System.out.println(
                "Precisión del caso: "
                + (int) porcentaje
                + "%"
        );

        System.out.println(
                "XP actual: "
                + agente.getEXP()
        );

        System.out.println(
                "Rango: "
                + agente.getRango()
        );

        System.out.println(
                "Reputación: "
                + agente.getRep()
        );
    }


    // =========================
    // FINAL PARCIAL
    // =========================

    private void finalParcial(double porcentaje) {

        System.out.println();
        System.out.println("=================================");
        System.out.println("          CASO RESUELTO");
        System.out.println("=================================");

        System.out.println();
        System.out.println(
                "Identificaste al responsable,"
        );

        System.out.println(
                "pero no analizaste toda la evidencia."
        );

        System.out.println();

        System.out.println(
                "Precisión: "
                + (int) porcentaje
                + "%"
        );

        System.out.println(
                "XP actual: "
                + agente.getEXP()
        );
    }


    // =========================
    // FINAL INCORRECTO
    // =========================

    private void finalIncorrecto() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("         OPERACIÓN FALLIDA");
        System.out.println("=================================");

        System.out.println();

        System.out.println(
                "La acusación fue incorrecta."
        );

        System.out.println(
                "El caso continúa en investigación."
        );

        System.out.println();

        System.out.println(
                "XP: "
                + agente.getEXP()
        );

        System.out.println(
                "Reputación: "
                + agente.getRep()
        );
    }


    // =========================
    // LEER NUMERO
    // =========================

    private static int leerEntero(String mensaje) {

        int valor = -1;

        boolean valido = false;

        while (!valido) {

            System.out.print(mensaje);

            String entrada = tc.nextLine().trim();

            try {

                valor = Integer.parseInt(entrada);

                valido = true;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Entrada inválida. Ingrese solo números."
                );
            }
        }

        return valor;
    }
}

