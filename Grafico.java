package Exerc_Charts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import HTML.Arquivo;;

public class Grafico {

	public static void main(String[] args) throws IOException {
		
		Arquivo html;
		
		Scanner entrada = new Scanner(System.in);
		
		final String fileName = "graficos";
		
		String titulo;
		String temp = " ";
		int cont = 0;
		
		
		System.out.print("Título do Gráfico: ");
	    titulo = entrada.nextLine();
	    
	    for(int k=0; k<7; k++) {
	    	
	    	cont = cont + 1;
	    	System.out.print("Informe a temperatura do dia: " + cont + ": ");
	    	temp = entrada.nextLine();
	    }
	    
	    html = new Arquivo();
	    html.grava(fileName, titulo, temp);
	}
}
