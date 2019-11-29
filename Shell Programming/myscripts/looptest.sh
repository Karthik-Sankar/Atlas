#!/bin/bash
arr=(1 2 3 4 5 6 7 8 9 10)
for i in "${arr[@]}"
do
	#v=$(expr $i % 2)
	if [ $(expr $i % 2) -eq 0 ];
	then
		echo "$i is even"
	else
		echo "$i is odd"
	fi
done
#echo "${arr[@]:0:5}"

