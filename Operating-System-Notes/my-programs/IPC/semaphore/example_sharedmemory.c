#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#include<unistd.h>
#include<string.h>
#include<errno.h>
#include<semaphore.h>
#include<sys/shm.h> 


int main()
{
  int i = 0;
  pid_t pid;
  int shmid;
  char *ptr, *shmptr;

  shmid = shmget(IPC_PRIVATE, sizeof(int),IPC_CREAT|0666);
 if(shmid<0)
 {
   printf("shmget error\n");
   exit(1);
 }
 shmptr = shmat(shmid,0,0);
 if(shmptr == (void *)-1)
 {
  printf("shmat error\n");
  exit(1);
 }
 *shmptr =(int)10;
 printf(" Shared memory contains %d \n", (int)(*shmptr)); 
 pid = fork(); 
 if(pid<0)
 {
   printf(" fork error\n");
   exit(1);
 }
 if(pid == 0)
 {
  while(i++<10) 
  { 
  	 printf("Child Process\n");
        *shmptr = (int)*shmptr-1; 
   printf(" In Child Process shmptr = %d\n",(int)*shmptr); 
  }
 } 
 else 
 {
  while(i++<10)
  { 
        printf("Parent Process\n");
        *shmptr = (int)*shmptr+1;
        printf(" In Parent process shmptr = %d\n",(int)*shmptr); 
  } 
 }
} 
