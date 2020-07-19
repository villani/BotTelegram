package br.com.fiap;

import java.util.HashMap;

public class Helper {

    /**
     * Método que calcula a distância de duas strings para saber o quão relacionadas estão
     * @param a do tipo String
     * @param b do tipo String
     * @return inteiro com o valor da distância
     */
	public static int distance(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        // i == 0
        int [] costs = new int [b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++) {
            // j == 0; nw = lev(i - 1, j)
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }

    /**
     * Método que faz o match entre um pergunta feita pelo usuário com a base de perguntas existentes
     * @param message String
     * @param map HashMap que possui chave e valor do tipo String
     * @return um objeto do tipo Match
     */
	public static Match getMatch(String message, HashMap<String, String> map) {
		int menor = -1;
		String chave = "";
		for (String key: map.keySet()) {
			int d = distance(key, message);
			if (d < menor || menor == -1) {
				menor = d;
				chave = key;
			}
		};
		Match m = new Match(chave, menor);
		return m;
	}
}
