package Sistema_de_Reserva;

public class ClienteFisico extends Usuario {
    
    private String CPF;

    public ClienteFisico(int id, String nome, String email, String telefone, String CPF){
        super(id, nome, email, telefone);
        this.CPF = CPF;
    }

    @Override
    public void ValidarDocumento(){

    }

    
}
