module FizzBuzzJudge
  module_function

  def judge(number)
    judge_str = '' 

    if number == 0
     judge_str = number.to_s
    elsif number % 15 == 0
     judge_str = 'FizzBuzz'
    elsif number % 3 == 0
     judge_str = 'Fizz'
    elsif number % 5 == 0
     judge_str = 'Buzz'
    else
     judge_str = number.to_s
    end
   
    return judge_str
  end
end
