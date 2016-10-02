
package br.com.core.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomUtil {
    public static void main(String[] args) {
        List lista = new ArrayList();
        int n = 10000;
        int inicio = 10;
        int fim = 50;
        for (int i = 0; i < n; i++) {
            lista.add(RandomUtil.randomRange(inicio, fim));
        }
        Collections.sort(lista);
        for (int i = 0; i < n; i++) {
            System.out.println(i+" : "+(lista.get(i)));            
        }
    }
    public static int randomRange(int inicio, int fim){
        return (new Random().nextInt((fim + 1) - inicio) + inicio);
    }
    
}
