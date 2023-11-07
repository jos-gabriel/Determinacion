package com.softtek.determinacion.service.determinacion;

import com.softtek.determinacion.exception.BadRequestException;
import com.softtek.determinacion.model.request.DeterminacionRequest;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class RulesDeterminacionService {

    public boolean esElegibleParaEvaluacion(DeterminacionRequest request) {
        return !request.getDetalleCertificacion().getIndicadorRJP();
    }

    public boolean tieneSuceptibilidadRJP(DeterminacionRequest request) {
        return request.getDetalleCertificacion().getIndicadorSuceptibilidadRJP();
    }

    public boolean esNoVigente(DeterminacionRequest request) {
        String tipoSituacionAfiliatoria = request.getAseguradoSolicitud().getClaveTipoSituacionAfiliatoria();
        tipoSituacionAfiliatoria = tipoSituacionAfiliatoria.replaceAll("\\s", "").toLowerCase();
        return "novigente".equals(tipoSituacionAfiliatoria);
    }

    public boolean validarFechaBaja(DeterminacionRequest request) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date fechaBajaAsegurado = sdf.parse(request.getAseguradoSolicitud().getFechaBaja());
            Date datePeriodo1 = sdf.parse("01/01/0001");
            Date datePeriodo2 = sdf.parse("31/12/9999");

            return !fechaBajaAsegurado.equals(datePeriodo1) && !fechaBajaAsegurado.equals(datePeriodo2);
        } catch (ParseException e) {
            throw new BadRequestException("Error al verificar la fecha");
        }
    }

    public boolean cumpleRequisitosEdad(DeterminacionRequest request, Boolean retiroVejez) {
        int edadAsegurado = Integer.parseInt(request.getDetalleCertificacion().getEdadAsegurado());

        if (retiroVejez) return edadAsegurado >= 65;
        return edadAsegurado >= 60;
    }

    public boolean cumpleRequisitosSemReco(DeterminacionRequest request) {
        return request.getDetalleCertificacion().getNumTotalSemRecoLey73() >= 500;
    }

    public boolean puedeElegirRegimen(DeterminacionRequest request) {

        return (request.getDetalleCertificacion().getNumDiasCotAntes01071997() > 0 ||
                request.getDetalleCertificacion().getNumTotalSemRecoLey73() > 0 ||
                request.getDetalleCertificacion().getNumTotalSemRecoLey97() > 0
        );
    }

    public boolean tieneDerechoConservacionDerVencidos(DeterminacionRequest request) {
        return request.getDetalleCertificacion().getIndicadorConservacionDerVencidos();
    }

    public boolean esReingreso26a29Semanas(DeterminacionRequest request) {
        return request.getDetalleCertificacion().getIdentificadorReingreso26a29Semanas();
    }

    public boolean esReingreso52a54Semanas(DeterminacionRequest request) {
        return request.getDetalleCertificacion().getIndentificadorReingreso52a54Semanas();
    }

    public boolean pensionVejez (DeterminacionRequest request) {

        String fechaBaja = request.getAseguradoSolicitud().getFechaBaja();
        String fechaNacimiento = request.getFechaDeNacimiento();
        String edad = request.getDetalleCertificacion().getEdadAsegurado();
        Boolean situacionAfiliatoria = esNoVigente(request);

        String tipoPension = determinarTipoPension(fechaBaja, fechaNacimiento, edad, situacionAfiliatoria);

        return tipoPension.equals("vejez");
    }

    private boolean fueDadoDeBajaDespuesDe65(String fechaDeBaja, String fechaNacimiento) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaBaja = LocalDate.parse(fechaDeBaja, formatter);
            LocalDate fechaNacimientoDate = LocalDate.parse(fechaNacimiento, formatter);

            LocalDate fecha65 = fechaNacimientoDate.plusYears(65);

            return fechaBaja.isAfter(fecha65);
        } catch (Exception e) {
            throw new BadRequestException("Error al calcular si fue dado de baja después de los 65");
        }
    }

    private String determinarTipoPension(String fechaDeBaja,String fechaNacimiento, String edad, Boolean situacionAfiliatoria) {
        boolean dadoDeBajaDespuesDe65 = fueDadoDeBajaDespuesDe65(fechaDeBaja, fechaNacimiento);

        int edadNumerica = Integer.parseInt(edad);

        if (edadNumerica > 60 && edadNumerica < 65) {
            if (!situacionAfiliatoria) {
                return "vejez";
            } else {
                return "cesantia";
            }
        } else if (edadNumerica >= 65 && dadoDeBajaDespuesDe65) {
            return "vejez";
        } else {
            return "cesantia";
        }
    }

}
