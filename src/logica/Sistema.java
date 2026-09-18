package logica;

import Modelo.Agente;
import Modelo.Caso;
import Modelo.Evidencia;
import Modelo.Sospechoso;
import Util.Utilidades;

import java.util.ArrayList;

public class Sistema {

    private Agente agente;
    private ArrayList<Caso> casos;
    private Caso casoActual;
    private Investigacion investigacion;
    private int casoDesbloqueado;

    public Sistema() {

        agente = new Agente("Agente", "NX-001");

        casos = new ArrayList<>();

        casoDesbloqueado = 1;

        cargarCasos();

        casoActual = casos.get(0);

        investigacion = new Investigacion(casoActual);
    }

    // =====================================================
    // CARGAR LOS 5 CASOS
    // =====================================================

    private void cargarCasos() {

        // =================================================
        // CASO 1
        // =================================================

        Caso caso1 = new Caso(
                1,
                "CASO-001",
                "LA SEÑAL",
                "Alguien accedió ilegalmente al servidor."
        );

        caso1.setSospechosoCorrecto("Alex");

        caso1.agregarSospechoso(
                new Sospechoso(
                        1,
                        "Alex",
                        "Ingeniero de sistemas",
                        "Tiene conocimientos técnicos y acceso al servidor.",
                        true,
                        true
                )
        );

        caso1.agregarSospechoso(
                new Sospechoso(
                        2,
                        "Diana",
                        "Administradora",
                        "Tiene acceso administrativo al sistema.",
                        true,
                        true
                )
        );

        caso1.agregarSospechoso(
                new Sospechoso(
                        3,
                        "Marco",
                        "Guardia de seguridad",
                        "Estaba encargado de vigilar el edificio.",
                        false,
                        true
                )
        );

        caso1.agregarEvidencia(
                new Evidencia(
                        1,
                        "Huella digital",
                        "Huella encontrada en el servidor.",
                        "Sala de servidores",
                        false,
                        true,
                        30
                )
        );

        caso1.agregarEvidencia(
                new Evidencia(
                        2,
                        "Registro digital",
                        "Se detectó un acceso desde una computadora autorizada.",
                        "Servidor principal",
                        false,
                        true,
                        25
                )
        );

        caso1.agregarEvidencia(
                new Evidencia(
                        3,
                        "Cámara",
                        "La cámara muestra movimiento durante la noche.",
                        "Pasillo principal",
                        false,
                        false,
                        10
                )
        );

        casos.add(caso1);


        // =================================================
        // CASO 2
        // =================================================

        Caso caso2 = new Caso(
                2,
                "CASO-002",
                "EL ARCHIVO DESAPARECIDO",
                "Un archivo confidencial desapareció de la oficina."
        );

        caso2.setSospechosoCorrecto("Sofia");

        caso2.agregarSospechoso(
                new Sospechoso(
                        1,
                        "Sofia",
                        "Analista de datos",
                        "Trabajaba directamente con los archivos.",
                        true,
                        true
                )
        );

        caso2.agregarSospechoso(
                new Sospechoso(
                        2,
                        "Luis",
                        "Técnico",
                        "Realizaba mantenimiento de computadoras.",
                        true,
                        false
                )
        );

        caso2.agregarSospechoso(
                new Sospechoso(
                        3,
                        "Elena",
                        "Secretaria",
                        "Tenía acceso a documentos administrativos.",
                        true,
                        true
                )
        );

        caso2.agregarEvidencia(
                new Evidencia(
                        4,
                        "Memoria USB",
                        "Se encontró una memoria conectada al equipo.",
                        "Oficina principal",
                        false,
                        true,
                        30
                )
        );

        caso2.agregarEvidencia(
                new Evidencia(
                        5,
                        "Registro",
                        "El sistema registra una descarga del archivo.",
                        "Computadora principal",
                        false,
                        true,
                        25
                )
        );

        caso2.agregarEvidencia(
                new Evidencia(
                        6,
                        "Cámara",
                        "Una persona pasó por el pasillo.",
                        "Pasillo",
                        false,
                        false,
                        10
                )
        );

        casos.add(caso2);


        // =================================================
        // CASO 3
        // =================================================

        Caso caso3 = new Caso(
                3,
                "CASO-003",
                "LA CUENTA BLOQUEADA",
                "Una cuenta importante fue bloqueada después de varios intentos."
        );

        caso3.setSospechosoCorrecto("Carlos");

        caso3.agregarSospechoso(
                new Sospechoso(
                        1,
                        "Carlos",
                        "Administrador de red",
                        "Conoce los sistemas de seguridad.",
                        true,
                        true
                )
        );

        caso3.agregarSospechoso(
                new Sospechoso(
                        2,
                        "Andrea",
                        "Diseñadora",
                        "Utiliza el sistema pero no administra cuentas.",
                        false,
                        true
                )
        );

        caso3.agregarSospechoso(
                new Sospechoso(
                        3,
                        "Roberto",
                        "Supervisor",
                        "Tiene autorización para revisar cuentas.",
                        true,
                        false
                )
        );

        caso3.agregarEvidencia(
                new Evidencia(
                        7,
                        "Dirección IP",
                        "Los intentos provienen de una computadora interna.",
                        "Servidor",
                        false,
                        true,
                        30
                )
        );

        caso3.agregarEvidencia(
                new Evidencia(
                        8,
                        "Registro de acceso",
                        "Se detectaron varios intentos consecutivos.",
                        "Sistema de seguridad",
                        false,
                        true,
                        25
                )
        );

        caso3.agregarEvidencia(
                new Evidencia(
                        9,
                        "Correo",
                        "Se encontró un correo relacionado con el incidente.",
                        "Bandeja de entrada",
                        false,
                        false,
                        10
                )
        );

        casos.add(caso3);


        // =================================================
        // CASO 4
        // =================================================

        Caso caso4 = new Caso(
                4,
                "CASO-004",
                "LA INFORMACIÓN FILTRADA",
                "Información interna fue enviada fuera de la organización."
        );

        caso4.setSospechosoCorrecto("Valeria");

        caso4.agregarSospechoso(
                new Sospechoso(
                        1,
                        "Valeria",
                        "Analista",
                        "Tenía acceso a información confidencial.",
                        true,
                        true
                )
        );

        caso4.agregarSospechoso(
                new Sospechoso(
                        2,
                        "Miguel",
                        "Técnico",
                        "Daba mantenimiento a los equipos.",
                        true,
                        false
                )
        );

        caso4.agregarSospechoso(
                new Sospechoso(
                        3,
                        "Natalia",
                        "Recepcionista",
                        "Tenía acceso limitado a las instalaciones.",
                        false,
                        true
                )
        );

        caso4.agregarEvidencia(
                new Evidencia(
                        10,
                        "Correo electrónico",
                        "Se encontró un mensaje enviado a una dirección externa.",
                        "Servidor de correo",
                        false,
                        true,
                        30
                )
        );

        caso4.agregarEvidencia(
                new Evidencia(
                        11,
                        "Documento",
                        "El documento filtrado estaba en una computadora específica.",
                        "Oficina",
                        false,
                        true,
                        25
                )
        );

        caso4.agregarEvidencia(
                new Evidencia(
                        12,
                        "Cámara",
                        "Se observa una persona entrando a la oficina.",
                        "Entrada",
                        false,
                        false,
                        10
                )
        );

        casos.add(caso4);


        // =================================================
        // CASO 5
        // =================================================

        Caso caso5 = new Caso(
                5,
                "CASO-005",
                "NEXUS-07",
                "Una serie de investigaciones parece estar conectada."
        );

        caso5.setSospechosoCorrecto("Elena");

        caso5.agregarSospechoso(
                new Sospechoso(
                        1,
                        "Elena",
                        "Especialista en seguridad",
                        "Conoce información sobre los casos anteriores.",
                        true,
                        true
                )
        );

        caso5.agregarSospechoso(
                new Sospechoso(
                        2,
                        "Daniel",
                        "Programador",
                        "Tiene conocimientos avanzados del sistema.",
                        true,
                        true
                )
        );

        caso5.agregarSospechoso(
                new Sospechoso(
                        3,
                        "Laura",
                        "Investigadora",
                        "Ha trabajado con los expedientes anteriores.",
                        true,
                        false
                )
        );

        caso5.agregarEvidencia(
                new Evidencia(
                        13,
                        "Código",
                        "Aparece nuevamente el código NEXUS-07.",
                        "Servidor central",
                        false,
                        true,
                        30
                )
        );

        caso5.agregarEvidencia(
                new Evidencia(
                        14,
                        "Expediente",
                        "Los casos anteriores tienen información relacionada.",
                        "Archivo central",
                        false,
                        true,
                        25
                )
        );

        caso5.agregarEvidencia(
                new Evidencia(
                        15,
                        "Mensaje oculto",
                        "Se encontró un mensaje relacionado con la identidad NEXUS-07.",
                        "Sistema",
                        false,
                        true,
                        35
                )
        );

        casos.add(caso5);
    }


    // =====================================================
    // INICIAR OPERACIÓN
    // =====================================================

    public void iniciarOperacion() {

        boolean continuar = true;

        while (continuar && !casoActual.isResuelto()) {

            System.out.println("\n=================================");
            System.out.println("       INICIAR OPERACIÓN");
            System.out.println("=================================");

            casoActual.mostrarInformacion();

            System.out.println("\n1. Ver sospechosos");
            System.out.println("2. Ver evidencias");
            System.out.println("3. Analizar evidencia");
            System.out.println("4. Ver progreso");
            System.out.println("5. Acusación final");
            System.out.println("6. Salir del caso");

            int opcion = Utilidades.leerEntero("\nSeleccione una opción: ");

            switch (opcion) {

                case 1:
                    mostrarSospechosos();
                    break;

                case 2:
                    mostrarEvidencias();
                    break;

                case 3:
                    analizarEvidencia();
                    break;

                case 4:
                    investigacion.mostrarProgreso();
                    Utilidades.pausar();
                    break;

                case 5:
                    realizarAcusacion();
                    break;

                case 6:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida.");
                    Utilidades.pausar();
            }
        }
    }


    // =====================================================
    // MOSTRAR SOSPECHOSOS
    // =====================================================

    private void mostrarSospechosos() {

        System.out.println("\n=================================");
        System.out.println("          SOSPECHOSOS");
        System.out.println("=================================");

        ArrayList<Sospechoso> lista = casoActual.getSospechosos();

        for (int i = 0; i < lista.size(); i++) {

            Sospechoso s = lista.get(i);

            System.out.println("\n[" + (i + 1) + "] " + s.getNombre());

            System.out.println("Profesión: " + s.getProfesion());

            System.out.println("Descripción: "
                    + s.getDescripcion());

            System.out.println("Tiene acceso: "
                    + (s.isTieneAcceso() ? "SI" : "NO"));

            System.out.println("Estaba presente: "
                    + (s.isEstabaPresente() ? "SI" : "NO"));
        }

        Utilidades.pausar();
    }


    // =====================================================
    // MOSTRAR EVIDENCIAS
    // =====================================================

    private void mostrarEvidencias() {

        System.out.println("\n=================================");
        System.out.println("           EVIDENCIAS");
        System.out.println("=================================");

        ArrayList<Evidencia> lista = casoActual.getEvidencias();

        for (Evidencia evidencia : lista) {

            evidencia.mostrarEvidencia();

            System.out.println("---------------------------------");
        }

        Utilidades.pausar();
    }


    // =====================================================
    // ANALIZAR EVIDENCIA
    // =====================================================

    private void analizarEvidencia() {

        ArrayList<Evidencia> evidencias = casoActual.getEvidencias();
        ArrayList<Sospechoso> sospechosos = casoActual.getSospechosos();

        System.out.println("\n=================================");
        System.out.println("       ANALIZAR EVIDENCIA");
        System.out.println("=================================");

        for (int i = 0; i < evidencias.size(); i++) {

            Evidencia evidencia = evidencias.get(i);

            System.out.println(
                    "[" + (i + 1) + "] "
                    + "Evidencia ID: "
                    + evidencia.getId()
                    + " | "
                    + (evidencia.isAnalizada()
                    ? "ANALIZADA"
                    : "PENDIENTE")
            );
        }

        int opcionEvidencia =
                Utilidades.leerEntero(
                        "\nSeleccione la evidencia: "
                );

        if (opcionEvidencia < 1
                || opcionEvidencia > evidencias.size()) {

            System.out.println("Evidencia no válida.");
            Utilidades.pausar();
            return;
        }

        Evidencia evidenciaSeleccionada =
                evidencias.get(opcionEvidencia - 1);

        if (evidenciaSeleccionada.isAnalizada()) {

            System.out.println(
                    "Esta evidencia ya fue analizada."
            );

            Utilidades.pausar();
            return;
        }

        System.out.println("\nAhora debes relacionar la evidencia");
        System.out.println("con uno de los sospechosos:");

        for (int i = 0; i < sospechosos.size(); i++) {

            System.out.println(
                    "[" + (i + 1) + "] "
                    + sospechosos.get(i).getNombre()
            );
        }

        int opcionSospechoso =
                Utilidades.leerEntero(
                        "\nSeleccione el sospechoso: "
                );

        if (opcionSospechoso < 1
                || opcionSospechoso > sospechosos.size()) {

            System.out.println("Sospechoso no válido.");
            Utilidades.pausar();
            return;
        }

        int idEvidencia =
                evidenciaSeleccionada.getId();

        int idSospechoso =
                sospechosos.get(opcionSospechoso - 1).getId();

        investigacion.analizarEvidencia(
                idEvidencia,
                idSospechoso
        );

        // Dar XP por analizar una evidencia
        if (evidenciaSeleccionada.isRelevante()) {

            agente.ganarExperiencia(10);

            System.out.println("\n+10 XP");
            System.out.println(
                    "La evidencia era relevante."
            );

        } else {

            System.out.println(
                    "\nLa evidencia no aporta información importante."
            );
        }

        Utilidades.pausar();
    }


    // =====================================================
    // ACUSACIÓN FINAL
    // =====================================================

    private void realizarAcusacion() {

        int total = casoActual.getEvidencias().size();

        int analizadas =
                investigacion.getEvidenciasAnalizadas();

        double porcentaje = 0;

        if (total > 0) {

            porcentaje =
                    (analizadas * 100.0) / total;
        }

        System.out.println("\n=================================");
        System.out.println("          ACUSACIÓN FINAL");
        System.out.println("=================================");

        System.out.println(
                "Investigación realizada: "
                + (int) porcentaje + "%"
        );

        if (porcentaje < 60) {

            System.out.println(
                    "\n⚠ No tienes suficiente evidencia."
            );

            System.out.println(
                    "Debes analizar al menos el 60% "
                    + "antes de realizar una acusación."
            );

            Utilidades.pausar();
            return;
        }

        ArrayList<Sospechoso> sospechosos =
                casoActual.getSospechosos();

        System.out.println(
                "\n¿A quién acusas?"
        );

        for (int i = 0; i < sospechosos.size(); i++) {

            System.out.println(
                    "[" + (i + 1) + "] "
                    + sospechosos.get(i).getNombre()
            );
        }

        int opcion =
                Utilidades.leerEntero(
                        "\nSeleccione al sospechoso: "
                );

        if (opcion < 1
                || opcion > sospechosos.size()) {

            System.out.println(
                    "Opción no válida."
            );

            Utilidades.pausar();
            return;
        }

        String acusado =
                sospechosos.get(opcion - 1).getNombre();

        String correcto =
                casoActual.getSospechosoCorrecto();

        agente.registrarDecision(
                acusado.equalsIgnoreCase(correcto)
        );

        if (acusado.equalsIgnoreCase(correcto)) {

            System.out.println("\n=================================");
            System.out.println("       ¡CASO RESUELTO!");
            System.out.println("=================================");

            System.out.println(
                    "La acusación contra "
                    + acusado
                    + " fue correcta."
            );

            agente.ganarExperiencia(100);

            agente.aumentarReputacion(10);

            casoActual.resolverCaso();

            System.out.println("\n+100 XP");
            System.out.println("+10 reputación");

            desbloquearSiguienteCaso();

        } else {

            System.out.println("\n=================================");
            System.out.println("       ACUSACIÓN INCORRECTA");
            System.out.println("=================================");

            System.out.println(
                    "La evidencia no respalda esa acusación."
            );

            agente.ganarExperiencia(-40);

            agente.reducirReputacion(10);

            System.out.println("\n-40 XP");
            System.out.println("-10 reputación");
        }

        Utilidades.pausar();
    }


    // =====================================================
    // DESBLOQUEAR SIGUIENTE CASO
    // =====================================================

    private void desbloquearSiguienteCaso() {

        if (casoDesbloqueado < casos.size()) {

            casoDesbloqueado++;

            casoActual =
                    casos.get(casoDesbloqueado - 1);

            investigacion =
                    new Investigacion(casoActual);

            System.out.println("\n=================================");
            System.out.println("       NUEVO CASO DESBLOQUEADO");
            System.out.println("=================================");

            System.out.println(
                    "Caso " + casoDesbloqueado
                    + " disponible."
            );

            System.out.println(
                    "Título: "
                    + casoActual.getTitulo()
            );

        } else {

            System.out.println("\n=================================");
            System.out.println("      TODAS LAS OPERACIONES");
            System.out.println("          COMPLETADAS");
            System.out.println("=================================");

            System.out.println(
                    "Has completado los 5 casos."
            );

            System.out.println(
                    "Código final: NEXUS-07"
            );
        }
    }


    // =====================================================
    // VER EXPEDIENTE
    // =====================================================

    public void verExpediente() {

        System.out.println("\n=================================");
        System.out.println("           EXPEDIENTE");
        System.out.println("=================================");

        casoActual.mostrarInformacion();

        System.out.println(
                "\nCasos desbloqueados: "
                + casoDesbloqueado
                + "/"
                + casos.size()
        );

        Utilidades.pausar();
    }


    // =====================================================
    // ENTRENAMIENTO
    // =====================================================

    public void entrenamiento() {

        System.out.println("\n=================================");
        System.out.println("          ENTRENAMIENTO");
        System.out.println("=================================");

        agente.mostrarPerfil();

        Utilidades.pausar();
    }


    // =====================================================
    // SALIR
    // =====================================================

    public void salir() {

        System.out.println("\n¡Hasta luego, agente!");
    }
}