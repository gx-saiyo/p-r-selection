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
      for i in 0 .. (@histories.size - 1) do
        FizzBuzz.fizz_buzz_history(@histories[i], @printer)
      end
    when '3'
      FizzBuzz.write(@histories)
    when '4'
      if File.exist?('data.txt')
        file = File.new('data.txt', 'r')
        begin
          while true
           @printer.execute(file.readline.chomp)
          end
        rescue EOFError
          file.close
        end
      end
    end
  end
end
