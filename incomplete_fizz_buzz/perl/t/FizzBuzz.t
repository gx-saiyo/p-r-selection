use strict;
use warnings;

use Test::More;
use t::PrinterSpy;
use FizzBuzz;

subtest 'prints multiple of 3 as Fizz' => sub {
    my $spy = t::PrinterSpy->new;
    FizzBuzz->fizz_buzz(3, $spy);
    is_deeply($spy->results, ['Fizz']);
};

subtest 'prints multiple of 5 as Buzz' => sub {
    my $spy = t::PrinterSpy->new;
    FizzBuzz->fizz_buzz(5, $spy);
    is_deeply($spy->results, ['Buzz']);
};

subtest 'prints multiple of 15 as FizzBuzz' => sub {
    my $spy = t::PrinterSpy->new;
    FizzBuzz->fizz_buzz(15, $spy);
    is_deeply($spy->results, ['FizzBuzz']);
};

subtest 'prints number which is not multiple of 3 and 5' => sub {
    my $spy = t::PrinterSpy->new;
    FizzBuzz->fizz_buzz(1, $spy);
    is_deeply($spy->results, ['1']);
};

done_testing;
