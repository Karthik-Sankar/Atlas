#include<stdio.h>
#include<unistd.h>
#define pf printf
int main(){
	pid_t cid1, cid2;
	if((cid1 = fork())>0)
	{
	pf("PARENT CREATED CHILD PROCESS %d\n", cid1);
	if((cid2 = fork())>0)
	{
	pf("PARENT CREATED CHILD PROCESS %d\n", cid2);
	if(waitpid(cid2)){
	pf("PARENT IS WAITING FOR CHILD PROCESS CID2\n");
	}
	if(waitpid(cid1)){
	pf("PARENT IS WAITING FOR CHILD PROCESS CID1\n");
	}
	}
	else if(cid2==0)
	{
	pf("IN CHILD PROCESS 2\n");
	}
	}
	else if(cid1==0){
	pf("IN CHILD PROCESS 1\n");
	}
}