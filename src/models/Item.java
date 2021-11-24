package Arvore;

public class Item {
	private int chave;
	// podem ter outros atributos, de acordo com a sua aplicacao
	public Item(int chave) {
		super();
		this.chave = chave;
	}
	public int getChave() {
		return chave;
	}
	public void setChave(int chave) {
		this.chave = chave;
	}
	@Override
	public String toString() {
		return "Item [chave=" + chave + "]";
	}
}
