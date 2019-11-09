#include<stdio.h>
#include<unistd.h>
#include<string.h>
#include<stdlib.h>
#include<sys/stat.h>
#include<sys/types.h>
#include<time.h>
#include<fcntl.h>

int main(int argc,char *argv[])
{
int fd;
struct stat sym,syb,syv;
char time1[100],time2[100];
char time3[100],time4[100];
char time5[100],time6[100];

strcpy(time1,ctime(&sym.st_atime));
strcpy(time2,ctime(&sym.st_mtime));
stat("statfile.txt",&sym);
printf("File stats using STAT:\n");
printf("------------------------------------------\n");
printf("the mode of file is :%o\n",sym.st_mode);
printf("the file creation time:%s",time1);
printf("the last modified time:%s",time2);
printf("the number of links:%ld\n",sym.st_nlink);
printf("userid of owner of the file is :%d\n",sym.st_uid);

fd=open("statnew.txt",O_RDONLY);
fstat(fd,&syb);
strcpy(time3,ctime(&syb.st_atime));
strcpy(time4,ctime(&syb.st_mtime));
printf("\nFile stats using FSTAT:\n");
printf("------------------------------------------\n");
printf("the mode of file is :%o\n",syb.st_mode);
printf("the file creation time:%s",time3);
printf("the last modified time:%s",time4);
printf("the number of links:%ld\n",syb.st_nlink);
printf("userid of owner of the file is :%d\n",syb.st_uid);
close(fd);


lstat("link1",&syv);
strcpy(time5,ctime(&syv.st_atime));
strcpy(time6,ctime(&syv.st_mtime));
printf("\nlink stats using LSTAT:\n");
printf("------------------------------------------\n");
printf("the mode of link is :%o\n",syv.st_mode);
printf("the link creation time:%s",time5);
printf("the link last modified time:%s",time6);
printf("the number of links:%ld\n",syv.st_nlink);
printf("userid of owner of the link is :%d\n",syv.st_uid);




 
return 0;
}
