# Overview

This is the beginnings of a PKCS11 library implemented using the JNA library.  I
wasn't able to find any other examples of this sort of thing.  It's nice because
you don't need to worry about deploying a JNI so/dll.  There's enough here to
list slot ID and token labels, so far.

Presumably this would be slower than a JNI implementation, but since you've
almost certainly got a network or USB (or even serial) interface between your
program and your PKCS11 device, I can't imagine it mattering much.

# TODO

It's not very useful so far.  And eventually, it would be nice to wrap a layer
over the low-level JNA code that makes PKCS11 a little nicer to use in java.
