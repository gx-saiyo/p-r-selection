use strict;
use warnings;

use Inputer;
use Printer;
use FizzBuzzRunner;
use Looper;

my $inputer = Inputer->new;
my $printer = Printer->new;
my $runner = FizzBuzzRunner->new($inputer, $printer);
my $looper = Looper->new($runner, $inputer);
$looper->loop();
