require 'client'
require 'helper'

describe Client do
  before { Helper.set_up }

  let(:client) { described_class.new }

    it do
      1000.times { expect(client.send_request('this is a request body')).to eq('ok') }
    end

  after { Helper.tear_down }
end
