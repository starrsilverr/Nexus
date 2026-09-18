
package Modelo;

public class Evidencia {

    private int id;
    private String tipo;
    private String descripcion;
    private String ubicacion;
    private boolean analizada;
    private boolean relevante;
    private int valor;

    public Evidencia(int id, String tipo, String descripcion, String ubicacion,
                     boolean analizada, boolean relevante, int valor) {

        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.analizada = analizada;
        this.relevante = relevante;
        this.valor = valor;
    }

    public void mostrarEvidencia() {

        System.out.println("ID: " + id);
        System.out.println("Tipo: " + tipo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Ubicacion: " + ubicacion);
        System.out.println("Analizada: " + analizada);
        System.out.println("Relevante: " + relevante);
        System.out.println("Valor: " + valor);
    }

    public void analizar() {
        analizada = true;
    }

    public void cambiarRelevancia(boolean nuevaRelevancia) {
        relevante = nuevaRelevancia;
    }

    public void cambiarValor(int nuevoValor) {
        valor = nuevoValor;
    }

    public boolean isAnalizada() {
    return analizada;
    }

    public int getValor() {
    return valor;
    }

    public boolean isRelevante() {
    return relevante;
    }

    public void setAnalizada(boolean b) {
    analizada = b;
    }
    
    public int getId(){
    return id;
    }
}
    