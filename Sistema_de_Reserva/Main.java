package Sistema_de_Reserva;
import java.util.*;

public class Main {
    
    static ArrayList <ClienteJuridico> pessoaJuridica = new ArrayList<>();
    static ArrayList <ClienteFisico> pessoaFisica = new ArrayList<>();
    static ArrayList <Espaco> espaco = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    static int idusuario = 1;
    static int idespaco = 1;
    static int idevento = 1;
    public static void main(String[] args){

    int opcao = 1;
    do{

        System.out.println("\n======== Sistema de Reserva ========\n");
        System.out.println("1. Cadastrar Usuário Pessoa Físico.");
        System.out.println("2. Cadastrar Usuário Pessoa Jurídico.");
        System.out.println("3. Cadastrar Espaço.");
        System.out.println("4. Listar Espaços.");
        System.out.println("5. Realizar reserva.");
        System.out.println("0. Sair.");
        System.out.print("\nEscolha uma opção: ");

        opcao = sc.nextInt();

        switch(opcao){

            case 1 :
                System.out.println("\n======== Cadastro de Usuário ========\n");
                System.out.printf("Nome: ");
                sc.nextLine();
                String nomeF = sc.nextLine();
                System.out.printf("Email: ");
                String emailF = sc.nextLine();
                System.out.printf("Telefone: ");
                String telefoneF = sc.nextLine();
                System.out.printf("CPF (somente números): ");
                String cpf = sc.nextLine();

                ClienteFisico usuarioF = new ClienteFisico(idusuario++, nomeF, emailF, telefoneF, cpf);
                pessoaFisica.add(usuarioF);

                System.out.println("\n -- Usuario cadastrado com sucesso! --");

                break;

            case 2 :

                System.out.println("\n======== Cadastro do Usuário ========\n");
                System.out.printf("Nome: ");
                sc.nextLine();
                String nomeJ = sc.nextLine();
                System.out.printf("Email: ");
                String emailJ = sc.nextLine();
                System.out.printf("Telefone: ");
                String telefoneJ = sc.nextLine();
                System.out.printf("CNPJ (somente números): ");
                String cnpj = sc.nextLine();

                ClienteJuridico usuarioJ = new ClienteJuridico(idusuario++, nomeJ, emailJ, telefoneJ, cnpj);
                pessoaJuridica.add(usuarioJ);
                
                System.out.println("\n -- Usuario cadastrado com sucesso! --");

                break;

                case 3:

                for (ClienteFisico cf  : pessoaFisica) {
                    cf.ge
                }


        }

    }while(opcao != 0);


        
    }
}
