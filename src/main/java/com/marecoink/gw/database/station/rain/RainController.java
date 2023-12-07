package com.marecoink.gw.database.station.rain;

import com.marecoink.gw.database.station.GWService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/gdanskiewody/measurements/")
public class RainController {

    private final GWService gWService;

    @Autowired
    public RainController(GWService gWService) {
        this.gWService = gWService;
    }

    @GetMapping("/{no}/rain/{date}")
    ResponseEntity<List<Rain>> getRainData(@PathVariable Long no, @PathVariable String date) {
        return gWService.getRainDataForStation(no, date);
    }
}


//    @PostMapping
//    public void addNewStation(@RequestBody Station station) {
//        gWService.addNewStation(station);
//    }

