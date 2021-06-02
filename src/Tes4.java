import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tes4 {
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
    private JButton Play;
    private JLabel kata;
    private JButton button1;
    private JLabel PlayMusik;
    private int skor;

    private boolean untukTimer;

    Skor musik = new Skor("E:\\1. UNDIP\\2. SEMESTER 2\\11. Praktikum DKP\\TUGAS AKHIR\\TES_CPNS_ONLINE\\src\\AOT OPENING.WAV");
    Timer timer;
    int menit;
    int detik;
    int detik2;
    int putarmusik;

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
                    musik.Stop();
                    if(D.isSelected()){
                        if(untukTimer==false){

                        }
                        else {
                            Tes5 tes5 = new Tes5(skor+20);
                            frame.dispose();
                            frame.setVisible(false);
                        }

                    }
                    else {
                        if(untukTimer==false){

                        }
                        else {
                            Tes5 tes5 = new Tes5(skor);
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

    public Tes4(int skor){
        untukTimer=true;
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
        soal1.setText("Lagu di atas merupakan lagu yang harus dinyanyikan dengan tangan\n" +
                "kanan mengepal di dada. Lagu tersebut merupakan lagu kebangsaan ...\n");

        Lanjut.addActionListener(e -> {
            untukTimer = false;
            musik.Stop();
            if(D.isSelected()){
                Tes5 tes5 = new Tes5(skor+20);
            }
            else {
                Tes5 tes5 = new Tes5(skor);
            }
            frame.dispose();
            frame.setVisible(false);
        });

        button1.addActionListener(new ActionListener() {
            Timer timer2;
            int detik2=15;
            @Override
            public void actionPerformed(ActionEvent e) {
                musik.Start();
                button1.setEnabled(false);
                timer2 = new Timer(1000, e1 -> {
                    detik2--;
                    if(detik2==0){
                        timer2.stop();
                        button1.setEnabled(true);
                    }
                });
                timer2.start();
            }
        });
    }
}
