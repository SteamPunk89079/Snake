import javax.swing.JFrame;

public class MyFrame extends JFrame{



    public MyFrame(){

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(new MyPanel());
        this.setResizable(false);




        this.pack();



    }
}
