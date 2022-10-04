/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import static principal.PARAMETROS.sc;

/**
 *
 * @author 113694
 */
public class PROCESOS {
    private int numero;
    private int rafagas;
    private int[] tiempo_rafagas;
    private int llegada;
    private int entrada_salidas;
    
    public PROCESOS(){}
    
    public void Ingresar(){
        
        do {            
            System.out.println("Ingrese el valor de llegada:");
            this.llegada = sc.nextInt();
            
            if(this.llegada <= 0){
                System.out.println("El valor de llegada debe ser mayor a 0");
            }
        } while (this.llegada <= 0 );
        
        do {            
            System.out.println("Ingrese la cantidad de rafagas:");
            this.rafagas = sc.nextInt();
            
            if((this.rafagas <= 0)||(this.rafagas > 5)){
                System.out.println("La cantidad de rafagas debe ser mayor a 0 y menor a 5");
            }
        } while ((this.rafagas <= 0)||(this.rafagas > 5));
        
        this.entrada_salidas = this.rafagas - 1;
        this.tiempo_rafagas = new int[this.rafagas];
        
        for(int i=0; i<this.rafagas; i++){
            do {                
                System.out.println("Ingrese el tiempo de la rafaga "+ (i+1) +":");
                this.tiempo_rafagas[i] = sc.nextInt();
                
                if(this.tiempo_rafagas[i] <= 0){
                    System.out.println("El tiempo debe ser mayor a 0");
                }
            } while (this.tiempo_rafagas[i] <= 0);

        }
    }

    public int getRafagas() {
        return rafagas;
    }

    public void setRafagas(int rafagas) {
        this.rafagas = rafagas;
    }

    public int[] getTiempo_rafagas() {
        return tiempo_rafagas;
    }

    public void setTiempo_rafagas(int[] tiempo_rafagas) {
        this.tiempo_rafagas = tiempo_rafagas;
    }

    public int getLlegada() {
        return llegada;
    }

    public void setLlegada(int llegada) {
        this.llegada = llegada;
    }

    public int getEntrada_salidas() {
        return entrada_salidas;
    }

    public void setEntrada_salidas(int entrada_salidas) {
        this.entrada_salidas = entrada_salidas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
}
