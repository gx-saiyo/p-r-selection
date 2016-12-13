package t::InputerStub;

use strict;
use warnings;

sub new {
    my ($class, $values) = @_;
    return bless { values => $values }, $class;
}

sub gets {
    my $self = shift;
    return shift @{$self->{values}};
}

1;
