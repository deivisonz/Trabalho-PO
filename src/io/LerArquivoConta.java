package io;

import java.io.*;
import java.util.*;
import models.Cliente;
import models.ClienteEspecial;
import models.Compra;

//Classe para criar um objeto do tipo arquivo de leitura
public class LerArquivoConta {

	 private Scanner entrada;

	    /**
	     * Construtor
	     *
	     * @param nome => Nome do arquivo que sera aberto para lei0tura
	     * @throws FileNotFoundException => Excecao se nao encontrar o arquivo
	     */
	    public LerArquivoConta(String nome) throws FileNotFoundException {
	        try {
	            this.entrada = new Scanner(new File(nome));
	        } catch (FileNotFoundException e) {
	            throw new FileNotFoundException("ARQUIVO NAO ENCONTRADO");
	        }
	    }

	    /**
	     * Metodo para ler os dados contidos no arquivo
	     *
	     * @return Vetor de Contas que serao lidas nesse metodo
	     * @throws NoSuchElementException
	     */
	    public ArrayList<Compra> ler() throws ArrayIndexOutOfBoundsException,
	            NumberFormatException {
	        
	        ArrayList<Compra> conta = new ArrayList<>();
	        String linha;
	        
	        // Enquanto tiver informacao na linha do cursor ele roda o while
	        while (this.entrada.hasNext()) {
	            
	            linha = this.entrada.nextLine();// pega a linha toda e joga na variavel linha
	            conta.add((separaDados(linha)));// separa os dados e adiciona na lista de contas
	        }
	        return conta;
	    }

	    /**
	     * Metodo para transformar uma linha do arquivo em um objeto da classe Conta
	     *
	     * @param linha => String contendo a linha do arquivo que sera transformada
	     * @return => A conta criada a partir do linha passada
	     * @throws NoSuchElementException => Excecao causada por elementos
	     * insuficientes na String, durante a transformacao
	     * @throws NumberFormatException => Excecao causada por transformar uma
	     * String que nao tem apenas digitos em inteiro
	     */
	    private Compra separaDados(String linha) throws ArrayIndexOutOfBoundsException,
	            NumberFormatException {
	        
	        String[] dados = null;
	        
	        try {
	            dados = linha.split(";");

	            if (dados.length == 5) {

	               // String atr = dados[2].replaceAll(".", "").replace(',', '.');
	                double atr2 = Double.parseDouble(dados[2]);
	                Cliente clienteEspecial = new ClienteEspecial(atr2, dados[0], dados[1]);

	                Calendar data = dividirData(dados[3]);
	                
	                //String valor = dados[4].replaceAll(".", "").replace(',', '.');
	                double valorDouble = Double.parseDouble(dados[4]);
	                
	                return (new Compra(clienteEspecial, data, valorDouble));
	                
	            } else {
	                
	                Cliente cliente = new Cliente(dados[0], dados[1]);

	                Calendar data = dividirData(dados[2]);
	                
	               // String valor = dados[3].replaceAll(".", "").replace(',', '.');
	                double valorDouble = Double.parseDouble(dados[3]);
	                
	                return (new Compra(cliente, data, valorDouble));
	                
	            }

	        } catch (ArrayIndexOutOfBoundsException erro) {
	            throw new ArrayIndexOutOfBoundsException("REGISTRO TEM " + dados.length + " INFORMACOES");
	        } catch (NumberFormatException erro) {
	            throw new NumberFormatException("NUMERO DA CONTA NAO E INTEIRO");
	        }
	    }


	    public Calendar dividirData(String dados) {
	        Calendar data = Calendar.getInstance();
	        int dia, mes, ano;

	        String[] dataCalendar = dados.split("/");

	        dia = Integer.parseInt(dataCalendar[0]);
	        mes = Integer.parseInt(dataCalendar[1]) - 1;
	        ano = Integer.parseInt(dataCalendar[2]);
	        data.set(ano, mes, dia);
	        return data;
	    }

	    /**
	     * Metodo para fechar o arquivo de leitura
	     *
	     * @throws IllegalStateException => Excecao causada se nao conseguir fechar
	     * o arquivo.
	     */
	    public void fecha() throws IllegalStateException {
	        try {
	            this.entrada.close();
	        } catch (IllegalStateException e) {
	            throw new IllegalStateException("ERRO AO FECHAR O ARQUIVO");
	        }

	    }
	
}
