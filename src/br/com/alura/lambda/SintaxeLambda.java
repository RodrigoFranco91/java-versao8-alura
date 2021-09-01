package br.com.alura.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class SintaxeLambda {
    public static void main(String[] args) {

        //Criando uma lista com itens de String
        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("editora casa do codigo");
        palavras.add("caelum");

        /*

        Tenha em mente que a função lambda funciona assim: antes do simbolo -> vem os argumentos e depois do -> vem o comando que pode ter
retorno. E a função lambda só pode ser passada como argumento em métodos que recebem um objeto do tipo Interface Funcional, que é
a interface que tem apenas um método abstrato!

         */

        //Entenda a SINTAXE do lambda:

        //Mas poderiamos fazer assim, que também funcionaria:

        Consumer<String> impressor = s -> System.out.println(s);
        palavras.forEach(impressor);

        //O código anterior funciona, pois Consumer é uma interface funcional, que seu método abstrato recebe apenas um argumento (foi
        //representado por s) e não retorna nada! LOgo o código a seguir NÃO funcionaria:

        //Comparator<String> comparador = s -> System.out.println(s);
        //palavras.sort(comparador);

        //O código anterior não funciona, pois Comparator é uma interface funcional, mas seu método abstrato recebe DOIS argumentos e retorna
        //um int, logo para funcionar teria que ser assim:

        Comparator<String> comparador = (s1, s2) -> 1;
        palavras.sort(comparador);

    }
}
