#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#include<unistd.h>
#include<string.h>
#include<errno.h>
#include<semaphore.h>
#include<sys/shm.h> 
#include<fcntl.h>
#include<sys/types.h>
int main()
{
  int i = 0,ans=0;
  pid_t pid;
  int shmid;
  char *ptr, *shmptr;
  sem_t *sem;
  key_t shmkey;
  shmkey = ftok("/dev/null",5);
  shmid = shmget(shmkey, sizeof(int),IPC_CREAT|0666);
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

 ans = sem_init(sem, 1, 1); 

 if( ans==-1)
  {
     printf("sem init failed\n");
     exit(1);
  }                       //"pSem", O_CREAT|O_EXCL, 0644, 1 );

 printf("Semaphore created\n");
 fflush(stdout);
 pid = fork(); 
 if(pid<0)
 {
//   sem_unlink("pSem");
   sem_close(sem);
   printf(" fork error\n");
   exit(1);
 }
 if(pid == 0)
 {
  while(i++<10) 
  { 
 	 printf("Child Process 1 calling sem_wait()\n");
         fflush(stdout);
      sem_wait(sem); 
 	 printf("Child Process 1\n");
         fflush(stdout);
        *shmptr = (int)(*shmptr)--;  
   printf(" In Child Process1 shmptr = %d\n",(int)*shmptr); 
         fflush(stdout);
      sem_post(sem); 
  }

 wait(pid);
 shmdt(shmptr);
 shmctl(shmid, IPC_RMID,0);
// sem_unlink("pSem");
 sem_close(sem);
 return 0; 
 } 
 else 
 {
  while(i++<10)
  {
 	 printf("Parent Process calling sem_wait()\n");
         fflush(stdout);
       sem_wait(sem); 
        printf("Parent Process\n");
        fflush(stdout);
        *shmptr = (int)(*shmptr)++;
        printf(" In Parent process shmptr = %d\n",(int)*shmptr); 
        fflush(stdout);
        sem_post(sem); 
 } 
 }
} 
