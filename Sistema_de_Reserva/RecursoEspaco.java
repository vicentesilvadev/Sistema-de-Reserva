package Sistema_de_Reserva;

public class RecursoEspaco {
    
    private String nome;
    private String status;
    private String descricao;

    public RecursoEspaco(String nome, String status, String descricao){
        this.nome = nome;
        this.status = status;
        this.descricao = descricao;
    }

    public void getMostrar(){
        System.out.println("Nome: "+nome);
        System.out.println("Status: "+status);
        System.out.println("Descrição "+descricao);
    }
}
