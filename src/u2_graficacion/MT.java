/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u2_graficacion;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author ERIKA GARCIA
 */
public class MT {
      Menu menuTransformacion;

    public MT(MenuListener cml) {
        final String[] str_Menus = {"Traslación", "Escalamiento", "Rotación", "Relleno"};
        ImageIcon imiMenus[] = new ImageIcon[str_Menus.length];
        menuTransformacion = new Menu(str_Menus, imiMenus, new Color(236, 236, 236), new Color(0, 188, 212),
                new Color(156, 39, 176), false);
        menuTransformacion.agregarManejador(cml);
    }

    public Menu getMenu() {
        return menuTransformacion;
    }

    public void activarMenu(int indice) {
        menuTransformacion.activarMenu(indice);
    }
}
