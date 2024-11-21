package SistemaBanco.Usuário;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Conta {
	
	Scanner scan = new Scanner(System.in);
	
	String tipoConta;
	int numConta;
	double saldo = 0.00d;
	List<extrato> extrat = new ArrayList<>();
	
	public Conta(int tipo,int numConta, double saldo) {
	this.numConta = numConta;
	tipoConta(tipo);
	}
	
	private void tipoConta(int ident) {
		if(ident == 1) {
			tipoConta = "corrente";
		} else if(ident == 2) {
			tipoConta = "poupanca";
		}
	}
	protected int getNumConta() {
		return numConta;
	}
	protected void deposito(double val) {
		saldo+=val;
	}
	protected void retirada(double val) {
		saldo-=val;
	}
	
	protected void acessar() {
		menu();
	}
	private void menu() {
		boolean i = true;
		while(i) {
			System.out.print("""
					======== Menu Conta ========
					[1]Depositar
					[2]Sacar
					[3]Extrato
					[0]Sair
					>> """);
			int opc = scan.nextInt();
			switch(opc) {
			case 1:
				depositar();
				break;
			case 2:
				sacar();
				break;
			case 3:
				extrato();
				break;
			case 0:
				System.out.println("saindo...");
				i = false;
				break;
			default:
				System.out.println("opcao invalida");
			}
		}
	}
	
	private void depositar() {
		System.out.print("valor deposito: ");
		double val = scan.nextDouble();
		saldo+=val;
		extrat.add(new extrato("deposito",val));
		System.out.println("R$"+val+" foi depositado");
	}
	private void sacar() {
		System.out.print("valor saque: ");
		double val = scan.nextDouble();
		if(val>saldo) {
			System.out.println("Saldo insuficiente");
		} else {
			saldo-=val;
			extrat.add(new extrato("saque",val));
			System.out.println("R$"+val+" foi retirado");
		}
	}
	private void extrato() {
		System.out.println("========== EXTRATO =========");
		for(extrato item:extrat) {
			if(item.tipo == "deposito") {
				System.out.println("+R$"+item.valor);
			} else {
				System.out.println("-R$"+item.valor);
			}
		}
		System.out.println("Saldo: R$"+saldo);
		System.out.println("============================");
	}
}
