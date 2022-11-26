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
		return "\nNome do usuário: " + this.usuarios.getNome() + "\nNúmero da conta: " + this.getNumeroConta()
				+ "\nSaldo: " + Utilitarios.doubleString(this.getSaldo()) + "\nEmail: " + this.usuarios.getEmail()
				+ "\nCPF: " + this.usuarios.getCpf();

	}

	public void depositar(Double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor);
			JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso, seu novo saldo na conta é: " + Utilitarios.doubleString(getSaldo()));
	

		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível realizar o depósito!");
			
		}
	}

	public void sacar(Double valor) {
		if (valor >= getSaldo()) {
			setSaldo(getSaldo() - valor);
			JOptionPane.showMessageDialog(null, "Saque realizado com sucesso! Seu novo saldo em conta é de: "+ Utilitarios.doubleString(getSaldo()));
			
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível realizar o saco, verifique que o valor em conta é maior ou igual ao valor a ser sacado!");
		}

	}

	public void transferir(ContaBanco contadepositada, Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			this.setSaldo(this.getSaldo() - valor);
			contadepositada.saldo = contadepositada.getSaldo() + valor;
			JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso! Seu novo saldo é de: " + Utilitarios.doubleString(getSaldo()));
		
		}
	}

}
