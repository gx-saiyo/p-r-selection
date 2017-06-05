require 'connection'
require 'access_token'
require 'sleeper'

class Client
  include Sleeper

  PERMISSION_ERROR = 'permission error'
  FREQUENCY_REQUEST_ERROR = 'too many request error'

  def initialize
    @connection = Connection.new
    @access_token = AccessToken.new
  end

  def send_request(body)
    @request = @connection.create_request
    @request.add_header('Content-Type', 'text/plain')
            .add_header('Authorization', @access_token.to_s)
            .set_body(body)
    do_post
    until response_success? do
      sleep
      do_post
    end
    @response.body
  end

  private
    def do_post
      @access_token.refresh!
      @response = @request.post
    end

    def response_success?
      errors = [
        PERMISSION_ERROR,
        FREQUENCY_REQUEST_ERROR
      ]
      errors.each do |error|
        return false if error == @response.body
      end
      return true
    end

end
