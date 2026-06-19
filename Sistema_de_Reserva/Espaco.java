package Sistema_de_Reserva;

public class Espaco {
    
    private int idEspaco;
    private String nome;
    private int capacidadeMax;
    private double precoBase;

    public Espaco(int id, String nome, int capacidadeMax, double precoBase){
        this.idEspaco = id;
        this.nome = nome;
        this.capacidadeMax = capacidadeMax;
        this.precoBase = precoBase;
    }

}
