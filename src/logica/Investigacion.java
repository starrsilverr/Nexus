
package logica;

import Modelo.Caso;
import Modelo.Evidencia;
import Modelo.Sospechoso;

public class Investigacion {

    private Caso caso;
    private int puntosSospechoso1;
    private int puntosSospechoso2;
    private int evidenciasAnalizadas;

    public Investigacion(Caso caso) {

        this.caso = caso;

        // Se inicializan los puntos y el contador de evidencias en 0.
        puntosSospechoso1 = 0;
        puntosSospechoso2 = 0;
        evidenciasAnalizadas = 0;
    }

    public void analizarEvidencia(int idEvidencia, int idSospechoso) {

        // Se busca la evidencia usando su ID.
        Evidencia evidencia = caso.buscarEvidencia(idEvidencia);

        if (evidencia != null) {

            // Se verifica que la evidencia todavía no haya sido analizada.
            if (evidencia.isAnalizada() == false) {

                evidencia.setAnalizada(true);

                // Se aumenta el contador de evidencias analizadas.
                evidenciasAnalizadas++;

                if (evidencia.isRelevante()) {

                    // Si pertenece al sospechoso 1, se suman los puntos de la evidencia.
                    if (idSospechoso == 1) {
                        puntosSospechoso1 = puntosSospechoso1 + evidencia.getValor();
                    }

                    // Si pertenece al sospechoso 2, se suman los puntos de la evidencia.
                    if (idSospechoso == 2) {
                        puntosSospechoso2 = puntosSospechoso2 + evidencia.getValor();
                    }
                }
            }
        }
    }

    public void mostrarPuntos(int idSospechoso) {

        // Muestra los puntos acumulados del sospechoso seleccionado.
        if (idSospechoso == 1) {
            System.out.println("Puntos del sospechoso 1: " + puntosSospechoso1);
        }

        if (idSospechoso == 2) {
            System.out.println("Puntos del sospechoso 2: " + puntosSospechoso2);
        }
    }

    public void mostrarEvidenciasAnalizadas() {

        // Muestra cuántas evidencias han sido analizadas.
        System.out.println("Evidencias analizadas: " + evidenciasAnalizadas);
    }

    public void mostrarSospechosoMasProbable() {

        // Compara los puntos para determinar qué sospechoso tiene mayor probabilidad.
        if (puntosSospechoso1 > puntosSospechoso2) {

            System.out.println("El sospechoso 1 tiene más puntos.");

        } else if (puntosSospechoso2 > puntosSospechoso1) {

            System.out.println("El sospechoso 2 tiene más puntos.");

        } else {

            // Si los puntos son iguales, se indica que hay un empate.
            System.out.println("Los dos sospechosos tienen los mismos puntos.");
        }
    }
}