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
public class ValidarTxt {
    public static void txtletras(java.awt.event.KeyEvent evt) {
        int k = (int) evt.getKeyChar();
        if (k >= 48 && k <= 58) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "No se puede ingresar n�meros en este campo", "Informaci�n", JOptionPane.ERROR_MESSAGE);
        }

    }
}
