package arvore;

import java.util.ArrayList;

public class Lista {
	private ArrayList<NoHash> lista;
	
	public Lista() {
		lista = new ArrayList<NoHash>();
	}
	
	public void add(NoHash no) {
		lista.add(no);
	}
	
	public String imprime() {
		String temp = "";
		for(NoHash no : lista) {
			temp += no.getCompra().getCliente().getCpf() + " | ";
		}
		return temp;
	}
	
	public NoHash pesquisa (String cpf) {
		if(eVazia()) {
			return null;
		}
		for(NoHash no : lista) {
			if(no.getCompra().getCliente().getCpf().equals(cpf)) {
				return no;
			}
		}
		return null;
	}
	
	public boolean eVazia() {
		if(lista.size() == 0) return true;
		
		return false;
	}
}
