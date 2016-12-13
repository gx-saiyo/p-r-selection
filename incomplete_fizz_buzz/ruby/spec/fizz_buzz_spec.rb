require 'fizz_buzz'
require 'printer_spy'

describe FizzBuzz do
  it do
    spy = PrinterSpy.new
    FizzBuzz.fizz_buzz(3, spy)
    expect(spy.results).to eq(['Fizz'])
  end

  it do
    spy = PrinterSpy.new
    FizzBuzz.fizz_buzz(5, spy)
    expect(spy.results).to eq(['Buzz'])
  end

  it do
    spy = PrinterSpy.new
    FizzBuzz.fizz_buzz(15, spy)
    expect(spy.results).to eq(['FizzBuzz'])
  end

  it do
    spy = PrinterSpy.new
    FizzBuzz.fizz_buzz(1, spy)
    expect(spy.results).to eq(['1'])
  end
end
