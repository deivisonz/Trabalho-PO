package Arvore;

import models.Compra;

public class NoAbb {
	private Compra compra;
	private NoAbb dir, esq;

	public NoAbb(Compra compra) {
		super();
		this.compra = compra;
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

	@Override
	public String toString() {
		return "" + this.compra.getCliente().getCpf();
	}

}
