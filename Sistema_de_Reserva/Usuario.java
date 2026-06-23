package Sistema_de_Reserva;
 
public abstract class Usuario {
    
    private int idUsuario;
    private String nome;
    private String email;
    private String telefone;

    public Usuario(int id, String nome, String email, String telefone){
        this.idUsuario = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public void RealizarReseva(){

    }

    public void ValidarDocumento(){
        
    }

}
