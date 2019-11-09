#include<stdio.h>
#include<semaphore.h>
#include<pthread.h>
#include<unistd.h>
#define pf printf
#define sf scanf
#define buffer 10
int val = 0;
sem_t mutex;


struct items{
	int items;
	struct items* next;	
}head,tail,curr;

head, tail, curr=NULL;

void* producer(void* arg)
{
	//int update = (int*)arg;
	pf("Producer Thread Starts!\n");
	sem_wait(&mutex);
	if(mutex==0)
		pf("Producer is waiting for consumer to consume!\n");
	while(mutex)
	{
	if(head == NULL)
	{
		head = (items*)malloc(sizeof(struct* items));
		head->items = ++val;
		head->next = NULL;
		curr,tail=head;
	}
	else
	{
		struct* items temp = (items*)malloc(sizeof(struct* items));
		temp->data = ++val;
		temp->next=NULL;
		tail=temp;
		curr->next = tail;
		curr=tail;
	}
	}
	pf("Producer Thread Completed!\n");
}
void* consumer(void* arg)
{
	//int update = (int*)arg;
	pf("Consumer Thread Starts!\n");
	for(int i=0;i<20;i++)
	{
		pf("Consumer Consumed %d\n", i+1);
		sleep(1);
		sem_post(&mutex);
	}
	pf("Consumer Thread Completed!\n");
}
int main()
{
	sem_init(&mutex, 0, buffer);
	pthread_t t1,t2;
	int tu1=100,tu2=-500;
	pthread_create(&t1,NULL,producer,(void*)0);
	sleep(25);
	pthread_create(&t2,NULL,consumer,(void*)0);
	pthread_join(t1,NULL);
	pthread_join(t2,NULL);
	//pf("%d", balance);
	sem_destroy(&mutex);
	return 0;
}