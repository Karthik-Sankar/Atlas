#include<stdio.h>
#include<sys/ipc.h>
#include<sys/shm.h>
#include<errno.h>
#define shmsize 27
#define pf printf
#define sf scanf
int main()
{
	key_t key;
	int shmid;
	char *str;
	key = 4052;
	//ftok("shmfile2",65);
	pf("Key %d\n",key);
	if(shmid=shmget(key, shmsize, 0666|IPC_CREAT) < 0)
	{
		perror("Shared Memory Creation Failed!\n");
		exit(1);
	}
	pf("SHMID %d\n",shmid);
	str = (char*)shmat(shmid,(void*)0,0);
	pf("data in shm : %s\n",str);
	pf("Tell something to other process!\n");
	gets(str);
	pf("%s\n",str);
	shmdt(str);
	return 0;
}