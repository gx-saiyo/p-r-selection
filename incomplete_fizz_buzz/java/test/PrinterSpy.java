import output.Printable;

import java.util.List;
import java.util.ArrayList;

public class PrinterSpy implements Printable {

  private List<String> strings = new ArrayList<String>();

  @Override
  public void execute(String s) {
    strings.add(s);
  }

  public List<String> results() {
    return strings;
  }
}
