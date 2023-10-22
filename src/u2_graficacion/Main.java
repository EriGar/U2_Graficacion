/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u2_graficacion;

import java.awt.BorderLayout;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author ERIKA GARCIA
 */

public class Main extends javax.swing.JFrame {
    private Transformacion tfmActive;
    private final MF menuFiguras;
    private final MT menuTransformaciones;
    private final Transformacion[] transformaciones;
    private java.awt.Shape[] shapes;
    private java.awt.Shape shapeCurrent;

    public static void main(String[] args) {
        Main app = new Main();
        app.setVisible(true);
    }

    public Main() {
        super("Transformaciones_EJGG");

        //Crear Figuras
        shapes = new java.awt.Shape[5];
        shapes[0] = Triangulo();
        shapes[1] = Rectangulo();
        shapes[2] = Poligono();
        shapes[3] = Circulo();
        shapeCurrent = shapes[0];
        menuFiguras = new MF((MenuEvent e) -> {
            shapeCurrent = shapes[e.getIndice()];
            tfmActive.cambiarFigura(shapeCurrent);
            tfmActive.jpnAreaDibujo.repaint();
        });
        add(menuFiguras.getMenu(), BorderLayout.NORTH);
        menuFiguras.activarMenu(0);
        menuTransformaciones = new MT((MenuEvent e) -> {
            showPanel(e.getIndice());
        });
        add(menuTransformaciones.getMenu(), BorderLayout.WEST);
        menuTransformaciones.activarMenu(0);

        transformaciones = new Transformacion[6];
        transformaciones[0] = new Traslacion(shapeCurrent);
        transformaciones[1] = new Escalamiento (shapeCurrent);
        transformaciones[2] = new Rotacion(shapeCurrent);
        transformaciones[3] = new Rellenar(shapeCurrent);
        transformaciones[4] = new Figura(shapeCurrent);
        tfmActive = transformaciones[0];
        add(tfmActive, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width,
                java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
    }

    private java.awt.Shape Triangulo() {
        int[] corX = new int[3];
        int[] corY = new int[3];
        corX[0] = 0;
        corY[0] = -100;
        corX[1] = -100;
        corY[1] = 73;
        corX[2] = 100;
        corY[2] = 73;
        return new java.awt.Polygon(corX, corY, 3);
    }

    private java.awt.Shape Rectangulo() {
        return new Rectangle2D.Double(-100.0, -50.0, 200.0, 100.0);
    }

    private java.awt.Shape Poligono() {
        int[] corX = new int[5];
        int[] corY = new int[5];
        corX[0] = 0;
        corY[0] = -100;
        corX[1] = -95;
        corY[1] = -30;
        corX[2] = -58;
        corY[2] = 80;
        corX[3] = 58;
        corY[3] = 80;
        corX[4] = 95;
        corY[4] = -30;
        return new java.awt.Polygon(corX, corY, 5);
    }

    private java.awt.Shape Circulo() {
        return new Ellipse2D.Double(-100, -100, 200, 200);
    }

    private void showPanel(int i) {
        this.getContentPane().remove(tfmActive);
        tfmActive = transformaciones[i];
        tfmActive.reiniciar();
        this.add(tfmActive, BorderLayout.CENTER);
        this.validate();
        tfmActive.repaint();
    }
}