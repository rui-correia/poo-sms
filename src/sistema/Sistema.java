package sistema;

import model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

    List<Pessoa> pessoas = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void inicializar() {
        carga();
        while (true) {
            menu();
        }
    }

    public void menu() {
        int opcao;

        System.out.println("----------Menu---------");
        System.out.println("01 - Cadastrar usuario-");
        System.out.println("02 - Listar usuarios  -");
        System.out.println("03 - Enviar SMS       -");
        System.out.println("04 - Ler sms          -");
        System.out.println("0 - Sair              -");

        opcao = scanner.nextInt();
        scanner.nextLine();
        escolha(opcao);
    }

    public void escolha(int opcao) {

        switch (opcao) {
            case 1:
                cadastrar();
                break;
            case 2:
                listarUsuarios();
                break;
            case 3:
                enviarSms();
                break;
            case 4:
                lerSms();
                break;
            case 0:
                System.exit(1);
        }
    }

    public void lerSms() {
        int cpf;

        System.out.println("Deseja ler sms de qual usuario?");

        cpf = scanner.nextInt();
        scanner.nextLine();

        for (Pessoa p : pessoas) {
            if (p.getCpf() == cpf) {
                if (p.getListaSms() == null) {
                    System.out.println("Usuario não possui sms.");
                    break;
                }
                for (String mensagem : p.getListaSms()) {
                    System.out.println(mensagem);
                }
            }
        }
    }

    public void listarUsuarios() {
        for (Pessoa p : pessoas) {
            System.out.println(p);
        }
    }

    public void cadastrar() {
        String nome;
        Integer cpf;
        Integer tel;

        System.out.println("Nome");
        nome = scanner.nextLine();
        System.out.println("cpf");
        cpf = scanner.nextInt();
        System.out.println("tel");
        tel = scanner.nextInt();

        Pessoa pessoa = new Pessoa(nome, cpf, tel, null);
        pessoas.add(pessoa);
    }

    public void carga() {
        Pessoa p1 = new Pessoa("Rivaldo", 123, 456, null);
        Pessoa p2 = new Pessoa("Cafu", 321, 654, null);
        Pessoa p3 = new Pessoa("Jose", 213, 645, null);
        Pessoa p4 = new Pessoa("Neymar", 231, 564, null);

        pessoas.add(p1);
        pessoas.add(p2);
        pessoas.add(p3);
        pessoas.add(p4);
    }

    public void enviarSms() {
        int telefone;
        boolean existeUsuario = false;
        String mensagem;

        System.out.println("Para quem será a sms?");
        telefone = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Informe a mensagem:");
        mensagem = scanner.nextLine();

        for (Pessoa p : pessoas) {
            if (p.getTelefone() == telefone) {
                existeUsuario = true;
                if (p.getListaSms() == null) {
                    p.setListaSms(new ArrayList<String>());
                }
                p.getListaSms().add(mensagem);
            }
        }
        if (existeUsuario == false) {
            System.out.println("Usuário não encontrado!");
        }

    }
}
