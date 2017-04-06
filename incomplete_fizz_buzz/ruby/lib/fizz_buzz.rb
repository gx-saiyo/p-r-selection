module FizzBuzz
  module_function

  def fizz_buzz(number, printer)
    judge = judgment(number)
    printer.execute(judge)
  end

  def fizz_buzz_history(histories, printer)
    histories.each do |history|
      judge = judgment(history)
      printer.execute("#{history}, #{judge}")
    end
  end

  def write(histories)
    file = File.new('data.txt', 'w')
    histories.each do |history|
      judge = judgment(history)
      file.puts("#{history}, #{judge}")
    end
    file.close
  end

  def read(printer)
    if File.exist?('data.txt')
      file = File.new('data.txt', 'r')
      begin
        while true
          printer.execute(file.readline.chomp)
        end
      rescue EOFError
        file.close
      end
    end
  end

  def judgment(number)
    fizz = number % 3
    buzz = number % 5

    return number.to_s if number == 0
    return "FizzBuzz" if (fizz == 0 && buzz == 0)
    return "Fizz" if fizz == 0
    return "Buzz" if buzz == 0

    number.to_s
  end
end
