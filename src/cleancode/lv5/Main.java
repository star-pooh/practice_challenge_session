package cleancode.lv5;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    // 실제 좌석 정보
    List<Seat> seatInfoList = List.of(
        new Seat("A1", SeatStatus.AVAILABLE),
        new Seat("A2", SeatStatus.AVAILABLE),
        new Seat("A3", SeatStatus.AVAILABLE));

    // 예약 하려는 좌석 정보
    List<String> seatBookList = List.of("A2", "A3", "A1", "A4");

    BookingManager bookingManager = new BookingManager();

    for (String seatNum : seatBookList) {
      bookingManager.bookSeat(seatInfoList, seatNum);
    }
    bookingManager.countBookedSeats(seatInfoList);
  }
}
