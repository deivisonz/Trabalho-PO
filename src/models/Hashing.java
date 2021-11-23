package models;

public class Hashing {

    public int Hashing(int chave, int M) {
        return chave / M;
    }

    public int Hashing(String chave) {
        char carac;
        int i, soma = 0;
        for (i = 0; i < chave.length(); i++) {
            carac = chave.charAt(i);
            soma += Character.getNumericValue(carac);
        }
        return soma;
    }

}
