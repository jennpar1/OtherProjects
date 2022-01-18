#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void bad_function(char *input) {
	char dest_buffer[32];
	char input_len = strnlen(input,32);

	if (input_len < 32) {
		strncpy(dest_buffer, input, 32);
		printf("The first command line argument is %s.\n", dest_buffer);
	} else {
		printf("Error --- input is too long for buffer.\n");
	}

}

int main(int argc, char *argv[]) {

	setvbuf(stdout, NULL, _IONBF, 0);
	setvbuf(stderr, NULL, _IONBF, 0);

	if (argc > 1) {
		bad_function(argv[1]);
	} else {
		printf("No command line argument was given.\n");
	}

	return 0;
}

