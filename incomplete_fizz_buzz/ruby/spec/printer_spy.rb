class PrinterSpy

  def initialize
    @strings = []
  end

  def output(s)
    @strings << s
  end

  def results
    @strings
  end
end
