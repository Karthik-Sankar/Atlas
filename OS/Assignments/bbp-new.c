#include<stdio.h>
#include<semaphore.h>
#include<pthread.h>
#include<unistd.h>
#define pf printf
#define sf scanf
#define buffer 10
sem_t mutex;
int items[buffer];
void* producer(void* arg)
{
	//int update = (int*)arg;
	pf("Producer Thread Starts!\n\n\n\n");
	for(int i=0;i<20;i++)
	{
		sem_wait(&mutex);
		items[i]=i+1;
		pf("---------------------------------------------------------------Producer Produced %d\n", i+1);
		pf("Buffer Size - %d\n", (i+1)%11);
		sleep(1);
	}
	pf("Producer Thread Completed!\n\n\n\n");
}
void* consumer(void* arg)
{
	//int update = (int*)arg;
	pf("Consumer Thread Starts!\n\n");
	for(int i=0;i<20;i++)
	{
		pf("---------------------------------------------------------------Consumer Consumed %d\n", i+1);
		sleep(1);
		sem_post(&mutex);
	}
	pf("Consumer Thread Completed!\n\n\n\n");
}
int main()
{
	sem_init(&mutex, 0, buffer);
	pthread_t t1,t2;
	int tu1=100,tu2=-500;
	pthread_create(&t1,NULL,producer,(void*)0);
	sleep(19);
	pthread_create(&t2,NULL,consumer,(void*)0);
	pthread_join(t1,NULL);
	pthread_join(t2,NULL);
	//pf("%d", balance);
	sem_destroy(&mutex);
	return 0;
}