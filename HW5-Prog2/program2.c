/*
 * studentGrades.c
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int get_student_grade();

int main(int argc, char *argv[]) {

	setvbuf(stdout, NULL, _IONBF, 0);
	setvbuf(stderr, NULL, _IONBF, 0);

	if (argc != 2) {
		printf("No grades to input.\n");
		return (-1);
	}


	int *student_grades;
	//create pointer
	unsigned int num_items = strtoul(argv[1], NULL, 10);
	if (num_items>100){
		printf("Choose less than 100 students");
		return(-1);
	}
	student_grades = (int *) malloc(num_items * sizeof(int));

	if (NULL == student_grades) {
		printf("Could not allocate memory.\n");
		return -1;
	}

	for (unsigned int ctr = 0; ctr < num_items; ctr++) {
		printf("\nPlease input student %u's grade: ", ctr);
		student_grades[ctr] = get_student_grade();
		if (student_grades[ctr] < 0){
			printf("Grade must be between 0 to 100. ");
			fflush(stdin);
			ctr --;
		}else if (student_grades[ctr]>100){
			printf("Grade must be less than 100.");
			fflush(stdin);
			ctr --;
		}
	}

	for (unsigned int ctr = 0; ctr < num_items; ctr++) {
		printf("Student %u grade: %d.\n", ctr, student_grades[ctr]);
	}

	free(student_grades);

	return 0;

}
int get_student_grade() {
	int grade;
	int results;
	char getInfo[32];
	char *p;
	fgets(getInfo, sizeof(getInfo), stdin);
	p = strchr(getInfo, '\n');
	if (p){
		*p = '\0';
	}
	char *end;
	grade = strtol(getInfo, &end, 0);

	if (*end == '\0'){
		return grade;
	}else {
		return -1;
	}

//	if (result == EOF) {
//		printf("end of file\n");
//		return 0;
//	}
//
//	if (result == 0) {
//		while (fgetc(stdin) != '\n');
//	}

}

