package br.com.fiap;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Boot {
	
	private static HashMap<String, String> faq;
	
	public static void carregarFaq(File csv) throws Exception {
		faq = new HashMap<>();
		Scanner leitor = new Scanner(csv);
		while (leitor.hasNextLine()) {
			String linha = leitor.nextLine();
			String[] campos = linha.split(";");
			faq.put(campos[0], campos[1]);
		}
		leitor.close();
	}
	
	public static String getQuestion(String question) {
		int menor = -1;
		String chave = "";
		for (String key: faq.keySet()) {
			int d = Helper.distance(key, question);
			if (d < menor || menor == -1) {
				menor = d;
				chave = key;
			}
		};
		return chave;
	}
	
	public static String getAnswer(String question) {
		String chave = getQuestion(question);
		return faq.get(chave);
	}

}
