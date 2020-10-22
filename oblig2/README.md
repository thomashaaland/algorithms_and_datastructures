To compile the program: ~$ javac *.java
Oblig2.java contains the main method.
To run the program: ~$ java Oblig2 ~/[inputfile_dir]/[inputfile].txt
Assumptions:
All input graphs can be read and compiled by Oblig2.java
I have infinite space on the computer, so haven't considered optimizing space

Status: As far as I know, it should work fine for all graphs as long as they are presented
 in a manner as to be interpretable by the code given to us in Oblig2.java
 
Peculiarities: Some of the code is sub optimal. The implementation of "displayWorkProcess()"
 runs over all times and will do alot of unneccesary checks. This could have been
 handled based on each vertice as opposed to each time unit to be more effective.
 Also, the program writes to terminal. I have used the 
 to write to files.

I have been inspired by course material, especially the course videos on topological sorting
and depth first searches.
