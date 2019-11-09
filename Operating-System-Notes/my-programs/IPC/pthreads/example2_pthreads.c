/* POSIX threads and semaphores demonstration program */

/* Warning: this example does not check the status return of all Pthread or
 *   semaphore library functions, and therefore merits a lowered grade.
 * Also, this example doesn't actually do anything like what a real
 *   program should do, it's just intended to demonstrate various
 *   capabilities.
 *
 * See the additional notes at the end of the file.
 */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <errno.h>

#include <pthread.h>    /* required for pthreads */
#include <semaphore.h>  /* required for semaphores */

/* On Solaris, compile with   cc -v -mt semaphore_sample.c -lpthread -lrt
 *             or             gcc -Wall -Wextra semaphore_sample.c -lpthread -lrt
 * On Mac OS X, compile with  gcc -Wall -Wextra semaphore_sample.c
 * On Linux, compile with     gcc -Wall -Wextra semaphore_sample.c -lpthread
 *
 * Note that all the compiler warnings from GCC are about printf format
 * mismatches.  These are easy to fix, but we didn't feel like taking the
 * time, so the grade should be lowered some more.
 *
 * Run with  a.out
 *           a.out 1
 *           a.out 2
 *           a.out 3
 *           a.out 4
 *           a.out 5
 *           a.out 6
 *           a.out 7
 * The operand selects which method to use to end the threads and process.
 */


/* function prototype for Pthread creation (a start function) */
void * thread_func(void * arg);

/* example of data passed to and from a Pthread start function */
typedef struct thread_data {
  int in;	/* used as an input value */
  int out;	/* used as an output value */
} thread_data_t;

/* semaphore for shared static local variable in thread_func()
 *   see the explanation in thread_func() comments
 */
static sem_t count_sem;


/* shared global variable, semaphore not necessary because of the way it is used,
 *   but see the additional notes at the end of the file.
 */
int quit = 0;


int main(int argc, char * argv[])
{
  pthread_t tid[2];     /* thread ID, to be set by pthread_create() */
  thread_data_t a[2];
  thread_data_t *b[2] = { NULL, NULL };
        /* &a[i] passed to thread i as argument by pthread_create()
         * b[i] received from thread i as return value by pthread_join()
         */
  int ret, v; 

  a[0].in = 2; a[0].out = 0;
  a[1].in = 4; a[1].out = 0;

  /* initialize semaphore for use by thread_func()
   * arg 1, pointer to semaphore
   * arg 2,
   *   for concurrent threads in the same process, second argument should be 0
   *   for concurrent processes, second argument should be nonzero
   * arg 3, allow at most one thread to have access
   */
  // Mac OS X does not actually implement sem_init()
  if (sem_init(&count_sem, 0, 1) == -1)
    { printf("sem_init: failed: %s\n", strerror(errno)); }

  /* at this point, there is only one thread, and quit can be safely modified */
  if (argc > 1) quit = atoi(argv[1]);
  /* after this point, quit is not changed, so it does not need semaphore protection */

  pthread_create(&tid[0], NULL, thread_func, (void *)&a[0]);
  pthread_create(&tid[1], NULL, thread_func, (void *)&a[1]);

  printf("main: process id %d, thread id = %d\n", getpid(), pthread_self());
  printf("main: tid[0] = %d, tid[1] = %d\n", tid[0], tid[1]);
  printf("main: &a[0] = 0x%08lx, &a[1] = 0x%08lx\n", &a[0], &a[1]);
  printf("main:  b[0] = 0x%08lx,  b[1] = 0x%08lx\n",  b[0],  b[1]);
  printf("main: a[0].in  = %d, a[1].in  = %d\n", a[0].in,  a[1].in);
  printf("main: a[0].out = %d, a[1].out = %d\n", a[0].out, a[1].out);

  // Mac OS X does not actually implement sem_getvalue()
  if (sem_getvalue(&count_sem, &v) == -1)
    { printf("sem_getvalue: failed: %s\n", strerror(errno)); }
  else
    { printf("main: count_sem value = %d\n", v); }

  if (quit == 1) pthread_exit(NULL);
  if (quit == 2) exit(0);
  if (quit == 3) pthread_cancel(tid[1]);

  pthread_join(tid[0], (void **)&b[0]);

  if ((ret = pthread_join(tid[1], (void **)&b[1])) != 0)
    {
      printf("main: pthread_join(tid[1],...) failed on return, %s\n", strerror(ret));
      printf("main: b[1] will be reset from 0x%08x to 0x%08x\n", b[1], NULL);
      b[1] = NULL;
    }
  else if (b[1] != &a[1])
    {
      printf("main: pthread_join(tid[1],...) failed on address, %s\n", strerror(-(int)b[1]));
      printf("main: b[1] will be reset from 0x%08x to 0x%08x\n", b[1], NULL);
      b[1] = NULL;
    }

  printf("\n");
  printf("main: process id %d, thread id = %d\n", getpid(), pthread_self());
  printf("main: tid[0] = %d, tid[1] = %d\n", tid[0], tid[1]);
  printf("main: &a[0] = 0x%08lx, &a[1] = 0x%08lx\n", &a[0], &a[1]);
  printf("main:  b[0] = 0x%08lx,  b[1] = 0x%08lx\n",  b[0],  b[1]);
  printf("main: a[0].in   = %d, a[1].in   = %d\n", a[0].in,  a[1].in);
  printf("main: a[0].out  = %d, a[1].out  = %d\n", a[0].out, a[1].out);
  if (b[0] == NULL && b[1] == NULL) {
    printf("main: b[0] is NULL, b[1] is NULL\n");
  } else if (b[0] == NULL) {
    printf("main: b[0] is NULL, b[1]->in = %d, b[1]->out = %d\n", b[1]->in, b[1]->out);
  } else if (b[1] == NULL) {
    printf("main: b[0]->in = %d, b[0]->out = %d, b[1] is NULL\n", b[0]->in, b[0]->out);
  } else {
    printf("main: b[0]->in  = %d, b[1]->in  = %d\n", b[0]->in,  b[1]->in);
    printf("main: b[0]->out = %d, b[1]->out = %d\n", b[0]->out, b[1]->out);
  }

  if (quit == 3 && b[1] != NULL && b[1]->out < 0)
    printf("main: thread %d returned b[1]->out = %d\n", tid[1], b[1]->out);

  if (quit == 6) pthread_exit(NULL);
  if (quit == 7) exit(0);

  return 0;
}

/* standard thread function format for Pthreads */
void * thread_func(void * arg)
{
  /* shared local variable, one instance among all threads using this function,
   * so a semaphore is needed to enforce mutual exclusion.  Because the
   * semaphore must be initialized, only once, the initialization takes place
   * in the main thread, and the semaphore is declared globally.  You should
   * be able to explain why the semaphore cannot safely be declared inside
   * thread_func() and initialized from within the thread function itself.
   * This problem could be corrected with a C++ constructor for a semaphore
   * class.
   */
  static int count = 0;
  /* static sem_t count_sem; */

  /* local variable, one instance per thread using this function */
  int s = 0, t, v;

  /* pointer to input and output struct */
  thread_data_t *p = (thread_data_t *)arg;

  /* enforce mutual exclusion for access to count */
  sem_wait(&count_sem);         /* start of critical section */
    count++;
  sem_post(&count_sem);         /* end of critical section */
  s++;

  /* should this use of count be protected by the semaphore? */
  printf("thread: process id %d, thread id = %d, p->in = %d, count = %d, s = %d\n",
      getpid(), pthread_self(), p->in, count, s);

  // Mac OS X does not actually implement sem_getvalue()
  if (sem_getvalue(&count_sem, &v) == -1)
    { printf("sem_getvalue: failed: %s\n", strerror(errno)); }
  else
    { printf("thread: count_sem value = %d\n", v); }

  sleep(p->in);

  sem_wait(&count_sem);
    count++; t = count;
  sem_post(&count_sem);
  s++;

  /* because count was copied to t, no semaphore is needed here */
  printf("thread: process id %d, thread id = %d, arg = %d, count = %d, s = %d\n",
      getpid(), pthread_self(), p->in, t, s);

  if (quit == 4)
    {
      p->out = -(int)pthread_self();
      pthread_exit(arg);
    }

  if (quit == 5) exit(0);

  p->out = (int)pthread_self();
  return arg;
}


/* Additional notes about using semaphores.  Is it better to be smart or careful?
 *
 * The variable count, although local to thread_func(), exists in only one instance,
 * and therefore needs mutual exclusion because it could be modified by any thread
 * using thread_func().  You can see this just by reading the code for thread_func().
 *
 * The variable quit, defined globally and used by both main() and thread_func(),
 * either does or does not need mutual exclusion.  A careful analysis, which is not
 * difficult in this short program, shows that quit is not modified by thread_func()
 * and is therefore read-only after it is initialized by the startup code and
 * possibly reassigned by main().  You can safely omit enforcing mutual exclusion
 * for access to quit.  However, in a longer or more complex program, when you do
 * not have enough time or enough support from your programming tools, it is better
 * to be conservative and write the mutual exclusion code for quit.  This requires
 * some care, though, since a thread calling pthread_exit() in a critical section
 * would not call the sem_post() that ends the critical section.  Thus, these
 * lines of code would need to be added or substituted at appropriate places:
 *
 *    sem_t quit_sem;
 *
 *    sem_init(&quit_sem, 0, 1);
 *
 *    int quit_local_copy;
 *
 *    sem_wait(&quit_sem);
 *      quit_local_copy = quit;
 *    sem_post(&quit_sem);
 *
 *    if (quit_local_copy == 4) pthread_exit( ... );
 *
 * Essentially, you have a choice between being thoughtful and careful, or being
 * thorough and careful.  You do not have the option of being careless.  Since it
 * is easier to be thorough than thoughtful, you should try modifying this code
 * as described here, and verify that it still works as before.
 *
 * We certainly do not want to suggest that being thoughtful is never better than
 * being thorough.  Both are good personal attributes, and both are required for
 * good programmers.  Being thorough here is the more conservative approach, and
 * is better for most people first learning a new concept.  Once you have mastered
 * the ideas, then you can go back and be thoughtful - but make sure you document
 * why you avoided doing something that a thorough and less thoughtful quality-
 * assurance tester (or grader!) would suspect is necessary.
 *
 * Anyway, how do you know when writing the code for thread_func() that there will
 * not be, in the future, some third kind of thread that also changes quit?  Good
 * modular design suggests that writing safe code now is better than debugging
 * unsafe code later.
 *
 * It is better to be both smart and careful.
 */

/*
 * Now that you have read about being careful, should you go back and extensively
 * edit the code so that every pthread_ and sem_ function call has its return
 * value inspected?  Here's something easier; though you may disagree with the
 * brutality of killing the program on detecting an error, this is the best
 * approach for beginners.  Just go back and change sem_wait() to Sem_wait(),
 * etc., and leave the rest of the code alone.  The flag sem_debug gives you
 * control over additional printing that may be useful in debugging the program.
 * Later, you could change sem_debug from a compile-time choice to a run-time
 * choice by using a command-line argument.  OK, it's not actually as easy as
 * changing sem_ to Sem_ everywhere, because these functions have an additional
 * argument.  The idea is that every call to a Sem_ function has a unique string
 * provided as the extra argument, so that, for example, two different messages
 * about waiting on a semaphore can be distinquished according to which call to
 * Sem_wait() was used.  And, just to be thorough, the thread ID is also
 * printed.  You will need to move these functions, or provide their prototypes,
 * ahead of their first use.  Two separate files Sem.h and Sem.c might be the
 * easiest approach.
 */

/*----------------------------------------------------------------------------*/

/* to enable more output, compile with cc -DSEM_DEBUG ... */

#if defined(SEM_DEBUG)
int sem_debug = 1;
#else
int sem_debug = 0;
#endif

#include <string.h>
#include <errno.h>

void Sem_init(sem_t *sem, int pshared, unsigned int value, char *msg)
{
  int ret;
  if (sem_debug) printf("sem_init: thread %d, %s\n", pthread_self(), msg);
  ret = sem_init(sem, pshared, value);
  if (ret == -1)
    {
      printf("sem_init: thread %d, %s: failed: %s\n",
            pthread_self(), msg, strerror(errno));
      exit(1);
    }
}

void Sem_wait(sem_t *sem, char *msg)
{
  int ret;
  if (sem_debug) printf("sem_wait: thread %d, %s\n", pthread_self(), msg);
  ret = sem_wait(sem);
  if (ret == -1)
    {
      printf("sem_wait: thread %d, %s: failed: %s\n",
            pthread_self(), msg, strerror(errno));
      exit(1);
    }
}

void Sem_post(sem_t *sem, char *msg)
{
  int ret;
  if (sem_debug) printf("sem_post: thread %d, %s\n", pthread_self(), msg);
  ret = sem_post(sem);
  if (ret == -1)
    {
      printf("sem_post: thread %d, %s: failed: %s\n",
            pthread_self(), msg, strerror(errno));
      exit(1);
    }
}

void Sem_getvalue(sem_t *sem, int *sval, char *msg)
{
  int ret;
  if (sem_debug) printf("sem_getvalue: thread %d, %s\n", pthread_self(), msg);
  ret = sem_getvalue(sem, sval);
  if (ret == -1)
    {
      printf("sem_getvalue: thread %d, %s: failed: %s\n",
            pthread_self(), msg, strerror(errno));
      exit(1);
    }
}

/*----------------------------------------------------------------------------*/

