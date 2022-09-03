package ru.netology.javaqa.game.game;
import ru.netology.javaqa.game.domain.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    protected List<Player> playerList = new ArrayList<>();

    public void register(Player player) {
        playerList.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;

        for (Player player : playerList) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }

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
