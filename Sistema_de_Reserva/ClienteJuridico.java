package Sistema_de_Reserva;

public class ClienteJuridico extends Usuario {

    private String CNPJ;

    public ClienteJuridico(int id, String nome, String email, String telefone, String CNPJ){
        super(id, nome, email, telefone);
        this.CNPJ = CNPJ;
    }

    public String getCNPJ(){
        return CNPJ;
    }

    @Override
    public void ValidarDocumento() throws DocumentoInvalidoException {
        if (CNPJ == null) {
            throw new DocumentoInvalidoException("CNPJ não informado para o usuário " + getNome() + ".");
        }

        String apenasNumeros = CNPJ.replaceAll("[^0-9]", "");
        if (apenasNumeros.length() != 14) {
            throw new DocumentoInvalidoException("CNPJ \"" + CNPJ + "\" inválido: deve conter 14 dígitos.");
        }
    }

}