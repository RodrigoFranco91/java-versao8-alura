package br.com.alura.streams;


import java.util.*;
import java.util.stream.Collectors;

public class TesteStream2 {

    public static void main(String[] args) {

        //Criando uma lista de cursos e adicionando diversos cursos
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("JAva 8", 113));
        cursos.add(new Curso("C", 55));

        //Filtrando elementos, no caso cursos que tem 100 ou mais alunos
        //Após o filtro eu peguei um item, no caso Curso, aleatoriamente.
        //Veja que o retorno é do tipo Optional, pois pode ter ou não um curso com 100 ou mais alunos.
        Optional<Curso> optionalCurso = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .findAny();

        //Verificando se há um Curso dentro de Optional:
        boolean present = optionalCurso.isPresent();
        if(present){
            //Usamos o get() para tirar o elemento de dentro do Optional.
            Curso cursoPreente = optionalCurso.get();
        }

        //Extraindo do Optional para um Curso, caso optinal não tenha, ele passara o valor null
        Curso curso = optionalCurso.orElse(null);
        System.out.println(curso.getNome());

        //Verifica se Optional tem Curso, se tiver vai printa-lo (Usando Method Reference)
        optionalCurso.ifPresent(System.out::println);

        //Verifica se Optional tem Curso, se tiver vai printa-lo (Usando Lambda)
        optionalCurso.ifPresent(c -> System.out.println(c.getNome()));

        //Utilizando o Optional juntamente com Stream.
        //O retorno do average() é Optional, pois caso não tivesse itens ocorreria uma divisao por zero (estamos calculamdo a media)
        OptionalDouble average = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(c -> c.getAlunos())
                .average();

        /*
            Lembra que Stream NÃO ALTERA A COLLECTION ORIGINAL?!!!!
            Veremos como colocar o resultado das operações em outra Collection ou então na prórpia Collection.
            Lembre-se Stream devolve Stream, então uma simples atribuição não vai funcionar!
            Teremos que ussar o Metodo collect() e dentro dele sempre chamar Collectors. Veja
         */

        //Guardando o resultado das operaçoes em uma nova Lista. POderia usar a mesma lista
        List<Curso> novaLista = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toList());

        //Coletar os itens agora em um Map, lembre-se que Map tem chave e valor!
        Map<String, Integer> mapa = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toMap(
                        //O primeiro é chave e o segundo valor.
                        c -> c.getNome(), c -> c.getAlunos()
                ));

        mapa.forEach((chave, valor) -> System.out.println(valor));

        //Fazendo o mesmo código anterior, mas diretamente
        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toMap(
                        //O primeiro é chave e o segundo valor.
                        c -> c.getNome(), c -> c.getAlunos()))
                .forEach((chave, valor) -> System.out.println(chave + " "+ valor));
    }
}
