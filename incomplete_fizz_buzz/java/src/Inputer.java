import java.io.DataInputStream;

public class Inputer implements Inputable {

  @Override
  public String gets() {
    try {
      DataInputStream stream = new DataInputStream(System.in);
      return stream.readLine();
    } catch(Exception e) {}
    return null;
  }
}
