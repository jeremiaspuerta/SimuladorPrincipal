/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.util.ArrayList;

/**
 *
 * @author jerem
 */
public class GRAFICO {
    private final int cant_unidades = 500;
    private final int alto = 15;
    private ArrayList<String>[][] arr  = new ArrayList[15][this.cant_unidades];
    
    public GRAFICO(){};
    
    public void generar(){
        int cont = 0;
        
        for (int x = 0; x < this.alto; x++) {
            System.out.println("");
            for (int j = 0; j < cant_unidades; j++) {
                arr[x][j] = new ArrayList<>();

                if (j == 0) {

                    switch (x) {
                        case 1:
                            System.out.print("BLOQUEO|");
                            break;
                        case 4:
                            System.out.print("P3     |");
                            break;
                        case 5:
                            System.out.print("P2     |");
                            break;
                        case 6:
                            System.out.print("P1     |");
                            break;
                        case 9:
                            System.out.print("LISTO  |");
                            break;
                        case 12:
                            System.out.print("S.O    |");
                            break;
                        case 14:
                            System.out.print("U.T    |");
                            break;
                        default:
                            System.out.print("       |");
                            break;
                    }

                }

                if (x == 14 && j <= cant_unidades) {
                    
                    if(cont >= 100){
                        
                        
                        arr[x][j].add(" " + String.valueOf(cont) + " ");
                    }else if (cont == 0){
                        arr[x][j].add("  " + String.valueOf(cont) + "  ");
                    }else if (cont >= 10){
                        arr[x][j].add("  " + String.valueOf(cont) + " ");
                    }else{
                        arr[x][j].add("  " + String.valueOf(cont) + "  ");
                    }                   
                    
                    
                    cont ++;

                } else {
                    arr[x][j].add("     ");
                }

                if (x == 3 || x == 7 || x == 11 || x == 13) {
                    System.out.print("-------");
                } else {
                    System.out.print(arr[x][j]);
                }

            }

        }

    }

    public int getAlto() {
        return alto;
    }

    public int getCant_unidades() {
        return cant_unidades;
    }

    public ArrayList<String>[][] getArr() {
        return arr;
    }
    
    
}
