#!/usr/bin/bash
if [ -e $1 -a -z $1 -a -f $1 ]
then
	echo "File Exist!"
	if [ -r $1 ]
	then
		echo "File has  Read Access!"
	fi
	if [ -w $1 ]
	then
		echo "File has Write Access!"
	fi
	if [ -x $1 ]
	then 
		echo "File has Execute Access!"
	fi
elif [ -e $1 -a -z $1 -a -d $1 ]
then
	echo "Directory Found instead of file!"
else
	echo "Unknown file/directory !"
fi
