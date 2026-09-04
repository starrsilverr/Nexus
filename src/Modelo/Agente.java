
package Modelo;
import logica.Puntuacion;

public class Agente {
    private String nombre,codigo, rango;
    private int EXP, rep, energia, estres;
    private double precision;

    //Contructor Parametrizado
    public Agente(String nombre, String codigo, String rango, int EXP, int rep, int energia, int estres, double precision) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.rango = rango;
        this.EXP = EXP;
        this.rep = rep;
        this.energia = energia;
        this.estres = estres;
        this.precision = precision;
    }
    
    //Funcion para mostrar la informacion
    public void mostrarDatos (){
    System.out.println("Nombre : " + nombre);
    System.out.println("Codigo : " + codigo);
    System.out.println("Rango : " + rango);
    System.out.println("EXP : " + EXP);
    System.out.println("Reputacion : " + rep);
    System.out.println("Energia : " + energia);
    System.out.println("Estres : " + estres);
    System.out.println("Preciscion : " + precision);
}
    
    public void Rangos(){
        //Ciclo para saber los rango entorno a la puntiacion.
        
    }
    
}
