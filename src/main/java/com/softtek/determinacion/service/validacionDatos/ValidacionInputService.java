package com.softtek.determinacion.service.validacionDatos;

import com.softtek.determinacion.model.request.DeterminacionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidacionInputService {

    private final ValidacionDatosService validacionDatosService;

    @Autowired
    public ValidacionInputService(ValidacionDatosService validacionDatosService) {
        this.validacionDatosService = validacionDatosService;
    }
    public void validarSolicitudRN003(DeterminacionRequest request) {
        validacionDatosService.validarCampoObligatorio(request.getId(), "id");
        validacionDatosService.validarCampoObligatorio(request.getNss(), "nss");
        validacionDatosService.validarCampoObligatorio(request.getIdDelServicio(), "idDelServicio");
        validacionDatosService.validarCampoObligatorio(request.getFechaDeNacimiento(), "fechaDeNacimiento");
        validacionDatosService.validarCampoObligatorio(request.getCurp(), "curp");
        validacionDatosService.validarCampoObligatorio(request.getUmf(), "umf");
        validacionDatosService.validarCampoObligatorio(request.getDelegacion(), "delegacion");
        validacionDatosService.validarCampoObligatorio(request.getSubdelegacion(), "subdelegacion");
        validacionDatosService.validarCampoObligatorio(request.getPrestacionSolicitada(), "prestacionSolicitada");
        validacionDatosService.validarCampoObligatorio(request.getFechaSiniestro(), "fechaSiniestro");
        validacionDatosService.validarCampoObligatorio(request.getInvalidez75oMas(), "invalidez75oMas");
        validacionDatosService.validarCampoObligatorio(request.getDiasSubsidiados(), "diasSubsidiados");
        validacionDatosService.validarCampoObligatorio(request.getRegistroPatronal(), "registroPatronal");
        validacionDatosService.validarCampoObligatorio(request.getMunicipio(), "municipio");
        validacionDatosService.validarCampoObligatorio(request.getConfirmacionCertificacion(), "confirmacionCertificacion");
        validacionDatosService.validarFormatoFecha(request.getFechaDeNacimiento(), "fechaDeNacimiento");
        validacionDatosService.validarFormatoFecha(request.getFechaSiniestro(), "fechaSiniestro");
        validacionDatosService.validarFormatoNSS(request.getNss());
        validacionDatosService.validarFormatoCurp(request.getCurp());
        validacionDatosService.coincideFechaNacimientoyCURP(request.getCurp(), request.getFechaDeNacimiento());
        validacionDatosService.coincideNSSySubdelegacion(request.getNss(), request.getSubdelegacion());
        validacionDatosService.coincideNSSyCURP(request.getNss(), request.getCurp());
    }
}
