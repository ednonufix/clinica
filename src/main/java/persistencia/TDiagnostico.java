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
public class TDiagnostico implements Serializable {

    private Long id_diag;
    private String diagnostico;

    public Long getId_diag() {
        return id_diag;
    }

    public void setId_diag(Long id_diag) {
        this.id_diag = id_diag;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public TDiagnostico() {
    }

}
