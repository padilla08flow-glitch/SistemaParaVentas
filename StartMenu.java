package main;
import javax.swing.*;

public class StartMenu extends JFrame {

    public StartMenu() {
        setTitle("Ropa Artesanal - Inicio");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Crear panel de bontones
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        
        JButton btnLogin = new JButton("Iniciar Sesión");
        JButton btnRegistro = new JButton("Registrarse (Nuevo Usuario)");

        btnLogin.setAlignmentX(CENTER_ALIGNMENT);
        btnRegistro.setAlignmentX(CENTER_ALIGNMENT);
        
        panel.add(btnLogin);
        panel.add(Box.createVerticalStrut(15)); 
        panel.add(btnRegistro);

        add(panel);

        // Inicio de Sesión
        btnLogin.addActionListener(e -> {
            new LoginForm().setVisible(true);
            this.dispose();
        });
        //registro
        btnRegistro.addActionListener(e -> {
            new UsuariosForm().setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StartMenu().setVisible(true));
    }
}
