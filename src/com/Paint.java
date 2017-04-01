package com;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Paint extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    static boolean ball_b = false;
    static boolean p = true;
    static int x = 100;
    static int y = 300;
    static int dx = 0;
    static int dy = 0;
    static int ballx = -100;
    static int bally = -100;
    static int balldx = 5;
    static int balldy = 5;
    static int enemies = 0;
    private long t0;
    private long t1;
    private int fps;
    private int frames;
    Image tank1 = new ImageIcon("res/tank1.jpg").getImage();
    Image tank2 = new ImageIcon("res/tank2.jpg").getImage();
    Image tank3 = new ImageIcon("res/tank3.jpg").getImage();
    Image tank4 = new ImageIcon("res/tank4.jpg").getImage();
    Image enemy1 = new ImageIcon("res/Enemy1.jpg").getImage();
    Image enemy2 = new ImageIcon("res/Enemy2.jpg").getImage();
    Image enemy3 = new ImageIcon("res/Enemy3.jpg").getImage();
    Image enemy4 = new ImageIcon("res/Enemy4.jpg").getImage();
    Image ball = new ImageIcon("res/ball.jpg").getImage();
    Image background = new ImageIcon("res/background.jpg").getImage();
    Image specieseffect = new ImageIcon("res/SpeciesEffect.jpg").getImage();
    static Image wall_image = new ImageIcon("res/wall.jpg").getImage();
    static Rectangle background_Rect;
    static Rectangle tank_Rect;
    static Rectangle enemy_Rect;
    static Rectangle enemy_Rect2;
    static Rectangle ball_Rect;
    static Thread enemyspawner = new Thread(new EnemySpawner());

    static boolean j = true;
    static JFrame m = new JFrame("power ups");
    static int wallx1 = (int) (Math.random() * PopUpJLabel2.m.getWidth());
    static int wallx2 = (int) (Math.random() * PopUpJLabel2.m.getWidth());
    static int wallx3 = (int) (Math.random() * PopUpJLabel2.m.getWidth());
    static int wallx4 = (int) (Math.random() * PopUpJLabel2.m.getWidth());
    static int wally1 = (int) (Math.random() * PopUpJLabel2.m.getHeight());
    static int wally2 = (int) (Math.random() * PopUpJLabel2.m.getHeight());
    static int wally3 = (int) (Math.random() * PopUpJLabel2.m.getHeight());
    static int wally4 = (int) (Math.random() * PopUpJLabel2.m.getHeight());
    static Rectangle wall_Rect1 = new Rectangle(wallx1, wally1,
            wall_image.getWidth(null), wall_image.getHeight(null));
    static Rectangle wall_Rect2 = new Rectangle(wallx2, wally2,
            wall_image.getWidth(null), wall_image.getHeight(null));
    static Rectangle wall_Rect3 = new Rectangle(wallx3, wally3,
            wall_image.getWidth(null), wall_image.getHeight(null));
    static Rectangle wall_Rect4 = new Rectangle(wallx4, wally4,
            wall_image.getWidth(null), wall_image.getHeight(null));

    public Paint() {

        enemyspawner.start();
        EnemySpawner.x = (int) (Math.random() * PopUpJLabel2.m.getWidth());
        EnemySpawner.y = (int) (Math.random() * PopUpJLabel2.m.getHeight());
        EnemySpawner.x2 = (int) (Math.random() * PopUpJLabel2.m.getWidth());
        EnemySpawner.y2 = (int) (Math.random() * PopUpJLabel2.m.getHeight());

        Timer r = new Timer(20, this);
        r.start();

    }

    public void paint(Graphics g) {

        if (enemies >= 1 && j == true) {
            m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            m.setResizable(false);
            m.setSize(300, 300);
            // m.setVisible(true);
            j = false;
        }
        Graphics2D g2d = (Graphics2D) g;
        ball_Rect = new Rectangle(ballx, bally, 7, 7);
        background_Rect = new Rectangle(0, 0, PopUpJLabel2.m.getWidth(),
                PopUpJLabel2.m.getHeight());
        g2d.drawImage(background, 0, 0, null);
        tank_Rect = new Rectangle(x, y, 35, 35);
        enemy_Rect = new Rectangle(EnemySpawner.x, EnemySpawner.y, 35, 35);
        enemy_Rect2 = new Rectangle(EnemySpawner.x2, EnemySpawner.y2, 35, 35);

        g2d.drawImage(wall_image, wallx1, wally1, null);
        g2d.drawImage(wall_image, wallx2, wally2, null);
        g2d.drawImage(wall_image, wallx3, wally3, null);
        g2d.drawImage(wall_image, wallx4, wally4, null);
        switch (PopUpJLabel2.img) {
            case 1:
                g2d.drawImage(tank1, x, y, null);

                break;
            case 2:
                g2d.drawImage(tank2, x, y, null);

                break;
            case 3:
                g2d.drawImage(tank3, x, y, null);

                break;
            case 4:
                g2d.drawImage(tank4, x, y, null);

                break;
        }
        if (ball_Rect.intersects(enemy_Rect)) {
            g2d.drawImage(specieseffect, ballx, bally, null);
            inter();
            EnemySpawner.x = (int) (Math.random() * PopUpJLabel2.m.getWidth());
            EnemySpawner.y = (int) (Math.random() * PopUpJLabel2.m.getHeight());

        }
        if (ball_Rect.intersects(enemy_Rect2)) {
            g2d.drawImage(specieseffect, ballx, bally, null);
            inter();
            EnemySpawner.x2 = (int) (Math.random() * PopUpJLabel2.m.getWidth());
            EnemySpawner.y2 = (int) (Math.random() * PopUpJLabel2.m.getHeight());

        }

        BasicStroke c = new BasicStroke(3); // ������� ����� 3 ��������������
        g2d.setStroke(c);
        g2d.setPaint(Color.GREEN);
        Polygon j = new Polygon();
        j.addPoint(0, 0);
        j.addPoint(493, 0);
        j.addPoint(493, 570);
        j.addPoint(0, 570);
        j.addPoint(0, 0);
        g.drawPolygon(j);
        BasicStroke c2 = new BasicStroke(1); // ������� ����� 3 ��������������
        g2d.setStroke(c2);
        int i = 0;
        for (int i1 = 0; i1 < 20; i1++) {
            g2d.setColor(Color.GREEN);
            g2d.drawLine(0, 0 + i, 500, 0 + i);
            i = i + 2;
        }
        int i2 = 0;
        for (int i1 = 0; i1 < 20; i1++) {
            g2d.setColor(Color.GREEN);
            g2d.drawLine(0, 570 + i2, 500, 570 + i2);
            i2 = i2 - 2;
        }

        switch (EnemySpawner.n) {
            case 0:
                g2d.drawImage(enemy1, EnemySpawner.x, EnemySpawner.y, null);

                break;
            case 1:
                g2d.drawImage(enemy2, EnemySpawner.x, EnemySpawner.y, null);

                break;
            case 2:
                g2d.drawImage(enemy3, EnemySpawner.x, EnemySpawner.y, null);

                break;
            case 3:
                g2d.drawImage(enemy4, EnemySpawner.x, EnemySpawner.y, null);

                break;
        }
        switch (EnemySpawner.n2) {
            case 0:
                g2d.drawImage(enemy1, EnemySpawner.x2, EnemySpawner.y2, null);

                break;
            case 1:
                g2d.drawImage(enemy2, EnemySpawner.x2, EnemySpawner.y2, null);

                break;
            case 2:
                g2d.drawImage(enemy3, EnemySpawner.x2, EnemySpawner.y2, null);

                break;
            case 3:
                g2d.drawImage(enemy4, EnemySpawner.x2, EnemySpawner.y2, null);

                break;
        }

        if (ball_b == true) {
            if (p == true) {
                switch (PopUpJLabel2.img) {
                    case 1:
                        balldy = -15;
                        balldx = 0;
                        break;
                    case 2:
                        balldy = 15;
                        balldx = 0;
                        break;
                    case 3:
                        balldx = -15;
                        balldy = 0;
                        break;
                    case 4:
                        balldx = 15;
                        balldy = 0;
                        break;
                }
                ballx = x + 17;
                bally = y + 17;
                p = false;
            }
            g2d.drawImage(ball, ballx, bally, null);
        }
        Font f = new Font("Italic", 30, 40);
        g2d.setColor(Color.BLUE);
        g2d.setFont(f);
        g2d.drawString(String.valueOf(enemies).toString(), 250, 33);
        frames++;
        t1 = System.currentTimeMillis();
        if (t1 - t0 >= 1000) {
            fps = frames;
            t0 = t1;
            frames = 0;
        }

        move();
        background_with_rects();
        enemy_with_tank();
        wall_with_rects();
        wall_with_ball();
        if (!background_Rect.contains(ball_Rect)) {
            if (ball_b == true) {
                ball_b = false;
            }
            p = true;
        }
        Font f1 = new Font("Default", 20, 20);
        g2d.setFont(f1);


    }

    private void wall_with_ball() {
        if (ball_Rect.intersects(wall_Rect1)
                || ball_Rect.intersects(wall_Rect2)
                || ball_Rect.intersects(wall_Rect3)
                || ball_Rect.intersects(wall_Rect4)) {
            ballx = -100;
            bally = -100;
            ball_b = false;

        }

    }

    int wx;
    int wy;

    private void wall_with_rects() {
        if (wall_Rect1.intersects(tank_Rect)) {

            wx = wallx1;
            wy = wally1;
            walltank();
        }
        if (wall_Rect2.intersects(tank_Rect)) {

            wx = wallx2;
            wy = wally2;
            walltank();
        }
        if (wall_Rect3.intersects(tank_Rect)) {

            wx = wallx3;
            wy = wally3;
            walltank();
        }
        if (wall_Rect4.intersects(tank_Rect)) {

            wx = wallx4;
            wy = wally4;
            walltank();
        }
        if (wall_Rect1.intersects(enemy_Rect)) {

            wx = wallx1;
            wy = wally1;
            walltank2();
        }
        if (wall_Rect2.intersects(enemy_Rect)) {

            wx = wallx2;
            wy = wally2;
            walltank2();
        }
        if (wall_Rect3.intersects(enemy_Rect)) {

            wx = wallx3;
            wy = wally3;
            walltank2();
        }
        if (wall_Rect4.intersects(enemy_Rect)) {

            wx = wallx4;
            wy = wally4;
            walltank2();
        }
        if (wall_Rect1.intersects(enemy_Rect2)) {

            wx = wallx1;
            wy = wally1;
            walltank3();
        }
        if (wall_Rect2.intersects(enemy_Rect2)) {

            wx = wallx2;
            wy = wally2;
            walltank3();
        }
        if (wall_Rect3.intersects(enemy_Rect2)) {

            wx = wallx3;
            wy = wally3;
            walltank3();
        }
        if (wall_Rect4.intersects(enemy_Rect2)) {

            wx = wallx4;
            wy = wally4;
            walltank3();
        }

    }

    private void walltank3() {
        if (dx == 2) {
            EnemySpawner.x2 = wx - wall_image.getWidth(null) - 4;

        }
        if (dx == -2) {
            EnemySpawner.x2 = wx + wall_image.getWidth(null) + 4;
        }
        if (dy == -2) {
            EnemySpawner.y2 = wy + wall_image.getHeight(null) + 4;
        }
        if (dy == 2) {
            EnemySpawner.y2 = wy - wall_image.getHeight(null) - 4;
        }

    }

    private void walltank2() {
        if (dx == 2) {
            EnemySpawner.x = wx - wall_image.getWidth(null) - 4;

        }
        if (dx == -2) {
            EnemySpawner.x = wx + wall_image.getWidth(null) + 4;
        }
        if (dy == -2) {
            EnemySpawner.y = wy + wall_image.getHeight(null) + 4;
        }
        if (dy == 2) {
            EnemySpawner.y = wy - wall_image.getHeight(null) - 4;
        }


    }

    private void walltank() {

        if (dx == 2) {
            x = wx - wall_image.getWidth(null) - 4;

        }
        if (dx == -2) {
            x = wx + wall_image.getWidth(null) + 4;
        }
        if (dy == -2) {
            y = wy + wall_image.getHeight(null) + 4;
        }
        if (dy == 2) {
            y = wy - wall_image.getHeight(null) - 4;
        }

    }

    private void enemy_with_tank() {
        if (enemy_Rect.intersects(tank_Rect)
                || enemy_Rect2.intersects(tank_Rect)) {
            x = (int) (Math.random() * PopUpJLabel2.m.getWidth());
            y = (int) (Math.random() * PopUpJLabel2.m.getHeight());
        }

    }

    private void background_with_rects() {
        if (background_Rect.getMinX() >= tank_Rect.getMinX()) {
            x = x + Math.abs(dx);
        }
        if (background_Rect.getMaxX() <= tank_Rect.getMaxX()) {
            x = x - Math.abs(dx);
        }
        if (background_Rect.getMinY() >= tank_Rect.getMinY()) {
            y = y + Math.abs(dy);
        }
        if (background_Rect.getMaxY() <= tank_Rect.getMaxY() + 35) {
            y = y - Math.abs(dy);
        }

        if (background_Rect.getMinX() >= enemy_Rect.getMinX()) {
            EnemySpawner.x = EnemySpawner.x + 2;
        }
        if (background_Rect.getMaxX() <= enemy_Rect.getMaxX()) {
            EnemySpawner.x = EnemySpawner.x - 2;
        }
        if (background_Rect.getMinY() >= enemy_Rect.getMinY()) {
            EnemySpawner.y = EnemySpawner.y + 2;
        }
        if (background_Rect.getMaxY() <= enemy_Rect.getMaxY() + 35) {
            EnemySpawner.y = EnemySpawner.y - 2;
        }

        if (background_Rect.getMinX() >= enemy_Rect2.getMinX()) {
            EnemySpawner.x2 = EnemySpawner.x2 + 2;
        }
        if (background_Rect.getMaxX() <= enemy_Rect2.getMaxX()) {
            EnemySpawner.x2 = EnemySpawner.x2 - 2;
        }
        if (background_Rect.getMinY() >= enemy_Rect2.getMinY()) {
            EnemySpawner.y2 = EnemySpawner.y2 + 2;
        }
        if (background_Rect.getMaxY() <= enemy_Rect2.getMaxY() + 35) {
            EnemySpawner.y2 = EnemySpawner.y2 - 2;
        }

    }

    private void inter() {
        ballx = -100;
        bally = -100;
        enemies++;
        ball_b = false;
    }

    public static void move() {
        x = x + dx;
        y = y + dy;
        EnemySpawner.x += EnemySpawner.dx;
        EnemySpawner.y += EnemySpawner.dy;
        EnemySpawner.x2 += EnemySpawner.dx2;
        EnemySpawner.y2 += EnemySpawner.dy2;
        if(ball_b == true){
            ballx += balldx;
            bally += balldy;
        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();

    }
}
