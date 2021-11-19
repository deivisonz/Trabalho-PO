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
	      
	    	int j, i;   	    
    	    Compra key;
    	    
    	    for (j = 1; j < this.vetCompra.size(); j++) {
    	      key = this.vetCompra.get(j);  	    	      
    	      for (i = j - 1; (i >= 0) && (compararCpfOuData(i, key) > 0); i--) {
    	    	  this.vetCompra.set(i + 1, this.vetCompra.get(i));
    	      }    	      
    	      this.vetCompra.set(i + 1, key);
    	    }
	    		 
	    }

	    @Override
	    public void quickSort() {
	    	ordenar(0, this.getVetCompra().size() -1);	   
	    }
	    
	    private void ordenar(int esq, int dir) {		
	    	int i = esq, j = dir;
	    	
	    	Compra pivo, temp;
			pivo = this.getVetCompra().get((i+j)/2);
			do {
				while (compararCpfOuData(i, pivo) < 0) {
					i++;
				}
				
				while (compararCpfOuData(j, pivo) > 0) {
					j--;
				}
				
				if (i <= j) {
					temp = this.getVetCompra().get(i);
					this.vetCompra.set(i, this.getVetCompra().get(j));
					this.vetCompra.set(j, temp);				
					i++;
					j--;
				}			
			} while (i <= j);
			
			if (esq < j) 
				ordenar(esq, j);
			
			if (dir > i) 
				ordenar(i, dir);
	    }

	    
		@Override
		public void shellSort() {	        
	    	int i , j , size = this.getVetCompra().size();
			Compra temp;
	 	    
	 	    int incremento = 1;
	 	    while(incremento < size) {
	 	        incremento = 3 * incremento + 1;
	 	    }
	 	     
	 	    while (incremento > 1) {
	 	        incremento /= 3;
	 	        
	 	        for(i = incremento; i < size; i++) {
	 	            temp = this.getVetCompra().get(i);
	 	            j = i - incremento;
	 	           
	 	            while (j >= 0 && compararCpfOuData(temp, j) < 0) {
	 	                this.getVetCompra().set(j + incremento, this.get(j));	 	            	
	 	                j -= incremento;
	 	            }
	 	           this.getVetCompra().set(j + incremento, temp);
	 	        }
	 	    }	  
	    
    	}

	    @Override
    public void quickComInsercao() {
        ordenarQuick(0, this.vetCompra.size() - 1);

    }

    private void ordenarQuick(int esq, int dir) {

        int i = esq, j = dir;
        Compra temp, pivo;

        pivo = this.vetCompra.get((i + j) / 2);
        do {
            while (compararCpfOuData(i, pivo) < 0) {
                i++;
            }
            while (compararCpfOuData(j, pivo) > 0) {
                j--;
            }
            if (i <= j) {
                temp = this.vetCompra.get(i);
                this.vetCompra.set(i, this.vetCompra.get(j));
                this.vetCompra.set(j, temp);
                i++;
                j--;
            }
        } while (i <= j);
        if (esq < j) {
            if (j - esq <= 20) {
                insercaoQuick(esq, j);
            } else {
                ordenarQuick(esq, j);
            }
        }
        if (dir > i) {
            if (dir - i <= 20) {
                insercaoQuick(i, dir);
            } else {
                ordenarQuick(i, dir);
            }
        }

    }
    
    public void insercaoQuick(int ini, int fim) {
        int i, j;
        Compra temp;
        for (j = ini; j <= fim; j++) {
            temp = this.vetCompra.get(j);
            for (i = j - 1; (i >= 0) && (compararCpfOuData(i, temp) > 0); i--) {
                this.vetCompra.set(i + 1, this.vetCompra.get(i));
            }
            this.vetCompra.set(i + 1, temp);
        }

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
	            if (c.getCliente().getCpf().equals(cpf) && c.getData() == data) {
            		vetCompra.remove(c);                
	            }
	        }
	    }
	    
	    private int compararCpfOuData(int indiceCompraUm, Compra compraDois) {
	    	int comparacao = this.vetCompra.get(indiceCompraUm).getCliente().getCpf().compareTo(compraDois.getCliente().getCpf());
	    	if (comparacao == 0) {
	    		comparacao = this.vetCompra.get(indiceCompraUm).getData().compareTo(compraDois.getData());
	    	}
	    	return comparacao;
	    }
	    
	    private int compararCpfOuData(Compra compraUm, int indiceCompraDois) {
	    	int comparacao = compraUm.getCliente().getCpf().compareTo(this.vetCompra.get(indiceCompraDois).getCliente().getCpf());
	    	if (comparacao == 0) {
	    		comparacao = compraUm.getData().compareTo(this.vetCompra.get(indiceCompraDois).getData());
	    	}
	    	return comparacao;
	    }

	
}
