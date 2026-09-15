package logica;

import Modelo.Agente;


public class Puntuacion {


    // TABLA DE PUNTOS
    public static final int ANALIZAR_EVIDENCIA_RELEVANTE = 10;
    public static final int RELACIONAR_CORRECTAMENTE = 15;
    public static final int ENCONTRAR_PISTA_ESPECIAL = 20;
    public static final int ACUSAR_CORRECTAMENTE = 100;
    public static final int ACUSAR_SIN_EVIDENCIA = -40;
    public static final int ARCHIVAR_EVIDENCIA_IMPORTANTE = -15;
    public static final int COSTO_SOLICITAR_ANALISIS = 5; // se descuenta de energía, no de XP

    // Cambios de reputación asociados a decisiones finales
    private static final int REPUTACION_POR_ACUSAR_BIEN = 10;
    private static final int REPUTACION_POR_ACUSAR_MAL = 35;

    // ACCIONES DURANTE LA INVESTIGACIÓN
    public void analizarEvidenciaRelevante(Agente agente) {
        agente.ganarExperiencia(ANALIZAR_EVIDENCIA_RELEVANTE);
    }

    public void relacionarCorrectamente(Agente agente) {
        agente.ganarExperiencia(RELACIONAR_CORRECTAMENTE);
    }

    public void encontrarPistaEspecial(Agente agente) {
        agente.ganarExperiencia(ENCONTRAR_PISTA_ESPECIAL);
    }

    public void archivarEvidenciaImportante(Agente agente) {
        // Archivar una evidencia que sí importaba es un error, por eso resta.
        agente.ganarExperiencia(ARCHIVAR_EVIDENCIA_IMPORTANTE);
    }

    // Pedir un análisis no cuesta XP, cuesta energía del agente.
    public void solicitarAnalisis(Agente agente) {
        agente.reducirEnergia(COSTO_SOLICITAR_ANALISIS);
    }

    // DECISIÓN FINAL (acusación)
    public void acusarCorrectamente(Agente agente) {
        agente.ganarExperiencia(ACUSAR_CORRECTAMENTE);
        agente.aumentarReputacion(REPUTACION_POR_ACUSAR_BIEN);
        agente.registrarDecision(true);
    }

    public void acusarSinEvidencia(Agente agente) {
        agente.ganarExperiencia(ACUSAR_SIN_EVIDENCIA);
        agente.reducirReputacion(REPUTACION_POR_ACUSAR_MAL);
        agente.registrarDecision(false);
    }

    // FIN DE CASO
    // El XP que da completar un caso varía según el caso, por eso se recibe como parámetro.
    public void completarCaso(Agente agente, int xpDelCaso) {
        agente.ganarExperiencia(xpDelCaso);
    }


    // CONSULTA DE PRECISIÓN
    // La precisión real ya la calcula y guarda el propio Agente
    // (decisiones correctas / decisiones totales x 100); este método
    // es solo un acceso directo desde la lógica de puntuación.
    public double calcularPrecision(Agente agente) {
        return agente.getPrecision();
    }


    // UTILIDAD: mostrar la tabla de reglas
    public void mostrarReglas() {
        System.out.println("=== SISTEMA DE PUNTUACIÓN ===");
        System.out.println("Analizar evidencia relevante   : +" + ANALIZAR_EVIDENCIA_RELEVANTE + " XP");
        System.out.println("Relacionar correctamente       : +" + RELACIONAR_CORRECTAMENTE + " XP");
        System.out.println("Encontrar pista especial       : +" + ENCONTRAR_PISTA_ESPECIAL + " XP");
        System.out.println("Acusar correctamente           : +" + ACUSAR_CORRECTAMENTE + " XP");
        System.out.println("Acusar sin evidencia            : " + ACUSAR_SIN_EVIDENCIA + " XP");
        System.out.println("Archivar evidencia importante   : " + ARCHIVAR_EVIDENCIA_IMPORTANTE + " XP");
        System.out.println("Solicitar análisis              : -" + COSTO_SOLICITAR_ANALISIS + " energía");
        System.out.println("Completar caso                  : +XP (según el caso)");
    }
}