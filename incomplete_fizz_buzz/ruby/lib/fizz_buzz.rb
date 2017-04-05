module FizzBuzz
  module_function

  def fizz_buzz(number, printer)
    judge = judgment(number)
    printer.execute(judge)
  end

  def fizz_buzz_history(number, printer)
    judge = judgment(number)
    printer.execute("#{number}, #{judge}")
  end

  def write(histories)
    file = File.new('data.txt', 'w')
    histories.each do |history|
      judge = judgment(history)
      file.puts("#{history}, #{judge}")
    end
    file.close
  end

  def judgment(number)
    fizz = number % 3
    buzz = number % 5

    if number == 0
      number.to_s
    elsif (fizz == 0 && buzz == 0)
      "FizzBuzz"
    elsif fizz == 0
      "Fizz"
    elsif buzz == 0
      "Buzz"
    else
      number.to_s
    end

  end
end
