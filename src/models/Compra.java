package models;

import java.util.Calendar;

public class Compra {
	
	 private Cliente cliente;
	    private Calendar data;
	    private double valor;

	    public Compra() {

	    }

	    public Compra(Cliente cliente, Calendar data, double valor) {
	        this.cliente = cliente;
	        this.data = data;
	        this.valor = valor;
	    }

	    public Cliente getCliente() {
	        return cliente;
	    }

	    public void setCliente(Cliente cliente) {
	        this.cliente = cliente;
	    }

	    public Calendar getData() {
	        return data;
	    }

	    public void setData(Calendar data) {

	        this.data = data;
	    }

	    public double getValor() {
	        return valor;
	    }

	    public void setValor(double valor) {
	        this.valor = valor;
	    }

	    public static String formatar(Calendar data) {
	        int dia = data.get(Calendar.DATE);
	        int mes = data.get(Calendar.MONTH) + 1;
	        int ano = data.get(Calendar.YEAR);
	        return (dia + "/" + mes + "/" + ano);
	    }

	    public String toStringArquivo(int codigo) {
	        if(codigo == 5){	            
	            ClienteEspecial clienteEsp = new ClienteEspecial();            
	            return cliente.getNome() + ";" + cliente.getCpf() + ";" + clienteEsp.getValeCompra() + ";" + formatar(this.getData()) + ";" + this.valor;     
	        } else {
	            return cliente.getNome() + ";" + cliente.getCpf() + ";" + formatar(this.getData()) + ";" + this.valor; 
	        }
	    }
	    
	    @Override
	    public String toString() {
	        return "Compra{" + "cliente=" + cliente + ", data=" + formatar(this.getData()) + ", valor=" + valor + '}';
	    }
	
}
