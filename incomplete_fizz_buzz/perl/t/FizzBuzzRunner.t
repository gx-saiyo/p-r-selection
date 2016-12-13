use strict;
use warnings;

use Test::More;
use Try::Tiny;

use t::InputerStub;
use t::PrinterSpy;
use FizzBuzzRunner;

sub delete_file {
    unlink('data.txt') if(-f 'data.txt');
}

subtest 'sets fizz buzz question' => sub {
    my $stub = t::InputerStub->new(['3']);
    my $spy = t::PrinterSpy->new;
    my $runner = FizzBuzzRunner->new($stub, $spy);
    $runner->run('1');
    is_deeply($spy->results, ['Fizz']);
};

subtest 'shows fizz buzz histories' => sub {
    my $stub = t::InputerStub->new(['3', '5']);
    my $spy = t::PrinterSpy->new;
    my $runner = FizzBuzzRunner->new($stub, $spy);
    $runner->run('1');
    $runner->run('1');
    $runner->run('2');
    is_deeply($spy->results, ['Fizz', 'Buzz', '3, Fizz', '5, Buzz']);
};

subtest 'saves fizz buzz histories' => sub {
    try {
        delete_file;
        my $stub = t::InputerStub->new(['3', '5']);
        my $spy = t::PrinterSpy->new;
        my $runner = FizzBuzzRunner->new($stub, $spy);
        $runner->run('1');
        $runner->run('1');
        $runner->run('3');
        open(FILE, 'data.txt');
        my $results = [];
        push @$results, <FILE>;
        push @$results, <FILE>;
        close(FILE);
        is_deeply($results, ["3, Fizz\n", "5, Buzz\n"]);
    } catch {
        fail;
    } finally {
        delete_file;
    };
};

subtest 'shows persisted histories' => sub {
    try {
        delete_file;
        my $stub = t::InputerStub->new(['3', '5']);
        my $spy = t::PrinterSpy->new;
        my $runner = FizzBuzzRunner->new($stub, $spy);
        $runner->run('1');
        $runner->run('1');
        $runner->run('3');
        $runner->run('4');
        is_deeply($spy->results, ['Fizz', 'Buzz', '3, Fizz', '5, Buzz']);
    } catch {
        fail;
    } finally {
        delete_file;
    };
};

done_testing;
