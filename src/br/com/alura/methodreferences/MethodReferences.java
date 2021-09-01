package br.com.alura.methodreferences;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MethodReferences {

    public static void main(String[] args) {

        /*
        Tenha em mente que um Method References é uma maneira de escrever uma Lambda!
        Method References NÃO é Reflection!!!!
         */

        //Criando uma lista com itens de String
        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("editora casa do codigo");
        palavras.add("caelum");

        //Criando um Comparator via Lambda:
//        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));


        //Sabemos que no Java nada recebe Lambda! Um função pode receber uma Interface Funcional,
        // mas é comum falarmos que uma função recebe um Lambda nesses casos!
        //Veremos que na interface Comparator existe métodos default estaticos! Ou seja, metodos da interface
        // que possuem corpo, por exemplo o método comparing() que recebe como argumento uma function,
        // e quando algo recebe uma function podemos pensar no LAMBDA!
        palavras.sort(Comparator.comparing(s -> s.length()));

        //Uma alternativa de como escrever a função lambda (a mais usada)
        //Pois a função lambda vamos usar o método lenght() de um objeto do tipo String, logo podemos escrever:
        //Essa maneira se chama Method References, que é uma função lambda
        palavras.sort(Comparator.comparing(String::length));

        //Ainda é possivel diminuir esse codigo, deixando a interface Comparator com import estatico
        //palavras.sort(comparing(String::length));

        //Se ficou dificil entender, vamos quebrar o mesmo código em duas linhas:
        Comparator<String> comparador = Comparator.comparing(s -> s.length());
        palavras.sort(comparador);

        //Se ainda está dificil entender, vamos quebrar o mesmo código de outro jeito:
        Function<String, Integer> funcao = s -> s.length();
        Comparator<String> comparador2 = Comparator.comparing(funcao);
        palavras.sort(comparador2);

        //Só para exemplificar, vamos mostrar como resolver o código anterior com classe anonima:
        Function<String, Integer> funcao2 = new Function<String, Integer>() {

            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        Comparator<String> comparador3 = Comparator.comparing(funcao2);
        palavras.sort(comparador3);

//---------------------------------------------------------------------------------------

        //Printando os elementos de uma lista atraves do lambda
        palavras.forEach(s -> System.out.println(s));

        //Fazendo o mesmo, agora com Method References:
        palavras.forEach(System.out::println);
    }
}
