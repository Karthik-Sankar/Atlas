#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>
#define pf printf
#define sf scanf
int main()
{
	pid_t cid;
	pf("Program's process id %d\n", getpid());
	sleep(5);
	if((cid=fork())>0)
	{
		pf("Parent's process id %d\n", getpid());
		if(waitpid(cid)>0)
		{
			pf("Waiting for child process cid=%d\n",cid);
		}
	}
	else if(cid == 0)
	{
		pf("Child's process id %d\n", getpid());
		sleep(2);
		pf("Parent's process id %d\n", getppid());
	}
	//sleep(5);
	//pf("Program's process id %d\n", getpid());
	return 0;
}