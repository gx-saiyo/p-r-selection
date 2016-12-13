package FizzBuzz;

use strict;
use warnings;

sub fizz_buzz {
    my ($class, $number, $printer) = @_;
    if($number == 0) {
        $printer->execute("$number");
    } elsif($number % 15 == 0) {
        $printer->execute('FizzBuzz');
    } elsif($number % 3 == 0) {
        $printer->execute('Fizz');
    } elsif($number % 5 == 0) {
        $printer->execute('Buzz');
    } else {
        $printer->execute("$number");
    }
}

sub fizz_buzz_history {
    my ($class, $number, $printer) = @_;
    if($number == 0) {
        $printer->execute("$number, $number");
    } elsif($number % 15 == 0) {
        $printer->execute("$number, FizzBuzz");
    } elsif($number % 3 == 0) {
        $printer->execute("$number, Fizz");
    } elsif($number % 5 == 0) {
        $printer->execute("$number, Buzz");
    } else {
        $printer->execute("$number, $number");
    }
}

sub write {
    my ($class, $histories) = @_;
    open(FILE, '> data.txt');
    for(my $i=0; $i < scalar(@$histories); $i++) {
        my $history = $histories->[$i];
        if($history == 0) {
            print FILE "$history, $history\n";
        } elsif($history % 15 == 0) {
            print FILE "$history, FizzBuzz\n";
        } elsif($history % 3 == 0) {
            print FILE "$history, Fizz\n";
        } elsif($history % 5 == 0) {
            print FILE "$history, Buzz\n";
        } else {
            print FILE "$history, $history\n";
        }
    }
    close(FILE);
}

1;
