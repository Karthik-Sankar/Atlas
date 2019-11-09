#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>
#include<semaphore.h>
//#include<ipc.h>
//#include<msg.h>
int main()
{
	//key_t key = ftok("msgq",65);
	//int mid = msgget(key, 0666|IPC_CREATE);
	sem_t mutex;
	pid_t cid1,cid2;
	sem_init(&mutex,1,1);
	if((cid1 = fork())>0 && (cid2 = fork())>0)
	{
		fflush(stdout);
		printf("Parent Process Executing! - Mutex %d\n", &mutex);
		fflush(stdout);
	}
	else if(cid1==0)
	{
		fflush(stdout);
		printf("Child 1 Process Executing! - Mutex %d\n", &mutex);
		fflush(stdout);
		sem_wait(&mutex);
		for(int i =0; i< 10; i++)
		{
			fflush(stdout);
			printf("Critical Section of child 1 - Mutex %d\n", &mutex);
			sleep(1);
			fflush(stdout);
		}
		sem_post(&mutex);
	}
	else if(cid2==0)
	{
		fflush(stdout);
		printf("Child 2 Process Executing!- Mutex %d\n", &mutex);
		fflush(stdout);
		sem_wait(&mutex);
		for(int i =0; i< 10; i++)
		{
			fflush(stdout);
			printf("Critical Section of child 2- Mutex %d\n", &mutex);
			sleep(1);
			fflush(stdout);
		}
		sem_post(&mutex);
	}


}