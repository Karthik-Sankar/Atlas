#include<stdio.h>
#include<malloc.h>
struct node
{
 int info;
 struct node * next;
};

int main()
{
 struct node *head=malloc(sizeof(struct node));
 printf("Hello");   


}
