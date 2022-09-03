package ru.netology.javaqa.game.domain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.game.game.Game;

public class GameTest {
    Game game = new Game();

    Player player1 = new Player(3, "Ivan", 100);
    Player player2 = new Player(78, "Maks", 140);
    Player player3 = new Player(45, "Petya", 80);
    Player player4 = new Player(32, "Nikita", 150);
    Player player5 = new Player(89, "Kolya", 100);

    @BeforeEach
    public void setup() {
        game.register("Ivan", player1);
        game.register("Maks", player2);
        game.register("Petya", player3);
        game.register("Nikita", player4);
        game.register("Kolya", player5);
    }

    @Test
    public void firstShouldWinSecond () {

        int expected = 1;
        int actual = game.round("Ivan", "Petya");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondShouldWinFirst () {

        int expected = 2;
        int actual = game.round("Ivan", "Maks");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeADraw () {

        int expected = 0;
        int actual = game.round("Ivan", "Kolya");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowRunTimeExceptionBecauseOfFirstPlayer () {

        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Vanya", "Maks");
        });
    }

    @Test
    public void shouldThrowRunTimeExceptionBecauseOfSecondPlayer () {

        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Ivan", "Maksym");
        });
    }

    @Test
    public void shouldShowId () {

        int expected = 45;
        int actual = player3.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowName () {

        String expected = "Maks";
        String  actual = player2.getName();
        Assertions.assertEquals(expected, actual);
    }
}
