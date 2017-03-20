module FizzBuzz
  module_function

  def fizz_buzz(number, printer)
    str = separater(number)
    printer.output(str)
  end

  def read_history(histories, printer)
    histories.each do |number|
      str = separater(number)
      printer.output("#{number}, #{str}")
    end
  end

  def write(histories)
    file = File.new('data.txt', 'w')
    histories.each do |history|
      str = separater(history)
      file.puts("#{history}, #{str}")
    end
    file.close
  end

  def read_file(printer)
    if File.exist?('data.txt')
      file = File.new('data.txt', 'r')
      begin
        while true
         printer.output(file.readline.chomp)
        end
      rescue EOFError
        file.close
      end
    end
  end

  def separater(number)
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
