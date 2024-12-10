package cleancode.lv5;

public class Seat {

  private final String seatNumber;
  private SeatStatus status;

  public Seat(String seatNumber, SeatStatus status) {
    this.seatNumber = seatNumber;
    this.status = status;
  }

  public String getSeatNumber() {
    return seatNumber;
  }

  public SeatStatus getStatus() {
    return status;
  }

  public void book() {
    this.status = SeatStatus.BOOKED;
  }
}
