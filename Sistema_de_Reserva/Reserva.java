package Sistema_de_Reserva;
import java.util.*;

public class Reserva {
    private int idReserva;
    private Date dataInicio;
    private Date dataFinal;
    private String status;
    private double valor;

    
    public Reserva(int id, String status, double valor){
        this.idReserva = id;
        this.status = status;
        this.valor = valor;
    }

    public void Confirmar(){

    }

    public void Cancelar(){

    }

    public void Valortotal(){

    }
    
}
