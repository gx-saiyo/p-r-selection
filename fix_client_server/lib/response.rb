class Response

  def self.set_up!
    Kernel.srand(Time.now.to_i)
    @@refresh_necessity = false
    @@sleep_necessity = false
    @@after_refresh = false
  end

  def body
    return @body if @body
    return @body = 'permission error' if permitted?
    return @body = 'too many request error' if unable_to_handle?
    @body = "ok"
    @body
  end

  def self.refresh!
    @@refresh_necessity = false
    @@after_refresh = true
  end

  def self.sleep!
    @@sleep_necessity = false
  end

  def self.reset!
    @@refresh_necessity = false
    @@after_refresh = false
  end

  private

    def unable_to_handle?
      number = Kernel.rand(1 .. 5).to_i
      if number == 5
        @@sleep_necessity = true
      end
      @@sleep_necessity
    end

    def permitted?
      return false if after_refrech?
      number = Kernel.rand(1 .. 9).to_i
      if 1 <= number && number <= 3
        @@refresh_necessity = true
      end
      @@refresh_necessity
    end

    def after_refrech?
      if @@after_refresh
        @@after_refresh = false
        return true
      end
      false
    end
end
