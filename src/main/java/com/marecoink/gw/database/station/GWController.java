package com.marecoink.gw.database.station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/gdanskiewody")
public class GWController {

    private final GWService gWService;

    @Autowired
    public GWController(GWService gWService) {
        this.gWService = gWService;
    }

    @GetMapping
    public List<Station> getStations() {
        return gWService.getStations();
    }

    @PostMapping
    public void addNewStation(@RequestBody Station station) {
        gWService.addNewStation(station);
    }
}
