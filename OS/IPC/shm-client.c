#include<stdio.h>
#include<sys/ipc.h>
#include<sys/shm.h>
#define shmsize 1024
#define pf printf
#define sf scanf
int main()
{
	key_t key;
	int shmid;
	char* c;
	key = 5678;
	if(shmid=shmget(key, shmsize, 0666|IPC_CREAT)<0)
	{
		perror("Error creating shared memory!");
	}
	c = (char*)shmat(shmid,NULL,0);
	pf("%s",c);
	shmdt(c);
	shmctl(shmid,IPC_RMID,NULL);
	return 0;
}