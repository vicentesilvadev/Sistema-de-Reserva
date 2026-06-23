package Sistema_de_Reserva;

public class ClienteJuridico extends Usuario {
    
     private String CNPJ;

    public ClienteJuridico(int id, String nome, String email, String telefone, String CNPJ){
        super(id, nome, email, telefone);
        this.CNPJ = CNPJ;
    }

    @Override
    public void ValidarDocumento(){

    }

    
}

