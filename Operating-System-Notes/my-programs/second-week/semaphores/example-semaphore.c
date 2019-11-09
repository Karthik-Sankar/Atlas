#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#include<semaphore.h>
#include<stdio.h>

void routine_forone(void *chr);
void routine_fortwo(void *chr2);

char buf[24];
sem_t mutex;
int count=0;

int main(int argc,char *argv[])
{
pthread_t thread1;
pthread_t thread2;

char *chr="the first one";
char *chr2="the second one";

sem_init(&mutex,0,1);

pthread_create(&thread1,NULL,(void *) &routine_forone,(void *)chr);
pthread_create(&thread2,NULL,(void *) &routine_fortwo,(void *)chr2);


pthread_join(thread1,NULL);
pthread_join(thread2,NULL);

sem_destroy(&mutex);
return 0;
}

void routine_forone(void *chr)
{
    char *ch;
    int i=0;
    ch=(char *)chr;
      sprintf(buf,"%s","Hi there");
    for(i=0;i<5;i++)
    {
      if(i%2==0) 
        sem_wait(&mutex);
       printf("%s\n",ch);
       printf("%s   Count = %d \n",buf,count++);
       sem_post(&mutex);
       fflush(stdout); 
//     sleep(1);
     }
   pthread_exit(0);
}


void routine_fortwo(void *chr2)
{
   char *ch2;
   int i=0; 
   ch2=(char *)chr2;
   for(i=0;i<5;i++)
   {
     if(i%2==1) 
        sem_wait(&mutex);
      printf("%s\n",ch2);
      printf("%s  Count = %d \n",buf,count++); 
      sem_post(&mutex);
      fflush(stdout); 
 //     sleep(1); 
   } 
pthread_exit(0);
}

