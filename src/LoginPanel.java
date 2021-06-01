import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LoginPanel {
    private JPanel PanelUtama;
    private JPanel Panel1;
    private JPanel Panel2;
    private JLabel UsenameBox;
    private JLabel PasswordBox;
    private JTextField Username;
    private JPasswordField Password;
    private JCheckBox checkBox;
    private JButton Login;
    private JLabel Header1;
    private JLabel Header2;
    private JLabel Logo;
    private JLabel CekLogin;
    private JLabel UsernameBox;

    public LoginPanel() {
        Border garistepi = BorderFactory.createLineBorder(Color.WHITE);
        Login.setBorder(garistepi);
        JFrame frame = new JFrame("Tes Online CPNS 2021");
        frame.setContentPane(PanelUtama);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        Password.setEchoChar('*');

        Login.addActionListener(e -> {
            CheckCredential cek = new CheckCredential(Username.getText(), Password.getText());
            boolean status = cek.CheckLogin();
            if (!status){
                Username.setText("");
                Password.setText("");
                CekLogin.setText("Username atau Password anda salah!");
            }
            else {
                Tes1 tes1 = new Tes1();
                frame.dispose();
                frame.setVisible(false);
            }
        });
        checkBox.addActionListener(e -> {
            if(checkBox.isSelected()){
                Password.setEchoChar((char)0);
            }
            else{
                Password.setEchoChar('*');
            }
        });
    }
}
