#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/msg.h>
#include<string.h>

struct mymsg
{
 long mtype;
 char msg[200];
};

int main()
{
 int msgid, i,j,k,flag;
 char str[100]; 
 struct mymsg msg; 
 key_t key;
 key = 2394;
  flag = IPC_CREAT|0666 ;

 if( (msgid = msgget(key , flag))<0)
 {
   printf("Messge creation failed\n");
   exit(1);
 }
 printf("The msgid is %d\n",msgid);
 while(1)
 {
  printf("Enter the string to be sent :\n");
  gets(str);
  msg.mtype=1; 
  strcpy(msg.msg,str); 
 if( (i=msgsnd(msgid,(void*)&msg,strlen(msg.msg)+1,0))<0)
 {
   printf("msg send error\n");
   exit(1);
 }
 printf("Message sent to msg queue\n");
 }
}
