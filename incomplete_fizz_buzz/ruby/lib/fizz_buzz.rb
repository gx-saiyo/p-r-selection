module FizzBuzz
  module_function

  def fizz_buzz(number, printer)
    if number == 0
      printer.execute(number.to_s)
    elsif number % 15 == 0
      printer.execute('FizzBuzz')
    elsif number % 3 == 0
      printer.execute('Fizz')
    elsif number % 5 == 0
      printer.execute('Buzz')
    else
      printer.execute(number.to_s)
    end
  end

  def fizz_buzz_history(number, printer)
    if number == 0
      printer.execute("#{number}, #{number.to_s}")
    elsif number % 15 == 0
      printer.execute("#{number}, FizzBuzz")
    elsif number % 3 == 0
      printer.execute("#{number}, Fizz")
    elsif number % 5 == 0
      printer.execute("#{number}, Buzz")
    else
      printer.execute("#{number}, #{number.to_s}")
    end
  end

  def write(histories)
    file = File.new('data.txt', 'w')
    for i in 0 .. (histories.size - 1) do
      history = histories[i]
      if history == 0
        file.puts("#{history}, #{history.to_s}")
      elsif history % 15 == 0
        file.puts("#{history}, FizzBuzz")
      elsif history % 3 == 0
        file.puts("#{history}, Fizz")
      elsif history % 5 == 0
        file.puts("#{history}, Buzz")
      else
        file.puts("#{history}, #{history.to_s}")
      end
    end
    file.close
  end
end
