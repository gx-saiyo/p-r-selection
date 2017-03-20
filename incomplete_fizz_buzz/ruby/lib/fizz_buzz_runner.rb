require 'fizz_buzz'

class FizzBuzzRunner
  def initialize(inputer, printer)
    @inputer = inputer
    @printer = printer
    @histories = []
  end

  def run(selector)
    case selector
    when '1'
      number = @inputer.gets.to_i
      @histories << number
      FizzBuzz.fizz_buzz(number, @printer)
    when '2'
      FizzBuzz.read_history(@histories, @printer)
    when '3'
      FizzBuzz.write(@histories)
    when '4'
      FizzBuzz.read_file(@printer)
    end
  end
end
