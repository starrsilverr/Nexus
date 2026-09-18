
package Modelo;

import java.util.ArrayList;

public class Caso {

    // =========================
    // ATRIBUTOS
    // =========================

    private int id;
    private String codigo;
    private String titulo;
    private String descripcion;

    private ArrayList<Sospechoso> sospechosos;
    private ArrayList<Evidencia> evidencias;

    private boolean resuelto;

    // Nombre del sospechoso correcto
    private String sospechosoCorrecto;


    // =========================
    // CONSTRUCTOR
    // =========================

    public Caso(int id, String codigo, String titulo, String descripcion) {

        this.id = id;
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;

        sospechosos = new ArrayList<>();
        evidencias = new ArrayList<>();

        resuelto = false;

        sospechosoCorrecto = "";
    }


    // =========================
    // AGREGAR SOSPECHOSO
    // =========================

    public void agregarSospechoso(Sospechoso sospechoso) {

        sospechosos.add(sospechoso);
    }


    // =========================
    // AGREGAR EVIDENCIA
    // =========================

    public void agregarEvidencia(Evidencia evidencia) {

        evidencias.add(evidencia);
    }


    // =========================
    // MOSTRAR INFORMACION
    // =========================

    public void mostrarInformacion() {

        System.out.println("=================================");
        System.out.println("          EXPEDIENTE");
        System.out.println("=================================");

        System.out.println("ID: " + id);
        System.out.println("Codigo: " + codigo);
        System.out.println("Titulo: " + titulo);
        System.out.println("Descripcion: " + descripcion);

        if (resuelto) {

            System.out.println("Estado: RESUELTO");

        } else {

            System.out.println("Estado: EN INVESTIGACION");
        }

        System.out.println("=================================");
    }


    // =========================
    // MOSTRAR SOSPECHOSOS
    // =========================

    public void mostrarSospechosos() {

        System.out.println("=================================");
        System.out.println("          SOSPECHOSOS");
        System.out.println("=================================");

        for (Sospechoso sospechoso : sospechosos) {

            sospechoso.mostrarInformacion();
        }
    }


    // =========================
    // BUSCAR SOSPECHOSO
    // =========================

    public Sospechoso buscarSospechoso(int id) {

        for (Sospechoso sospechoso : sospechosos) {

            if (sospechoso.getId() == id) {

                return sospechoso;
            }
        }

        return null;
    }


    // =========================
    // BUSCAR EVIDENCIA
    // =========================

    public Evidencia buscarEvidencia(int idEvidencia) {

        for (Evidencia evidencia : evidencias) {

            if (evidencia.getId() == idEvidencia) {

                return evidencia;
            }
        }

        return null;
    }


    // =========================
    // RESOLVER CASO
    // =========================

    public void resolverCaso() {

        resuelto = true;
    }


    // =========================
    // SOSPECHOSO CORRECTO
    // =========================

    public void setSospechosoCorrecto(String sospechosoCorrecto) {

        this.sospechosoCorrecto = sospechosoCorrecto;
    }

    public String getSospechosoCorrecto() {

        return sospechosoCorrecto;
    }


    // =========================
    // GETTERS
    // =========================

    public int getId() {

        return id;
    }

    public String getCodigo() {

        return codigo;
    }

    public String getTitulo() {

        return titulo;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public ArrayList<Sospechoso> getSospechosos() {

        return sospechosos;
    }

    public ArrayList<Evidencia> getEvidencias() {

        return evidencias;
    }

    public boolean isResuelto() {

        return resuelto;
    }
}