package br.com.alura.defaultmethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OdenaListaString {

    public static void main(String[] args) {

        //Criando uma lista com itens de String
        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("editora casa do codigo");
        palavras.add("caelum");

        //Ordenando a lista, os itens são String, por padrão a ordenação será em ordem alfabetica.
        //Só é possivel ordenar String, pq toda String implementa a interface Comparable
        Collections.sort(palavras);
        System.out.println(palavras);

        //Como ordernar palavras por outra forma? Por exemplo por tamanho de letras...
        //Temos que criar um objeto Comparator (por isso criamos a classe ComparandoPorTamanho)
        //E ao chamar sort() passar a lista e o objeto COmparator
        Comparator<String> comparador = new ComparandoPorTamanho();
        Collections.sort(palavras, comparador);
        System.out.println(palavras);

        //Com Java 8 podemos ordernar assim:
        //Tenha em mente que o metodo sort() está na interface List e ele tem corpo!
        //É estranho pois até então metodo em interface só tinha assinatura, mas é que agora existe
        // Default Methods, que é um metodo de interface que tem corpo! E esse corpo é usado por
        // todas as classes que implementam a interface.
        palavras.sort(comparador);
        System.out.println(palavras);

        //Percorrendo uma lista com for:
//        for(String palavra : palavras){
//            System.out.println(palavra);
//        }

        //Percorrendo uma lista usando um outro Default Methods da interface List, que se chama forEach()
        //Veja que esse método recebe um objeto do tipo Consumer, logo temos que criá-lo,
        Consumer<String> consumidor = new ImprimeNaLinha();
        palavras.forEach(consumidor);
    }
}

class ImprimeNaLinha implements  Consumer<String>{

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}

class ComparandoPorTamanho implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if(s1.length() < s2.length()){
            return -1;
        }
        if(s1.length() > s2.length()){
            return 1;
        }
        return 0;
    }
}
