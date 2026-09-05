
package logica;
import Util.Utilidades;


public class Sistema {
    private String nombreAgente = "Agente";
    
    public void iniciarOperacion() {
        System.out.println("=== INICIAR OPERACION ===");
        System.out.println("Cargando caso...");
        System.out.println("Aqui se conecta con la clase caso de susan :D");
        Utilidades.pausar();
    }
    
    public void verExpediente() {
        System.out.println("=== EXPEDIENTES ===");
        System.out.println("Lista de casos:");
        System.out.println("CASO #001: LA SENAL");
        System.out.println("CASO #002: EL PAQUETE");
        System.out.println("Aqui se concecta con la clase caso de susan :D");
        Utilidades.pausar();
    }
    
    public void entrenamiento() {
        System.out.println("=== ENTRENAMIENTO ===");
        System.out.println("Iniciando simulador de entrenamiento...");
        System.out.println("(Aqui se conecta con la clase agente de Amy");
        Utilidades.pausar();
    }
    
    public void salir() {
        System.out.println("¡Hasta luego, agente!");
        System.exit(0);
    }
}
