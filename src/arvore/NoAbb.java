package arvore;

import java.util.ArrayList;

import constantes.Constantes;
import models.Compra;

public class NoAbb {
	private String CPF;
	private ArrayList<Compra> lista; 
	private NoAbb esq, dir;
	private Compra compra;

	public NoAbb(Compra compra) {
		super();
		this.compra = compra;
		this.lista = new ArrayList<Compra>();
		this.lista.add(compra);
		this.CPF = compra.getCliente().getCpf();
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
