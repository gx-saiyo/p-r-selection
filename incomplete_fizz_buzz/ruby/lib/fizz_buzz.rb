module FizzBuzz
  module_function

  def fizz_buzz(number, printer)
    printer.execute judgment(number)
  end

  def fizz_buzz_history(histories, printer)
    histories.each do |history|
      printer.execute("#{history}, #{ judgment(history) }")
    end
  end

  def write(histories)
    file = File.new('data.txt', 'w')
    histories.each do |history|
      file.puts("#{history}, #{ judgment(history) }")
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
    return "FizzBuzz" if number % 15 == 0
    return "Buzz"     if number % 5 == 0
    return "Fizz"     if number % 3 == 0

    number.to_s
  end
end
