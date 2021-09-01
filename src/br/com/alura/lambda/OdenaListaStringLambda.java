package br.com.alura.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OdenaListaStringLambda {

    public static void main(String[] args) {

        //Criando uma lista com itens de String
        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("editora casa do codigo");
        palavras.add("caelum");


        //Com Java 8 podemos ordernar assim:
        //Tenha em mente que o metodo sort() está na interface List e ele tem corpo!
        //É estranho pois até então metodo em interface só tinha assinatura, mas é que agora existe
        // Default Methods, que é um metodo de interface que tem corpo! E esse corpo é usado por
        // todas as classes que implementam a interface

        //Usando a função lambda!
        //Como sort tem que receber um Comparator e Comparator é uma interface de um método só (sem ser default),
        // nossa funcap lambda será a implementação do método compare() da interface Comparator.
        //Quando a função tem apenas um método abstrato (assinatura), chamamos essa de Interface Funcional
//        palavras.sort((String s1, String s2) -> {
//                if(s1.length() < s2.length()){
//                    return -1;
//                }
//                if(s1.length() > s2.length()){
//                    return 1;
//                }
//                return 0;
//            });

        //Podemos omitir os tipos de argumento do lambda, pois quase sempre ele consegue inferir:
//        palavras.sort((s1, s2) -> {
//            if(s1.length() < s2.length()){
//                return -1;
//            }
//            if(s1.length() > s2.length()){
//                return 1;
//            }
//            return 0;
//        });

        //Essa comparação de tamanho de string poderia usar um metodo estatico de Integer e isso
        // deixaria nosso lambda apenas com um comando, ou seja, poderiamos fazer tudo na mesma linha:
        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));


        //Percorrendo uma lista usando um outro Default Methods da interface List, que se chama forEach()
        //Veja que esse método recebe um objeto do tipo Consumer, logo temos que criá-lo,
        // vamos criá-lo agora com função lambda.

        //Usando a função lambda!
        //Como forEach tem que receber um Consumer e consumer é uma interface de um método só (sem ser default),
        // nossa funcao lambda será a implementação do método accpet() da interface Consumer.
        //Quando a função tem apenas um método abstrato (assinatura), chamamos essa de Interface Funcional
//        palavras.forEach((String s) ->{
//                System.out.println(s);
//            });

        //Devido a função ter apenas um argumento, podemos fazer da seguinte maneira
//        palavras.forEach(s ->{
//            System.out.println(s);
//        });

        //Devido a função ter apenas um statement (1 comando), podemos fazer da seguinte maneira
        palavras.forEach(s -> System.out.println(s));


    }
}


