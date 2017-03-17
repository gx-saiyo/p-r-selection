import input.Inputable;

public class Looper {

  private FizzBuzzRunner fizzBuzzRunner;
  private Inputable inputer;

  public Looper(FizzBuzzRunner fizzBuzzRunner, Inputable inputer) {
    this.fizzBuzzRunner = fizzBuzzRunner;
    this.inputer = inputer;
  }

  public void loop() {
    while(true) {
      String selector = inputer.gets();
      if(selector.equals("0")) {
        return;
      }
      fizzBuzzRunner.run(selector);
    }
  }
}
