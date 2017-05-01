def get_name(year)
    i = 2010  #2010年のiPhone4を基準に2年毎に数字が1ずつ増えるため
    even_number = 4 + (year - i)/2  #西暦が偶数の場合に名前を求める式
    odd_number = (4 + ((year-1) - i)/2).to_s + 's' #西暦が奇数の場合に名前を求める式
    case year
      when 0..2006
        puts "iPhoneがまだ世に存在しません"
      when 2007
        puts '初代iPhone'
      when 2008
        puts '3G'
      when 2009
        puts '3GS'
      when 2010..2013
        if (year - i) % 2 == 0
          puts even_number
        else
          puts odd_number
        end
      when 2014..2016 #2014年以降にPlusが追加されたため
        if (year - i) % 2 == 0
          puts "#{even_number}/#{even_number}Plus "
        else
          puts "#{odd_number}/#{odd_number}Plus "
        end
      else
        puts "#{year}年版はまだ未発売です"
    end
end

puts '任意の西暦を入力しましょう！その年のiPhoneの名前を表示します'
year = gets.to_i
get_name(year)
