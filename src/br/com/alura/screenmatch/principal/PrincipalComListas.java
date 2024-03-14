package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.models.Filme;
import br.com.alura.screenmatch.models.Serie;
import br.com.alura.screenmatch.models.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        var filme = new Filme("Homem-Aranha 2", 2004);
        filme.setDuracaoEmMinutos(120);
        filme.avalia(10);
        filme.avalia(9.7);
        filme.avalia(9.5);

//        https://www.omdbapi.com/?i=tt3896198&apikey=983a7a2b
        var filme2 = new Filme("The Batman", 2022);
        filme2.setDuracaoEmMinutos(180);

        var oMentalista = new Serie("O Mentalista", 2008);
        oMentalista.setTemporadas(8);
        oMentalista.setEpisodiosPorTemporada(26);
        oMentalista.setMinutosPorEpisodios(45);

        var filme3 = new Filme("Percy Jackson", 2003);
        filme3.setDuracaoEmMinutos(100);

        ArrayList<Titulo> listaDeAssistidos = new ArrayList<>();
        listaDeAssistidos.add(filme);
        listaDeAssistidos.add(filme2);
        listaDeAssistidos.add(filme3);
        listaDeAssistidos.add(oMentalista);

        for (Titulo item : listaDeAssistidos){
            System.out.println(item.getNome());
            if (item instanceof Filme f){
                System.out.println("Classificação: " + f.getClassificacao());
            }

        }

        List<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Will Smith");
        buscaPorArtista.add("Andrew Garfield");
        buscaPorArtista.add("Tobey Maguire");
        buscaPorArtista.add("Keannu Reaves");

        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);

        Collections.sort(listaDeAssistidos);
        System.out.println(listaDeAssistidos);
        listaDeAssistidos.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(listaDeAssistidos);
    }
}
