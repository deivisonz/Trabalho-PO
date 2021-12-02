package arvore;

import java.util.ArrayList;

import constantes.Constantes;
import models.Compra;

public class NoAvl {
	private Compra compra;
	private NoAvl dir;
	private NoAvl esq;
	private ArrayList<Compra> lista;
	private byte fb;
	
	public NoAvl() {
		compra = null;
		lista = new ArrayList<Compra>();
		fb = 0;
	}

	public NoAvl(Compra compra) {
		this.compra = compra;
		lista = new ArrayList<Compra>();
		lista.add(compra);
		fb = 0;
	}
	 
	public NoAvl(Compra compra, NoAvl dir, NoAvl esq, ArrayList<Compra> cPfIgual, byte fb) {
		this.compra = compra;
		this.dir = dir;
		this.esq = esq;
		this.lista = cPfIgual;
		this.fb = fb;
	}
	
	public byte getFb() {
		return fb;
	}

	protected void setFb(byte fb) {
		this.fb = fb;
	}

	public NoAvl getDir() {
		return dir;
	}

	public void setDir(NoAvl dir) {
		this.dir = dir;
	}

	public NoAvl getEsq() {
		return esq;
	}

	public void setEsq(NoAvl esq) {
		this.esq = esq;
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
			temp += "data: " + Constantes.FORMATO_DATA.format(compra.getData().getTime()) + " \t valor: R$" + compra.getValor() + "\n";
		}
		temp += "Total: R$" + String.format("%.2f", getTotal()) + "\n\n";
		return temp;
	}	
	
	
	 
	
	 
	 
}
