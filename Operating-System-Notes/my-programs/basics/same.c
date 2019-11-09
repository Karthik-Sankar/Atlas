int count=10;
int swap(int a,int b)
{
 int temp;
 temp = a;
 a=b;
 b = temp;
 count++;
 printf(" a = %d \t b = %d\n",a,b);
 return 0;

}

