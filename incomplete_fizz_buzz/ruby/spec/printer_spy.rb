class PrinterSpy

  def initialize
    @strings = []
  end

  def execute(s)
    @strings << s
  end

  def results
    @strings
  end
end
