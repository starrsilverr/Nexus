
package Modelo;

import java.util.Scanner;

public class MotorDecisiones {
    //configuración del juego 
    //porcentaje de evidencia
    //puntos de experiencia
    //puntos de experiencia incorecta
    private static final double INVESTIGACION_MINIMA = 60.0;
    private static final int ACUSAR_CORRECTAMENTE = 100;
    private static final int ACUSAR_SIN_EVIDENCIA = -40;

    //variables de estado del juego y del caso actual
    private String[] sospechosos;       
    private String sospechosoCorrecto;  
    private int totalEvidencias;       
    private int evidenciasAnalizadas;   

    //metricas de progreso del jugador
    private int xp = 0;
    private int reputacion = 0;
    private int decisionesCorrectas = 0;
    private int decisionesTotales = 0;

    private static Scanner tc = new Scanner(System.in);
    
    //contructor para iniciar el motor de decisiones con los datos del caso
    public MotorDecisiones(String[] sospechosos, String sospechosoCorrecto,int totalEvidencias, int evidenciasAnalizadas) {
        
        this.sospechosos = sospechosos;
        this.sospechosoCorrecto = sospechosoCorrecto;
        this.totalEvidencias = totalEvidencias;
        this.evidenciasAnalizadas = evidenciasAnalizadas;
    }

    //actualiza la cantidad de evidencia que han sido analizada en el caso 
    public void actualizarEvidenciasAnalizadas(int cantidad) {
        this.evidenciasAnalizadas = cantidad;
    }

    //muestra las opciones de sospechosos en pantalla y procesa la seleccion final del usuario
    public void decisionFinal() {
        System.out.println("          DECISIÓN FINAL      ");
        System.out.println("\nLa evidencia analizada apunta hacia:\n");

        for (int i = 0; i < sospechosos.length; i++) {
            System.out.println("[" + (i + 1) + "] " + sospechosos[i].toUpperCase());
        }

        int opcion = leerEntero("\nIngrese su decisión: ");
        if (opcion < 1 || opcion > sospechosos.length) {
            System.out.println("Opción inválida.");
            return;
        }

        String acusado = sospechosos[opcion - 1];
        procesarAcusacion(acusado);
    }
    
    //evalúa si la acusación es correcta y si la investigación cumple con el porcentaje mínimo requerido
    private void procesarAcusacion(String acusado) {
        //calcula el porcentaje de evidencia analizada respecto al total
        double porcentajeInvestigado = totalEvidencias == 0
                ? 0
                : (evidenciasAnalizadas * 100.0) / totalEvidencias;

        boolean acusacionCorrecta = acusado.equalsIgnoreCase(sospechosoCorrecto);
        boolean investigacionSuficiente = porcentajeInvestigado >= INVESTIGACION_MINIMA;

        decisionesTotales++;

        //determina la ruta del final según el acierto y el nivel de investigación
        if (acusacionCorrecta && investigacionSuficiente) {
            xp += ACUSAR_CORRECTAMENTE;
            reputacion += 10;
            decisionesCorrectas++;
            finalPerfecto();
        } else if (acusacionCorrecta) {
            xp += ACUSAR_CORRECTAMENTE / 2;
            decisionesCorrectas++;
            finalParcial(porcentajeInvestigado);
        } else {
            xp += ACUSAR_SIN_EVIDENCIA;
            if (xp < 0) xp = 0; 
            reputacion -= 35;
            finalIncorrecto();
        }
    }

    //muestra los resultados cuando el caso se resuelve de manera óptima
    private void finalPerfecto() {
        System.out.println("\nOPERACIÓN COMPLETADA\n");
        System.out.println("Precisión: " + (int) calcularPrecision() + "%");
        System.out.println("Evidencias válidas: " + evidenciasAnalizadas + "/" + totalEvidencias);
        System.out.println("Reputación: " + reputacion);
        System.out.println("\nRANGO:");
        System.out.println(obtenerRango(xp));
    }

    //muestra los resultados cuando se acierta al culpable pero faltó investigar más evidencias
    private void finalParcial(double porcentajeInvestigado) {
        System.out.println("\nCASO RESUELTO\n");
        System.out.println("El responsable fue identificado,");
        System.out.println("pero parte de la evidencia fue");
        System.out.println("descartada incorrectamente.\n");
        System.out.println("Precisión: " + (int) porcentajeInvestigado + "%");
    }

    //muestra los resultados cuando la acusación es errónea o carece de sustento
    private void finalIncorrecto() {
        System.out.println("\nOPERACIÓN FALLIDA\n");
        System.out.println("La acusación no estaba respaldada");
        System.out.println("por evidencia suficiente.\n");
        System.out.println("Reputación: " + reputacion);
    }

    //evento o final secreto interactivo opcional basado en la narrativa del juego.
    public void finalSecreto() {
        System.out.println("ALERTA DEL SISTEMA");
        System.out.println("Se detectaron inconsistencias");
        System.out.println("en los expedientes anteriores.\n");
        System.out.println("Código de acceso:\n");
        System.out.println("NEXUS-07\n");

        int opcion = leerEntero("¿Desea abrir expediente clasificado?\n[1] SI\n[2] NO\nOpción: ");
        if (opcion == 1) {
            System.out.println("\nPROTOCOLO NEXUS ACTIVADO\n");
            System.out.println("Has descubierto que las investigaciones");
            System.out.println("anteriores fueron manipuladas.\n");
            System.out.println("NEXUS-07 NO ERA UN CÓDIGO.\n");
            System.out.println("ERA UNA IDENTIDAD.");
        }
    }
    
    //calcula el porcentaje global de precisión del jugador en base a sus decisiones
    private double calcularPrecision() {
        if (decisionesTotales == 0) return 0;
        return (decisionesCorrectas * 100.0) / decisionesTotales;
    }

    //retorna el rango militar o profesional del jugador según la experiencia acumulada
    private String obtenerRango(int xp) {
        if (xp < 500) return "RECLUTA";
        if (xp < 1000) return "ANALISTA";
        if (xp < 1500) return "INVESTIGADOR";
        if (xp < 2500) return "AGENTE";
        if (xp < 4000) return "AGENTE SENIOR";
        return "JEFE DE OPERACIONES";
    }

    //valida de manera segura la entrada por consola para asegurar que sea un número entero
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
                System.out.println("Entrada inválida. Ingrese solo números.");
            }
        }
        return valor;
    }

    //método principal para ejecutar y probar una instancia rápida del motor.
    public static void main(String[] args) {
        String[] sospechosos = {"Alex", "Diana", "Marco", "Elena"};

        //inicializa el motor con los sospechosos, el culpable "Alex", 5 evidencias totales y 3 analizadas
        MotorDecisiones motor = new MotorDecisiones(sospechosos, "Alex", 5, 3);

        motor.decisionFinal();
    }
}


