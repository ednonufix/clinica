/*
 * Copyright (C) 2016 Eduardo Noel Núñez <enoel@cubalub.cupet.cu>
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

import java.time.LocalDate;

/**
 *
 * @author Eduardo Noel Núñez <enoel@cubalub.cupet.cu>
 */
public class TTratamiento {

    private Long id_diag;
    private Long id_paciente;
    private TDiagnostico diagnosticos;
    private TPaciente paciente;
    private String lugar;
    private String referencia;
    private LocalDate fecha_ingreso;
    private LocalDate fecha_egreso;

    public Long getId_diag() {
        return id_diag;
    }

    public void setId_diag(Long id_diag) {
        this.id_diag = id_diag;
    }

    public Long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public TDiagnostico getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(TDiagnostico diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public TPaciente getPaciente() {
        return paciente;
    }

    public void setPaciente(TPaciente paciente) {
        this.paciente = paciente;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public LocalDate getFecha_egreso() {
        return fecha_egreso;
    }

    public void setFecha_egreso(LocalDate fecha_egreso) {
        this.fecha_egreso = fecha_egreso;
    }

}
