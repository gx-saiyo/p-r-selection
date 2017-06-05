class Looper

  def initialize(fizz_buzz_runner, inputer)
    @fizz_buzz_runner = fizz_buzz_runner
    @inputer = inputer
  end

  def loop
    while true
      selector = @inputer.get_input
      return if selector == '0'
      @fizz_buzz_runner.run(selector)
    end
  end
end
