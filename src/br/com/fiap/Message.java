package br.com.fiap;

public class Message {

	/**
	 * Variável que indica o estágio da conversa
	 */
	private int stage;

	/**
	 * Variável que contém o valor da mensagem
	 */
	private String value;

	/**
	 * Método que instancia um novo objeto do tipo Message
	 * @param stage estágio da mensagem
	 * @param value valor da mensagem a ser enviada
	 */
	public Message(int stage, String value) {
		this.stage = stage;
		this.value = value;
	}

	/**
	 * Método para obter o estágio
	 * @return inteiro com o estágio atual
	 */
	public int getStage() {
		return stage;
	}

	/**
	 * Método para setar o estágio
	 * @param stage estágio atual da conversa
	 */
	public void setStage(int stage) {
		this.stage = stage;
	}

	/**
	 * Método que incrementa +1 ao estágio atual do objeto Message
	 */
	public void goForwardStage() {
		this.stage++;
	}

	/**
	 * Método para obter o valor da mensagem
	 * @return String com a mensagem
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Método para setar o valor da mensagem
	 * @param value do tipo String
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
