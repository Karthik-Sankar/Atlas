#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/shm.h>
#include<sys/ipc.h>
#include<unistd.h>
#define pf printf
#define sf scanf
int main()
{
	key_t key = ftok("test",65);
	int shmid = shmget(key,27,0666|IPC_CREAT);
	if(shmid<0)
	{
		perror("SHMID: ");
	}
	char *str = (char*)shmat(shmid,(void*)0,0);
	printf("%d\n",shmid);
	pf("Data in SHM : %d\n",str);
	pf("Data in SHM : %s\n",str);
	shmdt(str);
	shmctl(shmid,IPC_RMID,NULL);
}