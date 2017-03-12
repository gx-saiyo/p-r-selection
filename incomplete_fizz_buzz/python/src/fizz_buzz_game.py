# -*- coding: utf-8 -*-
# Created:  2017-03-12
#

import random

def fizz_buzz(num):
    if num == 0:
        return num
    elif num % 15 == 0:
        return 'FizzBuzz'
    elif num % 3 == 0:
        return 'Fizz'
    elif num % 5 == 0:
        return 'Buzz'
    else:
        return num

class CPU(object):
    def __init__(self):
        # 10回連続でやればCPUは大体90%で負ける
        self._win_prob = 0.8
        self._pre_ans = None

    def get_ans(self, num):
        lose_prob = random.random()
        if lose_prob > self._win_prob:
            ans = self.get_wrong_ans(num)
        else:
            ans = fizz_buzz(num)

        self._pre_ans = ans
        return ans
    
    def get_pre_ans(self):
        return self._pre_ans

    def get_wrong_ans(self, num):
        candi = ['FizzBuzz', 'Fizz', 'Buzz', str(num)]
        ans = str(fizz_buzz(num))
        candi.remove(ans)
        return random.choice(candi)

class User(object):
    def __init__(self, inputer):
        self._inputer = inputer

    def get(self):
        return self._inputer.gets()

class FizzBuzzGamer(object):
    def __init__(self, level, inputer, printer):
        self._level = level
        self._num = None
        self._turn = 0
        self._max_turn = 30
        self._printer = printer
        self._cpu = CPU()
        self._user = User(inputer)

    def check_ans(self, num, pred):
        pred = str(pred)
        actu = str(fizz_buzz(num))
        if actu.lower() != pred.lower():
            return False
        else:
            return True

    def run(self):
        self.setup_init()
        self._printer.execute('初期数: {}'.format(self._num))

        while self._turn < self._max_turn:
            self._printer.execute('\nTurn: {}'.format(self._turn))
            if self._turn % 2 == 0:
                # CPUのターン
                pred = self._cpu.get_ans(self._num)
                self._printer.execute('CPU: ')
                self._printer.execute(pred)

            else:
                # ユーザのターン
                self._printer.execute('Your: ')
                pred = self._user.get()
                if pred.lower() == 'doubt':
                    if not self.check_ans(self._num - 1, self._cpu.get_pre_ans()):
                        self._printer.execute('You Win')
                    else:
                        self._printer.execute('You Lose, doubt is worng')
                    break
                else:
                    if not self.check_ans(self._num, pred):
                        self._printer.execute('You Lose, input is worng')
                        break

            self._turn += 1
            self._num += 1
        else:
            self._printer.execute('You Lose, time up')

    def setup_init(self):
        if self._level == '1':
            self._num = 0
        elif self._level == '2':
            self._num = random.randint(0, 255)

