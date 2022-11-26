package banco;

import java.util.ArrayList;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static ArrayList<ContaBanco> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<ContaBanco>();
		operacoes();

	}

	public static void operacoes() {

		int operacoes = Integer.parseInt(JOptionPane.showInputDialog("--- Selecione uma operação ---" +

				"\nOpção 1 -  Criar conta" + "\nOpção 2 - Depositar" + "\nOpção 3 -  Sacar" + "\nOpção 4 -  Transferir"
				+ "\nOpção 5 -  Listar" + "\nOpção 6 - Sair"));

		switch (operacoes) {
		case 1: {
			criarConta();
			break;
		}
		case 2: {
			depositar();
			break;
		}
		case 3: {
			sacar();
			break;
		}
		case 4: {
			transferir();
			break;
		}
		case 5: {
			listarContas();
			break;
		}
		case 6: {
			JOptionPane.showMessageDialog(null, "Obrigado pela preferência!" );
			
			scanner.close();
			break;
		}
		default:
			JOptionPane.showMessageDialog(null, "Opção inválida. Por favor digite uma opção válida!");

			operacoes();
		}

	}

	public static void criarConta() {
		Usuarios usuarios = new Usuarios();
		usuarios.setNome(JOptionPane.showInputDialog("Por favor digite seu nome completo: "));
		usuarios.setCpf(JOptionPane.showInputDialog("Por favor digite seu CPF: "));
		usuarios.setEmail(JOptionPane.showInputDialog("Por favor digite seu email: "));
		

		ContaBanco contasBancarias = new ContaBanco(usuarios);

		Main.contasBancarias.add(contasBancarias);
		JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso!");
		operacoes();

	}

	private static ContaBanco encontrarConta(int numeroConta) {

		ContaBanco contaBanco = null;
		if (contasBancarias.size() > 0) {
			for (ContaBanco c : contasBancarias) {
				if (c.getNumeroConta() == numeroConta)
					contaBanco = c;
			}
		}
		return contaBanco;
	}

	private static void depositar() {
		
		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta para deposito: "));

		ContaBanco conta = encontrarConta(numeroConta);
		if (conta != null) {
			
			Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Qual valor quer depositar? "));
			conta.depositar(valorDeposito);
			JOptionPane.showConfirmDialog(null, "Valor depositado com sucesso!");

		} else {
			JOptionPane.showConfirmDialog(null, "Não foi possível realizar o depósito!");
		}
		operacoes();

	}

	public static void sacar() {
		
		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta: "));

		ContaBanco conta = encontrarConta(numeroConta);
		if (conta != null) {
			
			Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Qual valor você desejar sacar?" ));
			conta.sacar(valorSaque);
			JOptionPane.showMessageDialog(null, "Valor sacado com sucesso");

		} else {
			JOptionPane.showMessageDialog(null, "Conta não encontrada!");

		}
		operacoes();
	}

	public static void transferir() {
	
		int numeroContaRemetente = Integer.parseInt(JOptionPane.showInputDialog("Por favor insira o número da sua conta: "));

		ContaBanco contaRemetente = encontrarConta(numeroContaRemetente);
		if (contaRemetente != null) {
			
			int numeroContaDestinatario = Integer.parseInt(JOptionPane.showInputDialog("Por favor insira o numero da conta do destinatário: "));
			if (encontrarConta(numeroContaDestinatario) != null) {
				ContaBanco ContaDestinatario = encontrarConta(numeroContaDestinatario);
				
				Double valorDaTransferencia = Double.parseDouble(JOptionPane.showInputDialog("Por favor insira o valor a ser transferido: "));
				contaRemetente.transferir(ContaDestinatario, valorDaTransferencia);
			} else {
				JOptionPane.showMessageDialog(null, "Não foi possível realizar a transferência!");
			}

		}
		operacoes();

	}

	public static void listarContas() {
		if (contasBancarias.size() > 0) {
			for (ContaBanco contaBanco : contasBancarias) {
				JOptionPane.showMessageDialog(null, contaBanco);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Não há contas cadastradas");
		}
		operacoes();
	}

}
