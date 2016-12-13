package FizzBuzzRunner;

use strict;
use warnings;
use FizzBuzz;

sub new {
    my ($class, $inputer, $printer) = @_;
    return bless { inputer => $inputer, printer => $printer, histories => [] }, $class;
}

sub run {
    my ($self, $selector) = @_;
    if($selector eq '1') {
        my $number = int $self->{inputer}->gets;
        push @{$self->{histories}}, $number;
        FizzBuzz->fizz_buzz($number, $self->{printer});
    } elsif($selector eq '2') {
        for(my $i=0; $i < scalar(@{$self->{histories}}); $i++) {
            FizzBuzz->fizz_buzz_history($self->{histories}->[$i], $self->{printer});
        }
    } elsif($selector eq '3') {
        FizzBuzz->write($self->{histories});
    } elsif($selector eq '4') {
        if(-f 'data.txt') {
            open(FILE, 'data.txt');
            while(1) {
                my $line = <FILE>;
                last unless $line;
                chomp($line);
                $self->{printer}->execute($line);
            }
            close(FILE);
        }
    }
}

1;
