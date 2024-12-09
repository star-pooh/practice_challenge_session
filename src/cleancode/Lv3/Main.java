package cleancode.Lv3;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    // 실제 좌석 정보
    List<Seat> seatInfoList = List.of(
        new Seat("A1", "AVAILABLE"),
        new Seat("A2", "AVAILABLE"),
        new Seat("A3", "AVAILABLE"));

    // 예약 하려는 좌석 정보
    List<String> seatBookList = List.of("A2", "A3", "A1", "A4");

    for (String seatNum : seatBookList) {
      bookSeat(seatInfoList, seatNum);
    }
    countBookedSeats(seatInfoList);
  }

  /**
   * 예약 가능한 좌석인지 확인 후 예약 진행
   *
   * @param seatInfoList 실제 좌석 정보
   * @param seatNum      예약하려는 좌석 번호
   */
  private static void bookSeat(List<Seat> seatInfoList, String seatNum) {
    boolean isExistSeat = false;

    for (Seat seat : seatInfoList) {
      if (!seat.getSeatNumber().equals(seatNum)) {
        continue;
      }

      if (seat.getStatus().equals("BOOKED")) {
        throw new IllegalStateException("Seat " + seatNum + " is already booked.");
      } else {
        seat.book();
        System.out.println("Seat " + seatNum + " has been successfully booked.");
      }
      isExistSeat = true;
    }

    if (!isExistSeat) {
      System.out.println("Seat " + seatNum + " does not exist.");
    }
  }

  /**
   * 예약된 좌석의 수 계산
   *
   * @param seatInfoList 실제 좌석 정보
   */
  private static void countBookedSeats(List<Seat> seatInfoList) {
    int count = (int) seatInfoList.stream().filter(i -> i.getStatus().equals("BOOKED")).count();
    System.out.println("Total booked seats: " + count);
  }
}
