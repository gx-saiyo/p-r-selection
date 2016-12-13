require 'response'

module Helper
  module_function

  def set_up
    Response.set_up!
  end

  def tear_down
    Response.reset!
  end
end
