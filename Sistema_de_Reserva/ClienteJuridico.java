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
    public boolean ValidarDocumento(){
        if (CNPJ == null) {
            return false;
        }
        String apenasNumeros = CNPJ.replaceAll("[^0-9]", "");
        return apenasNumeros.length() == 14;
    }

}