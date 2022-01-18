/*
 * CommandExecutor.cpp
 */

#include <cstdlib>
#include <cstdio>
#include <cstring>
#define BUFSIZE 63
class CommandExecutor {
      public:
          virtual void execute(const char *command)
          {
              system(command);
          }
 };

 class Greeter {
     public:
         virtual void sayHello(const char *name)
         {
             printf("Hello, %s!\n", name);
         }
 };

 void greet(Greeter *greeter);
 void doNothing();

 int main(int argc, char **argv)
 {

	setvbuf(stdout, NULL, _IONBF, 0);
	setvbuf(stderr, NULL, _IONBF, 0);

     Greeter g;
     char buf[2];
     char *p;
     printf("You must be 18 years or older to use this program. Are you? ");

     doNothing();

     fgets(buf, sizeof(buf), stdin); /* OVERFLOW */
     p = strchr(buf, '\n');
     	if (p){
     		*p = '\0';
     	}
     fflush(stdin);
     if (strcmp(buf, "y") == 0) {
         greet(&g);
         return 0;
     } else {
         return 1;
     }
 }

 void greet(Greeter *greeter)
 {
     char name[BUFSIZE + 1];
     printf("What is your name? ");
     fgets(name, 20, stdin);
     name[strlen(name)-1] = '\0';
     greeter->sayHello(name);
 }

 /* This exists just so that the compiler/linker needs to include
  * CommandExecutor's code, since otherwise it would be unused. */
 void doNothing()
 {
     CommandExecutor e;
 }




