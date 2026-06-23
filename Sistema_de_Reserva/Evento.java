package Sistema_de_Reserva;

public class Evento {
    
    private int idEvento;
    private int participantes;
    private String nome;
    private String tipo;

    public Evento( int id, int participantes, String nome, String tipo){
        this.idEvento = id;
        this.participantes = participantes;
        this.nome = nome;
        this.tipo = tipo;
    }

    public boolean ValidarCapacidade(int capacidadeMax){
        return true;
    }
}
