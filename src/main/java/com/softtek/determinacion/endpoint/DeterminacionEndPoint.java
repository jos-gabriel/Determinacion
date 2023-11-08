package com.softtek.determinacion.endpoint;

import com.softtek.determinacion.model.request.DeterminacionRequest;
import com.softtek.determinacion.model.response.Determinacion73y97Response;
import com.softtek.determinacion.service.DeterminacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeterminacionEndPoint {

    @GetMapping(path = "/")
    public @ResponseBody String doGet(){
        return "Determinación service is active";
    }

    private final DeterminacionService determinacionService;

    @Autowired
    public DeterminacionEndPoint(DeterminacionService determinacionService) {
        this.determinacionService = determinacionService;
    }

    @PostMapping("/mssofttek-determinacion/")
    public Determinacion73y97Response determinar(@RequestBody DeterminacionRequest request) {
        return determinacionService.determinar(request);
    }
}
