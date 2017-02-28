require 'fizz_buzz'

class FizzBuzzRunner
  HELP_TEXT = ["1: 整数を入力すると任意の文字列を表示",
               "2: 入力と出力の履歴を表示",
               "3: 入力と出力の履歴をファイルに保存",
               "4: 保存したファイルを読み込み、過去の履歴を表示",
               "0: プログラムを終了"]


  def initialize(inputer, printer)
    @inputer = inputer
    @printer = printer
    @histories = []
  end

  def run(selector)
    case selector
    when '1' then
      puts "整数を入力してください."
      print "-> "
      number = @inputer.gets.to_i
      @histories << number
      FizzBuzz.judge(number, @printer)
    when '2' then
      for i in 0 .. (@histories.size - 1) do
        FizzBuzz.show_history(@histories[i], @printer)
      end
    when '3' then
      FizzBuzz.write_history(@histories, 'data.txt')
    when '4' then
      FizzBuzz.read_history(@printer, 'data.txt')
    when 'h' then
      puts HELP_TEXT
    end
  end
end
