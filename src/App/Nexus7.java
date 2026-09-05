
package App;
import Modelo.Agente;
import Modelo.Caso;
import Modelo.Evidencia;
import Modelo.MotorDecisiones;
import Modelo.Sospechoso;
import Util.Utilidades;
import logica.Investigacion;
import logica.Puntuacion;
import logica.Sistema;

/*Aqui llame a todos los paquetes, esto puede estar sujeto a cambios a medida que avancemos*/

public class Nexus7 {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        int opcion;
        
        do {
            System.out.println("        N E X U S  7              ");
            System.out.println("     AGENCIA DE INTELIGENCIA       ");
            System.out.println("   [1] Iniciar operacion           ");
            System.out.println("   [2] Ver expediente              ");
            System.out.println("   [3] Entrenamiento               ");
            System.out.println("   [4] Salir                       ");
            
            opcion = Utilidades.leerEntero("Seleccione una opcion: ");
            
            switch (opcion) {
                case 1:
                    sistema.iniciarOperacion();
                    break;
                case 2:
                    sistema.verExpediente();
                    break;
                case 3:
                    sistema.entrenamiento();
                    break;
                case 4:
                    sistema.salir();
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    Utilidades.pausar();
            }
            
        } while (opcion != 4);
    }
    
}
