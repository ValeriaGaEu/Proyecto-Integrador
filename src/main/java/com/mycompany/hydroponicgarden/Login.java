/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hydroponicgarden;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

/**
 * Pantalla de inicio de sesión - HydroFarm
 * Interfaz Swing para NetBeans.
 */
public class Login extends JFrame {

    private static final Color VERDE_OSCURO   = new Color(20, 54, 31);   // paneles laterales
    private static final Color VERDE_TITULO   = new Color(26, 107, 46);  // titulo "HydroFarm"
    private static final Color VERDE_BOTON    = new Color(76, 140, 43);  // boton
    private static final Color VERDE_BOTON_H  = new Color(66, 122, 37);  // boton hover
    private static final Color VERDE_LINK     = new Color(46, 139, 61);  // enlaces / iconos
    private static final Color GRIS_CAMPO     = new Color(217, 217, 217);
    private static final Color BEIGE_LOGO     = new Color(247, 244, 232);
    private static final Color BORDE_LOGO     = new Color(216, 207, 168);
    private static final Color BARRA_TITULO   = new Color(234, 243, 238);

    public Login() {
        setTitle("HydroFarm");
        setSize(1300, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        JPanel root = new JPanel(new BorderLayout());
        root.add(buildTitleBar(), BorderLayout.NORTH);
        root.add(buildBody(), BorderLayout.CENTER);

        setContentPane(root);
    }

    /* ---------- barra de titulo simulada ---------- */
    private JPanel buildTitleBar() {
        JPanel bar = new JPanel(new BorderLayout());
        bar.setBackground(BARRA_TITULO);
        bar.setPreferredSize(new Dimension(1360, 40));
        bar.setBorder(new EmptyBorder(0, 12, 0, 12));

        JLabel icon = new JLabel("\uD83C\uDF31"); // hoja
        icon.setFont(new Font("SansSerif", Font.PLAIN, 16));
        bar.add(icon, BorderLayout.WEST);

        JLabel controls = new JLabel("\u2013     \u25A1     \u2715");
        controls.setFont(new Font("SansSerif", Font.PLAIN, 14));
        controls.setForeground(new Color(60, 60, 60));
        bar.add(controls, BorderLayout.EAST);

        return bar;
    }

    /* ---------- cuerpo: panel verde | contenido | panel verde ---------- */
    private JPanel buildBody() {
        JPanel body = new JPanel(new BorderLayout());

        JPanel left = new JPanel();
        left.setBackground(VERDE_OSCURO);
        left.setPreferredSize(new Dimension(210, 10));

        JPanel right = new JPanel();
        right.setBackground(VERDE_OSCURO);
        right.setPreferredSize(new Dimension(210, 10));

        JPanel center = new JPanel(new GridBagLayout());
        center.setBackground(Color.WHITE);
        center.add(buildLoginCard());

        body.add(left, BorderLayout.WEST);
        body.add(right, BorderLayout.EAST);
        body.add(center, BorderLayout.CENTER);

        return body;
    }

    /* ---------- tarjeta central con el formulario ---------- */
    private JPanel buildLoginCard() {
        JPanel card = new JPanel();
        card.setBackground(Color.WHITE);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(new EmptyBorder(0, 0, 0, 0));
        card.setMaximumSize(new Dimension(420, 700));

        // logo
        JPanel logo = new LogoPanel();
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(logo);
        card.add(Box.createRigidArea(new Dimension(0, 20)));

        // titulo
        JLabel titulo = new JLabel("HydroFarm");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 34));
        titulo.setForeground(VERDE_TITULO);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(titulo);
        card.add(Box.createRigidArea(new Dimension(0, 8)));

        // subtitulo
        JLabel subtitulo = new JLabel("Inicia sesión para continuar");
        subtitulo.setFont(new Font("Serif", Font.PLAIN, 20));
        subtitulo.setForeground(new Color(51, 51, 51));
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(subtitulo);
        card.add(Box.createRigidArea(new Dimension(0, 28)));

        // campo correo o telefono
        card.add(buildFieldLabel("Correo o teléfono", 'U'));
        card.add(Box.createRigidArea(new Dimension(0, 8)));
        JTextField txtUsuario = new JTextField();
        txtUsuario.setText("");
        styleField(txtUsuario);
        card.add(wrapFullWidth(txtUsuario));
        card.add(Box.createRigidArea(new Dimension(0, 18)));

        // placeholder text (JTextField no soporta placeholder nativo)
        addPlaceholder(txtUsuario, "Ingresa tu correo o télefono");

        // campo contraseña
        card.add(buildFieldLabel("Contraseña", 'L'));
        card.add(Box.createRigidArea(new Dimension(0, 8)));
        JPasswordField txtPass = new JPasswordField();
        txtPass.setText("contraseña123");
        styleField(txtPass);
        card.add(wrapFullWidth(txtPass));
        card.add(Box.createRigidArea(new Dimension(0, 10)));

        // enlace olvidaste tu contraseña
        JLabel forgot = new JLabel("¿Olvidaste tu contraseña?");
        forgot.setFont(new Font("SansSerif", Font.PLAIN, 14));
        forgot.setForeground(VERDE_LINK);
        forgot.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgot.setAlignmentX(Component.RIGHT_ALIGNMENT);
        JPanel forgotWrap = new JPanel(new BorderLayout());
        forgotWrap.setBackground(Color.WHITE);
        forgotWrap.setMaximumSize(new Dimension(420, 24));
        forgotWrap.add(forgot, BorderLayout.EAST);
        card.add(forgotWrap);
        card.add(Box.createRigidArea(new Dimension(0, 24)));

        // boton iniciar sesion
        JButton btnLogin = new JButton("Iniciar sesión") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getModel().isRollover() ? VERDE_BOTON_H : VERDE_BOTON);
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 6, 6));
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btnLogin.setFont(new Font("SansSerif", Font.PLAIN, 16));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setOpaque(false);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.setMaximumSize(new Dimension(420, 44));
        btnLogin.setPreferredSize(new Dimension(420, 44));
        btnLogin.addActionListener(e ->
            JOptionPane.showMessageDialog(this, "Iniciando sesión...", "HydroFarm", JOptionPane.INFORMATION_MESSAGE));
        card.add(wrapFullWidth(btnLogin));
        card.add(Box.createRigidArea(new Dimension(0, 22)));

        // registrate aqui
        JPanel signupPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 0));
        signupPanel.setBackground(Color.WHITE);
        JLabel signupTxt = new JLabel("¿No tienes cuenta?");
        signupTxt.setFont(new Font("SansSerif", Font.PLAIN, 14));
        signupTxt.setForeground(new Color(51, 51, 51));
        JLabel signupLink = new JLabel("Regístrate aquí");
        signupLink.setFont(new Font("SansSerif", Font.BOLD, 14));
        signupLink.setForeground(VERDE_LINK);
        signupLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signupPanel.add(signupTxt);
        signupPanel.add(signupLink);
        signupPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(signupPanel);

        return card;
    }

    private JComponent buildFieldLabel(String texto, char tipoIcono) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("SansSerif", Font.PLAIN, 15));
        label.setForeground(new Color(34, 34, 34));
        label.setIcon(new IconoCampo(tipoIcono));
        label.setIconTextGap(10);

        JPanel wrap = new JPanel(new BorderLayout());
        wrap.setBackground(Color.WHITE);
        wrap.setMaximumSize(new Dimension(420, 26));
        wrap.setAlignmentX(Component.CENTER_ALIGNMENT);
        wrap.add(label, BorderLayout.WEST);
        return wrap;
    }

    private JComponent wrapFullWidth(JComponent comp) {
        JPanel wrap = new JPanel(new BorderLayout());
        wrap.setBackground(Color.WHITE);
        wrap.setMaximumSize(new Dimension(420, comp.getPreferredSize().height > 0 ? comp.getPreferredSize().height : 40));
        wrap.add(comp, BorderLayout.CENTER);
        wrap.setAlignmentX(Component.CENTER_ALIGNMENT);
        return wrap;
    }

    private void styleField(JTextField field) {
        field.setPreferredSize(new Dimension(420, 40));
        field.setBackground(GRIS_CAMPO);
        field.setForeground(new Color(51, 51, 51));
        field.setFont(new Font("SansSerif", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(VERDE_BOTON, 1, true),
                new EmptyBorder(0, 12, 0, 12)));
    }

    private void addPlaceholder(JTextField field, String placeholder) {
        field.setForeground(Color.GRAY);
        field.setText(placeholder);
        field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(new Color(51, 51, 51));
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setForeground(Color.GRAY);
                    field.setText(placeholder);
                }
            }
        });
    }

    /* ---------- logo circular con hoja ---------- */
    private class LogoPanel extends JPanel {
        LogoPanel() {
            setPreferredSize(new Dimension(90, 90));
            setMaximumSize(new Dimension(90, 90));
            setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(BEIGE_LOGO);
            g2.fill(new Ellipse2D.Double(2, 2, 86, 86));
            g2.setColor(BORDE_LOGO);
            g2.setStroke(new BasicStroke(1.5f));
            g2.draw(new Ellipse2D.Double(2, 2, 86, 86));

            g2.setColor(VERDE_BOTON);
            g2.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            int cx = 45, cy = 45;
            g2.drawLine(cx, cy + 20, cx, cy - 10);
            g2.drawArc(cx - 20, cy - 25, 20, 20, 0, 180);
            g2.drawArc(cx, cy - 25, 20, 20, 0, 180);
            g2.drawLine(cx, cy + 20, cx - 12, cy + 30);
            g2.drawLine(cx, cy + 20, cx + 12, cy + 30);

            g2.dispose();
        }
    }

    /* ---------- iconos simples junto a las etiquetas (usuario / candado) ---------- */
    private class IconoCampo implements Icon {
        private final char tipo;
        IconoCampo(char tipo) { this.tipo = tipo; }

        @Override
        public int getIconWidth() { return 22; }

        @Override
        public int getIconHeight() { return 22; }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(VERDE_BOTON);
            g2.setStroke(new BasicStroke(1.6f));

            if (tipo == 'U') {
                g2.drawOval(x + 6, y + 1, 10, 10);
                g2.drawArc(x + 2, y + 10, 18, 14, 0, 180);
            } else {
                g2.drawRoundRect(x + 4, y + 10, 14, 10, 3, 3);
                g2.drawArc(x + 7, y + 2, 8, 12, 0, 180);
            }
            g2.dispose();
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}
