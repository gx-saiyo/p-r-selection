module FizzBuzz
  module_function

  def fizz_buzz(number)
    if number == 0
      return number.to_s
    elsif number % 15 == 0
      return 'FizzBuzz'
    elsif number % 3 == 0
      return 'Fizz'
    elsif number % 5 == 0
      return 'Buzz'
    else
      return number.to_s
    end
  end

  def judge(number, printer)
      printer.execute(fizz_buzz(number))
  end

  def show_history(number, printer)
      printer.execute("#{number}, #{fizz_buzz(number)}")
  end

  def write_history(histories, file_name)
    file = File.new(file_name, 'w')
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
    puts "#{file_name} に書き込みました."
  end

  def read_history(printer, file_name)
    if File.exist?(file_name)
      file = File.new(file_name, 'r')
      begin
        while true
          printer.execute(file.readline.chomp)
        end
      rescue EOFError
        file.close
      end
    end
  end
end
