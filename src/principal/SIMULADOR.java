package principal;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class SIMULADOR {

    ArrayList<PROCESOS> procesos = new ArrayList<>(3); 
    PARAMETROS parametros = new PARAMETROS();
    GRAFICO grafico = new GRAFICO();
    
    static Scanner sc = new Scanner(System.in);

    public void MENU() {

        int opc = 0, paso = 0;

        do {
            System.out.println("1_Cargar Parametros");
            // Parametros: 
            //  Cuanto demora la rutina del OS
            //  CUANTO DEMORA LA E/S
            //  Quantum de tiempo para RR
            System.out.println("2_Carga de procesos");
            //	Siempre van a ser 3 procesos
            //  	Establecer cuantos hemiciclos por proceso
            //  	  Establecer tiempo para CADA hemiciclo
            //  La cantidad de E/S es uno menor a la cantidad de hemiciclos. eg. 4 hemiciclos tiene 3 E/S
            System.out.println("3_Mostrar grafica de la politica FIFO");
            System.out.println("4_Mostrar grafica de la politica ROUND ROBIN");
            System.out.println("5_Mostrar resultados");
            System.out.println("6_Salir");

            do {
                opc = sc.nextInt();

                if (opc < 1 && opc > 6) {
                    System.out.println("Opcion incorrecta. Por favor, ingrese un numero valido.");
                }
            } while (opc < 1 && opc > 6);

            switch (opc) {
                case 1:
                    if (paso == 0) {
                        this.parametros.Ingresar();
                        paso = 1;
                    } else {
                        System.out.println("Los parametros ya fueron cargados");
                    }
                    break;
                case 2:
                    if (paso == 1) {
                        for (int x = 0; x < 3; x++) {
                            System.out.println("CARGA DEL PROCESO " + (x + 1));
                            
                            PROCESOS p = new PROCESOS();
                            p.Ingresar();
                            p.setNumero((x+1));
                            
                            this.procesos.add(p);
                            
                        }
                        paso = 2;
                    } else if (paso == 2) {
                        System.out.println("Los procesos ya fueron cargados");
                    } else if (paso != 2) {
                        System.out.println("DEBE CARGAR LOS PARAMETROS PRIMERO");
                    }

                    break;
                case 3:
                    if ((paso == 2) || (paso == 3) || (paso == 4)) {

                        paso = 3;
                    } else if (paso == 1) {
                        System.out.println("PRIMERO DEBE INGRESAR LOS PROCESOS");
                    } else if (paso == 0) {
                        System.out.println("PRIMERO DEBE INGRESAR LOS PARAMETROS Y LOS PROCESOS");
                    }

                    break;
                case 4:
                    if ((paso == 2) || (paso == 3) || (paso == 4)) {

                        paso = 4;
                    } else if (paso == 0) {
                        System.out.println("PRIMERO DEBE INGRESAR LOS PARAMETROS Y LOS PROCESOS");
                    } else if (paso == 1) {
                        System.out.println("PRIMERO DEBE INGRESAR LOS PROCESOS");
                    }
                    break;
                case 5:
                    if ((paso == 3) || (paso == 4)) {

                    } else {
                        System.out.println("NO PUEDE VER RESULTADOS SIN ANTES HABER HECHO EL GRAFICO");
                    }
                    break;
                case 6:
                    System.out.println("FIN DEL PROGRAMA");
                    break;
            }
        } while (opc != 6);

    }

//    public void GRAFICO() {
//        int cant_unidades = 500;
//        ArrayList<String>[][] arr = new ArrayList[15][cant_unidades];
//        int cont = 0;
//
//        for (int x = 0; x < 15; x++) {
//            System.out.println("");
//            for (int j = 0; j < cant_unidades; j++) {
//                arr[x][j] = new ArrayList<>();
//
//                if (j == 0) {
//
//                    switch (x) {
//                        case 1:
//                            System.out.print("BLOQUEO|");
//                            break;
//                        case 4:
//                            System.out.print("P3     |");
//                            break;
//                        case 5:
//                            System.out.print("P2     |");
//                            break;
//                        case 6:
//                            System.out.print("P1     |");
//                            break;
//                        case 9:
//                            System.out.print("LISTO  |");
//                            break;
//                        case 12:
//                            System.out.print("S.O    |");
//                            break;
//                        case 14:
//                            System.out.print("U.T    |");
//                            break;
//                        default:
//                            System.out.print("       |");
//                            break;
//                    }
//
//                }
//
//                if (x == 14 && j <= cant_unidades) {
//                    
//                    if(cont >= 100){
//                        
//                        
//                        arr[x][j].add(" " + String.valueOf(cont) + " ");
//                    }else if (cont == 0){
//                        arr[x][j].add("  " + String.valueOf(cont) + "  ");
//                    }else if (cont >= 10){
//                        arr[x][j].add("  " + String.valueOf(cont) + " ");
//                    }else{
//                        arr[x][j].add("  " + String.valueOf(cont) + "  ");
//                    }                   
//                    
//                    
//                    cont ++;
//
//                } else {
//                    arr[x][j].add("     ");
//                }
//
//                if (x == 3 || x == 7 || x == 11 || x == 13) {
//                    System.out.print("-------");
//                } else {
//                    System.out.print(arr[x][j]);
//                }
//
//            }
//
//        }
//    }
    
    public void GRAFICO_FIFO(){
        
        // !CARGA DE PROCESOS POR DEFECTO PARA FINES PRACTICOS
        Random random = new Random();
        
        for(int x = 0; x < 3; x++){
            PROCESOS p = new PROCESOS();
            p.setNumero(x+1);
            p.setLlegada(random.nextInt(10 + 1) + 1);
            p.setRafagas(3);
            p.setEntrada_salidas(2);
            
            int[] tiempo_rafagas = new int[p.getRafagas()];
            for(int j = 0; j < p.getRafagas(); j++){
                tiempo_rafagas[j] = 3;
                
            }
            p.setTiempo_rafagas(tiempo_rafagas);
            
            this.procesos.add(p);
            
        }
        // !FIN CARGA DE PROCESOS POR DEFECTO PARA FINES PRACTICOS
        
        
        for(int x = 0; x < 3; x++){
            System.out.println("PROCESO " + this.procesos.get(x).getNumero());
            System.out.println("");
            System.out.println("RAFAGAS " + this.procesos.get(x).getRafagas());
            System.out.println("TIEMPO POR RAFAGA " + Arrays.toString(this.procesos.get(x).getTiempo_rafagas()));
            System.out.println("LLEGADA " + this.procesos.get(x).getLlegada());
            System.out.println("E/S " + this.procesos.get(x).getEntrada_salidas());
            System.out.println("");
        }
        
        ArrayList<PROCESOS> ordenados = new ArrayList<>();
        
        PROCESOS menor = this.procesos.get(0);
        PROCESOS medio = this.procesos.get(0);
        PROCESOS mayor = this.procesos.get(0);
        
        for(int j = 0; j < 6; j++){
            for(int z = 0; z < 3; z++){
                if(this.procesos.get(z).getLlegada() < menor.getLlegada()){
                   menor = this.procesos.get(z);
//                   ordenados.add(0, this.procesos.get(z));
                }
                if(this.procesos.get(z).getLlegada() > mayor.getLlegada()){
                    mayor = this.procesos.get(z);
//                    ordenados.add(1, this.procesos.get(z));
                }
                
                if(this.procesos.get(z).getLlegada() < menor.getLlegada() && this.procesos.get(z).getLlegada() > mayor.getLlegada()){
                    medio = this.procesos.get(z);
                    
//                    ordenados.add(2, this.procesos.get(z));
                }

            }
        }
        
        ordenados.add(0, menor);
        ordenados.add(1, medio);
        ordenados.add(2, mayor);
        
        System.out.println("ORDENADOS");
        System.out.println("---------");
        
        for(int x = 0; x < 3; x++){
            System.out.println("PROCESO " + ordenados.get(x).getNumero());
            System.out.println("");
            System.out.println("RAFAGAS " + ordenados.get(x).getRafagas());
            System.out.println("TIEMPO POR RAFAGA " + Arrays.toString(ordenados.get(x).getTiempo_rafagas()));
            System.out.println("LLEGADA " + ordenados.get(x).getLlegada());
            System.out.println("E/S " + ordenados.get(x).getEntrada_salidas());
            System.out.println("");
        }

        this.grafico.generar();
        
        
//        for(int x = 0; x < this.grafico.getAlto(); x++){
//            for(int j = 0; j < this.grafico.getCant_unidades(); j++){
//                
//                
//                this.grafico.getArr()[x][j].size();
//            }
//        }   
        
        
    }

}
