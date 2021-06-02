import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Tes2 {
    private JPanel PanelUtama;
    private JPanel Panel1;
    private JLabel Header1;
    private JLabel Header2;
    private JLabel Logo;
    private JButton Login;
    private JLabel Waktu2;
    private JLabel Waktu;
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
                    if(B.isSelected()){
                        if(untukTimer==false){

                        }
                        else {
                            Tes3 tes3 = new Tes3(skor+20);
                            frame.dispose();
                            frame.setVisible(false);
                        }
                    }
                    else {
                        if(untukTimer==false){

                        }
                        else {
                            Tes3 tes3 = new Tes3(skor);
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

    public Tes2(int skor) {
        untukTimer=true;
        JFrame frame = new JFrame("Tes Online CPNS 2021");
        frame.setContentPane(PanelUtama);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        this.skor=skor;
        Border garistepi = BorderFactory.createLineBorder(Color.WHITE);
        PanelWaktu.setBorder(garistepi);
        Lanjut.setBorder(garistepi);
        WaktuMundur(frame);
        soal1.setText("Salah satu penyebab timbulnya cidera olahraga adalah kurangnya...\n");

        Lanjut.addActionListener(e -> {
            untukTimer = false;
            if(B.isSelected()){
                Tes3 tes3 = new Tes3(skor+20);
            }
            else {
                Tes3 tes3 = new Tes3(skor);
            }
            frame.dispose();
            frame.setVisible(false);
        });
    }
}
