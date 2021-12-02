package arvore;

import java.util.ArrayList;

import constantes.Constantes;
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
	
	@Override
	public String toString() {
		String temp = "CPF "+ compra.getCliente().getCpf() + " \t NOME " + compra.getCliente().getNome() +"\n";
		for(Compra compra : lista) {
			temp += "data: " + Constantes.FORMATO_DATA.format(compra.getData().getTime())+ " \t valor: R$" + compra.getValor() + "\n";
		}
		temp += "Total: R$" + String.format("%.2f", getTotal()) + "\n\n";
		return temp;
	}
	 
}
