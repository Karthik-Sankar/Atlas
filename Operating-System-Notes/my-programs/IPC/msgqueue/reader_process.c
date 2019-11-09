#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/msg.h>
#include<string.h>
#include<errno.h>
struct mymsg
{
 long mtype;
 char str[200];
};

int main(int argc,char **argv)
{
 int msgid, i,j,k,flag;
 key_t key = 2394;
 struct mymsg msg;
  
 flag = 0666 ;

 printf("The key is %d\n",key);
 if( (msgid = msgget(key, flag))<0)
 {
   printf("Messge creation failed\n");
   exit(1);
 }

 printf("The msgid is %d\n",msgid);
 while(1)
 {
  if( (i=msgrcv(msgid,(void*)&msg,200,0,0))<0)
  {
    printf("errno = %d\n",errno);
    strerror(errno);
   printf("msg receive error : %d\n",i);
   exit(1);
  }
  printf("The received msg is : %s\n",msg.str); 
 } 
}

