#include<stdio.h>
#include<errno.h>
int main()
{
	FILE *fp;
	fp = fopen("testing.txt", "r");
	printf("Error : %s\n", stderror(errno));
	perror("Error : ");
}