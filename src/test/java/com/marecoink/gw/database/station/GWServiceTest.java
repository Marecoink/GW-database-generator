package com.marecoink.gw.database.station;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GWServiceTest {

    @Mock
    private GWRepository gWRepository;
    private GWService underTest;

    @BeforeEach
    void setUp() {
        underTest = new GWService(gWRepository);
    }

    @Test
    void canGetStations() {
        //when
        underTest.getStations();
        //then
        verify(gWRepository).findAll();
    }

    @Test
    void canAddNewStation() {
        //given
        Station station = new Station(
                1,
                "Test Station",
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

        //when
        underTest.addNewStation(station);

        //then
        ArgumentCaptor<Station> stationArgumentCaptor = ArgumentCaptor.forClass(Station.class);
        verify(gWRepository).save(stationArgumentCaptor.capture());
        Station capturedStation = stationArgumentCaptor.getValue();
        assertEquals(capturedStation, station);
    }
}