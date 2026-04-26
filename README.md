## Fuga dos Perigos Noturnos - Versão Unicamp!

## DESCRIÇÃO DO JOGO:

Neste jogo de interação por terminal desenvolvido pelos alunos Gabriel Farias De Marco (249656) e João Vitor Ferreira Matias (196931), inspirado no card game e deckbuilder Slay the Spire, há um calouro da Universidade de Campinas que enfrenta diferentes festas, encaradas como perigos noturnos. Nele, seu objetivo é permanecer focado nos estudos mantendo sua sanidade e escapar dos "Perigos Noturnos" (festas universitárias) enfraquecendo-os diminuindo seu hype.

Para esclarecer os últimos termos, aqui explicamos os principais tópicos do jogo (representados pelas classes e seus objetos):

## Entidades:
    São definidas como os indivíduos que compõem o jogo. Englobam os heróis e os inimigos, que se enfrentam durante o combate. Possuem comportamentos em comum e específicos.

    Calouro (Héroi):

    Nome -> identificação do calouro. 
    Sanidade -> representa a "vida" do calouro. 
    Proteção -> representa o escudo/vida extra do calouro, utilizada somente durante um turno, sendo restaurada na troca deste. 
    Energia -> representa a capacidade de agir do calouro. É utilizada para realizar as ações do jogo, sendo consumida a cada uso de acordo com o custo de cada carta. A cada início de turno, é restaurada para seu valor máximo, analogamente à proteção.

    Festas Universitárias (Inimigo):

    Nome -> identificação da festa. 
    Hype -> representa a "vida" da festa. 
    Proteção -> representa o escudo/vida extra da festa, sendo restaurada assim como o escudo do calouro.

## Efeitos:
    Além das ações comuns de dano e escudo descritas abaixo na seção das Cartas, este jogo possui efeitos aplicáveis nas Entidades. Aqui, temos duas opções de efeitos:
        - Metanol: análogo a um veneno, em que ao final do turno da entidade afligida pelo efeito é descontado um valor X da sua vida, em que X corresponde aos acúmulos do efeito. Após a aplicação do dano, os acúmulos são reduzidos em 1 unidade. Com isso, a aplicação segue este ciclo até que os acúmulos se esgotem.
        - Investimento: análogo a uma força extra, este efeito concede dano extra a entidade que possui este efeito no momento em que esta realiza um ataque. O efeito é constante e uma vez aplicado dura até o final do combate.
    OBS: para as aplicações dos efeitos, utiliza-se cartas próprias assim como para as cartas de dano e de escudo, como descritas abaixo. 
    Como detalhes de implementação do programa, utiliza-se o padrão de designer Observer para notificar os momentos de ação dos efeitos, em que temos como Publisher (uma espécie de game manager) a classe Menu (utilizando trechos da classe App também), enquanto temos os próprios efeitos como Subscribers, notificados e agindo conforme o estado e executor de ações do combate.


## Cartas:
    Definem as ações do jogo. Cada carta define um modo de ataque ou defesa a base de energia para permitir que a batalha aconteça.

    CartaDano:

    Nome -> identificação da carta. 
    Custo -> o quanto de energia a carta consome. 
    Descrição -> Texto que informa sobre todos os atributos e usabilidade da carta.
    Dano -> o quanto de dano causa no adversário ao utilizá-la. Para o calouro, representa ações que este realiza para prejudicar as festas diminuindo o hype (relevância/popularidade) destas. Para as festas, representa ações que estas realizam para prejudicar o calouro e tentar fazê-lo perder sua sanidade.

    CartaEscudo:

    Nome -> identificação da carta.
    Custo -> o quanto de energia a carta consome.
    Descrição -> Texto que informa sobre todos os atributos e usabilidade da carta.
    Proteção -> o quanto de escudo/vida extra a carta fornece ao ser utilizada. Para o calouro, representa movimentos de blindagem ou para manter distância das festas e evitar a perda de sanidade. Para as festas, representa aumentar sua relevância ou popularidade.

    CartaEfeito:

    Nome -> identificação da carta.
    Custo -> o quanto de energia a carta consome.
    Descrição -> Texto que informa sobre todos os atributos e usabilidade da carta.
    Efeito -> indica qual o efeito que aquela carta aplica.
    Acumulos -> indica a quantidade de acúmulos do efeito correspondente que a carta oferece.
    
    - Apenas por detalhe e melhor visualização, foram implementadas duas CartaEfeito: "Resenhoff", a qual aplica o efeito Metanol com 3 acúmulos e a carta "Investimento" (mesmo nome do efeito), a qual aplica o efeito de Investimento com 3 acúmulos também.



## Jogabilidade:

Primeiramente, cada jogo abrange quatro eventos, seccionados como quatro fases. Os eventos incluem batalhas, o principal evento do jogo, lojas, fogueiras (para melhoria de cartas ou regeneração de vida) e escolhas. Neste jogo, chamamos as fogueiras de Bandeco e as escolhas de Aventura pelo Campus. Explica-se melhor os eventos na seção abaixo. Nas batalhas, caso o Herói perca toda sua vida, é derrotado e o jogo encerra. Para vencer, este deve avançar pelos eventos, derrotando inimigos pelo caminho e passando por demais eventos até chegar ao nível final, onde deve derrotar um inimigo especial como batalha final. Há um mapa comportando-se como árvore predefinido, em que a progressão do(a) jogador(a) ocorre com vitórias em batalhas, passagens por lojas e fogueiras, escolhas nas aventuras e decisões de qual caminho percorrer. 

Dessa forma, há uma batalha inicial predefinida com um inimigo inicial e, vencendo esta, o(a) jogador(a) (controlando o Herói) escolhe entre quatro opções para o segundo combate. Diante da vitória no segundo combate, o(a) jogador(a) escolhe qual evento deseja encarar como anterior ao combate final, que agora pode ter uma loja, fogueira, escolha ou um combate. Caso chegue no combate final e vença o inimigo especial, o jogo se encerra com vitória do herói. Caso seja derrotado em qualquer momento, o jogo se encerra com derrota do mesmo.

##  Eventos:

    Batalhas:

        Para garantir o dinamismo das partidas, o jogo utiliza um sistema de gerenciamento de cartas dividido em três zonas principais. A movimentação entre essas zonas ocorre de forma cíclica a cada turno:

        No início de cada combate, todas as cartas do inventário do Calouro são inseridas na Pilha de Compra de modo a iniciar o sistema. A cada novo turno, o(a) jogador(a) recebe as primeiras três cartas desta pilha que irão compor a sua mão. Dentre as cartas que tem, o(a) jogador(a) pode utilizar quantas desejar, desde que possua energia suficiente para cobrir o custo de cada carta. A cada turno, o(a) jogador(a) inicia com um valor máximo de quatro pontos de energia. Assim que uma carta é jogada, seu efeito (Dano ou Escudo) é aplicado e ela é movida imediatamente para a Pilha de Descarte. É importante apresentar que os escudos utilizados durante um turno duram apenas neste. Ao iniciar uma nova rodada, estes são resetados. Isso ocorre tanto para o Herói quanto para o Inimigo. Outro caso no qual a carta vai pra pilha de descarte é quando o(a) jogador(a) não usa uma carta. Caso a pilha de compra se esgote, a pilha de descarte é embaralhada e transformada em uma nova pilha de compra.

        Ao iniciar uma batalha, o usuário deverá escolher um nome para seu calouro, será direcionado para o primeiro combate e logo em seguida o mesmo será direcionado para um menu, podendo escolher entre:
            1 - Utilizar carta,
            2 - Encerrar turno.
        As cartas que vão para a mão do(a) jogador(a) são inicialmente embaralhadas na pilha de compra para garantir diferentes jogos e são selecionadas as três primeiras após isso para ir, de fato, à mão. Tais cartas variam entre:
            1 - Carta de Dano (Atacar) -> Concedem dano no inimigo (festa universitária); 
            2 - Carta de Escudo (Proteger) -> Concedem escudo ao herói (calouro); 
            3 - Carta de Efeito (Dano extra ou Veneno) -> Aplicadas ao herói ou a entidade (variam).

        o(a) jogador(a) deve sempre digitar a ação que quer realizar primeiramente e, após isso, digitar o número da carta que quer utilizar. Caso digite um número inválido, uma mensagem de erro é levantada e se requisita novamente o comando até que seja favorável. Além disso, caso o(a) jogador(a) tenha energia, mas não suficiente para utilizar as cartas restantes da mão, esse deve encerrar o turno para continuar o fluxo de jogo.

        Ao encerrar o turno ou esgotar sua energia, as cartas que estavam na mão do(a) jogador(a) vão para a pilha de descarte e o usuário encerra suas atividades naquele período e passa a vez para o inimigo;

        As jogadas do inimigo são randomizadas, tendo em vista que, a fim de tornar a experiência do(a) jogador(a) mais dinâmica, foram implementados mais de um inimigo (festas universitárias), bem como cartas de dano e escudo distintas das do herói.

        Após a vitória, o(a) jogador(a) recebe uma recompense. Lhe é oferecido(a) a opção entre receber ouro ou alguma carta. A quantidade de ouro pode variar entre 500 e 1500. Caso escolha carta, lhe é oferecido(a) algumas opções de cartas, com suas descrições, das quais ele pode escoher uma para ser adicionada ao seu baralho. Após isso, o(a) jogador(a) volta ao mapa para escolher seu próximo destino.
        
        Ao avançar, a vida e baralho do jogaodr não se alteram. Apenas efeitos e energia são restaurados à configuração inicial.

    Loja:

        Neste evento, o(a) jogador(a) se volta ao investimento de seu ouro em algumas ações estratégicas. Aqui, ele escolhe entre comprar novas cartas ou gastar seu ouro para remover cartas que sejam ineficientes na sua ideia de rotação e estratégia de jogo. Além disso, o(a) jogador(a) pode escolher simplesmente sair da loja. O(a) jogador(a) pode comprar repetidamente na mesma loja.

        Caso escolha comprar uma carta, lhe são oferecidas algumas cartas extras entre as quais pode escolher uma para comprar. Para a remoção, acontece algo semelhante, porém as cartas oferecidas são as do próprio baralho. O preço das cartas é proporcional ao custo energético.

        Para a implementação, utilizamos o padrão de design Command. Para consulta do padrão, utilizamos o catálogo do website Refactoring Guru (https://refactoring.guru/design-patterns/catalog). Como a loja pode ter diferentes execuções de ações, como comprar ou remover uma carta, possui diferentes comandos de ação por um mesmo executor (invoker), nesse caso a loja. Por isso, enquadramos este padrão para a implementação do sistema de progressão, que interage com o mapa em razão de ser um evento próprio deste. Como consome ouro e altera o baralho do herói, altera o estado do(a) jogador(a) para eventos futuros.

    Fogueira (Bandeco):

        No famoso Bandeco, o herói escolhe entre duas opções de utilização da fogueira: regeneração da própria vida ou melhoria de alguma das cartas que compõem o baralho. 
        
        Caso escolha a regeneração, este recebe 20% da sua vida máxima, que corresponde a 16 de vida em relação aos 80 máximos. Caso a regeneração ofereca mais do que 80 de vidas totais, o valor da vida máxima é truncado em 80. Caso escolha a melhoria, lhe são mostrados(as) as cartas atuais do baralho e este escolhe qual quer melhorar. A melhoria consiste em aumentar o valor da carta (dano, escudo ou efeito) na quantidade correspondente ao seu custo energético.

        Exemplo: carta que oferece 10 de dano exige 3 de energia para ser utilizada -> melhoria aumenta o dano para 13.

        Para a implementação, utilizamos o padrão de design Strategy. Da mesma forma, utilizamos o catálogo do website Refactoring Guru (https://refactoring.guru/design-patterns/catalog) para consulta. Como a fogueira é uma só e a sua utilização pode ser feita de diferentes maneiras, há uma estratégia de ação para contexto de utilização da fogueira. Por isso, enquadramos este padrão para a implementação do sistema de progressão, que também interage como evento com o mapa. Como altera vida e/ou cartas do baralho do herói, altera o estado do(a) jogador(a) para eventos futuros.
    
    Escolha (Aventura pelo Campus):

        Aqui, são oferecidos cenários diferentes de aventuras do herói pelo campus, com situações inusitadas em que ele precisa responder como reage. Conforme sua reação entre algumas opções, este sofre alguma consequência. As consequências podem envolver ganho de carta, ganho ou perda de vida, ganho de ouro ou aplicação de algum efeito para iniciar a próxima batalha.

Entre nessa jornada para descobrir quem é o inimigo final!

E de maneira simples mas concreta, esse é o modus operandi do jogo, esperamos que você se divirta e vença as tentações universitárias!

## COMO COMPILAR:

Certifique-se de estar na raiz do projeto no terminal e siga as instruções:

Para compilar, execute: ./gradlew build

Para iniciar o jogo, execute: ./gradlew run
