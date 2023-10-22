/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u2_graficacion;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JLabel;

/**
 *
 * @author ERIKA GARCIA
 */

public class Menu extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;
    private final Color clrActivo = Color.MAGENTA;
    private final Color clrInactivo = Color.LIGHT_GRAY;
    private final Color clrCaptura;
    private MenuListener mlManejador;
    private final MenuEvent meManejador;
    private ItemMenu[] mn_Menu;
    private ItemMenu mnActivo;

    public Menu(String[] str_items, ImageIcon[] imi_items, Color ca, Color ci, Color cc, boolean horizontal) {
        super(new java.awt.BorderLayout());
        clrCaptura = cc;
        meManejador = new MenuEvent();

        java.awt.LayoutManager lym;
        if (horizontal) {
            lym = new FlowLayout(FlowLayout.LEFT, 12, 0);
        } else {
            lym = new java.awt.GridLayout(imi_items.length, 1, 0, 12);
        }
        agregarMenu(str_items, imi_items, lym);
    }

    public void agregarManejador(MenuListener cml) {
        mlManejador = cml;
    }

    public void activarMenu(int indice) {
        mnActivo = mn_Menu[indice];
        mnActivo.activar();
    }

    private void agregarMenu(String[] str_itm, ImageIcon[] imi_itm, java.awt.LayoutManager lym) {
        
        MouseListener mslMenu = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ItemMenu imnActual = (ItemMenu) e.getSource();
                if (!imnActual.estaActivo()) {
                    mnActivo.desactivar();
                    imnActual.activar();
                    mnActivo = imnActual;
                    meManejador.setEvent(imnActual.indice);
                    mlManejador.changeItemMenu(meManejador);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                ItemMenu imnActual = (ItemMenu) e.getSource();
                if (!imnActual.estaActivo()) {
                    imnActual.setBackground(clrCaptura);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ItemMenu imnActual = (ItemMenu) e.getSource();
                if (!imnActual.estaActivo()) {
                    imnActual.setBackground(clrInactivo);
                }
            }
        };

        javax.swing.JPanel jpnMenu = new javax.swing.JPanel(lym);
        mn_Menu = new ItemMenu[str_itm.length];
        for (int i = 0; i < mn_Menu.length; ++i) {
            mn_Menu[i] = new ItemMenu(str_itm[i], imi_itm[i], i);
            mn_Menu[i].setBackground(clrInactivo);
            mn_Menu[i].addMouseListener(mslMenu);
            jpnMenu.add(mn_Menu[i]);
        }
        mnActivo = mn_Menu[0];
        jpnMenu.setBackground(clrInactivo);
        add(jpnMenu, java.awt.BorderLayout.CENTER);
    }

    class ItemMenu extends javax.swing.JPanel {

        private static final long serialVersionUID = 1L;
        public final int indice;
        private boolean activo;

       public ItemMenu(String strNombre, ImageIcon imi, int indice) {
            setBorder(javax.swing.BorderFactory.createSoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
            add(new JLabel(strNombre, imi, JLabel.RIGHT));
            this.indice = indice;
        }

        public void activar() {
            setBackground(clrActivo);
            activo = true;
        }

        public void desactivar() {
            setBackground(clrInactivo);
            activo = false;
        }

        public boolean estaActivo() {
            return activo;
        }
    ;
}
}
