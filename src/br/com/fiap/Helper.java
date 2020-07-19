package br.com.fiap;

import java.util.HashMap;

public class Helper {

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
