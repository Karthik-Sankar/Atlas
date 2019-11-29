echo "Num : "
read a
i=1
while [ $i -le 10 ]
do 
	echo "$a * $i = $(expr $a \* $b)"
	$i=`expr $i + 1`
done	
