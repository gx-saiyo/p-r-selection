import input.Inputable;

import java.util.Queue;

public class InputerStub implements Inputable {

  private Queue<String> values;

  public InputerStub(Queue<String> values) {
    this.values = values;
  }

  @Override
  public String gets() {
    return values.poll();
  }
}
