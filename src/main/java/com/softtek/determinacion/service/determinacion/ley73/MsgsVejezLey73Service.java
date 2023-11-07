package com.softtek.determinacion.service.determinacion.ley73;

import com.softtek.determinacion.constant.Propiedades;
import com.softtek.determinacion.model.response.ley73.DeterminacionLey73Model;
import org.springframework.stereotype.Service;

@Service
public class MsgsVejezLey73Service {
    public void configurarRJPMensajeFundamento(DeterminacionLey73Model ley73Model) {
        ley73Model.setMensaje(Propiedades.C_V_RJP_MSG_73_97);
        ley73Model.setClaveFundamento(Propiedades.V_RJP_CVE_FUN_73);
        ley73Model.setFundamento(Propiedades.C_V_RJP_FUN_73_97);
    }

    public void configurarSuceptibilidadObservaciones(DeterminacionLey73Model ley73Model) {
        ley73Model.setClaveObservacion(Propiedades.V_SUSCEPTIBILIDAD_CVE_OBS_73);
        ley73Model.setObservaciones(Propiedades.C_V_SUSCEPTIBILIDAD_OBS_73_97);
    }

    public void configurarAseguradoVigenteMensajeFundamento(DeterminacionLey73Model ley73Model) {
        ley73Model.setMensaje(Propiedades.V_ASEGURADOVIGENTE_MSG56_73);
        ley73Model.setClaveFundamento(Propiedades.V_ASEGURADOVIGENTE_CVE_FUN_73);
        ley73Model.setFundamento(Propiedades.V_ASEGURADOVIGENTE_FUN_73);
    }

    public void configurarAseguradoCumplaEdadMensajeFundamento(DeterminacionLey73Model ley73Model) {
        ley73Model.setMensaje(Propiedades.V_NOCUMPLEEDAD_MSG31_73);
        ley73Model.setClaveFundamento(Propiedades.V_NOCUMPLEEDAD_CVE_FUN_73);
        ley73Model.setFundamento(Propiedades.V_NOCUMPLEEDAD_FUN_73);
    }

    public void configurarNoSemanasReconocidas(DeterminacionLey73Model ley73Model) {
        ley73Model.setMensaje(Propiedades.V_NOSEMANASRECONOCIDAS_MSG36_73);
        ley73Model.setClaveFundamento(Propiedades.V_NOSEMANASRECONOCIDAS_CVE_FUN_73);
        ley73Model.setFundamento(Propiedades.V_NOSEMANASRECONOCIDAS_FUN_73);
    }

    public void configurarSinDerechoRegimenMensajeFundamento(DeterminacionLey73Model ley73Model) {
        ley73Model.setMensaje(Propiedades.C_V_SINDERECHOREGIMEN_MSG41_73_97);
        ley73Model.setClaveFundamento(Propiedades.C_V_SINDERECHOREGIMEN_CVE_FUN_73_97);
        ley73Model.setFundamento(Propiedades.C_V_SINDERECHOREGIMEN_FUN_73_97);
    }

    public void configurarFueraConservacionDerechosMensajeFundamento(DeterminacionLey73Model ley73Model) {
        ley73Model.setMensaje(Propiedades.V_FUERACONSERVACIONDERECHOS_MSG43_73);
        ley73Model.setClaveFundamento(Propiedades.V_FUERACONSERVACIONDERECHOS_CVE_FUN_73);
        ley73Model.setFundamento(Propiedades.V_FUERACONSERVACIONDERECHOS_FUN_73);
    }

    public void configurarReconocimientoDerechosMensajeFundamento(DeterminacionLey73Model ley73Model) {
        ley73Model.setMensaje(Propiedades.V_RECONOCIMIENTOSDERCHOS_MSG45_73);
        ley73Model.setClaveFundamento(Propiedades.V_RECONOCIMIENTOSDERCHOS_CVE_FUN_73);
        ley73Model.setFundamento(Propiedades.V_RECONOCIMIENTOSDERCHOS_FUN_73);
    }

}
