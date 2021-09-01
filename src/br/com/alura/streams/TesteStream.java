package br.com.alura.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TesteStream {

    public static void main(String[] args) {

        /*
        Tenha em Mente que Stream não é Collection!!!
         */

        //Criando uma lista de cursos e adicionando diversos cursos
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("JAva 8", 113));
        cursos.add(new Curso("C", 55));

        //Ordenando os itens pela quantidade de aluno. Usamos method reference, poderia ter sido lambda.
        cursos.sort(Comparator.comparing(Curso::getAlunos));

        //Percorrendo a lista e cada item será printado. Usamos Method Reference
        //O codigo a seguir mostrará o endereço de memoria, pois na classe Curso não implementamos o toString(),
        // e não queremos implementá-lo, pois queremos usar o getNome(), dessa maneira temo que usar Lambda,
        // no lugar do method reference.
        //cursos.forEach(System.out::println);
        cursos.forEach(c -> System.out.println(c.getNome()));

        //Imprimir cursos que possuem mais de 100 alunos, usando Stream (filter)
        //Toda Collection tem Stream
        //Toda Stream devolve Stream
        //Tenha em mente que o Stream não altera a estrutura original!
        //Stream usa o Padrão Interface Fluente.
        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .forEach(c -> System.out.println(c.getNome()));

        //Filtrar cursos que possuem mais de 100 alunos e depois imprimir quantos alunos tem cada curso
        //Poderiamos fazer igual exemplo anterior e impreimir o g.getAlunos(), mas assim não podemos trabalhar com essa quantidade.
        //Então vamos usar o map(), pois dado um Stream de Cursos eu vou mapear para um Stream de int e assim poderei manipulá-los.
        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .map(c -> c.getAlunos())
                .forEach(total -> System.out.println(total));

        //Mesmo exemplo anterior, usando Method Reference:
        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .map(Curso::getAlunos)
                .forEach(System.out::println);

        //E se eu quisesse somar a quantidade de alunos dos cursos que possuem mais de 100 alunos?
        //Será muito parecido com o código anterior, só temos que usar o mapInt no lugar do map,
        //pois com mapInt teremos método de Integer, como sum(). Outra diferença que temos que guardar a soma numa variavel!
        int totalALunos = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .sum();

        System.out.println(totalALunos);
    }
}
