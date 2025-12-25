package SDIDproject;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;

public class Horaire {
    private int id_horaire;
    private Station stationDepartH;
    private Station stationArriveH;
    private Time heureDepart;
    private Time heureArrive;
    private Train train;
    private transient boolean imminent;
    private transient double totalPrice;

    public Horaire(int id, Station stationDepart, Station stationArrive, LocalTime heureDepart, LocalTime heureArrive, Train train) {
        this.id_horaire = id;
        this.stationDepartH = stationDepart;
        this.stationArriveH = stationArrive;
        this.heureDepart = Time.valueOf(heureDepart);
        this.heureArrive = Time.valueOf(heureArrive);
        this.train = train;
    }

    public Horaire() {}

    public int getId() {
        return id_horaire;
    }

    public Station getStationArrive() {
        return stationArriveH;
    }

    public void setStationArrive(Station stationArrive) {
        this.stationArriveH = stationArrive;
    }

    public Station getStationDepart() {
        return stationDepartH;
    }

    public void setStationDepart(Station stationDepart) {
        this.stationDepartH = stationDepart;
    }

    public Time getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(Time heureDepart) {
        this.heureDepart = heureDepart;
    }

    public Time getHeureArrive() {
        return heureArrive;
    }

    public void setHeureArrive(Time heureArrive) {
        this.heureArrive = heureArrive;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public boolean isImminent() {
        return imminent;
    }

    public void setImminent(boolean imminent) {
        this.imminent = imminent;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDuration() {
        LocalTime depart = heureDepart.toLocalTime();
        LocalTime arrive = heureArrive.toLocalTime();

        // Calculate the total minutes for both times
        int departMinutes = depart.getHour() * 60 + depart.getMinute();
        int arriveMinutes = arrive.getHour() * 60 + arrive.getMinute();

        // Handle crossing midnight
        int durationMinutes = (arriveMinutes >= departMinutes)
                ? arriveMinutes - departMinutes
                : (1440 - departMinutes) + arriveMinutes; // 1440 = total minutes in a day

        // Convert total minutes back to hours and minutes
        int hours = durationMinutes / 60;
        int minutes = durationMinutes % 60;

        return String.format("%02d:%02d", hours, minutes);
    }


    @Override
    public String toString() {
        return "Horaire : " +
                "id_horaire = " + id_horaire +
                ",\nstationDepart = " + stationDepartH.getStationName() + '\'' +
                ",\nstationArrive = " + stationArriveH.getStationName() + '\'' +
                ",\nheureDepart = " + heureDepart + '\'' +
                ",\nheureArrive = " + heureArrive + '\'' +
                ",\ntrain = " + train.getTrainType() + train.getTrainID();
    }
}