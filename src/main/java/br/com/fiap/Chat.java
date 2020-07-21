package br.com.fiap;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Chat {

	/**
	 * Váriavel do tipo HashMap que contém o faq
	 */
	private static HashMap<String, String> faq;

	/**
	 * Variável do tipo HashMap que irá armazenar os arquivos .csv
	 */
	private static HashMap<String, String> bases;

	/**
	 * Método que inicializa a base
	 */
	public static void init() {
		bases = new HashMap<>();
		bases.put("coronavírus", "faq-corona-limpo.csv");
		bases.put("trânsito", "faq-transito-limpo.csv");
		bases.put("clima", "faq-clima-limpo.csv");
	}

	/**
	 * Método responsável por ler e carregar os arquivos .csv
	 * @param csv arquivo
	 * @throws Exception exceção caso não consiga ler o .csv
	 */
	public static void loadFaq(File csv) throws Exception {
		faq = new HashMap<>();
		Scanner leitor = new Scanner(csv);
		while (leitor.hasNextLine()) {
			String linha = leitor.nextLine();
			String[] campos = linha.split(";");
			faq.put(campos[0], campos[1]);
		}
		leitor.close();
	}

	/**
	 * Método que dada um string procura na base qual pode ser a resposta associada a ela
	 * @param question parâmetro do tipo string que contém a pergunta do usuário
	 * @return String com a possível resposta a pergunta do usuário
	 */
	public static String getFaq(String question) {
		String chave = Helper.getMatch(question, faq).getValue();
		return faq.get(chave);
	}

	/**
	 * Método responsável por controlar a máquina de estados e fornecer respostas ao usuário
	 * @param message do tipo Message que contém estágio da conversa e valor da mensagem
	 * @return retorna string com a resposta para o usuário
	 */
	public static String getAnswer(Message message) {
			String answer = "";
			switch (message.getStage()) {
			case 0:
				answer = "Olá, sou o VillaniBot e em minha base de conhecimentos há informações sobre o coronavírus, as leis de "
						+ "trânsito e o clima.";
				message.goForwardStage();
				
			case 1:
				answer += " Sobre quais desses assuntos gostaria de conversar?";
				message.goForwardStage();
				break;
			case 2:
				Match m = Helper.getMatch(message.getValue(), bases);
				if (m.getDistance() > 5) {
					answer = "Foi mal. Talvez eu não tenha entendido. Por favor, escreva somente: coronavírus OU "
							+ "trânsito OU clima.";
				} else {
					try {
						loadFaq(new File(bases.get(m.getValue())));
						answer = "Show! Vamos lá. O que quer saber a respeito de " + m.getValue() + "?";
						message.goForwardStage();
					} catch (Exception e) {
						answer = "Ops! Tive um problema para carregar a base sobre esse assunto :( \nPodemos falar sobre "
								+ "outra coisa?";
						message.setStage(1);
					}
					
				}
				break;
			case 3:
				answer = getFaq(message.getValue());
				answer += "\nGostaria de fazer outra pergunta ou mudar de assunto?";
				message.goForwardStage();
				break;
			case 4:
				if(message.getValue().equalsIgnoreCase("não") || message.getValue().equalsIgnoreCase("nao")){
					answer = "Tudo bem, quando quiser voltar a conversar, só me chamar";
					message.setStage(0);
					return answer;
				}
				if (Helper.distance(message.getValue(), "outra pergunta") < Helper.distance(message.getValue(), "mudar de assunto")) {
					answer = "Opa! Mande sua dúvida então...";
					message.setStage(3);
				} else {
					answer = "Sobre qual assunto?";
					message.setStage(2);
				}				
				
			}
			return answer;
		}

}
