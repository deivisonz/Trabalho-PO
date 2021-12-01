package arvore;

import java.util.ArrayList;

import models.Compra;

public class NoAvl {

	private byte fb;
	private String CPF;
	private ArrayList<Compra> lista; 
	private NoAvl esq, dir;
	private Compra compra;
	
	//Construtores
	public NoAvl(Compra compra) {
		super();
		this.lista = new ArrayList<Compra>();
		this.lista.add(compra);
		this.CPF = compra.getCliente().getCpf();
		this.fb = 0;
	}
	
	public NoAvl() {
		super();
		this.compra = null;
		this.fb = 0;
	}

	//Getters and Setters
	public byte getFb() {
		return fb;
	}

	protected void setFb(byte fb) {
		this.fb = fb;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public NoAvl getEsq() {
		return esq;
	}

	public void setEsq(NoAvl esq) {
		this.esq = esq;
	}

	public NoAvl getDir() {
		return dir;
	}

	public void setDir(NoAvl dir) {
		this.dir = dir;
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

	public ArrayList<Compra> imprime() {
		return this.lista;
	}
	
	public String ToString() {
		return ""+this.compra.getCliente().getCpf();
	}
	
		
}

