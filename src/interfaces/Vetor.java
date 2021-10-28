package interfaces;

import java.util.Calendar;

import models.Compra;

public interface Vetor {

	public Compra get(int pos);
	    
	public void insere(Compra compra);
	    
	public void remove(String cpf, Calendar data);
	
}
