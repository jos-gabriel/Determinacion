package com.softtek.determinacion.service.determinacion.ley97;

import com.softtek.determinacion.model.request.DeterminacionRequest;
import com.softtek.determinacion.model.response.DeterminacionLey97Model;
import com.softtek.determinacion.service.determinacion.RulesDeterminacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeterminacionLey97Service {

    private final RulesDeterminacionService rules;
    private final MsgsCesantiaLey97Service cesantia;
    private final MsgsVejezLey97Service vejez;

    @Autowired
    public DeterminacionLey97Service(
            RulesDeterminacionService rulesDeterminacionService,
            MsgsCesantiaLey97Service msgsCesantiaLey97Service,
            MsgsVejezLey97Service msgsVejezLey97Service
    ) {
        this.rules = rulesDeterminacionService;
        this.cesantia = msgsCesantiaLey97Service;
        this.vejez = msgsVejezLey97Service;
    }

    public DeterminacionLey97Model calcularDeterminacion(DeterminacionRequest request) {
        DeterminacionLey97Model ley97Model = new DeterminacionLey97Model();
        ley97Model.setDerecho("NO");
        boolean retiroVejez = rules.pensionVejez(request);

        if (rules.esElegibleParaEvaluacion(request)) {
            if (retiroVejez) {
                vejez.configurarRJPMensajeFundamento(ley97Model);
            } else {
                cesantia.configurarRJPMensajeFundamento(ley97Model);
            }
            return ley97Model;
        }

        if (rules.tieneSuceptibilidadRJP(request)) {
            if (retiroVejez) {
                vejez.configurarSuceptibilidadObservaciones(ley97Model);
            } else {
                cesantia.configurarSuceptibilidadObservaciones(ley97Model);
            }
        }

        int semanasReconocidas = rules.totalSemanasReconocidas(request);

        if (rules.noCumpleRequisitosRetiroTotalLey97(semanasReconocidas, request)) {

            if (retiroVejez) {
                vejez.configurarRetiroTotal(ley97Model);
            } else {
                cesantia.configurarRetiroTotal(ley97Model);
            }
            return ley97Model;
        }

        if (!rules.esNoVigente(request) || rules.validarFechaBaja(request)) {
            if (retiroVejez) {
                vejez.configurarAseguradoVigente(ley97Model);
            }else {
                cesantia.configurarAseguradoVigente(ley97Model);
            }
            return ley97Model;
        }

        if (!rules.cumpleRequisitosEdad(request, retiroVejez)) {

            if (retiroVejez) {
                vejez.configurarNoCumpleEdad(ley97Model);
            } else {
                cesantia.configurarNoCumpleEdad(ley97Model);
            }
            return ley97Model;
        }

        if (!rules.tieneDerechoPrestacionLey97(semanasReconocidas)) {
            if (retiroVejez) {
                vejez.configurarNoSemanasReconocidas(ley97Model);
            } else {
                cesantia.configurarNoSemanasReconocidas(ley97Model);
            }
            return ley97Model;
        }

        ley97Model.setDerecho("SI");
        return ley97Model;

    }
}
