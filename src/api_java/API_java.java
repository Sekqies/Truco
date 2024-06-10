/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package api_java;

/**
 *
 * @author maclocal
 */
public class API_java {

    public static void main(String[] args) {

        String URL = "https://api.ennead.cc/buruaka/character/" + finalNumber + "?id=true";//
        HttpClient client = HttpClient.newBuilder()//
        .build();//
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL)).build();//
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());//
            if (response.statusCode() == 200) {//
                String responseBody =  response.body();
                // Parse the JSON response body
                JSONParser parser = new JSONParser();
                JSONObject json = (JSONObject) parser.parse(responseBody);
                JSONObject character = (JSONObject) json.get("character");
                // Get the name from the character object
                String name = (String) character.get("name");
                System.out.println("Name: " + name);
                JSONObject info = (JSONObject) json.get("info");
                String club = (String) info.get("club");
                String school = (String) info.get("school");
                System.out.print("Enter club: ");
                Scanner scanner = new Scanner(System.in);
                String userClub = scanner.nextLine();
                System.out.print("Enter school: ");
                String userSchool = scanner.nextLine();
                 if (userClub.equals(club) && userSchool.equals(school)) {
                    System.out.println("Congratulations! Your guess is correct.");
                } else {
                    System.out.println("Sorry, your guess is incorrect.");
                    System.out.println("The correct club is: " + club);
                    System.out.println("The correct school is: " + school);
                }
            } else {
                System.out.println("Request failed: " + response.statusCode());
            }
        } catch (IOException | InterruptedException | ParseException e) {
            e.printStackTrace();
        }
    }
}
