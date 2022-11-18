package uz.b25.time_api;

import java.time.*;
import java.util.Set;

public class App1 {
    public static void main(String[] args) {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();

        availableZoneIds.forEach(System.out::println);

        System.out.println(availableZoneIds.size());

//        Period, Duration, ChronoUnit,
//        LocalDateTime, ZonedDateTime, TemporalAdjusters

    }
}
