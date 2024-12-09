package cleancode.Lv0;

import java.util.ArrayList;
import java.util.List;

public class DirtyCode {

  public static void main(String[] args) {
    // 실제 좌석 정보
    List<String> seats = new ArrayList<>();
    seats.add("A1:AVAILABLE");
    seats.add("A2:AVAILABLE");
    seats.add("A3:AVAILABLE");

    // 예약을 시도하려는 좌석 정보
    List<String> seats2 = List.of("A2", "A3", "A1", "A4");

    for (String seat2 : seats2) {
      boolean book = false;

      for (int i = 0; i < seats.size(); i++) {
        String seat = seats.get(i);
        if (seat.startsWith(seat2)) {
          if (seat.endsWith("BOOKED")) {
            // 예약 불가능한 좌석인 경우, 안내 메시지만 출력
            System.out.println("Seat " + seat2 + " is already booked.");
            book = true;
            break;
          } else {
            // 예약 가능한 좌석인 경우, 상태를 변경하고 예약 성공 메시지 출력
            seats.set(i, seat2 + ":BOOKED");
            System.out.println("Seat " + seat2 + " has been successfully booked.");
            book = true;
            break;
          }
        }
      }

      if (!book) {
        // 존재하지 않는 좌석인 경우, 에러 메시지 출력
        System.out.println("Seat " + seat2 + " does not exist.");
      }
    }

    int count = 0;
    for (String seat : seats) {
      if (seat.endsWith("BOOKED")) {
        count++;
      }
    }
    // 예약에 성공한 좌석의 수에 대한 안내 메시지 출력
    System.out.println("Total booked seats: " + count);
  }
}