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

Primeiramente, cada jogo abrange três combates Herói vs Inimigo. Caso o Herói perca toda sua vida, é derrotado e o jogo encerra. Para vencer, este deve derrotar os três inimigos das três batalhas. Há um mapa comportando-se como árvore predefinido, em que a progressão do jogador ocorre com vitórias e escolhas de qual caminho percorrer. 

Dessa forma, há uma batalha inicial predefinida com um inimigo inicial e, vencendo esta, o jogador (controlando o Herói) escolhe entre três opções para o segundo combate. Diante da vitória no segundo combate, o jogador escolhe uma entre duas opções para o combate final. Caso vença este, vence o jogo e este é encerrado. Caso seja derrotado em qualquer momento, o jogo se encerra.

Para garantir o dinamismo das partidas, o jogo utiliza um sistema de gerenciamento de cartas dividido em três zonas principais. A movimentação entre essas zonas ocorre de forma cíclica a cada turno:

No início de cada combate, todas as cartas do inventário do Calouro são inseridas na Pilha de Compra de modo a iniciar o sistema. A cada novo turno, o jogador recebe as primeiras três cartas desta pilha que irão compor a sua mão. Dentre as cartas que tem, o jogador pode utilizar quantas desejar, desde que possua energia suficiente para cobrir o custo de cada carta. A cada turno, o jogador inicia com um valor máximo de quatro pontos de energia. Assim que uma carta é jogada, seu efeito (Dano ou Escudo) é aplicado e ela é movida imediatamente para a Pilha de Descarte. É importante apresentar que os escudos utilizados durante um turno duram apenas neste. Ao iniciar uma nova rodada, estes são resetados. Isso ocorre tanto para o Herói quanto para o Inimigo. Outro caso no qual a carta vai pra pilha de descarte é quando o jogador não usa uma carta. Caso a pilha de compra se esgote, a pilha de descarte é embaralhada e transformada em uma nova pilha de compra.

Ao iniciar o jogo, o usuário deverá escolher um nome para seu calouro, será direcionado para o primeiro combate e logo em seguida o mesmo será direcionado para um menu, podendo escolher entre:
    1 - Utilizar carta,
    2 - Encerrar turno.
As cartas que vão para a mão do jogador são inicialmente embaralhadas na pilha de compra para garantir diferentes jogos e são selecionadas as três primeiras após isso para ir, de fato, à mão. Tais cartas variam entre:
    1 - Carta de Dano (Atacar) -> Concedem dano no inimigo (festa universitária); 
    2 - Carta de Escudo (Proteger) -> Concedem escudo ao herói (calouro); 
    3 - Carta de Efeito (Dano extra ou Veneno) -> Aplicadas ao herói ou a entidade (variam).

O jogador deve sempre digitar a ação que quer realizar primeiramente e, após isso, digitar o número da carta que quer utilizar. Caso digite um número inválido, uma mensagem de erro é levantada e se requisita novamente o comando até que seja favorável. Além disso, caso o jogador tenha energia, mas não suficiente para utilizar as cartas restantes da mão, esse deve encerrar o turno para continuar o fluxo de jogo.

Ao encerrar o turno ou esgotar sua energia, as cartas que estavam na mão do jogador vão para a pilha de descarte e o usuário encerra suas atividades naquele período e passa a vez para o inimigo;

As jogadas do inimigo são randomizadas, tendo em vista que, a fim de tornar a experiência do jogador mais dinâmica, foram implementados mais de um inimigo (festas universitárias), bem como cartas de dano e escudo distintas das do herói.

Após a vitória, o jogador escolhe qual o próximo inimigo que irá batalhar contra. Dessa forma, escolherá um caminho. Esolhendo um caminho, a batalha correspondente será iniciada e assim por diante. Ao avançar, a vida e baralho do jogaodr não se alteram. Apenas efeitos e energia são restaurados à configuração inicial.

E de maneira simples mas concreta, esse é o modus operandi do jogo, esperamos que você se divirta e vença as tentações universitárias!

## COMO COMPILAR:

Certifique-se de estar na raiz do projeto no terminal e siga as instruções:

Para compilar, execute: ./gradlew build

Para iniciar o jogo, execute: ./gradlew run
