#include<stdio.h>
#include<semaphore.h>
#include<pthread.h>
#include<unistd.h>
#define pf printf
#define sf scanf
sem_t mutex;
int balance=1000;
void* thread(void* arg)
{
	sem_wait(&mutex);
	//int update = (int*)arg;
	pf("Entering Critical Section!\n");
	//Critical Section
	sleep(4);
	//balance=balance+update;
	pf("Exiting Critical Section!\n");
	sem_post(&mutex);
}
int main()
{
	sem_init(&mutex, 0, 1);
	pthread_t t1,t2;
	int tu1=100,tu2=-500;
	pthread_create(&t1,NULL,thread,(void*)0);
	sleep(2);
	pthread_create(&t2,NULL,thread,(void*)0);
	pthread_join(t1,NULL);
	pthread_join(t2,NULL);
	//pf("%d", balance);
	sem_destroy(&mutex);
	return 0;
}