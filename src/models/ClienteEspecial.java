package models;

public class ClienteEspecial extends Cliente {

    private double valeCompra;
    
    public ClienteEspecial() {
    }

    public ClienteEspecial(double valeCompra) {
        this.valeCompra = valeCompra;
    }

    public ClienteEspecial(double valeCompra, String nome, String cpf) {
        super(nome, cpf);
        this.valeCompra = valeCompra;
    }

    public double getValeCompra() {
        return valeCompra;
    }

    public void setValeCompra(double valeCompra) {
        this.valeCompra = valeCompra;
    }
	
}
