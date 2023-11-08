package com.softtek.determinacion.service;

import com.softtek.determinacion.model.request.DeterminacionRequest;
import com.softtek.determinacion.model.response.Determinacion73y97Response;
import com.softtek.determinacion.service.determinacion.ley73.DeterminacionLey73Service;
import com.softtek.determinacion.service.determinacion.ley97.DeterminacionLey97Service;
import com.softtek.determinacion.service.validacionDatos.ValidacionDatosLey73Service;
import com.softtek.determinacion.service.validacionDatos.ValidacionDatosLey97Service;
import com.softtek.determinacion.service.validacionDatos.ValidacionInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeterminacionService {
    private final DeterminacionLey73Service determinacionLey73Service;
    private final DeterminacionLey97Service determinacionLey97Service;
    private final ValidacionInputService validacionInputService;
    private final ValidacionDatosLey73Service validacionLey73Service;
    private final ValidacionDatosLey97Service validacionLey97Service;


    @Autowired
    public DeterminacionService(
        DeterminacionLey73Service determinacionLey73Service,
        DeterminacionLey97Service determinacionLey97Service,
        ValidacionInputService validacionInputService,
        ValidacionDatosLey73Service validacionLey73Service,
        ValidacionDatosLey97Service validacionLey97Service
    ) {
        this.determinacionLey73Service = determinacionLey73Service;
        this.determinacionLey97Service = determinacionLey97Service;
        this.validacionInputService = validacionInputService;
        this.validacionLey73Service = validacionLey73Service;
        this.validacionLey97Service = validacionLey97Service;
    }

    public Determinacion73y97Response determinar(DeterminacionRequest request) {

        validacionInputService.validacionInputService(request);
        validacionLey73Service.validarSolicitudLey73(request);
        validacionLey97Service.validarSolicitudLey97(request);

        Determinacion73y97Response response = new Determinacion73y97Response();

        response.setDeterminacionLey73Model(determinacionLey73Service.calcularDeterminacion(request));
        response.setDeterminacionLey97Model(determinacionLey97Service.calcularDeterminacion(request));

        return response;
    }
}
