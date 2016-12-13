package t::PrinterSpy;

use strict;
use warnings;

sub new {
    my $class = shift;
    return bless { strings => [] }, $class;
}

sub execute {
    my ($self, $s) = @_;
    push(@{$self->{strings}}, $s);
}

sub results {
    my $self = shift;
    return $self->{strings};
}

1;
