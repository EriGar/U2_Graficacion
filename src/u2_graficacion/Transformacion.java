/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u2_graficacion;

import java.awt.Color;
import java.awt.geom.Line2D;

/**
 *
 * @author ERIKA GARCIA
 */

public abstract class Transformacion extends javax.swing.JPanel {

    protected static java.awt.Shape shpFigura;
    protected static Color clrD1 = Color.WHITE;
    protected static Color clrD2 = Color.WHITE;
    protected static Color clrR = Color.MAGENTA;
    protected static int apariencia = 0;
    protected javax.swing.JPanel jpnAreaDibujo;

    public Transformacion() {
        super(new java.awt.BorderLayout());
        jpnAreaDibujo = new javax.swing.JPanel() {

            @Override
            public void paintComponent(java.awt.Graphics g) {
                jpnAreaDibujo.setBackground(Color.WHITE);
                super.paintComponent(g);

                java.awt.Graphics2D g2d = (java.awt.Graphics2D) g;
                int w = getWidth();
                int h = getHeight();
                int cY0 = h / 2;
                int cX0 = w / 2;
                g2d.setFont(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.BOLD, 14));
                g2d.setPaint(Color.WHITE);
                g2d.draw(new Line2D.Double(cX0, 0, cX0, h)); //Eje Y
                g2d.draw(new Line2D.Double(0, cY0, w, cY0)); //Eje X
                int s = 25;
                int segX = w / (s * 2);
                int segY = h / (s * 2);
                g2d.setPaint(Color.WHITE);
                g2d.translate(cX0, cY0);
                for (int i = 1; i <= segX; i++) {
                    g2d.draw(new Line2D.Double(s * i, cY0 * (-1), s * i, cY0));
                    g2d.draw(new Line2D.Double(s * i * (-1), cY0 * (-1), s * i * (-1), cY0));
                }
                for (int i = 1; i <= segY; i++) {
                    g2d.draw(new Line2D.Double(cX0 * (-1), s * i, cX0, s * i));
                    g2d.draw(new Line2D.Double(cX0 * (-1), s * i * (-1), cX0, s * i * (-1)));
                }
                g2d.setPaint(Color.WHITE);
                g2d.drawString("X+", cX0 - 25, -10);
                g2d.drawString("Y+", 10, (-1) * cY0 + 15);
                dibujarFigura(g2d);
            }
        };
         add(jpnAreaDibujo, java.awt.BorderLayout.CENTER);
    }

    public abstract void cambiarFigura(java.awt.Shape shp);

    public abstract void dibujarFigura(java.awt.Graphics2D g2d);

    public abstract void reiniciar();

    protected void relleno(java.awt.Graphics2D g2d) {
        g2d.setPaint(clrR);
        g2d.fill(shpFigura);
    }
}

