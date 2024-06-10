package api_java;

public class Jogo {
    private int manilha;
    private static Baralho baralho;
    private Jogador jogador;
    private Jogador oponente;
    public void comecarJogo()
    {
        baralho = new Baralho();
        baralho.embaralhar();
        jogador.cartas = baralho.retirarCarta(3);
        oponente.cartas = baralho.retirarCarta(3);
        Tombar();
    }
    public static void Tombar()
    {
        Carta[] tombo = baralho.retirarCarta(1);
        System.out.println("Tombo: " + tombo[0].getValor() + " de " + tombo[0].getNaipe());
        this.manilha = tombo[0].getValor();
    }
}
