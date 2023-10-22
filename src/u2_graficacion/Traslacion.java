/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u2_graficacion;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
/**
 *
 * @author ERIKA GARCIA
 */

public class Traslacion extends Transformacion {
   private JTextField jtfX;
   private JTextField jtfY;
   private double X = 0.0;
   private double Y = 0.0;
   private double deltaX = 0.0;
   private double deltaY = 0.0;

   public Traslacion(java.awt.Shape shp) {
      shpFigura = shp;

      javax.swing.JPanel jpnOpciones = new javax.swing.JPanel();
      jpnOpciones.add(new javax.swing.JLabel("Vector de traslación: T = <"));
      jtfX = new JTextField("0.0");
      jtfX.setColumns(10);
      jtfY = new JTextField("0.0");
      jtfY.setColumns(10);
      jpnOpciones.add(jtfX);
      jpnOpciones.add(new javax.swing.JLabel(", "));
      jpnOpciones.add(jtfY);
      jpnOpciones.add(new javax.swing.JLabel(">, "));
      javax.swing.JButton jbtTrasladar = new javax.swing.JButton("Trasladar");
      jbtTrasladar.addActionListener((java.awt.event.ActionEvent e) -> {
          if (jtfX.getText().isEmpty() || jtfY.getText().isEmpty())
              JOptionPane.showMessageDialog(Traslacion.this, "Especifique el vector de traslación",
                      "Mensaje", JOptionPane.INFORMATION_MESSAGE);
          else {
              try {
                  deltaX = Double.parseDouble(jtfX.getText());
                  deltaY = Double.parseDouble(jtfY.getText());
                  deltaY *= (-25);
                  deltaX *= 25;
                  X += deltaX;
                  Y += deltaY;
                  jpnAreaDibujo.repaint();
              } catch (NumberFormatException ex) {
                  JOptionPane.showMessageDialog(Traslacion.this, "Ingrese solo números",
                          "Mensaje", JOptionPane.INFORMATION_MESSAGE);
              }
          }
      });
      jpnOpciones.add(jbtTrasladar);

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
      g2d.translate(X, Y);
      switch(apariencia) {
         case 0: sinRelleno(g2d); break;
         case 1: relleno(g2d); break;
      }
   }
   private void sinRelleno(java.awt.Graphics2D g2d) {
      g2d.setPaint(Color.MAGENTA);
      g2d.draw(shpFigura);
   }
   @Override
   public void reiniciar() {
      deltaX = deltaY = X = Y = 0.0;
      jtfX.setText("0.0");
      jtfY.setText("0.0");
   }
}
