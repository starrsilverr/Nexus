
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

        puntosSospechoso1 = 0;
        puntosSospechoso2 = 0;
        evidenciasAnalizadas = 0;
    }

    public void analizarEvidencia(int idEvidencia, int idSospechoso) {

        Evidencia evidencia = caso.buscarEvidencia(idEvidencia);

        if (evidencia != null) {

            if (evidencia.isAnalizada() == false) {

                evidencia.setAnalizada(true);

                evidenciasAnalizadas++;

                if (evidencia.isRelevante()) {

                    if (idSospechoso == 1) {
                        puntosSospechoso1 = puntosSospechoso1 + evidencia.getValor();
                    }

                    if (idSospechoso == 2) {
                        puntosSospechoso2 = puntosSospechoso2 + evidencia.getValor();
                    }
                }
            }
        }
    }

    public void mostrarPuntos(int idSospechoso) {

        if (idSospechoso == 1) {
            System.out.println("Puntos del sospechoso 1: " + puntosSospechoso1);
        }

        if (idSospechoso == 2) {
            System.out.println("Puntos del sospechoso 2: " + puntosSospechoso2);
        }
    }

    public void mostrarEvidenciasAnalizadas() {

        System.out.println("Evidencias analizadas: " + evidenciasAnalizadas);
    }

    public void mostrarSospechosoMasProbable() {

        if (puntosSospechoso1 > puntosSospechoso2) {

            System.out.println("El sospechoso 1 tiene más puntos.");

        } else if (puntosSospechoso2 > puntosSospechoso1) {

            System.out.println("El sospechoso 2 tiene más puntos.");

        } else {

            System.out.println("Los dos sospechosos tienen los mismos puntos.");
        }
    }
}
