package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroDeRecomendacao;
import br.com.alura.screenmatch.models.Episodio;
import br.com.alura.screenmatch.models.Filme;
import br.com.alura.screenmatch.models.Serie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var filme = new Filme("Homem-Aranha 2", 2004);
        filme.setDuracaoEmMinutos(120);

        var filme2 = new Filme("The Batman", 2022);
        filme2.setDuracaoEmMinutos(180);

        filme.avalia(9.2);
        filme.avalia(7);
        filme.avalia(6.2);
        System.out.println(filme.getTotalDeAvaliacoes());

        System.out.println(filme.obtemMedia());

        var oMentalista = new Serie("O Mentalista", 2008);
        oMentalista.setTemporadas(8);
        oMentalista.setEpisodiosPorTemporada(26);
        oMentalista.setMinutosPorEpisodios(45);

        var calculadora = new CalculadoraDeTempo();
        calculadora.inclui(filme);
        calculadora.inclui(filme2);
        calculadora.inclui(oMentalista);
        System.out.println(calculadora.getTempoTotal());


        var episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(oMentalista);
        episodio.setTotalDeVisualizacoes(400);
        var filtro = new FiltroDeRecomendacao();
        filtro.filtra(episodio);

        var filme3 = new Filme("Percy Jackson", 2003);
        filme3.setDuracaoEmMinutos(100);
        filme3.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filme);
        listaDeFilmes.add(filme2);
        listaDeFilmes.add(filme3);
        System.out.println(listaDeFilmes.size());
        System.out.println("Primeiro Filme: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
    }
}
