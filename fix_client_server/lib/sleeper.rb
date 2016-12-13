require 'response'

module Sleeper
  module_function

  def sleep
    Response.sleep!
  end
end
