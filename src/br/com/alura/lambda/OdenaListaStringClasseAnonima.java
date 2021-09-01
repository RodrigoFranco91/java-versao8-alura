package br.com.alura.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OdenaListaStringClasseAnonima {

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
        //Temos que criar um objeto Comparator, antes usamos a classe ComparandoPorTamanho que implementava comparator,
        // agora vamos usar uma classe anonima
        //E ao chamar sort() passar a lista e o objeto COmparator
        //Classe anonima:
        Comparator<String> comparador = new Comparator<String>() {
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
        };
        Collections.sort(palavras, comparador);
        System.out.println(palavras);

        //Com Java 8 podemos ordernar assim:
        //Tenha em mente que o metodo sort() está na interface List e ele tem corpo!
        //É estranho pois até então metodo em interface só tinha assinatura, mas é que agora existe
        // Default Methods, que é um metodo de interface que tem corpo! E esse corpo é usado por
        // todas as classes que implementam a interface.
        palavras.sort(comparador);
        System.out.println(palavras);

        //Classe anonima sendo usada sem criar uma referencia. É mais usada assim, direto como parametro:
        palavras.sort(new Comparator<String>() {
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
        });

        //Percorrendo uma lista usando um outro Default Methods da interface List, que se chama forEach()
        //Veja que esse método recebe um objeto do tipo Consumer, logo temos que criá-lo,
        // vamos criá-lo também com classe anonima.
        //Classe anonima:
//        Consumer<String> consumidor = new Consumer<String>(){
//
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };
//        palavras.forEach(consumidor);

        //Classe anonima sendo usada sem criar uma referencia. É mais usada assim, direto como parametro:
        palavras.forEach(new Consumer<String>(){

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}


