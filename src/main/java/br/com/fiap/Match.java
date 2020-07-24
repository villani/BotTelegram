package br.com.fiap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Match {

	/**
	 * Variável do tipo String que contém a String a ser comparada
	 */
	private String value;
	/**
	 * Variável do tipo inteiro que contém a distância
	 */
	private int distance;

}
