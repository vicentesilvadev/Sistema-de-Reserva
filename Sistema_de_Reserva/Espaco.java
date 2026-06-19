package Sistema_de_Reserva;

import java.util.*;

public class Espaco {
    
    private int idEspaco;
    private String nome;
    private int capacidadeMax;
    private double precoBase;
    private List<String> recursos;
    private boolean disponibilidade = true;

    public Espaco(int id, String nome, int capacidadeMax, double precoBase){
        this.idEspaco = id;
        this.nome = nome;
        this.capacidadeMax = capacidadeMax;
        this.precoBase = precoBase;
        this.recursos = new ArrayList<>();
    }

    public boolean VerificarDisponibilidade(){
        return true;
    }

    public double PrecoFinal(){
       return 0.0; 
    }

}
