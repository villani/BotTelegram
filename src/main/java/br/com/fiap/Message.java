package br.com.fiap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Message {

	/**
	 * Variável que indica o estágio da conversa
	 */
	private int state;

	/**
	 * Variável que contém o valor da mensagem
	 */
	private String value;


	/**
	 * Método que incrementa +1 ao estágio atual do objeto Message
	 */
	public void goForwardState() {
		this.state++;
	}

}
