#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <mpi.h>

typedef struct{
		int age;
		char workclass[20];
		int fnlwgt;
		char education[20];
		int edNum;
		char maritalStat[20];
		char occupation[20];
		char relationship[20];
		char race[20];
		char sex[10];
		int capGain;
		int capLoss;
		int hoursPerWeek;
		char nativeCountry[20];
		char lessOrGreat[10];

}Data;

double distance(int ageTest, int ageData, char workclassTest[],char workclassData[], int fnlwgtTest, int fnlwgtData, char educationTest[],
		char educationData[], int edNumTest, int edNumData, char maritalStatTest[], char maritalStatData[], char occupationTest[], char occupationData[],
		char relationshipTest[], char relationshipData[], char raceTest[], char raceData[], char sexTest[], char sexData[], int capGainTest,
		int capGainData, int capLossTest, int capLossData, int hoursPerWeekTest, int hoursPerWeekData, char nativeCountryTest[], char nativeCountryData[],
		int m){
	printf(" distance:\n");
	double n = (double)m;
	double distance = 0;
	double age = ageData - ageTest;
	double workclass = strcmp(workclassData, workclassTest);
	double fnlwgt = fnlwgtData - fnlwgtTest;
	double education = strcmp(educationData, educationTest);
	double edNum = edNumData-edNumTest;
	double maritalStat = strcmp(maritalStatData, maritalStatTest);
	double occupation = strcmp(occupationData, occupationTest);
	double relationship = strcmp(relationshipData, relationshipTest);
	double race = strcmp(raceData, raceTest);
	double sex = strcmp(sexData, sexTest);
	double capGain = capGainData - capGainTest;
	double capLoss = capLossData - capLossTest;
	double hoursPerWeek = hoursPerWeekData - hoursPerWeekTest;
	double nativeCountry = strcmp(nativeCountryData, nativeCountryTest);
	distance += abs(pow(age, n));
	distance += abs(pow(workclass,n));
	distance += abs(pow(fnlwgt, n));
	distance += abs(pow(education, n));
	distance += abs(pow(edNum, n));
	distance += abs(pow(maritalStat, n));
	distance += abs(pow(occupation, n));
	distance += abs(pow(relationship, n));
	distance += abs(pow(race, n));
	distance += abs(pow(sex, n));
	distance += abs(pow(capGain, n));
	distance += abs(pow(capLoss, n));
	distance += abs(pow(hoursPerWeek, n));
	distance += abs(pow(nativeCountry, n));
	distance = pow(distance, 1.0/n);
	printf("%e\n", distance);
	return distance;

}


int comparator(const void *p, const void *q)
{
    // Get the values at given addresses
    int l = *(const int *)p;
    int r = *(const int *)q;

    // both odd, put the greater of two first.
    if ((l&1) && (r&1))
        return (r-l);

    // both even, put the smaller of two first
    if ( !(l&1) && !(r&1) )
        return (l-r);

    // l is even, put r first
    if (!(l&1))
        return 1;

    // l is odd, put l first
    return -1;
}

bool classification(Data result[], char above50k[]){
	int above = 0, below = 0;
	for (int i = 0; i <sizeof(result); i++){
		if (result[i].lessOrGreat == above50k){
			above++;
		}
		else{
			below++;
		}
	}
	return above > below;
}


int main(){

	// Initialize the MPI environment
	    MPI_Init(NULL, NULL);

	    // Get the number of processes
	    int world_size;
	    MPI_Comm_size(MPI_COMM_WORLD, &world_size);

	    // Get the rank of the process
	    int world_rank;
	    MPI_Comm_rank(MPI_COMM_WORLD, &world_rank);

	    // Get the name of the processor
	    char processor_name[MPI_MAX_PROCESSOR_NAME];
	    int name_len;



	Data test[16282];
	Data data[32562];
	FILE *f, *g;
	char line[200];

	char *item1;
	char *item2;
	int count1=0;
	int count2=0;


	f = fopen("test.txt", "r");

	while (fgets(line, 200, f)){
//		printf("%s",line);

		//int age
		item1 = strtok(line, ", ");
		test[count1].age = atoi(item1);

		//char workclass
		item1 = strtok(NULL, ", ");
		strcpy(test[count1].workclass, item1);

		//int fnlwgt
		item1 = strtok(NULL, ", ");
		test[count1].fnlwgt = atoi(item1);

		//char education
		item1 = strtok(NULL, ", ");
		strcpy(test[count1].education, item1);

		//int edNum
		item1 = strtok(NULL, ", ");
		test[count1].edNum = atoi(item1);

		//char martialStat
		item1 = strtok(NULL, ", ");
		strcpy(test[count1].maritalStat, item1);

		//char occupation
		item1 = strtok(NULL, ", ");
		strcpy(test[count1].occupation, item1);

		//char relationship
		item1 = strtok(NULL, ", ");
		strcpy(test[count1].relationship, item1);

		//char race
		item1 = strtok(NULL, ", ");
		strcpy(test[count1].race, item1);

		//char sex
		item1 = strtok(NULL, ", ");
		strcpy(test[count1].sex, item1);

		//int capGain
		item1 = strtok(NULL, ", ");
		test[count1].capGain = atoi(item1);

		//int capLoss
		item1 = strtok(NULL, ", ");
		test[count1].capLoss = atoi(item1);

		//int hoursPerWeek
		item1 = strtok(NULL, ", ");
		test[count1].hoursPerWeek = atoi(item1);

		//char nativeCountry
		item1 = strtok(NULL, ", ");
		strcpy(test[count1].nativeCountry, item1);

		//char lessOrGreat
		item1 = strtok(NULL, ", ");
		strcpy(test[count1].lessOrGreat, item1);

//		printf("%d\n", test[count].age);
		count1++;

	}

	fclose(f);

	g = fopen("data.txt", "r");

	while (fgets(line, 200, g)){
//		printf("%s",line);

		//int age
		item2 = strtok(line, ", ");
		data[count2].age = atoi(item2);

		//char workclass
		item2 = strtok(NULL, ", ");
		strcpy(data[count2].workclass, item2);

		//int fnlwgt
		item2 = strtok(NULL, ", ");
		data[count2].fnlwgt = atoi(item2);

		//char education
		item2 = strtok(NULL, ", ");
		strcpy(data[count2].education, item2);

		//int edNum
		item2 = strtok(NULL, ", ");
		data[count2].edNum = atoi(item2);

		//char maritalStat
		item2 = strtok(NULL, ", ");
		strcpy(data[count2].maritalStat, item2);

		//char occupation
		item2 = strtok(NULL, ", ");
		strcpy(data[count2].occupation, item2);

		//char relationship
		item2 = strtok(NULL, ", ");
		strcpy(data[count2].relationship, item2);

		//char race
		item2 = strtok(NULL, ", ");
		strcpy(data[count2].race, item2);

		//char sex
		item2 = strtok(NULL, ", ");
		strcpy(data[count2].sex, item2);

		//int capGain
		item2 = strtok(NULL, ", ");
		data[count2].capGain = atoi(item2);

		//int capLoss
		item2 = strtok(NULL, ", ");
		data[count2].capLoss = atoi(item2);

		//int hoursPerWeek
		item2 = strtok(NULL, ", ");
		data[count2].hoursPerWeek = atoi(item2);

		//char nativeCountry
		item2 = strtok(NULL, ", ");
		strcpy(data[count2].nativeCountry, item2);

		//char lessOrGreat
		item2 = strtok(NULL, ", ");
		strcpy(data[count2].lessOrGreat, item2);

//		printf("%d\n", test[count].age);
		count2++;

	}

	fclose(g);

	for (int i = 0; i < sizeof(test); i ++){
		printf("%d%s", i, ".\n");
		printf("%d\n", test[i].age);
		printf("%s\n", test[i].workclass);
		printf("%d\n", test[i].fnlwgt);
		printf("%s\n", test[i].education);
		printf("%d\n", test[i].edNum);
		printf("%s\n", test[i].maritalStat);
		printf("%s\n", test[i].occupation);
		printf("%s\n", test[i].relationship);
		printf("%s\n", test[i].race);
		printf("%s\n", test[i].sex);
		printf("%d\n", test[i].capGain);
		printf("%d\n", test[i].capLoss);
		printf("%d\n", test[i].hoursPerWeek);
		printf("%s\n", test[i].nativeCountry);
	}

	MPI_Get_processor_name(processor_name, &name_len);

	Data results[11];
	int n = 14;
	char above50k[20];
	for(int i = 0; i < sizeof(test); i++){
		for (int j = 0; j < sizeof(data); j++){
			int ageTest = test[i].age;
			int ageData = data[j].age;
			char workclassTest[] = test[i].workclass;
			char workclassData[] = data[j].workclass;
			int fnlwgtTest = test[i].fnlwgt;
			int fnlwgtData = data[j].fnlwgt;
			char educationTest[] = test[i].education;
			char educationData[] = data[j].education;
			int edNumTest = test[i].education;
			int edNumData = data[j].education;
			above50k[0] = data[j].lessOrGreat;

			double dist = distance(test[i].age, data[j].age, test[i].workclass, data[j].workclass, test[i].fnlwgt, data[j].fnlwgt, test[i].education, data[j].education, test[i].edNum, data[j].edNum, test[i].maritalStat, data[j].maritalStat, test[i].occupation, data[j].occupation, test[i].relationship, data[j].relationship, test[i].race, data[j].race, test[i].sex, data[j].sex, test[i].capGain, data[j].capGain, test[i].capLoss, data[j].capLoss, test[i].hoursPerWeek, data[j].hoursPerWeek, test[i].nativeCountry, data[j].nativeCountry, n);
			printf("%d\n", dist);
			qsort(dist, n, sizeof(results), comparator);
		}
		if (classification(test[i], above50k)){
			printf("%s%s", test[i], " above 50k");
		}else{
			printf("%s%s", test[i], " below 50k");
		}
	}
	// Finalize the MPI environment.
	MPI_Finalize();
	for (int i = 0; i < sizeof(results); i++){
		printf("%d\n", results[i]);
	}

}





