package com.softtek.determinacion.model.response;

import com.softtek.determinacion.model.response.ley73.DeterminacionLey73Model;
import com.softtek.determinacion.model.response.ley97.DeterminacionLey97Model;
import lombok.Data;

@Data
public class DeterminacionResponse {
    private DeterminacionLey73Model determinacionLey73Model;
    private DeterminacionLey97Model determinacionLey97Model;
}