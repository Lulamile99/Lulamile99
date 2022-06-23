import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ColorMatch {
    JPanel[] pan;
    public void mainFrame(){
        //Main frame
        JFrame main_frame = new JFrame("Color Match");

        //Panels
        JPanel main_panel = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();
        JPanel p8 = new JPanel();
        JPanel p9 = new JPanel();

        pan = new JPanel[]{p1,p2,p3,p4,p5,p6,p7,p8,p9};
        addPanels(main_frame);
        //Set panel colors
        p1.setBackground(Color.GRAY);
        p2.setBackground(Color.RED);
        p3.setBackground(Color.BLUE);
        p4.setBackground(Color.GREEN);
        p5.setBackground(Color.YELLOW);
        p6.setBackground(Color.PINK);
        p7.setBackground(Color.LIGHT_GRAY);
        p8.setBackground(Color.BLUE);

        //Min frame color
        main_frame.setBackground(Color.black);

        //Main frame
        main_frame.setLayout(new GridLayout(3,3,4,4));
        main_frame.setSize(1000,1000);
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setVisible(true);
    }

    public void addPanels(JFrame main_frame){
        try {
            BufferedImage img = ImageIO.read(new File("YouTube-icon.png"));
            JLabel j = new JLabel(new ImageIcon(img));
            j.setSize(pan[0].getSize());
            for (int i = 0;i<pan.length;i++){
                main_frame.add(pan[i]);
                pan[i].add(j);
            }
        }
        catch (IOException e){
            System.out.println("Image not found");
        }
        //pan[0].add(img);
    }

    public static void main(String[] args) {
        ColorMatch a = new ColorMatch();
        a.mainFrame();
    }
}
