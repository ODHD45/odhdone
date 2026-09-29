
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 太阳系GUI主窗体 - 优化高速刷新版本
 * @author xxx
 */
public class SolarFrame extends Frame implements Runnable {

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 800;

    private final int centerX;
    private final int centerY;

    private Sun sun;
    private Planet[] planets;
    private double[] angles;

    private int[] orbitR;
    private double[] speed;
    private Color[] planetColors;

    /** 预先创建字体，避免每次paint重复创建 */
    private Font titleFont;

    /** 离屏缓冲图，用于双缓冲 */
    private BufferedImage offScreenImage;
    private Graphics2D offScreenGraphics;

    public SolarFrame() {
        setTitle("244810069-陈家旺-太阳系八行星系统运行图");
        setSize(WIDTH, HEIGHT);
        setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setResizable(false);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });

        centerX = WIDTH / 2;
        centerY = HEIGHT / 2;

        titleFont = new Font("微软雅黑", Font.PLAIN, 30);

        initPlanetData();
        initOffScreenBuffer();

        new Thread(this, "SolarAnimationThread").start();
    }

    /**
     * 初始化离屏缓冲，实现双缓冲
     */
    private void initOffScreenBuffer() {
        offScreenImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        offScreenGraphics = offScreenImage.createGraphics();
        offScreenGraphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
    }

    private void initPlanetData() {
        planets = new Planet[8];
        angles = new double[8];

        orbitR = new int[]{120, 170, 220, 270, 360, 430, 500, 560};

        /** 速度整体放大，动画更明显 */
        speed = new double[]{
                0.08,   // 水星
                0.055,  // 金星
                0.042,  // 地球
                0.032,  // 火星
                0.018,  // 木星
                0.014,  // 土星
                0.011,  // 天王星
                0.008   // 海王星
        };

        planetColors = new Color[]{
                Color.GRAY,
                new Color(255, 230, 150),
                Color.BLUE,
                new Color(190, 70, 40),
                new Color(255, 180, 80),
                new Color(230, 200, 120),
                new Color(160, 220, 220),
                new Color(30, 60, 180)
        };

        planets[0] = new Planet("水星", 0.387, 88, 58.6);
        planets[1] = new Planet("金星", 0.72, 225, 243);
        planets[2] = new Planet("地球", 1, 365, 1);
        planets[3] = new Planet("火星", 1.52, 687, 1.03);
        planets[4] = new Planet("木星", 5.2, 4330, 0.41);
        planets[5] = new Planet("土星", 9.54, 10832, 0.45);
        planets[6] = new Planet("天王星", 19.218, 30777, 0.72);
        planets[7] = new Planet("海王星", 30.06, 60328, 0.67);

        sun = new Sun("太阳", 5778);
        for (Planet p : planets) {
            sun.addPlanet(p);
        }
    }

    @Override
    public void run() {
        while (true) {
            /** 更新行星角度 */
            for (int i = 0; i < 8; i++) {
                angles[i] += speed[i];
            }

            /** 直接调用 paint 绘制到离屏图，再贴到屏幕 */
            paint(offScreenGraphics);
            paintToScreen();

            try {
                Thread.sleep(16); // 约60帧/秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 将离屏缓冲一次性绘制到屏幕
     */
    private void paintToScreen() {
        Graphics g = getGraphics();
        if (g != null) {
            g.drawImage(offScreenImage, 0, 0, null);
            g.dispose();
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        /** 先清黑底 */
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);

        /** 绘制学号姓名 */
        g2d.setFont(titleFont);
        g2d.setColor(Color.WHITE);
        g2d.drawString("学号：244810069姓名：陈家旺", 50, 50);

        /** 绘制太阳 */
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(centerX - 40, centerY - 40, 80, 80);

        /** 绘制轨道和行星 */
        for (int i = 0; i < 8; i++) {
            g2d.setColor(Color.GRAY);
            g2d.drawOval(
                    centerX - orbitR[i],
                    centerY - orbitR[i],
                    orbitR[i] * 2,
                    orbitR[i] * 2);

            int px = (int) (centerX + orbitR[i] * Math.cos(angles[i]));
            int py = (int) (centerY + orbitR[i] * Math.sin(angles[i]));

            g2d.setColor(planetColors[i]);
            g2d.fillOval(px - 12, py - 12, 24, 24);

            g2d.setColor(Color.WHITE);
            g2d.drawString(planets[i].getPlanetName(), px + 15, py);
        }
    }

    public static void main(String[] args) {
        new SolarFrame().setVisible(true);
    }
}