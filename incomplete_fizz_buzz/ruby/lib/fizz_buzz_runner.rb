require 'fizz_buzz'

class FizzBuzzRunner

  def initialize(inputer, printer)
    @inputer = inputer
    @printer = printer
    @histories = []
  end

  def run(selector)
    case selector

    when '1' then
      number = @inputer.gets.to_i
      @histories << number
      FizzBuzz.fizz_buzz(number, @printer)
    when '2' then
      for i in 0 .. (@histories.size - 1) do
        FizzBuzz.fizz_buzz_history(@histories[i], @printer)
      end
    when '3' then
      FizzBuzz.write(@histories)
    when '4' then
      filename = 'data.txt'
      FizzBuzz.read(filename, @printer)
    end
  end
end
