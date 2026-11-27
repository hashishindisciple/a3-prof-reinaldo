package br.com.a3prof;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        RepositorioMemoria<String, Hospede> hospedes = new RepositorioMemoria<>();
        RepositorioMemoria<Integer, Quarto> quartos = new RepositorioMemoria<>();
        RepositorioMemoria<Integer, Reserva> reservas = new RepositorioMemoria<>();
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nHOTEL: 1 cadastrar hospede, 2 listar hospedes, 3 alterar hospede, 4 excluir hospede");
                System.out.println("5 cadastrar quarto, 6 listar quartos, 7 alterar quarto, 8 excluir quarto");
                System.out.println("9 cadastrar reserva, 10 listar reservas, 11 alterar datas, 12 excluir reserva, 0 sair");
                String opcao = ler(in, "Opcao: ");
                if (opcao.equals("0")) return;
                try {
                    switch (opcao) {
                        case "1" -> criarHospede(hospedes, in);
                        case "2" -> hospedes.listar().forEach(App::mostrarHospede);
                        case "3" -> alterarHospede(hospedes, in);
                        case "4" -> resultado(hospedes.excluir(ler(in, "CPF: ")));
                        case "5" -> criarQuarto(quartos, in);
                        case "6" -> quartos.listar().forEach(App::mostrarQuarto);
                        case "7" -> alterarQuarto(quartos, in);
                        case "8" -> resultado(quartos.excluir(inteiro(in, "Numero: ")));
                        case "9" -> criarReserva(hospedes, quartos, reservas, in);
                        case "10" -> reservas.listar().forEach(App::mostrarReserva);
                        case "11" -> alterarReserva(reservas, in);
                        case "12" -> resultado(reservas.excluir(inteiro(in, "Id: ")));
                        default -> System.out.println("Opcao invalida.");
                    }
                } catch (RuntimeException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
        }
    }

    private static void criarHospede(RepositorioMemoria<String, Hospede> hospedes, Scanner in) {
        Hospede h = new Hospede();
        h.setNome(ler(in, "Nome: "));
        h.setCpf(ler(in, "CPF (11 digitos): "));
        h.setTelefone(ler(in, "Telefone (10 ou 11 digitos): "));
        h.setEmail(ler(in, "E-mail: "));
        resultado(hospedes.cadastrar(h.getCpf(), h));
    }

    private static void alterarHospede(RepositorioMemoria<String, Hospede> hospedes, Scanner in) {
        String cpf = ler(in, "CPF: ");
        Hospede h = new Hospede();
        h.setCpf(cpf);
        h.setNome(ler(in, "Novo nome: "));
        h.setTelefone(ler(in, "Novo telefone: "));
        h.setEmail(ler(in, "Novo e-mail: "));
        resultado(hospedes.atualizar(cpf, h));
    }

    private static void criarQuarto(RepositorioMemoria<Integer, Quarto> quartos, Scanner in) {
        Quarto q = new Quarto();
        q.setNumero(inteiro(in, "Numero: "));
        q.setCategoria(ler(in, "Categoria: "));
        q.setPreco(decimal(in, "Preco da diaria: "));
        q.setSituacao("Disponivel");
        resultado(quartos.cadastrar(q.getNumero(), q));
    }

    private static void alterarQuarto(RepositorioMemoria<Integer, Quarto> quartos, Scanner in) {
        int numero = inteiro(in, "Numero: ");
        Quarto q = new Quarto();
        q.setNumero(numero);
        q.setCategoria(ler(in, "Nova categoria: "));
        q.setPreco(decimal(in, "Novo preco: "));
        q.setSituacao(ler(in, "Situacao (Disponivel/Ocupado/Manutencao): "));
        resultado(quartos.atualizar(numero, q));
    }

    private static void criarReserva(RepositorioMemoria<String, Hospede> hospedes,
                                     RepositorioMemoria<Integer, Quarto> quartos,
                                     RepositorioMemoria<Integer, Reserva> reservas, Scanner in) {
        int id = inteiro(in, "Id da reserva: ");
        Hospede h = hospedes.buscar(ler(in, "CPF do hospede: "));
        Quarto q = quartos.buscar(inteiro(in, "Numero do quarto: "));
        if (h == null || q == null) {
            System.out.println("Cadastre o hospede e o quarto antes da reserva.");
            return;
        }
        Reserva r = new Reserva(id);
        r.setHospede(h);
        r.setQuarto(q);
        r.setDatas(LocalDate.parse(ler(in, "Entrada (AAAA-MM-DD): ")),
                LocalDate.parse(ler(in, "Saida (AAAA-MM-DD): ")));
        r.setValorDiaria(q.getPreco());
        resultado(reservas.cadastrar(id, r));
    }

    private static void alterarReserva(RepositorioMemoria<Integer, Reserva> reservas, Scanner in) {
        int id = inteiro(in, "Id da reserva: ");
        Reserva atual = reservas.buscar(id);
        if (atual == null) {
            System.out.println("Reserva nao encontrada.");
            return;
        }
        Reserva r = new Reserva(id);
        r.setHospede(atual.getHospede());
        r.setQuarto(atual.getQuarto());
        r.setValorDiaria(atual.getQuarto().getPreco());
        r.setDatas(LocalDate.parse(ler(in, "Nova entrada (AAAA-MM-DD): ")),
                LocalDate.parse(ler(in, "Nova saida (AAAA-MM-DD): ")));
        resultado(reservas.atualizar(id, r));
    }

    private static void mostrarHospede(Hospede h) {
        System.out.printf("%s | %s | %s | %s%n", h.getCpf(), h.getNome(), h.getTelefone(), h.getEmail());
    }

    private static void mostrarQuarto(Quarto q) {
        System.out.printf("%d | %s | %.2f | %s%n", q.getNumero(), q.getCategoria(), q.getPreco(), q.getSituacao());
    }

    private static void mostrarReserva(Reserva r) {
        System.out.printf("%d | %s | quarto %d | %s a %s | total %.2f%n",
                r.getId(), r.getHospede().getNome(), r.getQuarto().getNumero(),
                r.getEntrada(), r.getSaida(), r.getValorTotal());
    }

    private static String ler(Scanner in, String mensagem) {
        System.out.print(mensagem);
        return in.nextLine().trim();
    }

    private static int inteiro(Scanner in, String mensagem) {
        return Integer.parseInt(ler(in, mensagem));
    }

    private static double decimal(Scanner in, String mensagem) {
        return Double.parseDouble(ler(in, mensagem).replace(',', '.'));
    }

    private static void resultado(boolean sucesso) {
        System.out.println(sucesso ? "Operacao concluida." : "Registro nao encontrado ou ja existente.");
    }
}
