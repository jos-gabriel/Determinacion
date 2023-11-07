package com.softtek.determinacion.service.validacionDatos;

import com.softtek.determinacion.model.request.DeterminacionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidacionDatosLey97Service {

    private final ValidacionDatosService validacionDatosService;

    @Autowired
    public ValidacionDatosLey97Service(ValidacionDatosService validacionDatosService){
        this.validacionDatosService = validacionDatosService;
    }

    public void validarSolicitudLey97(DeterminacionRequest request) {
        validacionDatosService.validarCampoObligatorio(request.getPrestacionSolicitada(), "prestacionSolicitada");
        validacionDatosService.validarCampoObligatorio(request.getDetalleCertificacion().getEdadAsegurado(), "edadAsegurado");
        validacionDatosService.validarCampoObligatorio(request.getDetalleCertificacion().getNumTotalSemRecoLey73(), "numTotalSemRecoLey73");
        validacionDatosService.validarCampoObligatorio(request.getDetalleCertificacion().getNumTotalSemRecoLey97(), "numTotalSemRecoLey97");
        validacionDatosService.validarCampoObligatorio(request.getDetalleCertificacion().getTotalDiasRetiroTotal09(), "TotalDiasRetiroTotal09");
        validacionDatosService.validarCampoObligatorio(request.getDetalleCertificacion().getTotalSemanasRetiroIncapacidad94(), "totalSemanasRetiroIncapacidad94");
        validacionDatosService.validarCampoObligatorio(request.getDetalleCertificacion().getIndicadorRJP(), "indicadorRJP");
        validacionDatosService.validarCampoObligatorio(request.getDetalleCertificacion().getIndicadorSuceptibilidadRJP(), "indicadorSuceptibilidadRJP");
        validacionDatosService.validarCampoObligatorio(request.getAseguradoSolicitud().getNss(), "nss");
        validacionDatosService.validarCampoObligatorio(request.getAseguradoSolicitud().getFechaBaja(), "fechaBaja");
        validacionDatosService.validarFormatoFecha(request.getAseguradoSolicitud().getFechaBaja(), "fechaBaja");
        validacionDatosService.validarFormatoNSS(request.getAseguradoSolicitud().getNss());
        validacionDatosService.igualdadNSS(request.getAseguradoSolicitud().getNss(), request.getNss());
        validacionDatosService.validarEdad(request.getDetalleCertificacion().getEdadAsegurado(), request.getFechaDeNacimiento(), request.getFechaSiniestro());
    }
}
