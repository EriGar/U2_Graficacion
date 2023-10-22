/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u2_graficacion;

/**
 *
 * @author ERIKA GARCIA
 */

public class Figura extends Transformacion {

    private final javax.swing.JRadioButton jrbActivo;
    private boolean AFigura = false;

    public Figura(java.awt.Shape shp) {
        shpFigura = shp;
        javax.swing.JPanel jpnOpc = new javax.swing.JPanel();
        jpnOpc.add(jrbActivo = new javax.swing.JRadioButton("Mantener Figura para las transformaciones", AFigura));
        jrbActivo.addItemListener((java.awt.event.ItemEvent e) -> {
            if (e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                AFigura = true;
                apariencia = 3;
            } else if (AFigura) {
                apariencia = 0;
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
        if (apariencia != 3) {
            AFigura = false;
            jrbActivo.setSelected(AFigura);
        }
     }

    @Override
    public void reiniciar() {
    }
}

