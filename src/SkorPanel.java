import javax.swing.*;

public class SkorPanel {
    private JPanel PanelUtama;
    private JPanel Panel1;
    private JLabel Header1;
    private JLabel Header2;
    private JLabel Logo;
    private JPanel Panel2;
    private JLabel CekLogin;
    private JButton Login;
    private JLabel Skor;
    private JLabel Pengumuman;

    private int skortotal;

    public SkorPanel(int skortotal) {
        this.skortotal=skortotal;

        JFrame frame = new JFrame("Tes Online CPNS 2021");
        frame.setContentPane(PanelUtama);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        Skor.setText(""+ skortotal);

        if(skortotal<80){
            Pengumuman.setText("Mohon maaf, anda tidak lolos pada seleksi tahun ini");
        }
        else {
            Pengumuman.setText("Selamat, anda dinyatakan lolos seleksi CPNS 2021");
        }

        Login.addActionListener(e -> System.exit(0));
    }
}