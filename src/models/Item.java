package models;

public class Item {
	private char chave;
	// podem ter outros atributos, de acordo com a sua aplicacao
	public Item(char chave) {
		super();
		this.chave = chave;
	}
	public char getChave() {
		return chave;
	}
	public void setChave(char chave) {
		this.chave = chave;
	}
	@Override
	public String toString() {
		return "Item [chave=" + chave + "]";
	}
}
