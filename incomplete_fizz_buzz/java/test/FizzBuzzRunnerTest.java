import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import org.junit.Before;
import org.junit.After;

import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class FizzBuzzRunnerTest {

  @Before
  public void setUp() {
    deleteFile();
  }

  @After
  public void tearDown() {
    deleteFile();
  }

  @Test
  public void setsFizzBuzzQuestion() {
    Queue<String> values = new PriorityQueue<String>();
    values.add("3");
    InputerStub stub = new InputerStub(values);
    PrinterSpy spy = new PrinterSpy();
    FizzBuzzRunner runner = new FizzBuzzRunner(stub, spy);
    runner.run(1);
    List<String> expect = new ArrayList<String>();
    expect.add("Fizz");
    assertThat(spy.results(), is(expect));
  }

  @Test
  public void showsFizzBuzzHistories() {
    Queue<String> values = new PriorityQueue<String>();
    values.add("3");
    values.add("5");
    InputerStub stub = new InputerStub(values);
    PrinterSpy spy = new PrinterSpy();
    FizzBuzzRunner runner = new FizzBuzzRunner(stub, spy);
    runner.run(1);
    runner.run(1);
    runner.run(2);
    List<String> expect = new ArrayList<String>();
    expect.add("Fizz");
    expect.add("Buzz");
    expect.add("3, Fizz");
    expect.add("5, Buzz");
    assertThat(spy.results(), is(expect));
  }

  @Test
  public void savesFizzBuzzHistories() {
    Queue<String> values = new PriorityQueue<String>();
    values.add("3");
    values.add("5");
    InputerStub stub = new InputerStub(values);
    PrinterSpy spy = new PrinterSpy();
    FizzBuzzRunner runner = new FizzBuzzRunner(stub, spy);
    runner.run(1);
    runner.run(1);
    runner.run(3);
    List<String> results = new ArrayList<String>();
    FileReader fileReader = null;
    BufferedReader bufferedReader = null;
    try {
      fileReader = new FileReader("data.txt");
      bufferedReader = new BufferedReader(fileReader);
      results.add(bufferedReader.readLine());
      results.add(bufferedReader.readLine());
      fileReader.close();
      bufferedReader.close();
    } catch(Exception e) {}
    List<String> expect = new ArrayList<String>();
    expect.add("3, Fizz");
    expect.add("5, Buzz");
    assertThat(results, is(expect));
  }

  @Test
  public void showsPersistedHistories() {
    Queue<String> values = new PriorityQueue<String>();
    values.add("3");
    values.add("5");
    InputerStub stub = new InputerStub(values);
    PrinterSpy spy = new PrinterSpy();
    FizzBuzzRunner runner = new FizzBuzzRunner(stub, spy);
    runner.run(1);
    runner.run(1);
    runner.run(3);
    runner.run(4);
    List<String> expect = new ArrayList<String>();
    expect.add("Fizz");
    expect.add("Buzz");
    expect.add("3, Fizz");
    expect.add("5, Buzz");
    assertThat(spy.results(), is(expect));
  }

  private void deleteFile() {
    File file = new File("data.txt");
    if(file.exists()) {
      file.delete();
    }
  }
}
