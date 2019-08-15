package desafio_charts;

import java.io.IOException;
import java.util.Scanner;


public class Desafio_Charts {

    public static void main(String[] args) throws IOException {
        int linha = 5,coluna = 3;
        String teste[][] = new String [linha][coluna];
        Scanner entrada = new Scanner(System.in);
        HTML h = new HTML();
        
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j <coluna; j++) {
                if(i == 0){
                    System.out.println("Digite o nome da Coluna :");
                    teste[i][j]= entrada.nextLine();
                    
                }else{
                    System.out.println("Digite o "+j+" valor  "+teste[0][j]);
                    teste[i][j] = entrada.nextLine();
                }
              
            }
           
        }
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                System.out.print(" |"+teste[i][j]+" |");
            }
            System.out.println("");
        }
        h.setVetor(teste);
        h.gerarHTML();
       
        
    }
    
}
