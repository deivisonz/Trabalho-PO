package Arvore;

import models.Compra;

public class Hashing {
	private Lista[] vetor;
	
	public Hashing(int tam) {
		super();
		vetor = new Lista[tam];
		for (int i=0; i<tam; i++) {
			vetor[i] = new Lista();
		}
	}
	private int hashing (String cpf) {
		long auxCpf = Long.parseLong(cpf);
		return (int) (auxCpf%vetor.length);
		}
	public void inserir (Compra compra) {
		int hash = hashing (compra.getCliente().getCpf());
		vetor[hash].add(compra);
	}
	public  Compra pesquisar (String cpf) {
		int hash = hashing(cpf);
		return vetor[hash].pesquisa(cpf);
	}
}
