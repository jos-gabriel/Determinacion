package com.softtek.determinacion.service.determinacion.ley97;

import com.softtek.determinacion.constant.Propiedades;
import com.softtek.determinacion.model.response.DeterminacionLey97Model;
import org.springframework.stereotype.Service;

@Service
public class MsgsVejezLey97Service {

    public void configurarRJPMensajeFundamento(DeterminacionLey97Model ley97Model) {
        ley97Model.setMensaje(Propiedades.C_V_RJP_MSG_73_97);
        ley97Model.setClaveFundamento(Propiedades.V_RJP_CVE_FUN_97);
        ley97Model.setFundamento(Propiedades.C_V_RJP_FUN_73_97);
    }

    public void configurarSuceptibilidadObservaciones(DeterminacionLey97Model ley97Model) {
        ley97Model.setClaveObservacion(Propiedades.V_SUSCEPTIBILIDAD_CVE_OBS_97);
        ley97Model.setObservaciones(Propiedades.C_V_SUSCEPTIBILIDAD_OBS_73_97);
    }

    public void configurarNoSemanasReconocidas(DeterminacionLey97Model ley97Model) {
        ley97Model.setMensaje(Propiedades.V_NOSEMANASRECONOCIDAS_MSG37_97);
        ley97Model.setClaveFundamento(Propiedades.V_NOSEMANASRECONOCIDAS_CVE_FUN_97);
        ley97Model.setFundamento(Propiedades.V_NOSEMANASRECONOCIDAS_FUN_97);
    }

    public void configurarRetiroTotal(DeterminacionLey97Model ley97Model) {
        ley97Model.setMensaje(Propiedades.V_RETIROTOTAL_MSG26_97);
        ley97Model.setClaveFundamento(Propiedades.V_RETIROTOTAL_CVE_FUN_97);
        ley97Model.setFundamento(Propiedades.V_RETIROTOTAL_FUN_97);
        ley97Model.setClaveObservacionesSM(Propiedades.V_RETIROTOTAL_CVE_OBS_97);
        ley97Model.setObservacionesSM(Propiedades.V_RETIROTOTAL_OBS_97);
    }

    public void configurarNoCumpleEdad(DeterminacionLey97Model ley97Model) {
        ley97Model.setMensaje(Propiedades.V_NOCUMPLEEDAD_MSG32_97);
        ley97Model.setClaveFundamento(Propiedades.V_NOCUMPLEEDAD_CVE_FUN_97);
        ley97Model.setFundamento(Propiedades.V_NOCUMPLEEDAD_FUN_97);
    }

    public void configurarAseguradoVigente(DeterminacionLey97Model ley97Model) {
        ley97Model.setMensaje(Propiedades.V_ASEGURADOVIGENTE_MSG18_97);
        ley97Model.setClaveFundamento(Propiedades.V_ASEGURADOVIGENTE_CVE_FUN_97);
        ley97Model.setFundamento(Propiedades.V_ASEGURADOVIGENTE_FUN_97);
    }
}
