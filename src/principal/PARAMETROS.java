package principal;
import java.util.Scanner;

public class PARAMETROS {
    int rutina_so;
    int demora_es;
    int quantum;
    static Scanner sc = new Scanner(System.in);
    
    public PARAMETROS(){
    }
    
    public void Ingresar(){
        
        do {            
            System.out.println("Ingrese la demora de la rutina del S.O:");
            this.rutina_so = sc.nextInt();
            
            if(this.rutina_so <= 0){
                System.out.println("La demora de la rutina del SO debe ser mayor a 0");
            }
        } while (this.rutina_so <= 0);
        
        do {            
            System.out.println("Ingrese el tiempo de E/S:");
            this.demora_es = sc.nextInt();
            
            if(this.demora_es <= 0){
                System.out.println("El tiempo de E/S debe ser mayor a 0");
            }
        } while (this.demora_es <= 0);
        
        do {            
            System.out.println("Ingrese el valor del Quantum:");
            this.quantum = sc.nextInt();
        
            if(this.quantum <= 0){
                System.out.println("El valor del Quantum ser mayor a 0");
            }
        } while (this.quantum <= 0);


    }

    
}
