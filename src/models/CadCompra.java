package models;

import java.util.ArrayList;
import java.util.Calendar;

import interfaces.Ordenacao;
import interfaces.Vetor;

public class CadCompra implements Ordenacao, Vetor {

	  private ArrayList<Compra> vetCompra;

	    public CadCompra() {
	    }

	    public CadCompra(ArrayList<Compra> vetCompra) {
	        this.vetCompra = vetCompra;
	    }

	    public ArrayList<Compra> getVetCompra() {
	        return vetCompra;
	    }

	    public void setVetCompra(ArrayList<Compra> vetCompra) {
	        this.vetCompra = vetCompra;
	    }

	    @Override
	    public void insercaoDireta() {

	        int i, j;
	        int qtdElementos = vetCompra.size();
	        Compra temp;
	        for (i = 1; i < qtdElementos; i++) {
	            temp = this.vetCompra.get(i);
	            j = i - 1;

	            while ((j >= 0) && (this.vetCompra.get(j).getCliente().getCpf().compareTo(temp.getCliente().getCpf())) > 0) {
	                this.vetCompra.add(j + 1, this.vetCompra.get(j--));

	            }
	            if ((j >= 0) && (this.vetCompra.get(j).getCliente().getCpf().compareTo(temp.getCliente().getCpf())) == 0) {
	                if ((j >= 0) && (this.vetCompra.get(j).getData().compareTo(temp.getData())) > 0) {
	                    this.vetCompra.add(j + 1, this.vetCompra.get(j--));
	                }
	            }
	            this.vetCompra.add(j + 1, temp);
	        }

	    }

	    @Override
	    public void quickSort() {
	        ordena(0, this.vetCompra.size() - 1);
	    }

	    private void ordena(int esq, int dir) {
	        
	        String pivo;
	        int i = esq, j = dir;
	        Compra temp;

	        pivo = this.vetCompra.get(i + j / 2).getCliente().getCpf();
	        
	        do {
	            while (this.vetCompra.get(i).getCliente().getCpf().compareTo(pivo) < 0) {
	                i++;
	            }
	            while (this.vetCompra.get(j).getCliente().getCpf().compareTo(pivo) > 0) {
	                j--;
	            }
	            if ((j >= 0) && (this.vetCompra.get(j).getCliente().getCpf().compareTo(pivo)) == 0) {
	                if ((j >= 0) &&
	                        (this.vetCompra.get(j).getData().compareTo(this.vetCompra.get(i + j / 2).getData())) > 0) {
	                    this.vetCompra.add(j + 1, this.vetCompra.get(j--));
	                }
	            }
	            
	            if (i <= j) {
	                temp = this.vetCompra.get(i);
	                this.vetCompra.add(i, this.vetCompra.get(j));
	                this.vetCompra.add(j, temp);
	                i++;
	                j--;
	            }
	        } while (i <= j);
	        if (esq < j) {
	            ordena(esq, j);
	        }
	        if (dir > i) {
	            ordena(i, dir);
	        }

	    }

	    @Override
	    public void quickComInsercao(int esq, int dir) {//se for menor do que 40, ou j, ele chama o inserção direta quick
	        String pivo;
	        int i = esq, j = dir;
	        Compra temp;

	        pivo = this.vetCompra.get(i + j / 2).getCliente().getCpf();
	        do {
	            while (this.vetCompra.get(i).getCliente().getCpf().compareTo(pivo) == -1) {
	                i++;
	            }
	            while (this.vetCompra.get(j).getCliente().getCpf().compareTo(pivo) == 1) {
	                j--;
	            }
	            if (i <= j) {
	                temp = this.vetCompra.get(i);
	                this.vetCompra.add(i, this.vetCompra.get(j));
	                this.vetCompra.add(j, temp);
	                i++;
	                j--;
	            }
	        } while (i <= j);
	        if (esq < j) {
	            ordena(esq, j);
	        }
	        if (dir > i) {
	            ordena(i, dir);
	        }
	    }
	    
	    public void insercaoDiretaQuick(int ini, int fim) {

	        int i, j;
	        Compra temp;
	        for (i = 1; i < vetCompra.size(); i++) {
	            temp = this.vetCompra.get(i);
	            j = i - 1;

	            while ((j >= 0)
	                    && (this.vetCompra.get(j).getCliente().getCpf().compareTo(temp.getCliente().getCpf())) > 0) {
	                this.vetCompra.add(j + 1, this.vetCompra.get(j--));

	            }
	            if ((j >= 0) && (this.vetCompra.get(j).getCliente().getCpf().compareTo(temp.getCliente().getCpf())) == 0) {
	                if ((j >= 0) && (this.vetCompra.get(j).getData().compareTo(temp.getData())) > 0) {
	                    this.vetCompra.add(j + 1, this.vetCompra.get(j--));
	                }
	            }
	            this.vetCompra.add(j + 1, temp);
	        }

	    }

	    
	    @Override
	    public void shellSort() {
	        int i, j, h;
	        Compra temp;

	        h = 1;
	        do {
	            h = 3 * h + 1;
	        } while (h < vetCompra.size());

	        do {
	            h = h / 3;
	            for (i = h; i < vetCompra.size(); i++) {
	                temp = vetCompra.get(i);
	                j = i;

	                while (vetCompra.get(j - h).getCliente().getCpf().compareTo(temp.getCliente().getCpf()) > 0) {
	                    vetCompra.add(j, vetCompra.get(j - h));
	                    j -= h;
	                    if (j < h) {
	                        break;
	                    }
	                }
	                if ((j >= 0) && (this.vetCompra.get(j).getCliente().getCpf().compareTo(temp.getCliente().getCpf())) == 0) {
	                    if ((j >= 0) && (this.vetCompra.get(j).getData().compareTo(temp.getData())) > 0) {
	                        this.vetCompra.add(j + 1, this.vetCompra.get(j--));
	                }
	            }
	                vetCompra.add(j, temp);
	            }
	        } while (h != 1);
	    }

	    @Override
	    public Compra get(int pos) {

	        Compra compra = vetCompra.get(pos);
	        if (compra != null) {
	            return compra;
	        }
	        return null;

	    }

	    @Override
	    public void insere(Compra compra) {
	        if (vetCompra == null) {
	        	vetCompra = new ArrayList<Compra>();
	        }
	    	vetCompra.add(compra);
	    }

	    @Override
	    public void remove(String cpf, Calendar data) {
	        for (Compra c : vetCompra) {
	            if (c.getCliente().getCpf().equals(cpf)) {
	                if (c.getData() == data) {
	                    vetCompra.remove(c);
	                }
	            }

	        }

	    }

	
}
