package Sistema_de_Reserva;

public class ClienteFisico extends Usuario {

    private String CPF;

    public ClienteFisico(int id, String nome, String email, String telefone, String CPF){
        super(id, nome, email, telefone);
        this.CPF = CPF;
    }

    public String getCPF(){
        return CPF;
    }

    
    @Override
    public void ValidarDocumento() throws DocumentoInvalidoException {
        if (CPF == null) {
            throw new DocumentoInvalidoException("CPF não informado para o usuário " + getNome() + ".");
        }

        String apenasNumeros = CPF.replaceAll("[^0-9]", "");
        if (apenasNumeros.length() != 11) {
            throw new DocumentoInvalidoException("CPF \"" + CPF + "\" inválido: deve conter 11 dígitos.");
        }
    }

}