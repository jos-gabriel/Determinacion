package com.softtek.determinacion.service.determinacion.ley73;

import com.softtek.determinacion.model.request.DeterminacionRequest;
import com.softtek.determinacion.model.response.DeterminacionLey73Model;
import com.softtek.determinacion.service.determinacion.RulesDeterminacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeterminacionLey73Service {

    private final RulesDeterminacionService rules;
    private final MsgsCesantiaLey73Service cesantia;
    private final MsgsVejezLey73Service vejez;

    @Autowired
    public DeterminacionLey73Service(
            RulesDeterminacionService rulesDeterminacionService,
            MsgsCesantiaLey73Service msgsCesantiaLey73Service,
            MsgsVejezLey73Service msgsVejezLey73Service
    ) {
        this.rules = rulesDeterminacionService;
        this.cesantia = msgsCesantiaLey73Service;
        this.vejez = msgsVejezLey73Service;
    }

    public DeterminacionLey73Model calcularDeterminacion(DeterminacionRequest request) {
        DeterminacionLey73Model ley73Model = new DeterminacionLey73Model();
        ley73Model.setDerecho("NO");

        boolean retiroVejez = rules.pensionVejez(request);

        if (rules.esElegibleParaEvaluacion(request)) {
            if (retiroVejez) {
                vejez.configurarRJPMensajeFundamento(ley73Model);
            } else {
                cesantia.configurarRJPMensajeFundamento(ley73Model);
            }
            return ley73Model;
        }

        if (rules.tieneSuceptibilidadRJP(request)) {
            if (retiroVejez) {
                vejez.configurarSuceptibilidadObservaciones(ley73Model);
            } else {
                cesantia.configurarSuceptibilidadObservaciones(ley73Model);
            }
        }

        if (!rules.esNoVigente(request) || rules.validarFechaBaja(request)) {
            if (retiroVejez) {
                vejez.configurarAseguradoVigenteMensajeFundamento(ley73Model);
            }else {
                cesantia.configurarAseguradoVigenteMensajeFundamento(ley73Model);
            }
            return ley73Model;
        }

        if (!rules.cumpleRequisitosEdad(request, retiroVejez)) {
            if (retiroVejez) {
                vejez.configurarAseguradoCumplaEdadMensajeFundamento(ley73Model);
            } else {
                cesantia.configurarAseguradoCumplaEdadMensajeFundamento(ley73Model);
            }
            return ley73Model;
        }

        if (!rules.cumpleRequisitosSemReco(request)) {
            if (retiroVejez) {
                vejez.configurarNoSemanasReconocidas(ley73Model);
            } else {
                cesantia.configurarNoSemanasReconocidas(ley73Model);
            }
            return ley73Model;
        }

        if (!rules.puedeElegirRegimen(request)) {
            if (retiroVejez) {
                vejez.configurarSinDerechoRegimenMensajeFundamento(ley73Model);
            } else {
                cesantia.configurarSinDerechoRegimenMensajeFundamento(ley73Model);
            }
            return ley73Model;

        }

        if (!rules.tieneDerechoConservacionDerVencidos(request)) {
            if (retiroVejez) {
                vejez.configurarFueraConservacionDerechosMensajeFundamento(ley73Model);
                return ley73Model;
            } else {
                cesantia.configurarFueraConservacionDerechosMensajeFundamento(ley73Model);
                return ley73Model;
            }
        }

        if (!rules.esReingreso26a29Semanas(request) || !rules.esReingreso52a54Semanas(request) ) {
            if (retiroVejez) {
                vejez.configurarReconocimientoDerechosMensajeFundamento(ley73Model);
            } else {
                cesantia.configurarReconocimientoDerechosMensajeFundamento(ley73Model);
            }
            return ley73Model;
        }

        ley73Model.setDerecho("SI");
        return ley73Model;
    }

}
