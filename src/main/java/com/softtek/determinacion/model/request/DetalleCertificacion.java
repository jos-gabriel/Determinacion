package com.softtek.determinacion.model.request;

import lombok.Data;

@Data
public class DetalleCertificacion {

    private String edadAsegurado;
    private Boolean indicadorRJP;
    private Boolean indicadorSuceptibilidadRJP;
    private Boolean indicadorDiasValidosAnteriores1997;
    private Integer numDiasCotAntes01071997;
    private Integer numTotalSemRecoLey73;
    private Integer numTotalSemRecoLey97;
    private Integer totalSemanasRetiroIncapacidad94;
    private Integer totalDiasRetiroTotal09;
    private Boolean indicadorConservacionDerVencidos;
    private Boolean identificadorReingreso26a29Semanas;
    private Boolean indentificadorReingreso52a54Semanas;

}
