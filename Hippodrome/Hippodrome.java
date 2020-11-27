package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();

    public Hippodrome() {

    }

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    static Hippodrome game;

    void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        double max = 0;
        for (Horse horses : horses) {
            if (horses.distance > max) {
                max = horses.distance;
            }
        }
        for (Horse horses : horses) {
            if (horses.distance == max) {
                return horses;
            }
        }
        return null;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().name + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();
        game.getHorses().add(new Horse("\uD83D\uDC0E", 3, 0));
        game.getHorses().add(new Horse("\uD83D\uDC0E", 3, 0));
        game.getHorses().add(new Horse("\uD83D\uDC0E", 3, 0));

        game.run();
        game.printWinner();
    }
}
