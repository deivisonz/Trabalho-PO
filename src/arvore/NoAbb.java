package arvore;

import java.util.ArrayList;

import models.Compra;

public class NoAbb {
	private String CPF;
	private ArrayList<Compra> lista; 
	private NoAbb esq, dir;
	private Compra compra;

	public NoAbb(Compra compra) {
		super();
		this.lista = new ArrayList<Compra>();
		this.lista.add(compra);
		this.CPF = compra.getCliente().getCpf();
	}

	public NoAbb() {
		super();
		this.compra = null;
	}

	public Compra getCompra() {
		return compra;
	}

	public NoAbb getDir() {
		return dir;
	}

	public void setDir(NoAbb dir) {
		this.dir = dir;
	}

	public NoAbb getEsq() {
		return esq;
	}

	public void setEsq(NoAbb esq) {
		this.esq = esq;
	}
	
	public void insereCompra(Compra compra) {
		this.lista.add(compra);
	}
	
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	public ArrayList<Compra> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Compra> lista) {
		this.lista = lista;
	}

	public String imprime() {
		String resp = "";
		for(int i = 0; i >= lista.size()-1; i++) {
			resp += lista.toString()+" | ";
			}
		return resp;
	}

	@Override
	public String toString() {
		return "" + this.compra.getCliente().getCpf();
	}

}
