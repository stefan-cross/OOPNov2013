OOPNov2014
==========

Oxford Software Engineering OOP Nov 2014 Assignment

Deliverables

This assignment consists of two parts: (a) implement a ranking list, once using mutable objects and once using immutable objects; (b) write an essay of around 1000 words reflecting on the design, use, advantages and disadvantages of immutable objects.

Ranking list
============
An Online Music Store maintains an internal ranking list of downloads to screen the popularity of their offerings. Design and implement a ranking list (i) once using mutable objects, and (ii) a second time using immutable objects. Specifically, implement the following functionality:

1. count(Track)
The count for the given track is incremented by one; if the piece is
counted for the first time, add it to the ranking list.

2. downloads(Track)
Return the number of times the given track has been downloaded.

3. mostPopularTrack()
Return the most popular track, that is, the track with the highest
number of downloads.

4. mostPopularTrackOf(Artist)
Return the most popular track of the given artist.

5. iterator()
Return an iterator that iterates through the ranking list in some order, for example, in alphabetic order or in order of popularity. 

Assume the following interface for tracks:

       interface Track {
           Title  title;
           Artist artist;
       }

The discussion in Section 2 suggests that mutable and immutable rank- ing lists possess different interfaces. This should be reflected in your design.
Don’t use any predefined collection classes or libraries for the im- plementation. That said, efficiency is not a concern: you will get better marks for clear code that performs poorly than vice versa. Take excep- tional situations into account and document your design decisions.
