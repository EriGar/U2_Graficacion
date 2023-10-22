/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u2_graficacion;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

/**
 *
 * @author ERIKA GARCIA
 */

public class Rotacion extends Transformacion {

    private JTextField jtfAngulo;
    private javax.swing.JSlider jslAng;
    private double conversion;
    private double angle = 0;

    public Rotacion(java.awt.Shape shp) {
        shpFigura = shp;
        JPanel jpnOpciones = new JPanel(new BorderLayout());
        JPanel jpnAngulo = new JPanel();
        JPanel jpnCambio = new JPanel(new BorderLayout());
        jpnAngulo.add(new javax.swing.JLabel("Angulo = "));
        jtfAngulo = new JTextField("0");
        jtfAngulo.setColumns(10);
        jtfAngulo.addActionListener((java.awt.event.ActionEvent e) -> {
            if (jtfAngulo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(Rotacion.this, "Especifique el angulo de rotación",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                try {
                    int ang = Integer.parseInt(jtfAngulo.getText());
                    if (ang < 0) {
                        ang *= (-1);
                        ang %= 360;
                        ang = 360 - ang;
                    } else if (ang > 0) {
                        ang %= 360;
                        if (ang == 0) {
                            ang = 360;
                        }
                    }
                    jslAng.setValue(ang);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Rotacion.this, "Ingrese solo numeros enteros",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        jpnAngulo.add(jtfAngulo);
        jpnAngulo.add(new javax.swing.JLabel("Grados"));
        jslAng = new javax.swing.JSlider(javax.swing.SwingConstants.HORIZONTAL, 0, 360, 0);
        jslAng.setMajorTickSpacing(10);
        jslAng.setPaintTicks(true);
        jslAng.addChangeListener((javax.swing.event.ChangeEvent e) -> {
            int ang = jslAng.getValue();
            jtfAngulo.setText(String.valueOf(ang));
            angle = conversion * ang;
            jpnAreaDibujo.repaint();
        });
        jpnCambio.add(jslAng);
        jpnOpciones.add(jpnAngulo, BorderLayout.WEST);
        jpnOpciones.add(jpnCambio, BorderLayout.CENTER);

        conversion = (2 * Math.PI * (-1)) / 360;
        add(jpnOpciones, BorderLayout.NORTH);
    }

    @Override
    public void cambiarFigura(java.awt.Shape shp) {
        shpFigura = shp;
        reiniciar();
        jpnAreaDibujo.repaint();
    }

    @Override
    public void dibujarFigura(java.awt.Graphics2D g2d) {
        g2d.rotate(angle);
        switch (apariencia) {
            case 0:
                sinRelleno(g2d);
                break;
            case 1:
                relleno(g2d);
                break;
        }
    }

    public void sinRelleno(java.awt.Graphics2D g2d) {
        g2d.setPaint(Color.MAGENTA);
        g2d.draw(shpFigura);
    }

    @Override
    public void reiniciar() {
        jslAng.setValue(0);
    }
}
