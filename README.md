O **BotTelegram** é um *chatbot* integrado ao Telegram capaz de responder mais do que cinco perguntas sobre os três diferentes tipos de assuntos: coronavírus, trânsito e clima. As informações para as bases dos assuntos mencionados foram obtidas das seguintes fontes:
 
* [Agência Nacional de Vigilância Sanitária](http://portal.anvisa.gov.br/coronavirus/faq)
* [Departamento Nacional de Infraestrutura de Transportes](https://dnit.gov.br/rodovias/operacoes-rodoviarias/multas/perguntas-frequentes-faq)
* [Instituto Nacional de Pesquisas Espaciais](http://www.inpe.br/faq/index.php?pai=9)
* [Portal do Clima](http://portaldoclima.pt/pt/o-projeto/faqs/)

O funcionamento do BotTelegram considera a máquina de estados representada na Figura 1. Nessa figura cada elipse representa um estado. O estado inicial é identificado por uma seta apontada para ele e pelo rótulo S0. Cada arco orientado indicada a passagem de um estado para outro. O texto próximo a cada arco representa a interação realizada pelo usuário.

**Figura 1 - Máquina de estados usada no BotTelegram**

![Máquina de estados usada no BotTelegram]
(https://user-images.githubusercontent.com/2698761/87891494-805baa80-ca10-11ea-9695-ac23711770cd.png)


O usuário inicia a interação com uma mensagem fazendo com que o BotTelegram passe do Estado 0 para o Estado 2. O Estado 1 contém apenas uma apresentação e saudação ao usuário.

A interação do usuário do Estado 2 para o Estado 3, deverá selecionar a base de dados que será utilizada. A interação do Estado 3 para o Estado 4 deve conter uma das perguntas disponíveis no *FAQ* da base selecionada. Para essas interações optou-se pelo uso da Distância de Levenshtein. A Distância de Levenshtein é usada para comparar a similaridade (ou distância) entre duas cadeias de caracteres (textos). Neste caso, é comparado o texto informado pelo usuário com os possíveis textos esperados pelo BotTelegram. E então é retornada a resposta correspondente ao texto que mais se aproxima ao que o usuário informou.

No último estado, o usuário pode optar por mudar de assunto (retorna ao Estado 2), fazer outra pergunta do mesmo assunto (retorna ao Estado 3) ou encerrar a interação (retorna ao Estado 0).

Este software foi desenvolvido para avaliação final da disciplina Java Platform ministrada pelo Prof. Me. Rafael Tsuji Matsuyama no programa de MBA em Full Stack Developer da FIAP. O tutorial disponibilizado pelo professor e o link a seguir foram usados como referências para esse desenvolvimento:

* [Criando bots do Telegram com API Java](https://medium.com/@michelpf/criando-bots-do-telegram-com-api-java-64e921762b5f)
