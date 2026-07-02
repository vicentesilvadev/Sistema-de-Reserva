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

    public int getIdUsuario(){
        return idUsuario;
    }

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public String getTelefone(){
        return telefone;
    }

    public void RealizarReserva(Espaco espaco, Evento evento, Date dataInicio, Date dataFinal) {

        Reserva novaReserva = new Reserva("Pendente", dataInicio, dataFinal, this, espaco, evento);
        novaReserva.Valortotal();

        try {
            novaReserva.Confirmar();
            System.out.println("Processo de reserva iniciado pelo usuário: " + this.nome);
        } catch (DocumentoInvalidoException e) {
            System.out.println("Reserva não realizada (documento inválido): " + e.getMessage());
        } catch (EspacoIndisponivelException e) {
            System.out.println("Reserva não realizada (espaço indisponível): " + e.getMessage());
        } catch (CapacidadeExcedidaException e) {
            System.out.println("Reserva não realizada (capacidade excedida): " + e.getMessage());
        }
    }

    public abstract void ValidarDocumento() throws DocumentoInvalidoException;

}