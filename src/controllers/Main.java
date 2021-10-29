package controllers;

import static constantes.Constantes.INSERCAO;
import static constantes.Constantes.QUICKSORT;
import static constantes.Constantes.QUICKSORT_COM_INSERCAO;
import static constantes.Constantes.SAIR;
import static constantes.Constantes.SHELLSORT;
import static constantes.Constantes.TODOS;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Scanner;

import constantes.Constantes;
import io.GravarArquivo;
import io.LerArquivoConta;
import models.CadCompra;
import models.Compra;

public class Main {

    static Scanner scan = new Scanner(System.in);
    
    private static Long tempoInicial;
	private static Long tempoFinal;
   
    public static void main(String[] args) throws FileNotFoundException {

        int escolha = 0;
        int iteracoes = 0;
        do {
            System.out.print(
                      "|-----------------------------------------------------|\n"
                    + "|                    MENU PRINCIPAL                   |\n"
                    + "|-----------------------------------------------------|\n"
                    + "| 1 - Todos                                           |\n"
                    + "| 2 - Inserção                                        |\n"
                    + "| 3 - QuickSort                                       |\n"
                    + "| 4 - ShellSort                                       |\n"
                    + "| 5 - QuickSort com Inserção                          |\n"
                    + "| 6 - Sair                                            |\n"
                    + "|-----------------------------------------------------|\n"
                    + "|> ");

            System.out.print("Escolha uma opção: ");
            escolha = scan.nextInt();
            System.out.println("--------------------------");
            
            System.out.print("Digite a Quantidade de Iterações a serem Realizadas: ");
            iteracoes = scan.nextInt();
            System.out.println("--------------------------");
            
            if (escolha == TODOS) {
            	ordernar(INSERCAO, iteracoes);
            	ordernar(QUICKSORT, iteracoes);
            	ordernar(SHELLSORT, iteracoes);
            	ordernar(QUICKSORT_COM_INSERCAO, iteracoes);
            } else {
            	ordernar(escolha, iteracoes);
            }           
        } while (escolha >= TODOS && escolha <= SAIR && iteracoes > 0);

    }
    
    private static CadCompra lerArquivo(String caminho) throws FileNotFoundException {
    	LerArquivoConta arquivo = new LerArquivoConta(caminho);
		CadCompra compras = new CadCompra(arquivo.ler());
		arquivo.fecha();  
		
		return compras;
    }
    
    private static void caseOrdenar(CadCompra compras, int escolha) {
    	switch (escolha) {    			 
	        case INSERCAO:
	       	compras.insercaoDireta();               	
	       		break;
	        case QUICKSORT:
	       	 	compras.quickSort();  
	       	 	break;
	        case SHELLSORT:
	       	 	compras.shellSort();  
	       	 	break;
	        case QUICKSORT_COM_INSERCAO:
	        	compras.quickComInsercao(0, compras.getVetCompra().size() -1);  
	        	break;
	        case SAIR:
	            System.out.println("Encerrando...");
	            System.exit(0);
    	}  
    }
 
    private static void ordernar(int escolha, int iteracoes) throws FileNotFoundException {                    
    	System.out.println("\nMÉTODO: " + getDescricaoOrdenacao(escolha, false));
    	for (int i = 0; i < Constantes.NOME_ARQUIVO.length; i++) {
        	for (int j = 0; j < Constantes.TIPO_ARQUIVO.length; j++) {
        		
        		tempoInicial = System.currentTimeMillis();
        		
        		for (int k = 0; k < iteracoes; k++) {   					        		
	        		String caminho = Constantes.CAMINHO_TESTE + "compra" + Constantes.NOME_ARQUIVO[i] + Constantes.TIPO_ARQUIVO[j] + ".txt";           		      		
	        		CadCompra compras = lerArquivo(caminho);        		
	        		
	        		String caminhoProcessado = Constantes.CAMINHO_PROCESSADO + Constantes.NOME_ARQUIVO[i] + Constantes.TIPO_ARQUIVO[j] + getDescricaoOrdenacao(escolha, true) + ".txt";        		
	        		if (compras.getVetCompra() != null) {
	        			caseOrdenar(compras, escolha);         			    			
	                	gravarConta(compras, caminhoProcessado);          
	                }     	        		
        		} 
        		
        		tempoFinal = System.currentTimeMillis();
        		System.out.print(" -> Arquivo: " + Constantes.NOME_ARQUIVO[i] + Constantes.TIPO_ARQUIVO[j] + ".txt");
        		System.out.print(" [Tempo médio decorido : " + (tempoFinal - tempoInicial) / iteracoes + " ms]\n");
        		
        	}         	
        }    	
    }
          
    
    private static void gravarConta(CadCompra compras, String caminhoArquivo) {      	
    	try {
            GravarArquivo saida = new GravarArquivo(caminhoArquivo);
            for (Compra c : compras.getVetCompra()) {
                saida.gravar(c.toStringArquivo(compras.getVetCompra().size()) + "\n");
            }
            saida.fechar();
        } catch (IOException e) {
        	System.out.println("ERRO " + e.getMessage());
        }
    }
    
    private static String getDescricaoOrdenacao(int escolha, boolean abreviado) {
    	switch (escolha) {    			         
	        case INSERCAO: return abreviado ? "-InsDir" : "INSERÇÃO";
	        case QUICKSORT: return abreviado ? "-Quick" : "QUICKSORT"; 
	        case SHELLSORT: return abreviado ? "-Shell" : "SHELLSORT"; 
	        case QUICKSORT_COM_INSERCAO: return abreviado ? "-QuickIns" : "QUICKSORT COM INSERÇÃO";  
	        default: throw new InvalidParameterException("ERRO: Opção informada inválida");
    	}
    }
    
}
