/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u2_graficacion;

import javax.swing.ImageIcon;
import java.awt.Color;
/**
 *
 * @author ERIKA GARCIA
 */
public class MF {
    
     private final Menu menuFiguras;

    public MF(MenuListener cml) {
        final String[] str_Menus = {"Triángulo", "Rectángulo", "Polígono", "Círculo"};
        ImageIcon imiMenus[] = new ImageIcon[str_Menus.length];

        menuFiguras = new Menu(str_Menus, imiMenus, new Color(0, 188, 212), new Color(205, 220, 57),
               new Color(156, 39, 176), true);
        menuFiguras.agregarManejador(cml);
    }

    public Menu getMenu() {
        return menuFiguras;
    }

    public void activarMenu(int indice) {
        menuFiguras.activarMenu(indice);
    }
}
