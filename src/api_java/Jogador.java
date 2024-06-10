package api_java;

public class Jogador {
    private Carta[] cartas;
    private int pontos;
    public Jogador(Carta[] cartas){
        this.cartas = cartas;
        this.pontos = 0;
    }
}
