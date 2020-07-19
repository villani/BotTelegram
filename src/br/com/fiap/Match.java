package br.com.fiap;

public class Match {

	/**
	 * Variável do tipo String que contém a String a ser comparada
	 */
	private String value;
	/**
	 * Variável do tipo inteiro que contém a distância
	 */
	private int distance;

	/**
	 * Método que instancia um novo objeto do tipo Match
	 * @param value String que se deseja obter a distância
	 * @param distance inteiro com a distância
	 */
	public Match (String value, int distance) {
		this.value = value;
		this.distance = distance;
	}

	/**
	 * Método que obtém o valor da mensagem
	 * @return retorna valor obtido
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Método que atribui o valor a String value
	 * @param value do tipo String
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 *Método que obtém a distância
	 * @return retorna a distância obtida
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * Método que atribui o valor a distancia
	 * @param distance do tipo inteiro
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

}
