package uz.pdp;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){

        LocalDate initialDate=LocalDate.now();
        LocalDate finalDate=LocalDate.now().plusDays(15).plusMonths(2).plusYears(8);
        System.out.println(Period.between(initialDate, finalDate).getDays()+"\t\t=>\t\t"+ChronoUnit.DAYS.between(initialDate, finalDate));
        System.out.println(Period.between(initialDate, finalDate).getMonths()+"\t\t=>\t\t"+ChronoUnit.MONTHS.between(initialDate, finalDate));
        System.out.println(Period.between(initialDate, finalDate).getYears()+"\t\t=>\t\t"+ChronoUnit.YEARS.between(initialDate, finalDate));


        System.out.println(initialDate.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.CHINA)));

    }
}
