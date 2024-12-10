package cleancode.feedback;

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

  public void book(SeatStatus status, String seatNum) {
    if (status == SeatStatus.BOOKED) {
      throw new IllegalStateException("Seat " + seatNum + " is already booked.");
    }

    this.status = SeatStatus.BOOKED;
  }
}
