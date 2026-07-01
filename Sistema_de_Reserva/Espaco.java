package Sistema_de_Reserva;

import java.util.*;

public class Espaco {

    private ArrayList<RecursoEspaco> recurso = new ArrayList<>();
    private int idEspaco;
    private String nome;
    private int capacidadeMax;
    private double precoBase;
    private boolean disponibilidade = true;

    public Espaco( String nome, int id, int capacidadeMax, double precoBase){
        this.idEspaco = id;
        this.nome = nome;
        this.capacidadeMax = capacidadeMax;
        this.precoBase = precoBase;
    }

    public int getIdEspaco(){
        return idEspaco;
    }

    public String getNome(){
        return nome;
    }

    public int getCapacidadeMax(){
        return capacidadeMax;
    }

    public double getPrecoBase(){
        return precoBase;
    }

    public List<RecursoEspaco> getRecursos(){
        return recurso;
    }

    public boolean VerificarDisponibilidade(){
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade){
        this.disponibilidade = disponibilidade;
    }

    public void setRecursos(String nome, String descricao, String status){
        recurso.add(new RecursoEspaco(nome, status, descricao));
    }

    public double PrecoFinal(){
       return precoBase;
    }

    public void getEspaco(){
        System.out.println("\n\nNome: "+nome+"\n\nId: "+idEspaco+"\n\nCapacidade Maxima: "+capacidadeMax+"\n\nPreco base: "+precoBase);

        System.out.printf("\n ---- Recursos do Espaco ----\n\n ");

        for (RecursoEspaco recursoEspaco : recurso) {
            recursoEspaco.getMostrar();
        }
    }

}