import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Tes5 {
    private JPanel PanelUtama;
    private JPanel Panel1;
    private JLabel Header1;
    private JLabel Header2;
    private JLabel Logo;
    private JPanel Panel2;
    private JTextArea soal1;
    private JRadioButton A;
    private JRadioButton B;
    private JRadioButton C;
    private JRadioButton D;
    private JRadioButton E;
    private JLabel Nomer;
    private JButton Lanjut;
    private JPanel PanelWaktu;
    private JLabel Waktu;
    private JLabel Waktu2;
    private int skor;

    private boolean untukTimer;

    Timer timer;
    int menit;
    int detik;

    public void WaktuMundur(JFrame frame){
        menit = 2;
        detik = 0;
        timer = new Timer(1000, e -> {
            Waktu.setText(""+ menit);
            if(detik<10){
                Waktu2.setText(":  0" +detik);
            }
            else {
                Waktu2.setText(":  " +detik);
            }

            if (detik==0){
                menit--;
                if (menit<0){
                    timer.stop();
                    if(E.isSelected()){
                        if(untukTimer==false){

                        }
                        else {
                            SkorPanel skorPanel = new SkorPanel(skor+20);
                            frame.dispose();
                            frame.setVisible(false);
                        }
                    }
                    else {
                        if(untukTimer==false){

                        }
                        else {
                            SkorPanel skorPanel = new SkorPanel(skor);
                            frame.dispose();
                            frame.setVisible(false);
                        }

                    }

                }
                detik=60;
            }
            detik--;
        });
        timer.start();
    }

    public Tes5(int skor){
        this.skor=skor;
        Border garistepi = BorderFactory.createLineBorder(Color.WHITE);
        PanelWaktu.setBorder(garistepi);
        Lanjut.setBorder(garistepi);

        JFrame frame = new JFrame("Tes Online CPNS 2021");
        frame.setContentPane(PanelUtama);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        WaktuMundur(frame);
        soal1.setText("Bangsa yang besar adalah bangsa yang tak lupa jasa para pahlawannya.\n" +
                "Oleh karena itu, sebutkan satu tokoh pahlawan pemersatu bangsa ...");

        Lanjut.addActionListener(e -> {
            untukTimer=false;

            if(E.isSelected()){
                SkorPanel skorPanel = new SkorPanel(skor+20);
            }
            else {
                SkorPanel skorPanel = new SkorPanel(skor);
            }
            frame.dispose();
            frame.setVisible(false);
        });
    }
}