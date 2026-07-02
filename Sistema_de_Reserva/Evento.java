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

    public int getIdEvento(){
        return idEvento;
    }

    public int getParticipantes(){
        return participantes;
    }

    public String getNome(){
        return nome;
    }

    public String getTipo(){
        return tipo;
    }

    public void ValidarCapacidade(int capacidadeMax) throws CapacidadeExcedidaException {
        if (participantes > capacidadeMax) {
            throw new CapacidadeExcedidaException(
                "O evento \"" + nome + "\" tem " + participantes +
                " participantes, mas a capacidade máxima do espaço é " + capacidadeMax + "."
            );
        }
    }
}