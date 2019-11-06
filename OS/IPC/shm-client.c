#include<stdio.h>
#include<sys/ipc.h>
#include<sys/shm.h>
#define pf printf
#define sf scanf
int main()
{
	key_t key = ftok("shmfile",65);
	int shmid = shmget(key, 27, 0666|IPC_CREAT);
	char *str = (char*)shmat(shmid,NULL,0);
	printf("%s\n",str);
	shmdt(str);
	shmctl(shmid,IPC_RMID,NULL);
}