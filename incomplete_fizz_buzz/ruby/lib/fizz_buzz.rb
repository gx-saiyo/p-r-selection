require 'fizz_buzz_judge'

module FizzBuzz
  module_function

# fizz_buzz_judge.rbによって，3の倍数，5の倍数の判定を行う
  def fizz_buzz(number, printer)
    judge_str = FizzBuzzJudge.judge(number)
    printer.execute(judge_str)
  end

  def fizz_buzz_history(number, printer)
    judge_str = FizzBuzzJudge.judge(number)
    printer.execute("#{number}, #{judge_str}")
  end

  def write(histories)
    file = File.new('data.txt', 'w')
    for i in 0 .. (histories.size - 1) do
      history = histories[i]
      judge_str = FizzBuzzJudge.judge(history)
      file.puts("#{history}, #{judge_str}")
    end
    file.close
  end

  def read(filename,printer)
    if File.exist?(filename)
      file = File.new(filename, 'r')
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
