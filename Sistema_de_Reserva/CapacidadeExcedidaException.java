package Sistema_de_Reserva;

public class CapacidadeExcedidaException extends ReservaException {
    private static final long serialVersionUID = 1L;
    public CapacidadeExcedidaException(String mensagem){
        super(mensagem);
    }
}
