package com.softtek.determinacion.service.determinacion.ley73;

import com.softtek.determinacion.constant.Propiedades;
import com.softtek.determinacion.model.response.ley73.DeterminacionLey73Model;
import org.springframework.stereotype.Service;

@Service
public class MsgsCesantiaLey73Service {
    public void configurarRJPMensajeFundamento(DeterminacionLey73Model ley73Model) {
        ley73Model.setMensaje(Propiedades.C_V_RJP_MSG_73_97);
        ley73Model.setClaveFundamento(Propiedades.C_RJP_CVE_FUN_73);
        ley73Model.setFundamento(Propiedades.C_V_RJP_FUN_73_97);
    }

    public void configurarSuceptibilidadObservaciones(DeterminacionLey73Model ley73Model) {
        ley73Model.setClaveObservacion(Propiedades.C_SUSCEPTIBILIDAD_CVE_OBS_73);
        ley73Model.setObservaciones(Propiedades.C_V_SUSCEPTIBILIDAD_OBS_73_97);
    }

    public void configurarAseguradoVigenteMensajeFundamento(DeterminacionLey73Model ley73Model) {
        ley73Model.setMensaje(Propiedades.C_ASEGURADOVIGENTE_MSG27_73);
        ley73Model.setClaveFundamento(Propiedades.C_ASEGURADOVIGENTE_CVE_FUN_73);
        ley73Model.setFundamento(Propiedades.C_ASEGURADOVIGENTE_FUN_73);
    }

    public void configurarAseguradoCumplaEdadMensajeFundamento(DeterminacionLey73Model ley73Model) {
        ley73Model.setMensaje(Propiedades.C_NOCUMPLEEDAD_MSG29_73);
        ley73Model.setClaveFundamento(Propiedades.C_NOCUMPLEEDAD_CVE_FUN_73);
        ley73Model.setFundamento(Propiedades.C_NOCUMPLEEDAD_FUN_73);
    }

    public void configurarNoSemanasReconocidas(DeterminacionLey73Model ley73Model) {
        ley73Model.setMensaje(Propiedades.C_NOSEMANASRECONOCIDAS_MSG33_73);
        ley73Model.setClaveFundamento(Propiedades.C_NOSEMANASRECONOCIDAS_CVE_FUN_73);
        ley73Model.setFundamento(Propiedades.C_NOSEMANASRECONOCIDAS_FUN_73);
    }

    public void configurarSinDerechoRegimenMensajeFundamento(DeterminacionLey73Model ley73Model) {
        ley73Model.setMensaje(Propiedades.C_V_SINDERECHOREGIMEN_MSG41_73_97);
        ley73Model.setClaveFundamento(Propiedades.C_V_SINDERECHOREGIMEN_CVE_FUN_73_97);
        ley73Model.setFundamento(Propiedades.C_V_SINDERECHOREGIMEN_FUN_73_97);
    }

    public void configurarFueraConservacionDerechosMensajeFundamento(DeterminacionLey73Model ley73Model) {
        ley73Model.setMensaje(Propiedades.C_FUERACONSERVACIONDERECHOS_MSG42_73);
        ley73Model.setClaveFundamento(Propiedades.C_FUERACONSERVACIONDERECHOS_CVE_FUN_73);
        ley73Model.setFundamento(Propiedades.C_FUERACONSERVACIONDERECHOS_FUN_73);
    }

    public void configurarReconocimientoDerechosMensajeFundamento(DeterminacionLey73Model ley73Model) {
        ley73Model.setMensaje(Propiedades.C_RECONOCIMIENTOSDERCHOS_MSG44_73);
        ley73Model.setClaveFundamento(Propiedades.C_RECONOCIMIENTOSDERCHOS_CVE_FUN_73);
        ley73Model.setFundamento(Propiedades.C_RECONOCIMIENTOSDERCHOS_FUN_73);
    }

}
