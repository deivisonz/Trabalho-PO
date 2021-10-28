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
	    public void quickSort(int inicio, int fim) {
	    	if (inicio < fim) {
	    		int posicaoPivo = separar(inicio, fim);
                quickSort(inicio, posicaoPivo - 1);
                quickSort(posicaoPivo + 1, fim);
	    	}
	    }
	    
	    private int separar(int inicio, int fim) {
	    	Compra pivo = this.vetCompra.get(inicio);
	    		    	
            int i = inicio + 1, f = fim;
            while (i <= f) {
               if (compararCpfOuData(i, pivo) <= 0) {
            	   i++;
               } else if (compararCpfOuData(pivo, f) < 0) {
            	   f--;
               } else {
            	   Compra troca = this.vetCompra.get(i);
                   this.vetCompra.set(i, this.get(f));
                   this.vetCompra.set(f, troca);
                   i++;
                   f--;
               }
            }
            
            this.vetCompra.set(inicio, this.vetCompra.get(f));
            this.vetCompra.set(f, pivo);
             
            return f;
            
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

		//VALIDAR
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

	    //VALIDAR
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
	    
	    //VALIDAR
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
