module FizzBuzz
  module_function

  def fizz_buzz(number, printer)
    str = discriminator(number)
    printer.execute(str)
  end

  def fizz_buzz_history(number, printer)
    str = discriminator(number)
    printer.execute("#{number}, #{str}")
  end

  def write(histories)
    file = File.new('data.txt', 'w')
    for i in 0 .. (histories.size - 1) do
      history = histories[i]
      str = discriminator(history)
      file.puts("#{history}, #{str}")
    end
    file.close
  end

  def discriminator(number)
    if number == 0
      number.to_s
    elsif number % 15 == 0
      "FizzBuzz"
    elsif number % 3 == 0
      "Fizz"
    elsif number % 5 == 0
      "Buzz"
    else
      number.to_s
    end
  end
end
