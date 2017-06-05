# -*- coding: utf-8 -*-
import os
import fizz_buzz
from fizz_buzz_game import FizzBuzzGamer

class FizzBuzzRunner:

  def __init__(self, inputer, printer):
    self.inputer = inputer
    self.printer = printer
    self.histories = []

  def run(self, selector):
    if selector == '1':
      number = int(self.inputer.gets())
      self.histories.append(number)
      fizz_buzz.fizz_buzz(number, self.printer)
    elif selector == '2':
      for i in range(0, len(self.histories)):
        fizz_buzz.fizz_buzz_history(self.histories[i], self.printer)
    elif selector == '3':
      fizz_buzz.write(self.histories)
    elif selector == '4':
      if os.path.exists('data.txt'):
        file = open('data.txt', 'r')
        while True:
          line = file.readline()
          if not line:
            break
          self.printer.execute(line.rstrip())
        file.close
    elif selector == '5':
      self.printer.execute('FizzBuzzゲーム')
      self.printer.execute('ただのFizzBuzzです')
      self.printer.execute('CPUとFizzBuzzをしてもらいます')
      self.printer.execute('CPUは時々間違えるので、それを指摘してください')
      self.printer.execute('勝利条件: 30ターン内にCPUが間違った答えをした時にdoubtと入力する')
      self.printer.execute('敗北条件: 30ターンを超える。doubtでないときにdoubtを入力する。FizzBuzzを間違える。')

      while True:
        self.printer.execute('CPUのレベルを数字で入れてください. 1: 弱い, 2: 普通')
        self.printer.execute('>')
        level = self.inputer.gets()
        if level in ['1', '2']:
          break
      
      self.printer.execute('FizzBuzzスタート')
      fizz_buzz_gamer = FizzBuzzGamer(level, self.inputer, self.printer)
      fizz_buzz_gamer.run()
