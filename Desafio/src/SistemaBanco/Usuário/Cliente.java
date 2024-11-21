package SistemaBanco.Usuário;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	static Scanner scan = new Scanner(System.in);
	
	String nome,nomeCompleto;
	int CPF,idade,telefone,id;
	
	static List<Conta> contas = new ArrayList<>();
	
	public Cliente(String nome, String sobrenome, int CPF, int idade, int telefone, int id) {
		this.nome = nome;
		this.nomeCompleto = nome+" "+sobrenome;
		this.CPF = CPF;
		this.idade = idade;
		this.telefone = telefone;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public int getCPF() {
		return CPF;
	}
	
	private static void criarConta() {
		System.out.println("========== Criando Conta ==========");
		System.out.println("\nInsira tipo da conta(1.Corrente|2.Poupaça): ");
		int tipo = scan.nextInt();
		int numConta = contas.size()+1;
		Conta novaConta = new Conta(tipo, numConta, 0);
		contas.add(novaConta);
	}
	private static Conta encontraConta(int numConta) {
		for(Conta conta:contas) {
			if(conta.getNumConta() == numConta) {
				return conta;
			}
		}
		return null;
	}
	private static void acessarConta() {
		System.out.println("===================================");
		System.out.println("Insira numero da conta: ");
		int acesso = scan.nextInt();
		Conta conta = encontraConta(acesso);
		conta.acessar();
	}
	private static void transferir() {
		System.out.println("De qual conta deseja transferir? ");
		int acesso = scan.nextInt();
		Conta conta1 = encontraConta(acesso);
		System.out.println("Qual o valor a ser tranferido? ");
		double valor = scan.nextDouble();
		conta1.retirada(valor);
		System.out.println("Para qual conta deseja transferir? ");
		int acesso2 = scan.nextInt();
		Conta conta2 = encontraConta(acesso2);
		conta2.deposito(valor);
		System.out.println("R$"+valor+" foi depositado na conta "+conta2.tipoConta);
		
	}
	
	public void acessar() {
		menu();
	}
	private void menu() {
		boolean i=true;
		while(i) {
			System.out.print("""
					======= Menu Usuario =======
					[1]Criar Conta
					[2]Acessar Conta
					[3]Transferir
					[0]Sair
					>>""");
			int opc = scan.nextInt();
			
			switch(opc) {
			case 1:
				criarConta();
				break;
			case 2:
				acessarConta();
				break;
			case 3:
				transferir();
				break;
			case 0:
				i = false;
				break;
			}
		}
	}
}
