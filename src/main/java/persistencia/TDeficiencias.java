/*
 * Copyright (C) 2016 Eduardo Noel <enoel.corebsd@gmail.com>
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
package persistencia;

import java.io.Serializable;

/**
 *
 * @author Eduardo Noel <enoel.corebsd@gmail.com>
 */
public class TDeficiencias implements Serializable {

    private Long id_def;
    private String deficiencia;

    public Long getId_def() {
        return id_def;
    }

    public void setId_def(Long id_def) {
        this.id_def = id_def;
    }

    public String getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(String deficiencia) {
        this.deficiencia = deficiencia;
    }

    public TDeficiencias() {
    }

}
