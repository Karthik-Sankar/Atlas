fname=$1
if ls|grep $1
then
echo "File $1 is present in the current working directory!"
else
echo "File doesn't exist"
fi
