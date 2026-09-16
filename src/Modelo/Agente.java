package Modelo;


public class Agente {

    // LISTA DE RANGOS POSIBLES
    // Van de menor a mayor en este orden. Se guardan en un arreglo para
    // poder comparar cuál va antes que cuál (por ejemplo, para saber si
    // un cambio de rango fue un ascenso o un descenso).
    private static final String[] RANGOS = {
        "RECLUTA", "ANALISTA", "INVESTIGADOR", "AGENTE", "AGENTE SENIOR", "JEFE DE OPERACIONES"
    };

    // LÍMITES DEL SISTEMA
    private static final int MIN_ESTADO = 0;
    private static final int MAX_ESTADO = 100; // energia, estres y rep van de 0 a 100

    // ATRIBUTOS
    private String nombre;
    private String codigo;
    private String rango;
    private int EXP;
    private int rep;
    private double precision;
    private int energia;
    private int estres;

    // Para poder calcular la precisión real del agente (aciertos / decisiones totales)
    private int decisionesCorrectas;
    private int decisionesTotales;

    // CONSTRUCTORES
    public Agente(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.rango = "RECLUTA";
        this.EXP = 0;
        this.rep = 50; // reputación neutral al iniciar
        this.precision = 0.0;
        this.energia = 100;   // llega con toda la energía
        this.estres = 0;      // sin estrés acumulado
        this.decisionesCorrectas = 0;
        this.decisionesTotales = 0;
    }

    /**
     * Constructor parametrizado: se usa para reconstruir un agente que ya
     * tenía progreso (por ejemplo, si en el futuro se carga una partida
     * guardada). Aquí sí se reciben todos los valores.
     */
    public Agente(String nombre, String codigo, int EXP, int rep,
                  int energia, int estres, int decisionesCorrectas, int decisionesTotales) {

        this.nombre = nombre;
        this.codigo = codigo;
        this.EXP = Math.max(EXP, 0);
        this.rep = limitar(rep);
        this.energia = limitar(energia);
        this.estres = limitar(estres);
        this.decisionesCorrectas = Math.max(decisionesCorrectas, 0);
        this.decisionesTotales = Math.max(decisionesTotales, 0);

        this.rango = calcularRangoPorXP(this.EXP);
        recalcularPrecision();
    }


    // PROGRESO DEL AGENTE

    /**
     * Suma (o resta) EXP y revisa si el agente sube de rango.
     * Este método lo llama Puntuacion cada vez que ocurre una acción
     * que otorga o quita XP.
     */
    public void ganarExperiencia(int cantidad) {
        EXP += cantidad;
        if (EXP < 0) {
            EXP = 0;
        }
        actualizarRango();
    }

    // Revisa si con el XP actual corresponde un rango distinto al que tiene.
    // Si subió, muestra el cartel de ascenso.
    private void actualizarRango() {
        String nuevoRango = calcularRangoPorXP(EXP);
        if (!nuevoRango.equals(rango)) {
            String rangoAnterior = rango;
            rango = nuevoRango;
            // Solo celebramos el ascenso, no el descenso (por si el XP baja)
            if (posicionDelRango(nuevoRango) > posicionDelRango(rangoAnterior)) {
                mostrarAscenso(rangoAnterior, nuevoRango);
            }
        }
    }

    // Busca en el arreglo RANGOS en qué posición está un rango, para poder
    // comparar cuál va "más adelante" que otro (0 = RECLUTA, 5 = el más alto).
    private int posicionDelRango(String nombreRango) {
        for (int i = 0; i < RANGOS.length; i++) {
            if (RANGOS[i].equals(nombreRango)) {
                return i;
            }
        }
        return 0;
    }

    // Traduce una cantidad de XP al rango que le corresponde.
    // Se usa tanto al crear un agente como al actualizarlo.
    public static String calcularRangoPorXP(int xp) {
        if (xp < 500)   return "RECLUTA";
        if (xp < 1000)  return "ANALISTA";
        if (xp < 1500)  return "INVESTIGADOR";
        if (xp < 2500)  return "AGENTE";
        if (xp < 4000)  return "AGENTE SENIOR";
        return "JEFE DE OPERACIONES";
    }

    private void mostrarAscenso(String anterior, String nuevo) {

        System.out.println("        ASCENSO AUTORIZADO         ");
        System.out.println("  " + anterior + "  ->  " + nuevo);
        System.out.println("  XP actual: " + EXP);
    }

    /**
     * Registra si una decisión (por ejemplo, una acusación) fue correcta
     * o no, y recalcula la precisión del agente con esos datos.
     */
    public void registrarDecision(boolean correcta) {
        decisionesTotales++;
        if (correcta) {
            decisionesCorrectas++;
        }
        recalcularPrecision();
    }

    private void recalcularPrecision() {
        if (decisionesTotales == 0) {
            precision = 0.0;
        } else {
            precision = (decisionesCorrectas * 100.0) / decisionesTotales;
        }
    }

    // AJUSTES DE ESTADO (con límites 0-100)
    public void aumentarReputacion(int cantidad) {
        rep = limitar(rep + cantidad);
    }

    public void reducirReputacion(int cantidad) {
        rep = limitar(rep - cantidad);
    }

    public void aumentarEnergia(int cantidad) {
        energia = limitar(energia + cantidad);
    }

    public void reducirEnergia(int cantidad) {
        energia = limitar(energia - cantidad);
    }

    public void aumentarEstres(int cantidad) {
        estres = limitar(estres + cantidad);
    }

    public void reducirEstres(int cantidad) {
        estres = limitar(estres - cantidad);
    }

    // Evita que energia, estres o rep salgan del rango 0-100
    private int limitar(int valor) {
        if (valor < MIN_ESTADO) return MIN_ESTADO;
        if (valor > MAX_ESTADO) return MAX_ESTADO;
        return valor;
    }

    // MOSTRAR INFORMACIÓN
    public void mostrarPerfil() {

        System.out.println("          PERFIL DEL AGENTE      ");
        System.out.println(" Nombre: " + nombre);
        System.out.println(" Código: " + codigo);
        System.out.println(" Rango: " + rango);
        System.out.println(" XP: " + EXP);
        System.out.println(" Reputación: " + rep);
        System.out.println(" Precisión: " + (int) precision + "%");
        System.out.println(" Energía: " + energia);
        System.out.println(" Estrés: " + estres);

    }

    public void mostrarDatos() {
        System.out.println("Nombre : " + nombre);
        System.out.println("Codigo : " + codigo);
        System.out.println("Rango : " + rango);
        System.out.println("EXP : " + EXP);
        System.out.println("Reputacion : " + rep);
        System.out.println("Energia : " + energia);
        System.out.println("Estres : " + estres);
        System.out.println("Precision : " + (int) precision + "%");
    }

    // GETTERS
    public String getNombre() { return nombre; }
    public String getCodigo() { return codigo; }
    public String getRango() { return rango; }
    public int getEXP() { return EXP; }
    public int getRep() { return rep; }
    public double getPrecision() { return precision; }
    public int getEnergia() { return energia; }
    public int getEstres() { return estres; }
    public int getDecisionesCorrectas() { return decisionesCorrectas; }
    public int getDecisionesTotales() { return decisionesTotales; }

    // SETTERS (con validación)
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del agente no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código del agente no puede estar vacío.");
        }
        this.codigo = codigo;
    }
}