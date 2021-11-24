package Arvore;

import Entidades.Compra;

public class NoAvl {

	private byte fb;
	private Compra compra;
	private NoAvl esq, dir;
	
	//Contrutores
	public NoAvl(Compra compra) {
		super();
		this.compra = compra;
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
	
	public String ToString() {
		return ""+this.compra.getCliente().getCpf();
	}
}

