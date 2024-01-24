package holyStudio.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

    private JButton comecar;
    private JButton fecharButton;
    private JButton theRoom;

    public static int WIDTH = 390;
    public static int HEIGHT = 240;
    public static int SCALE = 3;

    public static JFrame jframe;

    private Game game;

    public Menu() {
        setTitle("Lost Will");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH * SCALE, HEIGHT * SCALE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);

        JLabel titleLabel = new JLabel("LOST WILL");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Sabon", Font.BOLD, 120));
        titleLabel.setBorder(new EmptyBorder(20, 0, 10, 0));
        titleLabel.setForeground(Color.YELLOW);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(Color.BLACK);
        comecar = createCustomButton("Começar");
        fecharButton = createCustomButton("Fechar");
        theRoom = createCustomButton("The Room");
        

        JMenuItem fecharItem = new JMenuItem("Fechar");
        fecharItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecharJanela();
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets.top = 20;

        buttonPanel.add(comecar, gbc);

        // Adiciona o botão "Fechar"
        buttonPanel.add(fecharButton, gbc);

        
//        gbc.gridy = 2; 
//        gbc.anchor = GridBagConstraints.SOUTHEAST;  
//        gbc.insets.bottom = 50; 
//        buttonPanel.add(theRoom, gbc);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        comecar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game();
                game.start();
                game.jframe.setVisible(true);
                fecharJanela();
            }
        });

        theRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TheRoom room = new TheRoom();
                room.start();
                room.jframe.setVisible(true);
            }
        });

        fecharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecharJanela();
            }
        });

        SwingUtilities.updateComponentTreeUI(this);
        setContentPane(mainPanel);

        comecar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                comecar.setBackground(Color.BLACK);
                comecar.setForeground(Color.RED);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                comecar.setBackground(Color.BLACK);
                comecar.setForeground(Color.YELLOW);
            }
        });

        fecharButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fecharButton.setBackground(Color.BLACK);
                fecharButton.setForeground(Color.RED);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                fecharButton.setBackground(Color.BLACK);
                fecharButton.setForeground(Color.YELLOW);
            }
        });

        fecharButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fecharButton.setBackground(Color.BLACK);
                fecharButton.setForeground(Color.RED);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                fecharButton.setBackground(Color.BLACK);
                fecharButton.setForeground(Color.YELLOW);
            }
        });
    

        fecharButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fecharButton.setBackground(Color.BLACK);
                fecharButton.setForeground(Color.RED);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                fecharButton.setBackground(Color.BLACK);
                fecharButton.setForeground(Color.YELLOW);
            }
        });
        
    }
    
    public void papelDeparede(Graphics g) {
        g.setColor(Color.BLACK); 
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    private void fecharJanela() {
        this.dispose();
    }

    private JButton createCustomButton(String label) {
        JButton button = new JButton(label);
        int buttonWidth = 150; 
        int buttonHeight = 40; 
        button.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.YELLOW);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(new RoundedBorder(20));
        button.setFocusPainted(false);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Menu menu = new Menu();
            menu.setVisible(true);
        });
    }
    public void render() {
    	Graphics g = getGraphics();
    	papelDeparede(g);
    }
    
    
    
    
    
    
}

class RoundedBorder implements javax.swing.border.Border {
    private int radius;

    public RoundedBorder(int radius) {
        this.radius = radius;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.BLACK);
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}
