package ru.netology.manager;


import ru.netology.domain.Film;

import java.util.Arrays;

public class BillboardManager {
    private static final int DISPLAY_LENGTH = 10;

    private Film[] films = new Film[0];
    private int show;

    BillboardManager() {
        show = DISPLAY_LENGTH;
    }

    public BillboardManager(int show) {
        this.show = show;
    }

    public Film[] getFilms() {
        return films;
    }

    public void setFilms(Film[] films) {
        this.films = films;
    }

    public int getShow() {
        return show;
    }

    public void setShow(int show) {
        this.show = show;
    }

    /**
     * Добавить фильм
     */
    public void addFilm(Film film) {
        // Заводим новый массив с местом для нового элемента
        Film[] tmpArray = new Film[films.length + 1];
        // Копируем содержимое массива films в tmpArray
        System.arraycopy(films, 0, tmpArray, 0, films.length);

        tmpArray[tmpArray.length - 1] = film;

        films = tmpArray;

    }

    private int[] concat(int[] a, int[] b){
       int[] result = Arrays.copyOf(a, a.length + b.length);
       System.arraycopy(b, 0, result, a.length, b.length);

       return result;
    }

    /**
     * Получить последние фильмы (по умолчанию 10)
     */
    public Film[] getLastFilms() {
        // Выбираем, сколько будем показывать: если всего фильмов меньше
        // чем задано параметром show, то отображаем сколько есть
        int displayLength = Math.min(this.show, films.length);

        Film[] copyOfFilm = new Film[displayLength];
        for (int i = 0; i < displayLength; i++) {
            copyOfFilm[i] = films[films.length - i - 1];
        }

        return copyOfFilm;
    }
}
