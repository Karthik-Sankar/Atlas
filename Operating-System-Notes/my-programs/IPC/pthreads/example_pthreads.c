#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<string.h>
#include<errno.h>

#include<pthread.h>
#include<semaphore.h>

void *thread_func(void *arg);

typedef struct thread_data
{
 int in;
 int out;
} thread_data_t;

static sem_t count_sem;

int quit = 0;

int main(int argc, char *argv[])
{
 pthread_t tid[2];
 thread_data_t a[2];
 thread_data_t *b[2] = {NULL, NULL};
 
 int ret, v;
 
 a[0].in = 2;
 a[0].out = 0;
 a[1].in = 4;
 a[1].out = 0;

 if(sem_init(&count_sem,0,1)==-1)
 {
   printf("sem_init: Failed: %s\n", strerror(errno));
 }
 if(argc > 1)
             atoi(argv[1]);
 pthread_create(&tid[0],NULL,thread_func,(void *)&a[0]);
 pthread_create(&tid[1],NULL,thread_func, (void *)&a[1]);

 printf("Main : Process id %d, thread id = %d\n",getpid(),pthread_self());
 printf("Main : tid[0] = %d, tid[1] = %d\n", tid[0],tid[1]);
 printf("Main : &a[0] = 0x%08lx, &a[1] = 0x%08lx\n", &a[0], &a[1]);
 printf("Main : b[0] = 0x%08lx, b[1] = 0x%08lx]n", b[0],b[1]);
 printf("Main : a[0].in = %d, a[1].in = %d\n", a[0].in, a[1].in);
 printf("Main : a[0].out = %d, a[1].out = %d\",a[0].out,a[1].out);

 if(sem_getvalue(&count_sem, &v) == -1)
 {
   printf("sem_getvalue: failed: %s\n", strerror(errno));
 }
 else
 {
   printf("Main: count_sem value = %d\n",v);
 }

 if(quit == 1)
             pthread_exit(NULL);
 if(quit == 2)
             exit(0);
 if(quit == 3)
             pthread_cancel(tid[1]);
  )



