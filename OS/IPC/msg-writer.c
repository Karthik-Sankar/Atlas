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

	key_t key = ftok("msg_ipc_ftok",65);
	int msgqid = msgget(key, 0666|IPC_CREAT);

	pf("Enter something to be added in msg queue - ");
	sf("%s",message.msg);
	message.type = 1;

	msgsnd(msgqid,&message,sizeof(message),0);
}