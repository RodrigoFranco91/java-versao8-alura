package br.com.alura.data;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Datas {

    public static void main(String[] args) {

        /*
            No Java 8 entrou a API LocalDate (e suas derivadas). São API's para trabalhar com Data!
            Na classe LocalDate tem muitos métodos estaticos.
         */

        //Pega a data de hoje. O formato usado sera ISO do locale, poderemos mudar o formato.
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        //Criando uma data com os valores de: ano, mes e dia.
        LocalDate dataOlimpiadas = LocalDate.of(2016, Month.JUNE, 5);

        //Calculando na mão a diferença de anos:
        int anos = hoje.getYear() - dataOlimpiadas.getYear();
        System.out.println(anos);

        //Calculando diferenca de ano (periodo), usando classe Period:
        //A resposta é P de period, Y de year, M de mes e D de dia
        //O period de resposta terá metodos para ver os dias, meses...
        Period periodo = Period.between(hoje, dataOlimpiadas);
        System.out.println(periodo);
        System.out.println(periodo.getDays());

        //Temos minus() para subtrair (dia,mes,ano) na data
        //O objeto de LocalDate são imutaveis, logo devemos guardar o valor em outra variavel
        LocalDate olimpiadasMenosVinte = dataOlimpiadas.minusDays(20);
        System.out.println(olimpiadasMenosVinte);

        //Temos plus() para adicionar (dia,mes,ano) na data
        //O objeto de LocalDate são imutaveis, logo devemos guardar o valor em outra variavel
        LocalDate proximaOlimpiadas = dataOlimpiadas.plusYears(4);
        System.out.println(proximaOlimpiadas);

        //Para formatar uma saida de data temos que usar a classe DateTimeFormatter
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = proximaOlimpiadas.format(formatador);
        System.out.println(dataFormatada);


        //Se precisar de Hora, minuto e segundo devemos usar a classe LocalDateTime
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        System.out.println(agora.format(formatadorComHoras));

        //Conversão de LocalDateTime para LocalDate e vice-versa
        LocalDate conversao = agora.toLocalDate();

        //Existe classe para cada estrutura do ano, há classe Year, YearMonth, hora, etc...
        YearMonth mes = YearMonth.of(2020, Month.APRIL);
        LocalTime intervaloSomenteTempo = LocalTime.of(35,30);


    }

}
