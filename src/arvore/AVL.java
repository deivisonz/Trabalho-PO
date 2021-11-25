package Arvore;

import java.util.ArrayList;

import models.Compra;

public class AVL {
	private NoAvl raiz;
	private boolean h;
	private int nElem;

	public AVL() {
		this.raiz = null;
		this.h = true;
	}

	public boolean eVAzia() {
		if (this.raiz == null) {
			return true;
		} else {
			return false;
		}
	}

	public NoAvl getRaiz() {
		return raiz;
	}

	public int getnElem() {
		return nElem;
	}

	public NoAvl pesquisar(String elem) {
		return pesquisar(elem, this.raiz);
	}

	public NoAvl pesquisar(String elem, NoAvl no) {
		if (no == null) {
			return null;
		} else {
			if (elem.compareTo(no.imprime().get(0).getCliente().getCpf()) < 0) {
				no = pesquisar(elem, no.getEsq());
			} else if (elem.compareTo(no.imprime().get(0).getCliente().getCpf()) > 0) {
				no = pesquisar(elem, no.getDir());
			}
			return no;
		}
	}

	public void inserir(Compra compra) {
		NoAvl no = pesquisar(compra.getCliente().getCpf());
		if (no == null) {
			this.raiz = this.inserir(compra, this.raiz);
		}
	}

	private NoAvl inserir(Compra compra, NoAvl no) {
		if (no == null) {
			NoAvl novo = new NoAvl(compra);
			this.nElem++;
			this.h = true;
			return novo;
		} else if (compra.getCliente().getCpf().compareTo(no.getCompra().getCliente().getCpf()) < 0) {
			no.setEsq(this.inserir(compra, no.getEsq()));
			no = this.balancearDir(no);
		} else if (compra.getCliente().getCpf().compareTo(no.getCompra().getCliente().getCpf()) > 0) {
			no.setDir(this.inserir(compra, no.getDir()));
			no = this.balancearEsq(no);
		} else {
			no.insereCompra(compra);
		}
		return no;
	}

	private NoAvl balancearDir(NoAvl no) {
		if (this.h)
			switch (no.getFb()) {
			case 1:
				no.setFb((byte) 0);
				this.h = false;
				break;
			case 0:
				no.setFb((byte) -1);
				break;
			case -1:
				no = this.rotacaoDireita(no);
			}
		return no;
	}

	private NoAvl balancearEsq(NoAvl no) {
		if (this.h)
			switch (no.getFb()) {
			case -1:
				no.setFb((byte) 0);
				this.h = false;
				break;
			case 0:
				no.setFb((byte) -1);
				break;
			case 1:
				no = this.rotacaoEsquerda(no);
			}
		return no;
	}

	private NoAvl rotacaoDireita(NoAvl no) {
		NoAvl temp1, temp2;
		temp1 = no.getEsq();
		if (temp1.getFb() == -1) {
			no.setEsq(temp1.getDir());
			temp1.setDir(no);
			no.setFb((byte) 0);
			no = temp1;
		} else {
			temp2 = temp1.getDir();
			temp1.setDir(temp2.getEsq());
			temp2.setEsq(temp1);
			no.setEsq(temp2.getDir());
			temp2.setDir(no);
			if (temp1.getFb() == -1)
				no.setFb((byte) 1);
			else
				no.setFb((byte) 0);
			if (temp2.getFb() == -1)
				temp1.setFb((byte) 1);
			else
				temp1.setFb((byte) 0);
			no = temp2;
		}
		no.setFb((byte) 0);
		this.h = false;
		return no;
	}

	private NoAvl rotacaoEsquerda(NoAvl no) {
		NoAvl temp1, temp2;
		temp1 = no.getDir();
		if (temp1.getFb() == -1) {
			no.setDir(temp1.getEsq());
			temp1.setEsq(no);
			no.setFb((byte) 0);
			no = temp1;
		} else {
			temp2 = temp1.getEsq();
			temp1.setEsq(temp2.getDir());
			temp2.setDir(temp1);
			no.setDir(temp2.getEsq());
			temp2.setEsq(no);
			if (temp1.getFb() == -1)
				no.setFb((byte) 1);
			else
				no.setFb((byte) 0);
			if (temp2.getFb() == -1)
				temp1.setFb((byte) 1);
			else
				temp1.setFb((byte) 0);
			no = temp2;
		}
		no.setFb((byte) 0);
		this.h = false;
		return no;
	}

	public ArrayList<NoAvl> CamCentral() {
		ArrayList<NoAvl> vetor = new ArrayList<NoAvl>(this.nElem);
		return (fazCamCentral(vetor, this.raiz));
	}

	private ArrayList<NoAvl> fazCamCentral(ArrayList<NoAvl> vetor, NoAvl no) {
		if (no != null) {
			vetor = fazCamCentral(vetor, no.getEsq());
			vetor.add(no);
			vetor = fazCamCentral(vetor, no.getDir());
		}
		return vetor;
	}

	public String imprime() {
		ArrayList<NoAvl> vetor = CamCentral();
		String temp = "";
		for (NoAvl no : vetor) {
			temp += no.getCompra().getCliente().getCpf() + " | ";
		}
		return temp;
	}

}
