#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>

void *routine_forone(void *chr)
{
char *ch;
ch=(char *)chr;
int i;
//printf("I am the first one\n");
for(i=0;i<10;i++)
{
printf("%s :%d\n",ch,i);
//sleep(1);
}
return NULL;
}

void *routine_fortwo(void *chr2)
{
char *ch2;
ch2=(char *)chr2;
int i;
//printf("I am the second one\n");
for(i=0;i<10;i++)
{
printf("%s :%d\n",ch2,i);
//sleep(1);
}
return NULL;
}

int main(int argc,char *argv[])
{
pthread_t thread1,thread2;
int ret1,ret2;
char *chr="the first one";
char *chr2="the second one";

ret1 = pthread_create(&thread1,NULL,routine_forone,(void *)chr);
ret1 = pthread_create(&thread2,NULL,routine_fortwo,(void *)chr2);


pthread_join(thread1,NULL);
pthread_join(thread2,NULL);

printf("the thread1 returned :%d\n",ret1);
printf("the thread2 returned :%d\n",ret2);

return 0;
}

