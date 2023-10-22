/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u2_graficacion;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JOptionPane;
/**
 *
 * @author ERIKA GARCIA
 */

public class Escalamiento extends Transformacion {

    private JTextField jtFacEscX;
    private JTextField jtFacEscY;
    private double facEscX = 1.0;
    private double facEscY = 1.0;

    public Escalamiento(java.awt.Shape shp) {
        shpFigura = shp;

        //Panel opciones
        javax.swing.JPanel jpnOpciones = new javax.swing.JPanel();
        jpnOpciones.add(new javax.swing.JLabel("Factor de escala X = "));
        jtFacEscX = new JTextField("1.0");
        jtFacEscX.setColumns(10);
        jtFacEscY = new JTextField("1.0");
        jtFacEscY.setColumns(10);
        jpnOpciones.add(jtFacEscX);
        jpnOpciones.add(new javax.swing.JLabel(", Y = "));
        jpnOpciones.add(jtFacEscY);
        javax.swing.JButton jbtEscalation = new javax.swing.JButton("Escalar");
        jbtEscalation.addActionListener((java.awt.event.ActionEvent e) -> {
            if (jtFacEscX.getText().isEmpty() || jtFacEscY.getText().isEmpty()) {
                JOptionPane.showMessageDialog(Escalamiento.this, "Especifique la escala",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                try {
                    facEscX = Double.parseDouble(jtFacEscX.getText());
                    facEscY = Double.parseDouble(jtFacEscY.getText());
                    jpnAreaDibujo.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Escalamiento.this, "Ingrese solo números",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        jpnOpciones.add(jbtEscalation);

        add(jpnOpciones, java.awt.BorderLayout.NORTH);
    }

    @Override
    public void cambiarFigura(java.awt.Shape shp) {
        shpFigura = shp;
        reiniciar();
        jpnAreaDibujo.repaint();
    }

    @Override
    public void dibujarFigura(java.awt.Graphics2D g2d) {
        g2d.scale(facEscX, facEscY);
        switch (apariencia) {
            case 0:
                sinRelleno(g2d);
                break;
            case 1:
                relleno(g2d);
                break;
          /*  case 2:
                degradado(g2d);
                break;
            case 2:
                rellenoCnFig(g2d);
                break;*/
        }
    }

    private void sinRelleno(java.awt.Graphics2D g2d) {
        g2d.setPaint(Color.MAGENTA);
        g2d.draw(shpFigura);
    }

    @Override
    public void reiniciar() {
        facEscX = facEscY = 1.0;
        jtFacEscX.setText("1.0");
        jtFacEscY.setText("1.0");
    }
}
