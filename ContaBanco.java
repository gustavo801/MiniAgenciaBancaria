package banco;

import javax.swing.JOptionPane;

public class ContaBanco {
	private int numeroConta;
	private Usuarios usuarios;
	private Double saldo = 0.0;
	private static int contadorDeContas = 1;

	public ContaBanco(Usuarios usuarios) {

		this.usuarios = usuarios;
		this.numeroConta = contadorDeContas;
		contadorDeContas += 1;

	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public static int getContadorDeContas() {
		return contadorDeContas;
	}

	public String toString() {
		return "\nNome do usu�rio: " + this.usuarios.getNome() + "\nN�mero da conta: " + this.getNumeroConta()
				+ "\nSaldo: " + Utilitarios.doubleString(this.getSaldo()) + "\nEmail: " + this.usuarios.getEmail()
				+ "\nCPF: " + this.usuarios.getCpf();

	}

	public void depositar(Double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor);
			JOptionPane.showMessageDialog(null, "Dep�sito realizado com sucesso, seu novo saldo na conta �: " + Utilitarios.doubleString(getSaldo()));
	

		} else {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel realizar o dep�sito!");
			
		}
	}

	public void sacar(Double valor) {
		if (valor >= getSaldo()) {
			setSaldo(getSaldo() - valor);
			JOptionPane.showMessageDialog(null, "Saque realizado com sucesso! Seu novo saldo em conta � de: "+ Utilitarios.doubleString(getSaldo()));
			
		} else {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel realizar o saco, verifique que o valor em conta � maior ou igual ao valor a ser sacado!");
		}

	}

	public void transferir(ContaBanco contadepositada, Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			this.setSaldo(this.getSaldo() - valor);
			contadepositada.saldo = contadepositada.getSaldo() + valor;
			JOptionPane.showMessageDialog(null, "Transfer�ncia realizada com sucesso! Seu novo saldo � de: " + Utilitarios.doubleString(getSaldo()));
		
		}
	}

}
