require 'fizz_buzz_runner'
require 'printer'
require 'inputer'
require 'looper'

inputer = Inputer.new
printer = Printer.new
runner = FizzBuzzRunner.new(inputer, printer)
looper = Looper.new(runner, inputer)
looper.loop
