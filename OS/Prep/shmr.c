#include<stdio.h>
#include<sys/shm.h>
#include<sys/types.h>
#include<sys/ipc.h>
#include<unistd.h>
#include<stdlib.h>
#define pf printf
#define sf scanf
int main()
{
	key_t key=ftok("test",65);
	int shmid=shmget(key,27,0666|IPC_CREAT);
	if(shmid<0)
	{
		perror("SHMID: ");
	}
	printf("%d\n",shmid);
	char *str=(char*)shmat(shmid,(void*)0,0);
	gets(str);
	pf("Data in SHM : %d\n",&str);
	pf("In SHM : %s",str);
	shmdt(str);
}