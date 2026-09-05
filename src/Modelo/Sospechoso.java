
package Modelo;


public class Sospechoso {
     // Atributos del sospechoso
    private int id;                  // Identificador del sospechoso
    private String nombre;           // Nombre del sospechoso
    private String profesion;        // Profesión del sospechoso
    private String descripcion;      // Descripción del sospechoso
    private boolean tieneAcceso;     // Indica si tiene acceso al servidor
    private boolean estabaPresente;  // Indica si estaba presente durante el incidente

    // Constructor de la clase
    // Se utiliza para crear un sospechoso con todos sus datos
    public Sospechoso(int id, String nombre, String profesion,
                      String descripcion, boolean tieneAcceso,
                      boolean estabaPresente) {

        // Guardamos los valores recibidos en los atributos
        this.id = id;
        this.nombre = nombre;
        this.profesion = profesion;
        this.descripcion = descripcion;
        this.tieneAcceso = tieneAcceso;
        this.estabaPresente = estabaPresente;
    }

    // =========================
    // MÉTODOS GET
    // =========================

    // Devuelve el ID del sospechoso
    public int getId() {
        return id;
    }

    // Devuelve el nombre del sospechoso
    public String getNombre() {
        return nombre;
    }

    // Devuelve la profesión del sospechoso
    public String getProfesion() {
        return profesion;
    }

    // Devuelve la descripción del sospechoso
    public String getDescripcion() {
        return descripcion;
    }

    // Devuelve si el sospechoso tiene acceso al servidor
    public boolean isTieneAcceso() {
        return tieneAcceso;
    }

    // Devuelve si el sospechoso estaba presente
    public boolean isEstabaPresente() {
        return estabaPresente;
    }

    // =========================
    // MÉTODOS SET
    // =========================

    // Permite cambiar el nombre del sospechoso
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Permite cambiar la profesión del sospechoso
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    // Permite cambiar la descripción del sospechoso
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Permite cambiar si tiene acceso al servidor
    public void setTieneAcceso(boolean tieneAcceso) {
        this.tieneAcceso = tieneAcceso;
    }

    // Permite cambiar si estaba presente durante el incidente
    public void setEstabaPresente(boolean estabaPresente) {
        this.estabaPresente = estabaPresente;
    }

    // =========================
    // MÉTODO PARA MOSTRAR DATOS
    // =========================

    // Muestra toda la información del sospechoso en la consola
    public void mostrarInformacion() {

        // Línea para separar la información
        System.out.println("--------------------------------");

        // Mostrar los datos básicos
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Profesion: " + profesion);
        System.out.println("Descripcion: " + descripcion);

        // Verificar si el sospechoso tiene acceso al servidor
        if (tieneAcceso) {
            System.out.println("Acceso al servidor: SI");
        } else {
            System.out.println("Acceso al servidor: NO");
        }

        // Verificar si el sospechoso estaba presente
        if (estabaPresente) {
            System.out.println("Estaba presente: SI");
        } else {
            System.out.println("Estaba presente: NO");
        }

        // Línea final para separar la información
        System.out.println("--------------------------------");
    }
}
