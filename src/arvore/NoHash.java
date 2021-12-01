package arvore;

import java.util.ArrayList;

import models.Compra;

public class NoHash {

	private Compra compra;
	private ArrayList<Compra> lista;
	
	public NoHash() {
		compra = null;
		lista = new ArrayList<Compra>();
	}

	public NoHash(Compra compra) {
		this.compra = compra;
		lista = new ArrayList<Compra>();
		lista.add(compra);
	}
	
	public ArrayList<Compra> getCPFIgual() {
		return lista;
	}

	public void setCPFIgual(ArrayList<Compra> cPfIgual) {
		this.lista = cPfIgual;
	}

	public Compra getCompra() {
		return compra;
	}
	
	public double getTotal() {
		double total = 0;
		for(Compra compra: lista) {
			total += compra.getValor();
		}
		return total;
	}
	 
	 
}
