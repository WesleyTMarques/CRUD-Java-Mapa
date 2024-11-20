package Mapa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static ArrayList<Cliente> clientes = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);
	
	private static int proximoId = 1;
	
	public static void main(String[] args) {
		int opcao;
		
		System.out.print("Bem vindo! \n\n");
		
		do {
			System.out.print("Escolha uma operação:\n\n");
			System.out.println("1 - Cadastrar Clientes");
			System.out.println("2 - Listar Clientes");
			System.out.println("3 - Atualizar Clientes");
			System.out.println("4 - Remover Clientes");
			System.out.println("5 - Buscar Clientes");
			System.out.println("0 - Sair do Programa");
			
			opcao = sc.nextInt();
			sc.nextLine();
			
			switch(opcao) {
				case 1:				
					cadastrarCliente();
					break;
				case 2:
					mostrarClientes();			
					break;
				case 3:				
					atualizarClientes();
					break;
				case 4:
					removerClientes();
					break;
				case 5:			
					buscarClientes();
					break;
				case 0:
					System.out.println("Encerrando o programa...");
					break;
				default:
					System.out.println("Operação invalida, tente novamente.");
			}
			
		} while (opcao != 0);

	}
	
	public static int gerarNovoId() {
        return proximoId++;
    }

	private static void cadastrarCliente() {		
		int id = gerarNovoId();
		
		System.out.print("\nNome: ");
		String nome = sc.nextLine();
		
		System.out.print("email: ");
		String email = sc.nextLine();
		
		System.out.print("Telefone: ");
		String telefone = sc.nextLine();
		
		Cliente cliente = new Cliente(id, nome, email, telefone);
        clientes.add(cliente);
		
		System.out.println("\nCliente cadastrado com sucesso!\n");

		
	}
	
	private static void mostrarClientes() {
		if (clientes.isEmpty()) {
			System.out.println("\nNenhum cliente cadastrado.\n");
		} else {
			System.out.println("\nClientes Cadastrados: ");
			for (Cliente clientes : clientes) {
				System.out.println(clientes);
			}
		}
		
	}
	
	private static void atualizarClientes() {
		System.out.println("\nDigite o ID do cliente: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		Cliente cliente = buscarIdCliente(id);
		
		if (cliente != null) {
			System.out.println("\nSelecione o dado que deseja alterar: ");
			System.out.println("1 - Nome ");
			System.out.println("2 - Email ");
			System.out.println("3 - Telefone ");
			System.out.println("4 - Todos ");
			
			int opcAtu = sc.nextInt();
			sc.nextLine();
			
			switch (opcAtu) {
			case 1: {
				System.out.print("\nDigite o novo nome: ");
				String nome = sc.nextLine();
				
				cliente.setNome(nome);
				
				System.out.println("\nNome alterado com sucesso!\n");
				
				break;
			}
			case 2: {
				System.out.println("\nDigite o novo email: ");
				String email = sc.nextLine();
				
				cliente.setEmail(email);
				
				System.out.println("\nEmail alterado com sucesso!\n");
				
				break;
			}
			case 3: {
				System.out.println("\nDigite o novo telefone: ");
				String telefone = sc.nextLine();
				
				cliente.setTelefone(telefone);
				
				System.out.println("\nTelefone alterado com sucesso!\n");
				
				break;
			}
			case 4: {
				System.out.print("\nDigite o novo nome: ");
				String nome = sc.nextLine();
				
				System.out.print("\nDigite o novo email: ");
				String email = sc.nextLine();
				
				System.out.print("\nDigite o novo telefone: ");
				String telefone = sc.nextLine();
				
				cliente.setNome(nome);
				cliente.setEmail(email);
				cliente.setTelefone(telefone);
				
				System.out.println("\nDados alterados com sucesso!\n");
				
				break;
			}
			default:
				System.out.println("\nValor digitado não é valido.\n");
				break;
			}
		} else {
			System.out.println("\nCliente com id " + id + "não localizado.\n");
		}
	}
	
	private static void removerClientes() {
		System.out.println("\nDigite o ID do cliente que deseja remover: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		Cliente cliente = buscarIdCliente(id);
		
		if(cliente != null) {
			clientes.remove(cliente);
			System.out.println("\nCliente de id " + id + " removido.\n");
		} else {
			System.out.println("\nCliente com id " + id + " não localizado.\n");
		}
	}
	
	private static void buscarClientes() {
		System.out.println("\nDigite o id do cliente que deseja localizar: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		Cliente cliente = buscarIdCliente(id);
		
		if(cliente != null) {
				if(cliente.getId() == id) {
					System.out.println(cliente);
				}
		} else {
			System.out.println("\nCliente com id " + id + " não localizado.\n");
		}
	}
	
	private static Cliente buscarIdCliente(int id) {
		for (Cliente cliente : clientes) {
			if (cliente.getId() == id) {
				return cliente;
			}
		}
	return null;
	}
}
