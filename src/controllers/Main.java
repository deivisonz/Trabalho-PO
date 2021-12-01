package controllers;

import static constantes.Constantes.INSERCAO;
import static constantes.Constantes.QUICKSORT;
import static constantes.Constantes.QUICKSORT_COM_INSERCAO;
import static constantes.Constantes.SAIR;
import static constantes.Constantes.SHELLSORT;
import static constantes.Constantes.TODOS;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Scanner;

import arvore.ABB;
import arvore.AVL;
import arvore.Hashing;
import arvore.NoHash;
import constantes.Constantes;
import arvore.NoAbb;
import arvore.NoAvl;
import io.GravarArquivo;
import io.LerArquivoConta;
import models.CadCompra;
import models.Compra;

public class Main {

    static Scanner scan = new Scanner(System.in);
    
    private static Long tempoInicial;
	private static Long tempoFinal;
   
    public static void main(String[] args) throws IOException {

        int etapa = 0;
        int iteracoes = Constantes.QUANTIDADE_ITERACOES_PADRAO;
             	
    	System.out.print(
                "|-----------------------------------------------------|\n"
              + "|                    MENU PRINCIPAL                   |\n"
              + "|-----------------------------------------------------|\n"
              + "| 1 - Etapa 1 (M�todos de Ordena��o)                  |\n"
              + "| 2 - Etapa 2 (M�todos de Pesquisa)                   |\n"
              + "|-----------------------------------------------------|\n"
              + "|> ");
        
	    System.out.print("Escolha uma op��o: ");
	    etapa = scan.nextInt();
        System.out.println("--------------------------");
                     
        if (etapa == Constantes.ETAPA_UM_METODOS_ORDENACAO) {
        	int escolha = 0;
        	do {
	        	System.out.print(
	                      "|-----------------------------------------------------|\n"
	                    + "|                    MENU PRINCIPAL                   |\n"
	                    + "|-----------------------------------------------------|\n"
	                    + "| 1 - Todos                                           |\n"
	                    + "| 2 - Inser��o                                        |\n"
	                    + "| 3 - QuickSort                                       |\n"
	                    + "| 4 - ShellSort                                       |\n"
	                    + "| 5 - QuickSort com Inser��o                          |\n"
	                    + "| 6 - Sair                                            |\n"
	                    + "|-----------------------------------------------------|\n"
	                    + "|> ");
	        	
	        	System.out.print("Escolha uma op��o: ");
	        	escolha = scan.nextInt();
	            System.out.println("--------------------------");	        	
           
         
	            if (escolha == TODOS) {
	            	ordernar(INSERCAO, iteracoes);
	            	ordernar(QUICKSORT, iteracoes);
	            	ordernar(SHELLSORT, iteracoes);
	            	ordernar(QUICKSORT_COM_INSERCAO, iteracoes);
	            } else {
	            	ordernar(escolha, iteracoes);
	            }           
        	} while (escolha >= TODOS && escolha <= SAIR);
        } else if (etapa == Constantes.ETAPA_DOIS_METODOS_PESQUISA) {
        	ordernarArvore(Constantes.ABB, iteracoes);
        	ordernarArvore(Constantes.AVL, iteracoes);
        	ordernarArvore(Constantes.HASHING, iteracoes);
        }

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
	        	compras.quickComInsercao();  
	        	break;
	        case SAIR:
	            System.out.println("Encerrando...");
	            System.exit(0);
    	}  
    }
    
    private static void ordernar(int escolha, int iteracoes) throws FileNotFoundException {                    
    	System.out.println("\nM�TODO: " + getDescricaoOrdenacao(escolha, false));
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
        		System.out.print(" [Tempo m�dio decorido : " + (tempoFinal - tempoInicial) / iteracoes + " ms]\n");
        		
        	}         	
        }    	
    }
    
    private static void ordernarArvore(int escolha, int iteracoes) throws IOException {                    	   	   	   	    	
    	System.out.println("\nM�TODO: " + getDescricaoArvore(escolha, false));
    	for (int i = 0; i < Constantes.NOME_ARQUIVO.length; i++) {
        	for (int j = 0; j < Constantes.TIPO_ARQUIVO.length; j++) {
        		tempoInicial = System.currentTimeMillis();
        		for (int k = 0; k < iteracoes; k++) {         			      		
        			String caminho = Constantes.CAMINHO_TESTE + "compra" + Constantes.NOME_ARQUIVO[i] + Constantes.TIPO_ARQUIVO[j] + ".txt";           		      			        		
	        		
        			ABB abb = new ABB();
	            	AVL avl = new AVL();
	            	Hashing hashing = new Hashing(55001);
	        		
	        		CadCompra compras = lerArquivo(caminho);        		
	        		
	        		String caminhoProcessado = Constantes.CAMINHO_PROCESSADO + Constantes.NOME_ARQUIVO[i] + Constantes.TIPO_ARQUIVO[j] + getDescricaoArvore(escolha, true) + ".txt";        		
	        		if (compras.getVetCompra() != null) {
	        			int count = 0;
	        			for (Compra compra : compras.getVetCompra()) {
	        				if (escolha == Constantes.ABB) {
	        		    		abb.inserir(compra);	        		    		
	        		    	} else if (escolha == Constantes.AVL) {
	        		    		avl.inserir(compra);
	        		    	} else if (escolha == Constantes.HASHING) {
	        		    		hashing.inserir(compra);
	        		    	}	        				
	        				count++;
	        				System.out.println(String.valueOf(count));
	        			}      					        			
	                	gravarContaArvore(escolha, compras, caminhoProcessado, abb, avl, hashing);          
	                }     	        		
        		} 
        		
        		tempoFinal = System.currentTimeMillis();
        		System.out.print(" -> Arquivo: " + Constantes.NOME_ARQUIVO[i] + Constantes.TIPO_ARQUIVO[j] + ".txt");
        		System.out.print(" [Tempo m�dio decorido : " + (tempoFinal - tempoInicial) / iteracoes + " ms]\n");
        		
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
    
    private static void gravarContaArvore(int escolha, CadCompra compras, String caminhoArquivo, ABB abb, AVL avl, Hashing hashing) {      	
    	try {
    		List<String> cpfsCompra = Files.readAllLines(Paths.get(Constantes.CAMINHO_TESTE + "compra.txt"));
    		
    		GravarArquivo saida = new GravarArquivo(caminhoArquivo);
    		cpfsCompra.forEach( cpf -> {
    			Compra compra = null; 					
    			if (escolha == Constantes.ABB) {
        			abb.balancear(); 
        			NoAbb noAbb = null;  	
        			noAbb = abb.pesquisar(cpf);
        			if (noAbb == null) {
						saida.gravar("\nN�O H� NENHUMA COMPRA COM O CPF " + cpf); 
					} else {
						saida.gravar(compra.toString() + "\n"); 
					}
    	    	} else if (escolha == Constantes.AVL) {
    	    		NoAvl noAvl = null;
    	    		noAvl = avl.pesquisar(cpf);
    	    		if (noAvl == null) {
						saida.gravar("\nN�O H� NENHUMA COMPRA COM O CPF " + cpf); 
					} else {
						saida.gravar(compra.toString() + "\n"); 
					}
    	    	} else if (escolha == Constantes.HASHING) {
    	    		NoHash noHash = null;
    	    		noHash = hashing.pesquisar(cpf);
					if (noHash == null) {
						saida.gravar("\nN�O H� NENHUMA COMPRA COM O CPF " + cpf); 
					} else {
						saida.gravar(compra.toString() + "\n"); 
					}
    	    	}    			 			
    		});   		

            saida.fechar();
        } catch (IOException e) {
        	System.out.println("ERRO " + e.getMessage());
        }
    }
    
    private static String getDescricaoOrdenacao(int escolha, boolean abreviado) {
    	switch (escolha) {    			         
	        case INSERCAO: return abreviado ? "-InsDir" : "INSER��O";
	        case QUICKSORT: return abreviado ? "-Quick" : "QUICKSORT"; 
	        case SHELLSORT: return abreviado ? "-Shell" : "SHELLSORT"; 
	        case QUICKSORT_COM_INSERCAO: return abreviado ? "-QuickIns" : "QUICKSORT COM INSER��O";  
	        default: throw new InvalidParameterException("ERRO: Op��o informada inv�lida");
    	}
    }
    
    private static String getDescricaoArvore(int escolha, boolean abreviado) {
    	switch (escolha) {    			         
	        case Constantes.ABB: return abreviado ? "-ABB" : "ABB";
	        case Constantes.AVL: return abreviado ? "-AVL" : "AVL"; 
	        case Constantes.HASHING: return abreviado ? "-Hashing" : "HASHING"; 	     
	        default: throw new InvalidParameterException("ERRO: Op��o informada inv�lida");
    	}
    }
    
    private static int numeroPrimo(int numero) {
		if (numero == 500) {
			return 557;
		} else if (numero == 5000) {
			return 5501;
		} else if (numero == 1000) {
			return 1103;
		} else if (numero == 10000) {
			return 11003;
		} else {
			return 55001;
		}		
	}
    
}
