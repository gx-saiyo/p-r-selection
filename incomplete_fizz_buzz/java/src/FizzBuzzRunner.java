public class FizzBuzzRunner {
  private Inputable inputer;
  private Printable printer;
  private History history = new History();

  public FizzBuzzRunner(Inputable inputer, Printable printer) {
    this.inputer = inputer;
    this.printer = printer;
  }

  public void run(String selector) {
    switch(selector) {
      case "1":
        int number = Integer.parseInt(inputer.gets());
        history.add(number);
        FizzBuzz.fizzBuzz(number, printer);
        break;
      case "2":
        history.print(printer);
        break;
      case "3":
        File.write(history);
        break;
      case "4":
        File.read(printer);
    }
  }
}
