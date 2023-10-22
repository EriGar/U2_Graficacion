/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u2_graficacion;

import java.awt.Color;
import javax.swing.JColorChooser;

/**
 *
 * @author ERIKA GARCIA
 */

public class Rellenar extends Transformacion {

    private final javax.swing.JRadioButton jrbActivo;
    private boolean ActivoRelleno = false;

    public Rellenar(java.awt.Shape shp) {
        shpFigura = shp;

        javax.swing.JPanel jpnOpc = new javax.swing.JPanel();
        javax.swing.JButton jbtCambiarColor = new javax.swing.JButton("Cambiar de color ");
        jpnOpc.add(jbtCambiarColor);
        jpnOpc.add(jrbActivo = new javax.swing.JRadioButton("Mantener el relleno", ActivoRelleno));
        jrbActivo.addItemListener((java.awt.event.ItemEvent e) -> {
            if (e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                ActivoRelleno = true;
                apariencia = 1;
            } else if (ActivoRelleno) {
                apariencia = 0;
            }
        });
        jbtCambiarColor.addActionListener((java.awt.event.ActionEvent e) -> {
            Color color = JColorChooser.showDialog(Rellenar.this, "Selecciona un color", clrR);
            if (color != null) {
                clrR = color;
                jpnAreaDibujo.repaint();
            }
        });

        add(jpnOpc, java.awt.BorderLayout.NORTH);
    }

    @Override
    public void cambiarFigura(java.awt.Shape shp) {
        shpFigura = shp;
        jpnAreaDibujo.repaint();
    }

    @Override
    public void dibujarFigura(java.awt.Graphics2D g2d) {
        if (apariencia != 1) {
            ActivoRelleno = false;
            jrbActivo.setSelected(ActivoRelleno);
        }
        relleno(g2d);
    }

    @Override
    public void reiniciar() {
    }
}
