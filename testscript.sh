#!/bin/sh


{

mvn -Dtest=GuitarPartTest test;
mvn -Dtest=FenderGuitarPartTest test;
mvn -Dtest=GibsonGuitarPartTest test;
mvn -Dtest=GuitarTest test;} | tee   output.txt
