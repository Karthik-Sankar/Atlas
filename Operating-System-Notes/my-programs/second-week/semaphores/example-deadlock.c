#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#include<semaphore.h>
#include<stdio.h>

void routine_forone(void *chr);
void routine_fortwo(void *chr2);

char buf[24];
sem_t mutex1,mutex2;
int count=0;

int main(int argc,char *argv[])
{
pthread_t thread1;
pthread_t thread2;

char *chr="the first one";
char *chr2="the second one";

sem_init(&mutex1,0,1);
sem_init(&mutex2,0,1);

pthread_create(&thread1,NULL,(void *) &routine_forone,(void *)chr);
pthread_create(&thread2,NULL,(void *) &routine_fortwo,(void *)chr2);


pthread_join(thread1,NULL);
pthread_join(thread2,NULL);

sem_destroy(&mutex1);
sem_destroy(&mutex2);
return 0;
}

void routine_forone(void *chr)
{
    char *ch;
    int i=0;
    ch=(char *)chr;
      sprintf(buf,"%s","Hi there");
        
       sem_wait(&mutex1);
        sleep(1);
       sem_wait(&mutex2);
 
       printf("%s\n",ch);
       printf("%s   Count = %d \n",buf,count++);
       
       sem_post(&mutex2);
       sem_post(&mutex1);
       fflush(stdout); 
     sleep(1);
   pthread_exit(0);
}


void routine_fortwo(void *chr2)
{
   char *ch2;
   int i=0; 
   ch2=(char *)chr2;
        
       sem_wait(&mutex1);
       sleep(1);  
      sem_wait(&mutex2);
      
      printf("%s\n",ch2);
      printf("%s  Count = %d \n",buf,count++); 
      
      sem_post(&mutex2);
      sem_post(&mutex1);
      fflush(stdout); 
      sleep(1); 
pthread_exit(0);
}

