package br.com.core.number;

public class EsperaCircular {

    public static void main(String[] args) {
        //isso gerara uma sequencia de 0 ateh (NUMERO-1)
        int Numero = 2;
        int MAX_LOOP = 2;
        for (int i = 0; i < MAX_LOOP; i++) {
            System.out.println(( (i+1) % Numero));
        }
    }
}
