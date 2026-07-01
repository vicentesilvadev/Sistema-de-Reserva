package Sistema_de_Reserva;
import java.util.Date;

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

    
    public void RealizarReserva(Espaco espaco, Evento evento, Date dataInicio, Date dataFinal) {
        int idNovaReserva = 1; 
        double valorInicial = 0.0; 

        
        Reserva novaReserva = new Reserva(idNovaReserva, "Pendente", valorInicial, dataInicio, dataFinal, this, espaco, evento);
       
        novaReserva.Valortotal();
        
        System.out.println("Processo de reserva iniciado pelo usuário: " + this.nome);
    }

    public String getNome(){
        return nome;
    }
    public abstract boolean ValidarDocumento();

} 