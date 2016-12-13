require 'fizz_buzz_runner'
require 'printer_spy'
require 'inputer_stub'


describe FizzBuzzRunner do
  before { delete_file }
  after { delete_file }

  it do
    stub = InputerStub.new(['3'])
    spy = PrinterSpy.new
    runner = FizzBuzzRunner.new(stub, spy)
    runner.run('1')
    expect(spy.results).to eq(['Fizz'])
  end

  it do
    stub = InputerStub.new(['3', '5'])
    spy = PrinterSpy.new
    runner = FizzBuzzRunner.new(stub, spy)
    runner.run('1')
    runner.run('1')
    runner.run('2')
    expect(spy.results).to eq(['Fizz', 'Buzz', '3, Fizz', '5, Buzz'])
  end

  it do
    stub = InputerStub.new(['3', '5'])
    spy = PrinterSpy.new
    runner = FizzBuzzRunner.new(stub, spy)
    runner.run('1')
    runner.run('1')
    runner.run('3')
    file = File.new('data.txt', 'r')
    results = []
    results << file.readline
    results << file.readline
    file.close
    expect(results).to eq(["3, Fizz\n", "5, Buzz\n"])
  end

  it do
    stub = InputerStub.new(['3', '5'])
    spy = PrinterSpy.new
    runner = FizzBuzzRunner.new(stub, spy)
    runner.run('1')
    runner.run('1')
    runner.run('3')
    runner.run('4')
    expect(spy.results).to eq(['Fizz', 'Buzz', '3, Fizz', '5, Buzz'])
  end

  private

    def delete_file
      File.delete('data.txt') if File.exist?('data.txt')
    end
end
