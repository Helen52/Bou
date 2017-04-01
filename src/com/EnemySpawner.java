package com;

public class EnemySpawner implements Runnable {
    static int x;
    static int y;
    static int x2;
    static int y2;
    static int dx;
    static int dy;
    static int dx2;
    static int dy2;
    static int n = 0;
    static int n2 = 0;

    public void run() {
        while (true) {
            try {
                Thread.sleep((int)(Math.random()*3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            n = (int) (Math.random() * 4);
            n2 = (int) (Math.random() * 4);
            switch (n) {
                case 0:
                    dx = 0;
                    dy = -2;
                    break;
                case 1:
                    dx = 0;
                    dy = 2;
                    break;
                case 2:
                    dx = -2;
                    dy = 0;
                    break;
                case 3:
                    dx = 2;
                    dy = 0;
                    break;
            }
            switch (EnemySpawner.n2) {
                case 0:
                    dx2 = 0;
                    dy2 = -2;
                    break;
                case 1:
                    dx2 = 0;
                    dy2 = 2;
                case 2:
                    dx2 = -2;
                    dy2 = 0;
                    break;
                case 3:
                    dx2 = 2;
                    dy2 = 0;
                    break;
            }

        }
    }
}
