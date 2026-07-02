package Sistema_de_Reserva;

import java.util.*;
import java.text.SimpleDateFormat;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Espaco> espacos = new ArrayList<>();
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

    static int proximoIdUsuario = 1;
    static int proximoIdEspaco = 1;
    static int proximoIdEvento = 1;

    public static void main(String[] args){

        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE RESERVA DE ESPAÇOS =====");
            System.out.println("1 - Cadastrar cliente pessoa física");
            System.out.println("2 - Cadastrar cliente pessoa jurídica");
            System.out.println("3 - Cadastrar espaço");
            System.out.println("4 - Adicionar recurso a um espaço");
            System.out.println("5 - Listar espaços");
            System.out.println("6 - Realizar reserva");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = lerInteiro();

            switch (opcao) {
                case 1 -> cadastrarClienteFisico();
                case 2 -> cadastrarClienteJuridico();
                case 3 -> cadastrarEspaco();
                case 4 -> adicionarRecurso();
                case 5 -> listarEspacos();
                case 6 -> realizarReserva();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }

    static void cadastrarClienteFisico(){
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        
        String cpf = lerCPF();

        Usuario usuario = new ClienteFisico(proximoIdUsuario++, nome, email, telefone, cpf);
        usuarios.add(usuario);
        System.out.println("Cliente físico cadastrado com sucesso!");
    }

    static void cadastrarClienteJuridico(){
        System.out.print("Nome/Razão social: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        String cnpj = lerCNPJ();

        Usuario usuario = new ClienteJuridico(proximoIdUsuario++, nome, email, telefone, cnpj);
        usuarios.add(usuario);
        System.out.println("Cliente jurídico cadastrado com sucesso!");
    }

    static void cadastrarEspaco(){
        System.out.print("Nome do espaço: ");
        String nome = sc.nextLine();
        int capacidade = lerInteiroPositivo("Capacidade máxima: ");
        double preco = lerDoubleNaoNegativo("Preço base (por diária): ");

        Espaco espaco = new Espaco(nome, proximoIdEspaco++, capacidade, preco);
        espacos.add(espaco);
        System.out.println("Espaço \"" + nome + "\" cadastrado com sucesso!");
    }

    static void adicionarRecurso(){
        Espaco espaco = escolherEspaco();
        if (espaco == null) return;

        System.out.print("Nome do recurso (ex: Projetor): ");
        String nome = sc.nextLine();
        System.out.print("Status (ex: Disponível/Em manutenção): ");
        String status = sc.nextLine();
        System.out.print("Descrição/observações: ");
        String descricao = sc.nextLine();

        espaco.setRecursos(nome, descricao, status);
        System.out.println("Recurso adicionado ao espaço \"" + espaco.getNome() + "\".");
    }

    static void listarEspacos(){
        if (espacos.isEmpty()) {
            System.out.println("Nenhum espaço cadastrado ainda.");
            return;
        }
        for (Espaco espaco : espacos) {
            espaco.mostrar();
            System.out.println("Disponível: " + espaco.isDisponivel());
        }
    }

    static void realizarReserva(){
        if (usuarios.isEmpty()) {
            System.out.println("Cadastre um cliente antes de realizar uma reserva.");
            return;
        }

        Espaco espaco = escolherEspaco();
        if (espaco == null) return;

        Usuario usuario = escolherUsuario();
        if (usuario == null) return;

        System.out.print("Nome do evento: ");
        String nomeEvento = sc.nextLine();
        System.out.print("Tipo do evento (ex: Casamento, Palestra...): ");
        String tipoEvento = sc.nextLine();
        int participantes = lerInteiroPositivo("Número de participantes: ");

        Evento evento = new Evento(proximoIdEvento++, participantes, nomeEvento, tipoEvento);

        Date dataInicio = lerData("Data de início (dd/MM/yyyy): ");
        Date dataFinal = lerDataFinal("Data de término (dd/MM/yyyy): ", dataInicio);

        usuario.RealizarReserva(espaco, evento, dataInicio, dataFinal);
    }

    static Espaco escolherEspaco(){
        if (espacos.isEmpty()) {
            System.out.println("Nenhum espaço cadastrado ainda.");
            return null;
        }
        System.out.println("Escolha o espaço:");
        for (int i = 0; i < espacos.size(); i++) {
            System.out.println((i + 1) + " - " + espacos.get(i).getNome());
        }
    
        int indice;
        while (true) {
            indice = lerInteiro() - 1;
            if (indice >= 0 && indice < espacos.size()) {
                return espacos.get(indice);
            }
            System.out.print("Espaço inválido, escolha um número da lista acima: ");
        }
    }

    static Usuario escolherUsuario(){
        System.out.println("Escolha o cliente:");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((i + 1) + " - " + usuarios.get(i).getNome());
        }
        int indice;
        while (true) {
            indice = lerInteiro() - 1;
            if (indice >= 0 && indice < usuarios.size()) {
                return usuarios.get(indice);
            }
            System.out.print("Cliente inválido, escolha um número da lista acima: ");
        }
    }

    static String lerCPF(){
        while (true) {
            System.out.print("CPF (somente números): ");
            String cpf = sc.nextLine();

            ClienteFisico teste = new ClienteFisico(0, "", "", "", cpf);
            try {
                teste.ValidarDocumento();
                return cpf;
            } catch (DocumentoInvalidoException e) {
                System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
            }
        }
    }

    static String lerCNPJ(){
        while (true) {
            System.out.print("CNPJ (somente números): ");
            String cnpj = sc.nextLine();

            ClienteJuridico teste = new ClienteJuridico(0, "", "", "", cnpj);
            try {
                teste.ValidarDocumento();
                return cnpj;
            } catch (DocumentoInvalidoException e) {
                System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
            }
        }
    }

    static int lerInteiro(){
        while (!sc.hasNextInt()) {
            System.out.print("Digite um número válido: ");
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }

    static int lerInteiroPositivo(String mensagem){
        while (true) {
            System.out.print(mensagem);
            int valor = lerInteiro();
            if (valor > 0) {
                return valor;
            }
            System.out.println("Erro: o valor deve ser maior que zero.");
        }
    }

    static double lerDouble(){
        while (!sc.hasNextDouble()) {
            System.out.print("Digite um valor numérico válido: ");
            sc.next();
        }
        double valor = sc.nextDouble();
        sc.nextLine();
        return valor;
    }

    static double lerDoubleNaoNegativo(String mensagem){
        while (true) {
            System.out.print(mensagem);
            double valor = lerDouble();
            if (valor >= 0) {
                return valor;
            }
            System.out.println("Erro: o valor não pode ser negativo.");
        }
    }

    static Date lerData(String mensagem){
        while (true) {
            System.out.print(mensagem);
            String texto = sc.nextLine();
            try {
                formatoData.setLenient(false);
                return formatoData.parse(texto);
            } catch (Exception e) {
                System.out.println("Erro: data inválida, use o formato dd/MM/yyyy. Tente novamente.");
            }
        }
    }

    static Date lerDataFinal(String mensagem, Date dataInicio){
        while (true) {
            Date dataFinal = lerData(mensagem);
            if (!dataFinal.before(dataInicio)) {
                return dataFinal;
            }
            System.out.println("Erro: a data de término não pode ser anterior à data de início.");
        }
    }
}