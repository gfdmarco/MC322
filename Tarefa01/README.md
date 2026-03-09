## Fuga dos Perigos Noturnos - Versão Unicamp! ##

## DESCRIÇÃO DO JOGO:
Neste jogo de interação por terminal desenvolvido pelos alunos Gabriel Farias De Marco (249656) e João Vitor Ferreira Matias (196931), inspirado no card game Slay the Spire, há um calouro da Universidade de Campinas que enfrenta diferentes festas, encaradas como perigos noturnos. Nele, seu objetivo é permanecer focado nos estudos mantendo sua sanidade e escapar dos "Perigos Noturnos" (festas universitárias) enfraquecendo-os diminuindo seu hype.

Para esclarecer os últimos termos, aqui explicamos os principais tópicos do jogo (representados pelas classes e seus objetos):

## Calouro (Héroi):
Nome -> identificação do calouro.
Sanidade -> representa a "vida" do calouro.
Proteção -> representa o escudo/vida extra do calouro, utilizada somente durante um turno, sendo restaurada na troca deste.
Energia -> representa a capacidade de agir do calouro. É utilizada para realizar as ações do jogo, sendo consumida a cada uso de acordo com o custo de cada carta. A cada início de turno, é restaurada para seu valor máximo, analogamente à proteção.

## Festas Universitárias (Inimigo):
Nome -> identificação da festa.
Hype -> representa a "vida" da festa.
Proteção -> representa o escudo/vida extra da festa, sendo restaurada assim como o escudo do calouro.

## CartaDano:
Nome -> identificação da carta.
Custo -> o quanto de energia a carta consome.
Dano -> o quanto de dano causa no adversário ao utilizá-la. Para o calouro, representa ações que este realiza para prejudicar as festas diminuindo o hype (relevância/popularidade) destas. Para as festas, representa ações que estas realizam para prejudicar o calouro e tentar fazê-lo perder sua sanidade.

## CartaEscudo:
Nome -> identificação da carta.
Custo -> o quanto de energia a carta consome.
Proteção -> o quanto de escudo/vida extra a carta fornece ao ser utilizada. Para o calouro, representa movimentos de blindagem ou para manter distância das festas e evitar a perda de sanidade. Para as festas, representa aumentar sua relevância ou popularidade.

## Jogabilidade:

Ao iniciar o jogo, o usuário deverá escolher um nome para seu calouro e logo em seguida o mesmo será direcionado para um menu, no qual poderá escolher entre 3 opções:

1 - Usar Carta de Dano (Atacar) -> Ao escolher essa opção, o usuário será direcionado para outro menu contendo as cartas de Dano;
2 - Usar Carta de Escudo (Proteger) -> Ao escolher essa opção, o usuário será direcionado para outro menu contendo as cartas de Escudo;
3 - Encerrar turno -> Ao escolher essa opção, o usuário encerra suas atividades naquele turno e passa a vez para o inimigo;

As jogadas do inimigo são randomizadas, tendo em vista que, a fim de tornar a experiência do jogador mais dinâmica, foram implementados mais de um inimigo (festas universitárias), bem como cartas de dano e escudo distintas das do herói.

E de maneira simples mas concreta, esse é o modus operandi do jogo, esperamos que você se divirta e vença as tentações universitárias!

## COMO COMPILAR:

Caso esteja na pasta "src" diretamente, no terminal, acesse a pasta src do projeto (Tarefa01) e execute: javac App.java. Após a compilação, execute: java App

Caso esteja na pasta "Tarefa01" propriamente, execute javac -d bin $(find src -name "App.java") para compular. Para a execução, após a compilação, execute: java -cp bin App.

## OBS: Certifique-se que ao compilar o usuário está na pasta "src" do projeto.