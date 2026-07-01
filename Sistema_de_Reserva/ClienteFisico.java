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
    public boolean ValidarDocumento(){
        if (CPF == null) {
            return false;
        }
        String apenasNumeros = CPF.replaceAll("[^0-9]", "");
        return apenasNumeros.length() == 11;
    }
 
}   
