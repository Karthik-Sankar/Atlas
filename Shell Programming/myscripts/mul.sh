echo "enter a num"
read m
for i in {1..10}
do 
	echo "$m * $i = $(expr $m \* $i)"
done
