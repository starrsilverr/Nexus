
package logica;

import Modelo.Caso;
import Modelo.Evidencia;
import Modelo.Sospechoso;

public class Investigacion {

    private Caso caso;
    private int evidenciasAnalizadas;

    public Investigacion(Caso caso) {
        this.caso = caso;
        evidenciasAnalizadas = 0;
    }

    // Analiza una evidencia y la relaciona con un sospechoso
    public void analizarEvidencia(int idEvidencia, int idSospechoso) {

        Evidencia evidencia = caso.buscarEvidencia(idEvidencia);

        if (evidencia == null) {
            System.out.println("No se encontró esa evidencia.");
            return;
        }

        // Verificamos si ya fue analizada
        if (evidencia.isAnalizada()) {
            System.out.println("Esta evidencia ya fue analizada.");
            return;
        }

        // Marcamos la evidencia como analizada
        evidencia.setAnalizada(true);

        // Aumentamos el contador
        evidenciasAnalizadas++;

        System.out.println("\n=================================");
        System.out.println("       ANÁLISIS COMPLETADO");
        System.out.println("=================================");

        // Buscamos el sospechoso seleccionado
        Sospechoso sospechoso = caso.buscarSospechoso(idSospechoso);

        if (sospechoso != null) {

            System.out.println("Evidencia relacionada con: "
                    + sospechoso.getNombre());

            if (evidencia.isRelevante()) {
                System.out.println("La evidencia parece ser RELEVANTE.");
                System.out.println("Valor de la evidencia: "
                        + evidencia.getValor());
            } else {
                System.out.println("La evidencia no parece ser relevante.");
            }

        } else {
            System.out.println("No se encontró el sospechoso.");
        }

        System.out.println("Evidencias analizadas: "
                + evidenciasAnalizadas + "/"
                + caso.getEvidencias().size());
    }

    // Muestra el progreso de la investigación
    public void mostrarProgreso() {

        int total = caso.getEvidencias().size();

        double porcentaje = 0;

        if (total > 0) {
            porcentaje = (evidenciasAnalizadas * 100.0) / total;
        }

        System.out.println("\n=================================");
        System.out.println("     PROGRESO DE INVESTIGACIÓN");
        System.out.println("=================================");
        System.out.println("Evidencias analizadas: "
                + evidenciasAnalizadas + "/" + total);
        System.out.println("Porcentaje investigado: "
                + (int) porcentaje + "%");
    }

    public int getEvidenciasAnalizadas() {
        return evidenciasAnalizadas;
    }
}
