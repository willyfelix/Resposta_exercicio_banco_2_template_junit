package org.exercicio.banco.template.model;

import java.util.Objects;

/**
*
* Nome: Williane Felix
* Curso: TSI
* Matrícula: 20212TSIIG0342
* 
*/
public class ContaBancaria {
	private int numeroConta;
	private double saldo;
	private String titular;
	private boolean status;

	/**
	 * Construtor recebe apenas numeroConta e titular. Saldo e status iniciam
	 * com valores padrão: saldo com 0 e status com true.
	 * @param numeroConta
	 * @param titular
	 */
	public ContaBancaria(int numeroConta, double saldo) {
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.status = true;
	}
	
	public ContaBancaria(int numeroConta, String titular) {
		this.numeroConta = numeroConta;
		this.titular = titular;
		this.saldo = 0;
		this.status = true;
	}

	/*
	 * OBS: RESPONDA A LISTA DE EXERCICIO COM A SEGUINTE SEQUENCIA:
	 * 1) DEPOSITAR
	 * 2) SACAR
	 * 3) FECHARCONTA
	 * 4) REABRIRCONTA
	 * 5) REALIZARTRANSFERENCIA
	 * 
	 * */
	
	/**
	 * O metodo deve receber um valor a ser acrescido ao saldo. No entanto, deve-se
	 * checar se o valor passado como argumento é maior que 0 (zero). Caso nao seja,
	 * a seguinte mensagem deve ser impressa no console: "Valor invalido para
	 * deposito." Utilize o System.out.print()
	 * 
	 * @param valor
	 */
	public void depositar(double valor) {
		if(valor > 0) {
			this.saldo += valor;
		} else {
			System.out.print("Valor invalido para deposito.");
		}
	}

	/**
	 * Metodo sacar deve descrementar do saldo o valor passado como argumento.
	 * Deve-se verificar primeiramente se a conta esta ativa, caso nao esteja a msg
	 * "Conta inativa." deve ser impressa no console. Em seguida, caso o argumento
	 * valor seja menor ou igual a 0 (zero), a seguinte msg deve ser impressa no
	 * console "Valor inválido para saque." Por fim, caso o valor solicitado para o
	 * saque seja maior que o saldo disponivel, a msg "Saldo insuficiente." deve ser
	 * exibida no console. Caso as checagens sejam atendidas, decremente o valor
	 * solicitado do saldo. Utilize System.out.print();
	 * 
	 * @param valor
	 */
	public void sacar(double valor) {
		if(!this.status) {
			System.out.print("Conta inativa.");
		} else if(valor <= 0) {
			System.out.print("Valor invalido para saque.");
		} else if(valor > this.saldo) {
			System.out.print("Saldo insuficiente.");
		} else {
			this.saldo -= valor;
		}
	}

	/**
	 * O metodo fechar conta verifica se a conta ja esta inativa, caso esteja a msg
	 * "Conta ja inativa." deve ser exibida no console. Caso o saldo nao esteja
	 * zerado, nao eh possivel fechar a conta e a msg "Conta com saldo. Nao eh
	 * possivel fecha-la." deve ser exibida no console. Com as condicoes de
	 * verificacao atendidas, a flag ativa deve ser ajustada para false, a fim de
	 * fechar a conta. Utilize System.out.print();
	 */
	public void fecharConta() {
		if(!this.status) {
			System.out.print("Conta ja inativa.");
		} else if(saldo != 0) {
			System.out.print("Conta com saldo. Nao eh possivel fecha-la.");
		} else {
			this.status = false;
		}
	}

	/**
	 * O metodo marca a flag ativa para true, caso a conta esteja desativada. No
	 * entanto, caso o metodo seja executado com a conta ja ativa, a msg "Conta já
	 * ativa." deve ser exibida no console. Utilize System.out.print();
	 */
	public void reabrirConta() {
		if (!this.status) {
			this.status = true;
		} if (this.status == true) {
			System.out.print("Conta já ativa.");
		}
	}

	/**
	 * Metodo exige que seja passado o parametro quantia e contadestino, o qual ira
	 * decrementar a quantia do saldo da conta que executa o metodo e incrementa a
	 * mesma quantia no saldo da conta destino. Trate as condicoes na seguinte ordem:
	 * Caso a conta de origem esteja desativada, exiba a msg no console:
	 * "Conta de origem inativa.". Em seguida, verifique se a conta destino
	 * tambem esta ativa, caso nao esteja exiba no console: 
	 * "Conta de destino inativa.". Por fim, caso a quantia passada seja maior
	 * que o saldo disponivel na conta de origem, a msg "Saldo insuficiente para
	 * transferencia." deve ser exibida no console. Utilize System.out.print();
	 * 
	 * @param quantia
	 * @param destino
	 */
	public void realizarTransferencia(double quantia, ContaBancaria destino) {
		if(!this.status) {
			System.out.print("Conta de origem inativa.");
		} else if(!destino.status) {
			System.out.print("Conta de destino inativa.");
		} else if(quantia > this.saldo) {
			System.out.print("Saldo insuficiente para transferencia.");
		} else {
			this.saldo -= quantia;
			destino.saldo += quantia;
		}
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public boolean isAtiva() {
		return status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroConta, saldo, status, titular);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaBancaria other = (ContaBancaria) obj;
		return numeroConta == other.numeroConta
				&& Double.doubleToLongBits(saldo) == Double.doubleToLongBits(other.saldo) && status == other.status
				&& Objects.equals(titular, other.titular);
	}
	
	
}
