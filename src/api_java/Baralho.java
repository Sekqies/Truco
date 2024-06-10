package api_java;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Baralho {
    private String deckID; 
    private int cartasRestantes;
    private HttpClient client = HttpClient.newBuilder().build();

    public void embaralhar()
    {
        String URL = "https://www.deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1&exclude=8C,8D,8H,8S,9C,9D,9H,9S,0C,0D,0H,0S";
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL)).build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200){
                String responseBody = response.body();
                JSONObject json = (JSONObject) parser.parse(responseBody);
                deckID = (String) json.get("deck_id");
                cartasRestantes = (int) json.get("remaining");
            }
            else{
                System.out.println("Request failed: " + response.statusCode());
            }
        }
    }
    public Carta[] retirarCarta(int numeroCartas)
    {
        String URL = "https://www.deckofcardsapi.com/api/deck/" + deckID + "/draw/?count=" + numeroCartas;
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL)).build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200){
                String responseBody = response.body();
                JSONObject json = (JSONObject) parser.parse(responseBody);
                cartasRestantes = (int) json.get("remaining");
                JSONArray cartas = (JSONArray) json.get("cards");
                Carta[] cartasRetiradas = new Carta[numeroCartas];
                for(int i = 0; i < numeroCartas; i++){
                    JSONObject carta = (JSONObject) cartas.get(i);
                    String valor = (String) carta.get("value");
                    String naipe = (String) carta.get("suit");
                    String imagem = (String) carta.get("image");
                    cartasRetiradas[i] = new Carta(valor, naipe, imagem);
                }
                return cartasRetiradas;
            }
            else{
                System.out.println("Request failed: " + response.statusCode());
            }
        }
    }
}
