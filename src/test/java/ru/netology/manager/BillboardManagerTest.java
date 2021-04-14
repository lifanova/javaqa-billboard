package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BillboardManagerTest {
    BillboardManager manager;

    @BeforeEach
    void prepareData() {
        manager = new BillboardManager();

        Film[] films = new Film[10];
        films[0] = new Film(1, "The Lord of the Rings: The Fellowship of the Ring", "Fantasy");
        films[1] = new Film(2, "Raya and the Last Dragon", "Cartoon");
        films[2] = new Film(3, "Mortal Kombat", "Thriller");
        films[3] = new Film(4, "100% Wolf", "Cartoon");
        films[4] = new Film(5, "Godzilla vs. Kong", "Thriller");
        films[5] = new Film(6, "Way Down", "Thriller");
        films[6] = new Film(7, "Minari", "Drama");
        films[7] = new Film(8, "My Salinger Year", "Drama");
        films[8] = new Film(9, "Violet Evergarden: The Movie", "Cartoon");
        films[9] = new Film(10, "The Lord of the Rings: The Two Towers", "Fantasy");

        manager.setFilms(films);
    }

    @Test
    void shouldShowTenFilms() {
        int show = 10;
        manager.setShow(show);

        // Получить все фильмы
        Film[] films = manager.getFilms();

        Film[] expected = new Film[show];
        for (int i = 0; i < show; i++) {
            expected[i] = films[films.length - i - 1];
        }

        // Получить последние n
        Film[] actual = manager.getLastFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowThreeFilms() {
        int show = 3;
        manager.setShow(show);

        // Получить все фильмы
        Film[] films = manager.getFilms();
        System.out.println(Arrays.toString(films));

        Film[] expected = new Film[show];
        for (int i = 0; i < show; i++) {
            expected[i] = films[films.length - i - 1];
        }

        // Получить последние n
        Film[] actual = manager.getLastFilms();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowAboveMax() {
        int show = 12;
        manager.setShow(show);
        // Получить все фильмы
        Film[] films = manager.getFilms();
        System.out.println(Arrays.toString(films));

        Film[] expected = new Film[films.length];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = films[films.length - i - 1];
        }

        // Получить последние n
        Film[] actual = manager.getLastFilms();

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldAddFilm(){
        Film film = new Film(11, "Piter FM", "comedy");
        manager.addFilm(film);

        Film[] films = manager.getFilms();
        Film actual = films[films.length - 1];

        assertEquals(film, actual);
    }
}
