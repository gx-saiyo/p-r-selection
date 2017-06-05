public class Looper {

  private FizzBuzzRunner fizzBuzzRunner;
  private Inputable inputer;

  public Looper(FizzBuzzRunner fizzBuzzRunner, Inputable inputer) {
    this.fizzBuzzRunner = fizzBuzzRunner;
    this.inputer = inputer;
  }

  public void loop() {
    System.out.println(FizzBuzzRunner.DISCRIPTION_TEXT);
    while(true) {
      String selector = inputer.gets();
      if(selector.equals("0")) {
        System.out.println("プログラムを終了します．");
        return;
      }
      fizzBuzzRunner.run(selector);
    }
  }
}
