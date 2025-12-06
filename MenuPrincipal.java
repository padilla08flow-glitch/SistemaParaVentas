package main;
import javax.swing.*;
/**
 *
 * @author alma1
 */
public class MenuPrincipal extends JFrame {
    public MenuPrincipal(String usuario, String rol) {
        setTitle("Ropa Artesanal - Menú");
        setSize(980,560);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panelMenu = new JPanel(null);
        panelMenu.setBounds(0,0,220,560);
        panelMenu.setBackground(new java.awt.Color(40,80,120));
        add(panelMenu);

        JButton btnClientes = crearBoton("Clientes", 30);
        JButton btnProveedores = crearBoton("Proveedores", 80);
        JButton btnProductos = crearBoton("Productos", 130);
        JButton btnInventario = crearBoton("Inventario", 180);
        JButton btnVentas = crearBoton("Ventas", 230);
        JButton btnApartados = crearBoton("Apartados", 280);
        JButton btnPagos = crearBoton("Pagos", 330);
        JButton btnReportes = crearBoton("Reportes", 380);
        JButton btnSalir = crearBoton("Salir", 430);

        panelMenu.add(btnClientes); panelMenu.add(btnProveedores); panelMenu.add(btnProductos);
        panelMenu.add(btnInventario); panelMenu.add(btnVentas); panelMenu.add(btnApartados);
        panelMenu.add(btnPagos); panelMenu.add(btnReportes); panelMenu.add(btnSalir);

        // Control de roles: solo admin puede ver Usuarios/Proveedores (ejemplo)
        if (!"Administrador".equalsIgnoreCase(rol)) {
            btnProveedores.setEnabled(false);
            btnReportes.setEnabled(false);
        }

        // Acciones: abrir formularios que usan tus clases CRUD
        btnClientes.addActionListener(e -> new ClientesForm().setVisible(true));
        btnProveedores.addActionListener(e -> { /* abrir ProveedoresForm */ });
        btnProductos.addActionListener(e -> { /* abrir ProductosForm */ });
        btnSalir.addActionListener(e -> { dispose(); new LoginForm().setVisible(true); });

        JLabel lbl = new JLabel("Bienvenido, " + usuario);
        lbl.setBounds(240, 40, 500, 30);
        lbl.setFont(new java.awt.Font("Arial",1,20));
        add(lbl);

        JLabel rolLbl = new JLabel("Rol: " + rol);
        rolLbl.setBounds(240, 75, 300, 20);
        add(rolLbl);
    }

    private JButton crearBoton(String text, int y) {
        JButton b = new JButton(text);
        b.setBounds(20, y, 180, 38);
        return b;
    }
}
