package com.softtek.determinacion.service.determinacion.ley97;

import com.softtek.determinacion.constant.Propiedades;
import com.softtek.determinacion.model.response.ley97.DeterminacionLey97Model;
import org.springframework.stereotype.Service;

@Service
public class MsgsCesantiaLey97Service {

    public void configurarRJPMensajeFundamento(DeterminacionLey97Model ley97Model) {
        ley97Model.setMensaje(Propiedades.C_V_RJP_MSG_73_97);
        ley97Model.setClaveFundamento(Propiedades.C_RJP_CVE_FUN_97);
        ley97Model.setFundamento(Propiedades.C_V_RJP_FUN_73_97);
    }

    public void configurarSuceptibilidadObservaciones(DeterminacionLey97Model ley97Model) {
        ley97Model.setClaveObservacion(Propiedades.C_SUSCEPTIBILIDAD_CVE_OBS_97);
        ley97Model.setObservaciones(Propiedades.C_V_SUSCEPTIBILIDAD_OBS_73_97);
    }

    public void configurarNoSemanasReconocidas(DeterminacionLey97Model ley97Model) {
        ley97Model.setMensaje(Propiedades.C_NOSEMANASRECONOCIDAS_MSG34_97);
        ley97Model.setClaveFundamento(Propiedades.C_NOSEMANASRECONOCIDAS_CVE_FUN_97);
        ley97Model.setFundamento(Propiedades.C_NOSEMANASRECONOCIDAS_FUN_97);
    }

    public void configurarRetiroTotal(DeterminacionLey97Model ley97Model) {
        ley97Model.setMensaje(Propiedades.C_RETIROTOTAL_MSG25_97);
        ley97Model.setClaveFundamento(Propiedades.C_RETIROTOTAL_CVE_FUN_97);
        ley97Model.setFundamento(Propiedades.C_RETIROTOTAL_FUN_97);
        ley97Model.setClaveObservacionesSM(Propiedades.C_RETIROTOTAL_CVE_OBS_97);
        ley97Model.setObservacionesSM(Propiedades.C_RETIROTOTAL_OBS_97);
    }

    public void configurarNoCumpleEdad(DeterminacionLey97Model ley97Model) {
        ley97Model.setMensaje(Propiedades.C_NOCUMPLEEDAD_MSG30_97);
        ley97Model.setClaveFundamento(Propiedades.C_NOCUMPLEEDAD_CVE_FUN_97);
        ley97Model.setFundamento(Propiedades.C_NOCUMPLEEDAD_FUN_97);
    }

    public void configurarAseguradoVigente(DeterminacionLey97Model ley97Model) {
        ley97Model.setMensaje(Propiedades.C_ASEGURADOVIGENTE_MSG28_97);
        ley97Model.setClaveFundamento(Propiedades.C_ASEGURADOVIGENTE_CVE_FUN_97);
        ley97Model.setFundamento(Propiedades.C_ASEGURADOVIGENTE_FUN_97);
    }
}
