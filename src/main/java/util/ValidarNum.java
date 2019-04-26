/*
 * Copyright (C) 2015 Eduardo Noel <enoel.corebsd@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package util;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo Noel <enoel.corebsd@gmail.com>
 */
public class ValidarNum {
    
     public static void txtnumero(java.awt.event.KeyEvent evt) {
            int k=(int)evt.getKeyChar();
            if (k >= 97 && k <= 122 || k>=65 && k<=90){
            evt.setKeyChar((char)KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null,"No puede ingresar letras en este campo","Informacion",JOptionPane.ERROR_MESSAGE);
            }
            if(k==241 || k==209 || k>=91 && k<=96 || k>=123 && k<=255 || k>=32 && k<=45 || k==47 || k>=58 && k<=64){
            evt.setKeyChar((char)KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null,"No puede ingresar car�cteres especiales en este campo","Informacion",JOptionPane.ERROR_MESSAGE);
            }
        }
    
}
