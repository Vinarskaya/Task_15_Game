package ru.netology.javaqa.game.game;
import ru.netology.javaqa.game.domain.Player;
import java.util.HashMap;


public class Game {
    protected HashMap<String, Player> players= new HashMap<>();

    public void register(String name, Player player) {
        players.put(name, player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = players.get(playerName1);
        Player player2 = players.get(playerName2);

        if (player1 == null) {
            throw new RuntimeException(
                    "Player with name: " + playerName1 + " not found");
        }
        if (player2 == null) {
            throw new RuntimeException(
                    "Player with name: " + playerName2 + " not found");
        }

        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }
}
