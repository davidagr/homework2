package homework;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class JasonVoorhees {
    public static void friday13count(int firstYear,int secondYear){
        LocalDate start = LocalDate.ofYearDay(firstYear,13);
        LocalDate end = LocalDate.ofYearDay(secondYear,349);
        Stream.iterate(start,next->next.plusMonths(1))
                .limit(ChronoUnit.MONTHS.between(start,end))
                .filter(next->next.getDayOfWeek()== DayOfWeek.FRIDAY)
                .filter(next->next.getDayOfMonth()==13)
                .collect(groupingBy(LocalDate::getYear,counting()))
                .entrySet().stream()
                .sorted((year1,year2)->(int)(year2.getValue()-year1.getValue()))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        friday13count(1973,1999);
    }
}
