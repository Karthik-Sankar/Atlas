#include<stdio.h>
#include<errno.h>
#include<string.h>

int main()
{
 FILE *fp;
 fp = fopen("amazon.txt","r");
 printf("The value of erron is : %d\n",errno);
 printf("The error message is : %s\n",strerror(errno));
 perror("Mesage from perror");
}
