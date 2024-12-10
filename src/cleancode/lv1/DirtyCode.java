package cleancode.lv1;

import java.util.ArrayList;
import java.util.List;

public class DirtyCode {

  public static void main(String[] args) {
    // 실제 좌석 정보
    List<String> seatInfoList = new ArrayList<>();
    seatInfoList.add("A1:AVAILABLE");
    seatInfoList.add("A2:AVAILABLE");
    seatInfoList.add("A3:AVAILABLE");

    // 예약하려는 좌석 정보
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
  private static void bookSeat(List<String> seatInfoList, String seatNum) {
    boolean isExistSeat = false;

    for (int i = 0; i < seatInfoList.size(); i++) {
      String seatInfo = seatInfoList.get(i);

      if (!seatInfo.startsWith(seatNum)) {
        continue;
      }

      if (seatInfo.endsWith("BOOKED")) {
        System.out.println("Seat " + seatNum + " is already booked.");
      } else {
        seatInfoList.set(i, seatNum + ":BOOKED");
        System.out.println("Seat " + seatNum + " has been successfully booked.");
      }
      isExistSeat = true;
    }

    if (!isExistSeat) {
      System.out.println("Seat " + seatNum + " does not exist.");
    }
  }

  /**
   * 예약된 좌석 수 확인
   *
   * @param seatInfoList 실제 좌석 정보
   */
  private static void countBookedSeats(List<String> seatInfoList) {
    int count = 0;
    for (String seatInfo : seatInfoList) {
      if (seatInfo.endsWith("BOOKED")) {
        count++;
      }
    }
    System.out.println("Total booked seats: " + count);
  }
}