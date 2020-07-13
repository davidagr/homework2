package homework

import java.time.{DayOfWeek, LocalDate}
import java.time.temporal.ChronoUnit
import java.util.stream.Collectors.{counting, groupingBy}
import java.util.stream.{Collectors, Stream}

class Friday13(start:Int,end:Int){
  def countingFridays(): Unit ={
    val startDate:LocalDate=LocalDate.ofYearDay(start,13)
    val endDate:LocalDate=LocalDate.ofYearDay(end,349)

    Stream.iterate(startDate, (next: LocalDate) => next.plusMonths(1)).
      limit(ChronoUnit.MONTHS.between(startDate, endDate)).
      filter((next) => next.getDayOfWeek == DayOfWeek.FRIDAY).
      filter((next) => next.getDayOfMonth == 13).
      collect(Collectors.groupingBy(, counting)).
      entrySet.stream.sorted((year1: java.util.Map.Entry[Integer, Long], year2: java.util.Map.Entry[Integer, Long]) => (year2.getValue - year1.getValue).toInt).
      forEach(System.out.println)
  }

}
