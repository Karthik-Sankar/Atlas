#include<stdio.h>
#include<sys/ipc.h>
#include<sys/msg.h>
#define pf printf
#define sf scanf
int main()
{
	struct msg_ipc{
		long int type;
		char msg[100];
	}message;

	key_t key;
	key = ftok("msg_ipc_ftok",65);

	int msgqid = msgget(key, 0666|IPC_CREAT);

	msgrcv(msgqid,&message,sizeof(message),1,0);

	pf("Received %s", message.msg);

	msgctl(msgqid,IPC_RMID,0);
}