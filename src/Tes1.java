import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Tes1 {
    private JPanel PanelUtama;
    private JPanel Panel1;
    private JLabel Header1;
    private JLabel Header2;
    private JLabel Logo;
    private JPanel Panel2;
    private JButton Lanjut;
    private JTextArea soal1;
    private JRadioButton A;
    private JRadioButton B;
    private JRadioButton C;
    private JRadioButton D;
    private JRadioButton E;
    private JLabel Nomer;
    private JLabel Waktu;
    private JLabel Waktu2;
    private JPanel PanelWaktu;

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
                    if(C.isSelected()){
                        if(untukTimer==false){

                        }
                        else {
                            Tes2 tes2 = new Tes2(20);
                            frame.dispose();
                            frame.setVisible(false);
                        }

                    }
                    else {
                        if(untukTimer==false){

                        }
                        else {
                            Tes2 tes2 = new Tes2(0);
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
    public Tes1() {
        untukTimer=true;

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

        soal1.setText("Windu = 8 tahun, Dekade/dasawarsa = 10 tahun, Abad = 100 tahun\n" +
                      "Aku sayang kamu selamanya = ...");

        Lanjut.addActionListener(e -> {
        untukTimer = false;
        if(C.isSelected()){
            Tes2 tes2 = new Tes2(20);
        }
        else {
            Tes2 tes2 = new Tes2(0);
        }
        frame.dispose();
        frame.setVisible(false);

        });
    }
}
