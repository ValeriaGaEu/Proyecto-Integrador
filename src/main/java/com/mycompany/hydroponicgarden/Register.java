/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hydroponicgarden;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Register extends JPanel {

    private static final Color VERDE_OSCURO   = new Color(6, 43, 6);
    private static final Color VERDE_TITULO   = new Color(30, 100, 30);
    private static final Color VERDE_BORDE    = new Color(76, 153, 76);
    private static final Color VERDE_BOTON    = new Color(76, 153, 0);
    private static final Color GRIS_CAMPO     = new Color(211, 211, 211);
    private static final Font  FUENTE_TITULO  = new Font("Serif", Font.BOLD, 28);
    private static final Font  FUENTE_LABEL   = new Font("SansSerif", Font.PLAIN, 14);
    private static final Font  FUENTE_LINK    = new Font("SansSerif", Font.BOLD, 13);

    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEmailTelefono;
    private JComboBox<String> cbDia;
    private JComboBox<String> cbMes;
    private JComboBox<String> cbAnio;
    private JPasswordField txtContrasena;
    private JPasswordField txtVerificaContrasena;
    private JButton btnRegistrate;
    private JLabel lblYaTengoCuenta;

    public Register() {
        setLayout(new BorderLayout());
        setBackground(VERDE_OSCURO);
        setPreferredSize(new Dimension(730, 730));

        // Panel blanco central con margen a los lados (efecto de la imagen)
        JPanel panelCentral = new JPanel();
        panelCentral.setBackground(Color.WHITE);
        panelCentral.setLayout(new GridBagLayout());
        panelCentral.setBorder(new EmptyBorder(30, 60, 30, 60));

        add(panelCentral, BorderLayout.CENTER);

        // Márgenes laterales verdes
        JPanel margenIzq = new JPanel();
        margenIzq.setBackground(VERDE_OSCURO);
        margenIzq.setPreferredSize(new Dimension(100, 10));
        JPanel margenDer = new JPanel();
        margenDer.setBackground(VERDE_OSCURO);
        margenDer.setPreferredSize(new Dimension(100, 10));
        add(margenIzq, BorderLayout.WEST);
        add(margenDer, BorderLayout.EAST);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 0, 4, 0);
        int fila = 0;

        // Título
        JLabel lblTitulo = new JLabel("Regístrate", SwingConstants.CENTER);
        lblTitulo.setFont(FUENTE_TITULO);
        lblTitulo.setForeground(VERDE_TITULO);
        gbc.gridy = fila++;
        gbc.insets = new Insets(0, 0, 25, 0);
        panelCentral.add(lblTitulo, gbc);
        gbc.insets = new Insets(4, 0, 4, 0);

        // Nombre (con icono)
        gbc.gridy = fila++;
        panelCentral.add(crearEtiquetaConIcono("Nombre"), gbc);
        txtNombre = crearCampoTexto();
        gbc.gridy = fila++;
        gbc.insets = new Insets(0, 0, 15, 0);
        panelCentral.add(txtNombre, gbc);
        gbc.insets = new Insets(4, 0, 4, 0);

        // Apellido
        gbc.gridy = fila++;
        panelCentral.add(crearEtiquetaCentrada("Apellido"), gbc);
        txtApellido = crearCampoTexto();
        gbc.gridy = fila++;
        gbc.insets = new Insets(0, 0, 15, 0);
        panelCentral.add(txtApellido, gbc);
        gbc.insets = new Insets(4, 0, 4, 0);

        // Email - Teléfono
        gbc.gridy = fila++;
        panelCentral.add(crearEtiquetaCentrada("Email- Telefono"), gbc);
        txtEmailTelefono = crearCampoTexto();
        gbc.gridy = fila++;
        gbc.insets = new Insets(0, 0, 15, 0);
        panelCentral.add(txtEmailTelefono, gbc);
        gbc.insets = new Insets(4, 0, 4, 0);

        // Fecha de nacimiento
        gbc.gridy = fila++;
        panelCentral.add(crearEtiquetaCentrada("Fecha de nacimiento"), gbc);

        JPanel panelFecha = new JPanel(new GridLayout(1, 3, 15, 0));
        panelFecha.setBackground(Color.WHITE);

        cbDia = new JComboBox<>(generarRango(1, 31));
        cbMes = new JComboBox<>(generarRango(1, 12));
        cbAnio = new JComboBox<>(generarRango(1920, 2026));
        cbAnio.setSelectedItem("1980");

        panelFecha.add(cbDia);
        panelFecha.add(cbMes);
        panelFecha.add(cbAnio);

        gbc.gridy = fila++;
        gbc.insets = new Insets(4, 0, 15, 0);
        panelCentral.add(panelFecha, gbc);
        gbc.insets = new Insets(4, 0, 4, 0);

        // Contraseña (con icono candado)
        gbc.gridy = fila++;
        panelCentral.add(crearEtiquetaConCandado("Contraseña"), gbc);
        txtContrasena = crearCampoPassword();
        gbc.gridy = fila++;
        gbc.insets = new Insets(0, 0, 15, 0);
        panelCentral.add(txtContrasena, gbc);
        gbc.insets = new Insets(4, 0, 4, 0);

        // Verifica la contraseña
        gbc.gridy = fila++;
        panelCentral.add(crearEtiquetaConCandado("Verifica la contraseña"), gbc);
        txtVerificaContrasena = crearCampoPassword();
        gbc.gridy = fila++;
        gbc.insets = new Insets(0, 0, 25, 0);
        panelCentral.add(txtVerificaContrasena, gbc);
        gbc.insets = new Insets(4, 0, 4, 0);

        // Botón Registrate
        btnRegistrate = new JButton("Registrate");
        btnRegistrate.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnRegistrate.setForeground(Color.WHITE);
        btnRegistrate.setBackground(VERDE_BOTON);
        btnRegistrate.setFocusPainted(false);
        btnRegistrate.setBorder(new EmptyBorder(10, 30, 10, 30));
        btnRegistrate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRegistrate.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(Color.WHITE);
        panelBoton.add(btnRegistrate);
        gbc.gridy = fila++;
        gbc.insets = new Insets(4, 0, 8, 0);
        panelCentral.add(panelBoton, gbc);
        gbc.insets = new Insets(4, 0, 4, 0);

        // Link "Ya tengo cuenta"
        lblYaTengoCuenta = new JLabel("Ya tengo cuenta", SwingConstants.CENTER);
        lblYaTengoCuenta.setFont(FUENTE_LINK);
        lblYaTengoCuenta.setForeground(VERDE_BOTON);
        lblYaTengoCuenta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridy = fila++;
        panelCentral.add(lblYaTengoCuenta, gbc);

        // Acciones de ejemplo (opcional, se pueden remover o conectar a lógica real)
        btnRegistrate.addActionListener(e -> onRegistrar());
        lblYaTengoCuenta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onYaTengoCuenta();
            }
        });
    }

    // ---------- Componentes auxiliares ----------

    private JLabel crearEtiquetaCentrada(String texto) {
        JLabel lbl = new JLabel(texto, SwingConstants.CENTER);
        lbl.setFont(FUENTE_LABEL);
        lbl.setForeground(Color.DARK_GRAY);
        return lbl;
    }

    private JPanel crearEtiquetaConIcono(String texto) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 6, 0));
        p.setBackground(Color.WHITE);
        JLabel icono = new JLabel("\uD83D\uDEE1"); // escudo (placeholder de icono)
        icono.setForeground(VERDE_BORDE);
        JLabel lbl = crearEtiquetaCentrada(texto);
        p.add(icono);
        p.add(lbl);
        return p;
    }

    private JPanel crearEtiquetaConCandado(String texto) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 6, 0));
        p.setBackground(Color.WHITE);
        JLabel icono = new JLabel("\uD83D\uDD12"); // candado (placeholder de icono)
        icono.setForeground(VERDE_BORDE);
        JLabel lbl = crearEtiquetaCentrada(texto);
        p.add(icono);
        p.add(lbl);
        return p;
    }

    private JTextField crearCampoTexto() {
        JTextField campo = new JTextField();
        campo.setPreferredSize(new Dimension(0, 32));
        campo.setBorder(BorderFactory.createLineBorder(VERDE_BORDE, 1));
        return campo;
    }

    private JPasswordField crearCampoPassword() {
        JPasswordField campo = new JPasswordField();
        campo.setPreferredSize(new Dimension(0, 32));
        campo.setBackground(GRIS_CAMPO);
        campo.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 1));
        return campo;
    }

    private String[] generarRango(int desde, int hasta) {
        String[] valores = new String[hasta - desde + 1];
        for (int i = 0; i < valores.length; i++) {
            int v = desde + i;
            valores[i] = (v < 10 ? "0" + v : String.valueOf(v));
        }
        return valores;
    }

    // ---------- Lógica de ejemplo (personalizar según necesidad) ----------

    private void onRegistrar() {
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String emailTelefono = txtEmailTelefono.getText().trim();
        String pass = new String(txtContrasena.getPassword());
        String pass2 = new String(txtVerificaContrasena.getPassword());
        String fechaNacimiento = cbDia.getSelectedItem() + "/" + cbMes.getSelectedItem() + "/" + cbAnio.getSelectedItem();

        if (nombre.isEmpty() || apellido.isEmpty() || emailTelefono.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!pass.equals(pass2)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String mensaje = "Registro exitoso:\n" +
                "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Email/Telefono: " + emailTelefono + "\n" +
                "Fecha de nacimiento: " + fechaNacimiento;
        JOptionPane.showMessageDialog(this, mensaje, "Registrado", JOptionPane.INFORMATION_MESSAGE);
    }

    private void onYaTengoCuenta() {
        JOptionPane.showMessageDialog(this, "Ir a la pantalla de inicio de sesión.", "Ya tengo cuenta", JOptionPane.INFORMATION_MESSAGE);
    }

    // ---------- Método main de prueba ----------

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Regístrate");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new Register());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);
        });
    }
}
