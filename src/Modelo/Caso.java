package Modelo;
// Importamos ArrayList para poder guardar varios sospechosos
// y varias evidencias dentro de un caso.
import java.util.ArrayList;
import logica.Puntuacion;
import Modelo.Sospechoso;

public class Caso {
// Clase que representa un caso de investigación
    // =========================
    // ATRIBUTOS DEL CASO
    // =========================

    // Identificador numérico del caso
    private int id;

    // Código que identifica al caso
    private String codigo;

    // Nombre o título del caso
    private String titulo;

    // Descripción de lo ocurrido en el caso
    private String descripcion;

    // Lista donde se guardan los sospechosos del caso
    private ArrayList<Sospechoso> sospechosos;

    // Lista donde se guardan las evidencias del caso
    private ArrayList<Evidencia> evidencias;

    // Indica si el caso ya fue resuelto
    // true = resuelto
    // false = no resuelto
    private boolean resuelto;


    // =========================
    // CONSTRUCTOR
    // =========================

    // Constructor que permite crear un caso
    // recibiendo sus datos principales.
    public Caso(int id, String codigo, String titulo, String descripcion) {

        // Guardamos los valores recibidos en los atributos
        this.id = id;
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;

        // Creamos una lista vacía para almacenar sospechosos
        sospechosos = new ArrayList<>();

        // Creamos una lista vacía para almacenar evidencias
        evidencias = new ArrayList<>();

        // Al crear un caso, inicialmente no está resuelto
        resuelto = false;
    }


    // =========================
    // AGREGAR SOSPECHOSO
    // =========================

    // Este método permite agregar un sospechoso
    // a la lista de sospechosos del caso.
    public void agregarSospechoso(Sospechoso sospechoso) {

        // Añadimos el sospechoso a la lista
        sospechosos.add(sospechoso);
    }


    // =========================
    // AGREGAR EVIDENCIA
    // =========================

    // Este método permite agregar una evidencia
    // a la lista de evidencias del caso.
    public void agregarEvidencia(Evidencia evidencia) {

        // Añadimos la evidencia a la lista
        evidencias.add(evidencia);
    }


    // =========================
    // MOSTRAR INFORMACIÓN
    // =========================

    // Este método muestra la información principal
    // del caso en la consola.
    public void mostrarInformacion() {

        // Líneas decorativas para organizar la información
        System.out.println("=================================");
        System.out.println("          EXPEDIENTE");
        System.out.println("=================================");

        // Mostramos los datos del caso
        System.out.println("ID: " + id);
        System.out.println("Codigo: " + codigo);
        System.out.println("Titulo: " + titulo);
        System.out.println("Descripcion: " + descripcion);

        // Comprobamos si el caso está resuelto
        if (resuelto) {
            System.out.println("Estado: RESUELTO");
        } else {
            System.out.println("Estado: EN INVESTIGACION");
        }

        // Línea final para separar la información
        System.out.println("=================================");
    }


    // =========================
    // MOSTRAR SOSPECHOSOS
    // =========================

    // Este método muestra todos los sospechosos
    // que están relacionados con el caso.
    public void mostrarSospechosos() {

        System.out.println("=================================");
        System.out.println("          SOSPECHOSOS");
        System.out.println("=================================");

        // Recorremos uno por uno todos los sospechosos
        // que están guardados en la lista.
        for (Sospechoso sospechoso : sospechosos) {

            // Llamamos al método mostrarInformacion()
            // de cada sospechoso para mostrar sus datos.
            sospechoso.mostrarInformacion();
        }
    }


    // =========================
    // BUSCAR SOSPECHOSO
    // =========================

    // Este método busca un sospechoso utilizando su ID.
    public Sospechoso buscarSospechoso(int id) {

        // Recorremos la lista de sospechosos
        for (Sospechoso sospechoso : sospechosos) {

            // Comparamos el ID que estamos buscando
            // con el ID de cada sospechoso.
            if (sospechoso.getId() == id) {

                // Si encontramos el ID, devolvemos ese sospechoso
                return sospechoso;
            }
        }

        // Si no encontramos ningún sospechoso con ese ID,
        // devolvemos null.
        return null;
    }


    // =========================
    // RESOLVER CASO
    // =========================

    // Este método cambia el estado del caso a resuelto.
    public void resolverCaso() {

        // Cambiamos resuelto de false a true
        resuelto = true;
    }


    // =========================
    // MÉTODOS GET
    // =========================

    // Devuelve el ID del caso
    public int getId() {
        return id;
    }

    // Devuelve el código del caso
    public String getCodigo() {
        return codigo;
    }

    // Devuelve el título del caso
    public String getTitulo() {
        return titulo;
    }

    // Devuelve la descripción del caso
    public String getDescripcion() {
        return descripcion;
    }

    // Devuelve la lista de sospechosos
    public ArrayList<Sospechoso> getSospechosos() {
        return sospechosos;
    }

    // Devuelve la lista de evidencias
    public ArrayList<Evidencia> getEvidencias() {
        return evidencias;
    }

    // Devuelve si el caso está resuelto o no
    public boolean isResuelto() {
        return resuelto;
    }
}

