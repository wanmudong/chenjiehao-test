#!/bin/bash

function rand(){
    min=$1
    max=$(($2-$min+1))
    num=$(($RANDOM+1000000000)) 
    echo $(($num%$max+$min))
}

N=7

while(( $N<=30 ))
do
    echo "N: " $N  >> testresults.txt
    numTrail=$(rand 1400000 1500000)
    echo "numTrail: " $numTrail >> testresults.txt

    javac BirthdaySolver.java 
    java BirthdaySolver $N $numTrail   >> testresults.txt

    let "N++"
done