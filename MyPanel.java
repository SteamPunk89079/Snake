import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
    private final int PIXEL_SIZE = 35;
    private final int SCREEN_SIZE = 700;

    public char direction = 'X';

    private Graphics2D g2d;
    public boolean apple_exists = false;

    private int score = 0;

    private int X = 10;
    private int Y = 10;

    private int apple_x = 1;
    private int apple_y = 1;

 
    public MyPanel(){

        this.setPreferredSize(new Dimension(SCREEN_SIZE, SCREEN_SIZE));
        this.setVisible(true);
    

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        direction = 'L';  
                        X = X - 1;
                        repaint();
                        break;            
                    case KeyEvent.VK_RIGHT:
                        direction = 'R';  
                        X = X + 1;
                        repaint();
                        break;            
                    case KeyEvent.VK_UP:
                        direction = 'U';  
                        Y = Y - 1;
                        repaint();
                        break;            
                    case KeyEvent.VK_DOWN:
                        direction = 'D';  
                        Y = Y + 1;
                        repaint();
                        break;            
                }
            };
        });


        
    }




    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        this.setBackground(Color.DARK_GRAY);

        g2d.setColor(Color.green);
        for ( int i = 0 ; i <= 100 ; i ++){
            g2d.drawLine(i*PIXEL_SIZE,0, i*PIXEL_SIZE, SCREEN_SIZE);
            g2d.drawLine(0, i*PIXEL_SIZE, SCREEN_SIZE, i*PIXEL_SIZE);
            
        }

        if ( X <= SCREEN_SIZE % PIXEL_SIZE || X >= 0){
            draw_apple();
            if (X == apple_x && Y == apple_y){
                generate_apple();
                score ++;
            }
            draw_snake();
        }
        
        this.requestFocusInWindow();
    }






    public void generate_apple(){
        Random rand = new Random();
        apple_x = rand.nextInt(20);
        apple_y = rand.nextInt(20);
    }

    public void draw_apple(){
        g2d.setColor(Color.RED);
        g2d.fillRect(apple_x*PIXEL_SIZE, apple_y*PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
    }

    public void draw_snake(){

        g2d.setColor(Color.green);
        g2d.fillRect(X*PIXEL_SIZE, Y*PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);



    }


    
    
}


