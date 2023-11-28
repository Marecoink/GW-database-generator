package com.marecoink.gw.database.station;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GWConfig {

    @Bean
    CommandLineRunner commandLineRunner(GWRepository repository) {
        return args -> {
            Station stationX = new Station(
                    1,
                    "Dolne Miasto",
                    true,
                    true,
                    true,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false
            );

            repository.saveAll(List.of(stationX));
        };
    }
}
