package Sistema_de_Reserva;
import java.util.*;

public class Reserva {

    private static int contadorId = 1;

    private int idReserva;
    private Date dataInicio;
    private Date dataFinal;
    private String status;
    private double valor;

    private Usuario usuario;
    private Espaco espaco;
    private Evento evento;

    public Reserva(String status, Date inicio, Date fim, Usuario usuario, Espaco espaco, Evento evento){
        this.idReserva = contadorId++;
        this.status = status;
        this.valor = 0.0;
        this.dataInicio = inicio;
        this.dataFinal = fim;

        this.usuario = usuario;
        this.espaco = espaco;
        this.evento = evento;
    }

    public int getIdReserva(){
        return idReserva;
    }

    public String getStatus(){
        return status;
    }

    public double getValor(){
        return valor;
    }

    public Date getDataInicio(){
        return dataInicio;
    }

    public Date getDataFinal(){
        return dataFinal;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public Espaco getEspaco(){
        return espaco;
    }

    public Evento getEvento(){
        return evento;
    }

    public void Confirmar() throws DocumentoInvalidoException, EspacoIndisponivelException, CapacidadeExcedidaException {
        usuario.ValidarDocumento();
        espaco.VerificarDisponibilidade();
        evento.ValidarCapacidade(espaco.getCapacidadeMax());

        this.status = "Confirmada";
        espaco.setDisponibilidade(false);
        System.out.println("Reserva #" + idReserva + " confirmada com sucesso! Valor total: R$ " + String.format("%.2f", valor));
    }

    public void Cancelar(){
        this.status = "Cancelada";
        espaco.setDisponibilidade(true);
        System.out.println("Reserva #" + idReserva + " cancelada. O espaço \"" + espaco.getNome() + "\" está disponível novamente.");
    }

    public void Valortotal(){
        long diferencaMillis = dataFinal.getTime() - dataInicio.getTime();
        long dias = diferencaMillis / (1000L * 60 * 60 * 24);

        if (dias < 1) {
            dias = 1;
        }

        this.valor = dias * espaco.PrecoFinal();
    }

}