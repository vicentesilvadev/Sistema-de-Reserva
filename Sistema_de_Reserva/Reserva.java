package Sistema_de_Reserva;
import java.util.*;

public class Reserva {
    private int idReserva;
    private Date dataInicio;
    private Date dataFinal;
    private String status;
    private double valor;

    private Usuario usuario;
    private Espaco espaco;
    private Evento evento;
    
    public Reserva(int id, String status, double valor, Date inicio, Date fim, Usuario usuario, Espaco espaco, Evento evento){
        this.idReserva = id;
        this.status = status;
        this.valor = valor;
        this.dataFinal = fim;
        this.dataInicio = inicio;

        this.usuario = usuario;
        this.espaco = espaco;
        this.evento = evento;
    }

    public void Confirmar(){

    }

    public void Cancelar(){

    }

    public void Valortotal(){

    }
    
}
