import input.Inputer;
import output.Printer;

public class Main {

  public static void main(String[] args) {
    Inputer inputer = new Inputer();
    Printer printer = new Printer();
    FizzBuzzRunner runner = new FizzBuzzRunner(inputer, printer);
    Looper looper = new Looper(runner, inputer);
    looper.loop();
  }
}
