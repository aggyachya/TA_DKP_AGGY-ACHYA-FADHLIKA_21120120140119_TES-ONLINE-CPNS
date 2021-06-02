import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Tes3 {
    private JPanel PanelUtama;
    private JPanel Panel1;
    private JLabel Header1;
    private JLabel Header2;
    private JLabel Logo;
    private JTextArea soal1;
    private JRadioButton A;
    private JButton Lanjut;
    private JPanel PanelWaktu;
    private JLabel Waktu;
    private JLabel Waktu2;
    private JPanel Panel2;
    private JRadioButton B;
    private JRadioButton C;
    private JRadioButton D;
    private JRadioButton E;
    private JLabel Nomer;
    private JPanel Gambar2;
    private JLabel Gambar;
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
                    if(A.isSelected()){
                        if(untukTimer==false){

                        }
                        else {
                            Tes4 tes4 = new Tes4(skor+20);
                            frame.dispose();
                            frame.setVisible(false);
                        }

                    }
                    else {
                        if (untukTimer==false){

                        }
                        else {
                            Tes4 tes4 = new Tes4(skor);
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

    public Tes3(int skor){
        untukTimer=true
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
        soal1.setText("10 tahun yang lalu Rudi pernah menjadi salah satu demonstran di\n" +
                "gedung DPR, sekarang Rudi telah menjadi bagian dari gedung itu,\n" +
                "apa yang seharusnya Rudi lakukan? \n");

        Lanjut.addActionListener(e -> {
            untukTimer = false;
            if(A.isSelected()){
                Tes4 tes4 = new Tes4(skor+20);
            }
            else {
                Tes4 tes4 = new Tes4(skor);
            }
            frame.dispose();
            frame.setVisible(false);
        });
    }
}
