echo "Enter a number: "
read a
case "$a" in
	"1") echo "One"
		;;
	"2") echo "Two"
		;;
	"3") echo "Three"
		;;
	"4") echo "Four"
		;;
	"5") echo "Five"
		;;
	"6") echo "Six"
		;;
	"7") echo "Seven"
		;;
	"8") echo "Eight"
		;;
	"9") echo "Nine"
		;;
	"10") echo "Ten"
		;;
esac


echo "Enter a char: "
read b
case "$b" in 
	"a") echo "Its a vowel"
		;;
	"e") echo "Its a vowel"
		;;
	"i") echo "Its a vowel"
		;;
	"o") echo "Its a vowel"
		;;
	"u") echo "Its a vowel"
		;;
	"A") echo "Its a vowel"
		;;
	"E") echo "Its a vowel"
		;;
	"I") echo "Its a vowel"
		;;
	"O") echo "Its a vowel"
		;;
	"U") echo "Its a vowel"
		;;
	*) echo "Its a consonant"
		;;
esac

