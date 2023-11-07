package com.softtek.determinacion.service.validacionDatos;

import com.softtek.determinacion.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

@Service
public class ValidacionDatosService {

    public void validarCampoObligatorio(Object campo, String nombreCampo) {
        if (campo == null || (campo instanceof String && ((String) campo).isEmpty())) {
            throw new BadRequestException("El campo " + nombreCampo + " es obligatorio y no puede estar vacío.");
        }
    }

    public void validarFormatoFecha(String fecha, String fechaCampo) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(fecha);
        } catch (ParseException e) {
            throw new BadRequestException("El campo" + fechaCampo + " no tiene un formato de fecha válido. Debe estar en formato yyyy-MM-dd.");
        }
    }

    public void validarFormatoNSS(String nss) {
        if (!nss.matches("\\d{11}")) {
            throw new BadRequestException("El NSS debe contener 11 dígitos numéricos.");
        }
    }

    public void validarFormatoCurp(String curp) {
        if (curp.length() != 18) {
            throw new BadRequestException("El CURP debe contener exactamente 18 caracteres.");
        }
        if (!curp.matches("[A-Z&Ñ]{1}[AEIOU&Ñ][A-Z&Ñ]{2}\\d{6}[HM][A-Z&Ñ]{5}\\d{2}")) {
            throw new BadRequestException("El CURP no cumple con el formato válido.");
        }

        String fechaNacimiento = curp.substring(4, 10);
        int year = Integer.parseInt(fechaNacimiento.substring(0, 2));
        int mes = Integer.parseInt(fechaNacimiento.substring(2, 4));
        int dia = Integer.parseInt(fechaNacimiento.substring(4, 6));

        if (year < 0 || year > 99 || mes < 1 || mes > 12 || dia < 1 || dia > 31) {
            throw new BadRequestException("El CURP tiene una fecha de nacimiento inválida.");
        }
    }

    public void coincideNSSyCURP(String nss, String curp) {
        if (!nss.substring(4, 6).equals(curp.substring(4, 6))) {
            throw new BadRequestException("El NSS y CURP no coinciden.");
        }
    }

    public void coincideFechaNacimientoyCURP(String curp, String fechaNacimiento) {
        String fechaCurp = curp.substring(4, 10);
        if(!fechaCurp.equals(fechaNacimiento.replaceAll("-", "").substring(2))){
            throw new BadRequestException("La fecha de nacimiento no coincide con el CURP.");
        }
    }

    public void coincideNSSySubdelegacion(String nss, String subdelegacion) {
        try {
            int nssParte1 = Integer.parseInt(nss.substring(0, 2));
            int subdelegacionNum = Integer.parseInt(subdelegacion);

            if (nssParte1 != subdelegacionNum) {
                throw new BadRequestException("El NSS y subdelegación no coinciden.");
            }
        } catch (NumberFormatException e) {
            throw new BadRequestException("Error de formato en el NSS o la Subdelegación");
        }
    }

    public String calcularEdad(String fechaNacimiento, String fechaSiniestro) {
        LocalDate nacimiento = LocalDate.parse(fechaNacimiento);
        LocalDate siniestro = LocalDate.parse(fechaSiniestro);
        int edad = Period.between(nacimiento, siniestro).getYears();
        return String.valueOf(edad);
    }

    public void validarEdad(String edad, String fechaNacimiento, String fechaSiniestro) {
        String edadCalculada = calcularEdad(fechaNacimiento, fechaSiniestro);

        if (!edad.equals(edadCalculada)) {
            throw new BadRequestException("La edad proporcionada no coincide con la diferencia entre la fecha de siniestro y la fecha de nacimiento.");
        }
    }

    public void igualdadNSS(String nss1, String nss2){
        if(!nss1.equals(nss2)){
            throw new BadRequestException("Los NSS de la solicitud no coinciden.");
        }
    }

    public String determinarRegimenPensionario(String nss) {
        int yearAfiliacion = Integer.parseInt(nss.substring(2, 4));
        return (yearAfiliacion < 97) ? "ley73" : "ley97";
    }

}
