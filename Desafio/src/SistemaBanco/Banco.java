package SistemaBanco;

import SistemaBanco.Usuário.Cliente;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	static Scanner scan = new Scanner(System.in);
	static List<Cliente> clientes = new ArrayList<>();
	
	public static void cadastraUsuario() {
		System.out.println("=== Cadastrando Usuario ====");
		System.out.print("Insira primeiro nome: ");
		String pnome = scan.next();
		
		System.out.print("Insira sobrenome: ");
		String snome = scan.next();
		
		System.out.print("Insira idade: ");
		int idade = scan.nextInt();
		
		System.out.print("Insira CPF: ");
		int CPF = scan.nextInt();
		
		System.out.print("Insira telefone ");
		int tel = scan.nextInt();
		int id = clientes.size()+1;
		Cliente newCliente = new Cliente(pnome,snome,CPF,idade,tel,id);
		clientes.add(newCliente);
	}
	
	public static Cliente buscaUsuario(int idUser, int userCPF) {
		for(Cliente user:clientes) {
			if(user.getId() == idUser) {
				if(user.getCPF() == userCPF) {
					return user;
				} else {
					System.out.println("CPF nao cadastrado");
					return null;
				}
			}
		}
		System.out.println("Usuario nao encontrado");
		return null;
	}
	
	public static void acessaUsuario() {
		System.out.print("Insira seu ID: ");
		int id = scan.nextInt();
		System.out.print("Insira seu CPF: ");
		int cpf = scan.nextInt();
		Cliente user = buscaUsuario(id,cpf);
		user.acessar();
	}
	public static void criarTeste() {
		 Cliente teste = new Cliente("Alexandre","Filho",181,20,99457,1);
		 clientes.add(teste);		
	}
	public static void main(String[] args) {
		criarTeste();
		boolean m = true;
		while(m) {
			System.out.print("""
					======== Menu Banco ========
					[1]Cadastrar Usuario
					[2]Acessar Usuario
					[0]Sair
					>> 
					""");
			int op = scan.nextInt();
			
			switch(op) {
			case 1:
				cadastraUsuario();
				break;
			case 2:
				acessaUsuario();
				break;
			case 0:
				m = false;
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opcao invalida");
				break;
			}
		}
	}
}
