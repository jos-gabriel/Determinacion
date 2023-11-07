package com.softtek.determinacion.service;

import com.softtek.determinacion.model.request.DeterminacionRequest;
import com.softtek.determinacion.model.response.DeterminacionResponse;
import com.softtek.determinacion.service.determinacion.ley73.DeterminacionLey73Service;
import com.softtek.determinacion.service.determinacion.ley97.DeterminacionLey97Service;
import com.softtek.determinacion.service.validacionDatos.ValidacionDatosLey73Service;
import com.softtek.determinacion.service.validacionDatos.ValidacionDatosLey97Service;
import com.softtek.determinacion.service.validacionDatos.ValidacionDatosRN003Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeterminacionService {
    private final DeterminacionLey73Service determinacionLey73Service;
    private final DeterminacionLey97Service determinacionLey97Service;
    private final ValidacionDatosRN003Service validacionDatosRN003Service;
    private final ValidacionDatosLey73Service validacionLey73Service;
    private final ValidacionDatosLey97Service validacionLey97Service;


    @Autowired
    public DeterminacionService(
            DeterminacionLey73Service determinacionLey73Service,
            DeterminacionLey97Service determinacionLey97Service,
            ValidacionDatosRN003Service validacionDatosRN003Service,
            ValidacionDatosLey73Service validacionLey73Service,
            ValidacionDatosLey97Service validacionLey97Service
    ) {
        this.determinacionLey73Service = determinacionLey73Service;
        this.determinacionLey97Service = determinacionLey97Service;
        this.validacionDatosRN003Service = validacionDatosRN003Service;
        this.validacionLey73Service = validacionLey73Service;
        this.validacionLey97Service = validacionLey97Service;
    }

    public DeterminacionResponse determinar(DeterminacionRequest request) {

        validacionDatosRN003Service.validarSolicitudRN003(request);
        validacionLey73Service.validarSolicitudLey73(request);
        validacionLey97Service.validarSolicitudLey97(request);
        DeterminacionResponse response = new DeterminacionResponse();
        response.setDeterminacionLey73Model(determinacionLey73Service.calcularDeterminacion(request));
        response.setDeterminacionLey97Model(determinacionLey97Service.calcularDeterminacion(request));

        return response;
    }
}
