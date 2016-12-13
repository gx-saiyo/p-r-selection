import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.List;
import java.util.ArrayList;

public class FizzBuzzTest {

  @Test
  public void printsMultipleOf3AsFizz() {
    PrinterSpy spy = new PrinterSpy();
    FizzBuzz.fizzBuzz(3, spy);
    List<String> results = new ArrayList<String>();
    results.add("Fizz");
    assertThat(spy.results(), is(results));
  }

  @Test
  public void printsMultipleOf5AsBuzz() {
    PrinterSpy spy = new PrinterSpy();
    FizzBuzz.fizzBuzz(5, spy);
    List<String> results = new ArrayList<String>();
    results.add("Buzz");
    assertThat(spy.results(), is(results));
  }

  @Test
  public void printsMultipleOf15AsFizzBuzz() {
    PrinterSpy spy = new PrinterSpy();
    FizzBuzz.fizzBuzz(15, spy);
    List<String> results = new ArrayList<String>();
    results.add("FizzBuzz");
    assertThat(spy.results(), is(results));
  }

  @Test
  public void printsNumberWhichIsNotMultipleOf3And5() {
    PrinterSpy spy = new PrinterSpy();
    FizzBuzz.fizzBuzz(1, spy);
    List<String> results = new ArrayList<String>();
    results.add("1");
    assertThat(spy.results(), is(results));
  }
}
