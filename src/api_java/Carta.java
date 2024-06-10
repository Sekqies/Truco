package api_java;


enum Naipe {
    OUROS, ESPADAS, COPAS, PAUS

}
enum Valor{
    QUATRO, CINCO, SEIS, SETE, VALETE, DAMA, REI,AS,DOIS, TRES,

}

public class Carta {
    private Naipe naipe;
    private Valor valor;
    private String imagem; 
    public Carta(String naipe, String valor, String imagem){
        //Converte naipe para enum Naipe
        switch(naipe){
            case "HEARTS":
                this.naipe = Naipe.COPAS;
                break;
            case "DIAMONDS":
                this.naipe = Naipe.OUROS;
                break;
            case "CLUBS":
                this.naipe = Naipe.PAUS;
                break;
            case "SPADES":
                this.naipe = Naipe.ESPADAS;
                break;
        }
        //Converte valor para enum Valor
        switch(valor){
            case "2":
                this.valor = Valor.DOIS;
                break;
            case "3":
                this.valor = Valor.TRES;
                break;
            case "4":
                this.valor = Valor.QUATRO;
                break;
            case "5":
                this.valor = Valor.CINCO;
                break;
            case "6":
                this.valor = Valor.SEIS;
                break;
            case "7":
                this.valor = Valor.SETE;
                break;
            case "JACK":
                this.valor = Valor.VALETE;
                break;
            case "QUEEN":
                this.valor = Valor.DAMA;
                break;
            case "KING":
                this.valor = Valor.REI;
                break;
            case "ACE":
                this.valor = Valor.AS;
                break;
        }
        this.imagem = imagem;
    }
}
