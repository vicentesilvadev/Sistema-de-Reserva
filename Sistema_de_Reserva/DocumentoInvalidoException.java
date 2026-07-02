package Sistema_de_Reserva;

public class DocumentoInvalidoException extends ReservaException {
    private static final long serialVersionUID = 1L;
    public DocumentoInvalidoException(String mensagem){
        super(mensagem);
    }
}
