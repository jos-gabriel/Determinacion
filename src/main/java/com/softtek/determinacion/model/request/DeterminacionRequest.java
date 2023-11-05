package com.softtek.determinacion.model.request;

import lombok.Data;

@Data
public class DeterminacionRequest {
    private Integer id;
    private String nss;
    private AseguradoSolicitud aseguradoSolicitud;
    private DetalleCertificacion detalleCertificacion;
    private String curp;
    private String idDelServicio;
    private String curpUsuario;
    private String fechaDeNacimiento;
    private String umf;
    private String delegacion;
    private String subdelegacion;
    private String fechaSiniestro;
    private String invalidez75oMas;
    private String diasSubsidiados;
    private String registroPatronal;
    private String municipio;
    private String confirmacionCertificacion;
    private String prestacionSolicitada;
}
