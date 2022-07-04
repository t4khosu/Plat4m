/*
 * Settings
 * -------------------
 *
 * 1) Breakpoints ändern
 * 		Einstellungen dazu befinden sich in World.java->Konstruktor.
 * 		Hier wird ein neuer BreakPointManager erzeugt und der aktuelle Punkt gesetzt.
 * 		SetBreakPointBeginning(0) ist der Standardbeginn. Bei points = 3 ist
 * 		man direkt in der Welt.
 * 		Weiterhin kann man den PlayerModus einstellen, wobei modus = 0 der Gottmodus ist.
 *
 * 2) Wetter Setting
 * 		Wetter wird in World.java pro Tick geupdatet. Startzeitpunkt und Dauer werden
 * 		als Attribut verwaltet und können dort zu Testzwecken geändert werden.
 * 		Das Attribut fasterWeather kann hierfür verwendet werden. Umso größer der Wert,
 * 		Desto schneller läuft der Wettervorgang ab.
 */


package com.t4khosu.Platformer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.t4khosu.Platformer.graphics.Screen;
import com.t4khosu.Platformer.Level.World;
import com.t4khosu.Platformer.Surface.Surface;
import com.t4khosu.Platformer.input.Keyboard;

public class Game extends Canvas implements Runnable {

    /*
     * Umlaute:
     * ae -> \u00E4, Ae -> \u00C4
     * oe -> \u00F6, Oe -> \u00D6
     * ue -> \u00FC, Ue ->\u00DC
     * sz -> \u00df,
     * arrow right -> \u21E8,
     */

    private static final long serialVersionUID = 1L;

    public static int width = 350;
    public static int height = width * 9 / 16;
    public static int scale = 3;

    private static final String title = "Plat4m";
    private static boolean running = false;

    private final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private final int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    Thread thread;
    JFrame frame;
    Screen screen;

    Keyboard keyBoard;
    World world;
    Surface surface;

    public static int timer = 0;

    private boolean updateFluctuationTooGreat = false;

    public Game() {
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);
        frame = new JFrame();
        screen = new Screen(width, height);

        keyBoard = new Keyboard();
        addKeyListener(keyBoard);

        world = new World(keyBoard);
        surface = new Surface(keyBoard, world);
        world.initSurface(surface);
    }

    public synchronized void start() {
        world.getPlayer().initWorld(world);
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        requestFocus();

        long lastTime = System.nanoTime();
        final int goalUpdatesPerSecond = 55;
        final double ns = 1000000000.0 / goalUpdatesPerSecond;
        double delta = 0;

        int updates = 0;
        int updatesPerSecond = 0;
        int renders = 0;
        long timeSpent = 0;

        while (running) {
            long now = System.nanoTime();
            timeSpent += now - lastTime;
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1) {
                this.updateFluctuationTooGreat = updatesPerSecond <= goalUpdatesPerSecond - 5 || updatesPerSecond >= goalUpdatesPerSecond + 5;

                if (!this.updateFluctuationTooGreat) {
                    update();
                }
                updates++;
                delta--;
            }

            render();
            renders++;

            if (timeSpent >= 1000000000) {
                frame.setTitle(title + " | Updates per Second: " + updates + " | Frames per Second: " + renders);

                updatesPerSecond = updates;
                timeSpent = 0;
                updates = 0;
                renders = 0;
            }
        }
    }

    private void update() {
        if (timer > 2000) timer = 0;
        timer++;

        keyBoard.update();
        world.update();
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        int xScroll = world.getCamera().getX() - screen.getWidth() / 2;
        int yScroll = world.getCamera().getY() - screen.getHeight() / 2;

        if (xScroll < 0) xScroll = 0;
        if (yScroll < 0) yScroll = 0;
        if (yScroll > (world.getActualArea().getActualLevel().tileHeight * 8) - screen.getHeight())
            yScroll = (world.getActualArea().getActualLevel().tileHeight * 8) - screen.getHeight();
        if (xScroll > (world.getActualArea().getActualLevel().tileWidth * 8) - screen.getWidth())
            xScroll = (world.getActualArea().getActualLevel().tileWidth * 8) - screen.getWidth();

        screen.clear();

        if (!this.updateFluctuationTooGreat) {
            world.render(screen, xScroll, yScroll);
        }

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen.getPixels()[i];
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        if (!this.updateFluctuationTooGreat) {
            world.render(g);
        } else {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial Hebrew", Font.PLAIN, 20));
            g.drawString("Loading...", 30, 30);
        }

        g.dispose();
        bs.show();
    }


    public synchronized void stop() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setTitle(title);
        game.frame.setVisible(true);
        game.frame.setLocationRelativeTo(null);
        game.frame.setResizable(false);

        game.start();
    }
}
