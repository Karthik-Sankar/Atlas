#include<stdio.h>
#include<stdlib.h>

int main()
{
 FILE * fp;
 int i, j, k;
 char str[100];

 fp = popen("/bin/ls -al","r");
 if(fp==NULL)
 {
   printf("popen error\n");
   exit(1);
 }
 while((i=fread(str,1, 100,fp))>0)
 {
   fwrite(str,1, i, stdout); 
 }
 pclose(fp);
}

