package com.marecoink.gw.database.station;

import com.marecoink.gw.database.station.rain.Rain;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "station")
public class Station {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no", updatable = false, nullable = false, unique = true)
    private long no;
    private String name;
    private boolean active;
    private boolean rain;
    private boolean water;
    private boolean flow;
    private boolean winddir;
    private boolean windlevel;
    private boolean temp;
    private boolean pressure;
    private boolean humidity;
    private boolean sun;

    @OneToMany(mappedBy = "station", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rain> rainData = new ArrayList<>();

    public Station() {
    }

    public Station(long no, String name, boolean active, boolean rain, boolean water, boolean flow,
                   boolean winddir, boolean windlevel, boolean temp, boolean pressure, boolean humidity, boolean sun) {
        this(no, name, active, rain, water, flow, winddir, windlevel, temp, pressure, humidity, sun, new ArrayList<>());
    }

    public Station(long no, String name, boolean active, boolean rain, boolean water, boolean flow,
                   boolean winddir, boolean windlevel, boolean temp, boolean pressure, boolean humidity, boolean sun, List<Rain> rainData) {
        this.no = no;
        this.name = name;
        this.active = active;
        this.rain = rain;
        this.water = water;
        this.flow = flow;
        this.winddir = winddir;
        this.windlevel = windlevel;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.sun = sun;
        this.rainData = rainData;
    }

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isRain() {
        return rain;
    }

    public void setRain(boolean rain) {
        this.rain = rain;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFlow() {
        return flow;
    }

    public void setFlow(boolean flow) {
        this.flow = flow;
    }

    public boolean isWinddir() {
        return winddir;
    }

    public void setWinddir(boolean winddir) {
        this.winddir = winddir;
    }

    public boolean isWindlevel() {
        return windlevel;
    }

    public void setWindlevel(boolean windlevel) {
        this.windlevel = windlevel;
    }

    public boolean isTemp() {
        return temp;
    }

    public void setTemp(boolean temp) {
        this.temp = temp;
    }

    public boolean isPressure() {
        return pressure;
    }

    public void setPressure(boolean pressure) {
        this.pressure = pressure;
    }

    public boolean isHumidity() {
        return humidity;
    }

    public void setHumidity(boolean humidity) {
        this.humidity = humidity;
    }

    public boolean isSun() {
        return sun;
    }

    public void setSun(boolean sun) {
        this.sun = sun;
    }

    public List<Rain> getRainData() {
        return rainData;
    }

    public void setRainData(List<Rain> rainData) {
        this.rainData = rainData;
    }

    @Override
    public String toString() {
        return "Station{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", rain=" + rain +
                ", water=" + water +
                ", flow=" + flow +
                ", winddir=" + winddir +
                ", windlevel=" + windlevel +
                ", temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", sun=" + sun +
                '}';
    }

}
