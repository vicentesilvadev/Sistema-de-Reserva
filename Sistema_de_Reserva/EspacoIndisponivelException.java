package Sistema_de_Reserva;

public class EspacoIndisponivelException extends ReservaException {
    private static final long serialVersionUID = 1L;
    public EspacoIndisponivelException(String mensagem){
        super(mensagem);
    }
}
