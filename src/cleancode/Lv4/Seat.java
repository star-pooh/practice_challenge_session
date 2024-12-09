package cleancode.Lv4;

public class Seat {

  private final String seatNumber;
  private String status;

  public Seat(String seatNumber, String status) {
    this.seatNumber = seatNumber;
    this.status = status;
  }

  public String getSeatNumber() {
    return seatNumber;
  }

  public String getStatus() {
    return status;
  }

  public void book() {
    this.status = "BOOKED";
  }
}
