module FizzBuzz
  module_function

  def fizz_buzz(number, printer) 
       printer.execute(check(number))
  end

  def fizz_buzz_history(number, printer)
        printer.execute("#{number}, #{check(number)}")
  end

  def write(histories)
    file = File.new('data.txt', 'w')
    for i in 0 .. (histories.size - 1) do
      history = histories[i]
        file.puts("#{history}, #{check(history)}")
    end
    file.close
  end
end

  def check(value)
    if value == 0 
        responce = value.to_s
    elsif value % 15 == 0
        responce = 'FizzBuzz'
    elsif value % 3 == 0
        responce = 'Fizz'
    elsif value % 5 == 0
        responce = 'Buzz'
    else 
        responce = value.to_s
    end
  end
