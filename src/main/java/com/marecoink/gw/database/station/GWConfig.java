package com.marecoink.gw.database.station;

import com.marecoink.gw.database.json.JsonPlaceholderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class GWConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    CommandLineRunner commandLineRunner(JsonPlaceholderService jsonPlaceholderService, GWRepository gWRepository) {
        return args -> {
            List<Station> stations = jsonPlaceholderService.getStations();

            // Log stations to check if it's empty or not
            stations.forEach(station -> System.out.println(station));

            gWRepository.saveAll(stations);
        };
    }
}
//    @Bean

//    CommandLineRunner commandLineRunner(GWRepository repository) {
//        return args -> {
//            Station stationX = new Station(
//                    1,
//                    "Dolne Miasto",
//                    true,
//                    true,
//                    true,
//                    false,
//                    false,
//                    false,
//                    false,
//                    false,
//                    false,
//                    false
//            );
//
//            repository.saveAll(List.of(stationX));
//        };
//    }

