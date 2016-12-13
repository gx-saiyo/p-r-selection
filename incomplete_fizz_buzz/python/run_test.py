from unittest import TestLoader
from unittest import TextTestRunner
import sys


sys.path.append('src')
loader = TestLoader()
test = loader.discover('test')
runner = TextTestRunner()
runner.run(test)
