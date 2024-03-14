package br.com.alura.screenmatch.models;

import br.com.alura.screenmatch.exception.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacao;
    private String sinopse;
    private String genero;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Titulo(String nome, int anoDeLancamento) {
        this.setNome(nome);
        this.setAnoDeLancamento(anoDeLancamento);
    }
    public Titulo(TituloOmdb tituloOmdb){
        this.nome = tituloOmdb.title();

        if (tituloOmdb.year().length() > 4){
            throw new ErroDeConversaoDeAnoException("Não foi possível converter o ano. " +
                    "Pq tem mais de 4 caracteres");
        }
        this.anoDeLancamento = Integer.valueOf(tituloOmdb.year());
        this.genero = tituloOmdb.genre();
        this.sinopse = tituloOmdb.plot();
        this.duracaoEmMinutos = Integer.valueOf(tituloOmdb.runtime().substring(0,3));
    }
    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de Lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacao += nota;
        totalDeAvaliacoes++;
    }

    public double obtemMedia(){
        return somaDasAvaliacao / totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo titulo) {
        return this.getNome().compareTo(titulo.getNome());
    }

    @Override
    public String toString() {
        return "Título: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")\n" + "Gênero: " + this.getGenero()
                + "\nDuração: " + this.getDuracaoEmMinutos() + "\nSinopse: " + this.getSinopse();
    }
}
