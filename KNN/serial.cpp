// C++ program to find groups of unknown
// Points using K nearest neighbour algorithm.
#include <cstdlib>
#include <cstdio>
#include <bits/stdc++.h>
#include <fstream>
#include <iostream>
#include <ostream>
#include <string>
#include <cmath>
//#include <algorithm>

using namespace std;
struct Adult
{
	string age;				//int
	string workclass;
	string fnlwgt;			//int
	string education;
	string educationNum;	//int
	string maritalStatus;
	string occupation;
	string relationship;
	string race;
	string sex;
	string capitalGain;		//int
	string capitalLoss;		//int
	string hoursPerWeek;	//int
	string nativeCountry;
	string earning;
};

friend ostream &operator<<(ostream &os, const Adult &input){
	os << "age: " << input.age << " workclass: " << input.workclass << " fnlwgt: " << input.fnlwgt << " education: " << input.education << " educationNum: " << input.educationNum << " maritalStatus: " << input.maritalStatus << " occupation: " << input.occupation << " relationship: " << input.relationship << " race: " << input.race << " sex: " << input.sex << " captialGain: " << input.capitalGain << " capitalLoss: " << input.capitalLoss << " hoursPerWeek: " << input.hoursPerWeek << " nativeCountry: " << input.nativeCountry << " earning: " << input.earning;
	return os;
}

double distance(int ageInput, int ageData, string workclassInput, string workclassData, int fnlwgtInput, int fnlwgtData, string educationInput, string educationData, int educationNumInput, int educationNumData, string maritalStatusInput, string maritalStatusData, string occupationInput, string occupationData, string relationshipInput, string relationshipData, string raceInput, string raceData, string sexInput, string sexData, int capitalGainInput, int capitalGainData, int capitalLossInput, int capitalLossData, int hoursPerWeekInput, int hoursPerWeekData, string nativeCountryInput, string nativeCountryData, int n)
{
	printf(" distance\n");
	double distance;
	double age = ageData - ageInput;
	double workclass = workclassData.compare(workclassInput);
	double fnlwgt = fnlwgtData - fnlwgtInput;
	double education = educationData.compare(educationInput);
	double educationNum = educationNumData - educationNumInput;
	double maritalStatus = maritalStatusData.compare(maritalStatusInput);
	double occupation = occupationData.compare(occupationInput);
	double relationship = relationshipData.compare(relationshipInput);
	double race = raceData.compare(raceInput);
	double sex = sexData.compare(sexInput);
	double capitalGain = capitalGainData - capitalGainInput;
	double capitalLoss = capitalLossData - capitalLossInput;
	double hoursPerWeek = hoursPerWeekData - hoursPerWeekInput;
	double nativeCountry = nativeCountryData.compare(nativeCountryInput);
	distance += abs(pow(age, n));
	distance += abs(pow(workclass, n));
	distance += abs(pow(fnlwgt, n));
	distance += abs(pow(education, n));
	distance += abs(pow(educationNum, n));
	distance += abs(pow(maritalStatus, n));
	distance += abs(pow(occupation, n));
	distance += abs(pow(relationship, n));
	distance += abs(pow(race, n));
	distance += abs(pow(sex, n));
	distance += abs(pow(capitalGain, n));
	distance += abs(pow(capitalLoss, n));
	distance += abs(pow(hoursPerWeek, n));
	distance += abs(pow(nativeCountry, n));
	distance = pow(distance, 1.0/n);
	cout << distance << "\n";
	return distance;
}

bool comparison(Adult a[], Adult b[])
{
	return a->distance < b->distance;
}

bool classification(Adult result[], string above50k)
{
	int above = 0;
	int below = 0;
	for(int i = 0; i<sizeof(result); i++){
		if(result[i].earning == above50k){
			above++;
		}
		else{
			below++;
		}
	}
	return above > below;
}

int main()
{
   	ifstream myFile;
   	myFile.open("adult.test");
	string line;
	getline(myFile, line);
	Adult input[16282];
    	while(!myFile.eof())
    	{
		int i = 0;
		getline(myFile, input[i].age, ',');
		getline(myFile, input[i].workclass, ',');
		getline(myFile, input[i].fnlwgt, ',');
		getline(myFile, input[i].education, ',');
		getline(myFile, input[i].educationNum, ',');
		getline(myFile, input[i].maritalStatus, ',');
		getline(myFile, input[i].occupation, ',');
		getline(myFile, input[i].relationship, ',');
		getline(myFile, input[i].race, ',');
		getline(myFile, input[i].sex, ',');
		getline(myFile, input[i].capitalGain, ',');
		getline(myFile, input[i].capitalLoss, ',');
		getline(myFile, input[i].hoursPerWeek, ',');
		getline(myFile, input[i].nativeCountry, ',');
		getline(myFile, input[i].earning, '\n');
		//cout << input[i].age << "\n";
		i++;
	}
	myFile.close();

	ifstream dataFile;
	dataFile.open("adult.data");
	string newLine;
	getline(dataFile, newLine);
	Adult data[32562];
	while(!dataFile.eof())
	{
		int i = 0;
		getline(dataFile, data[i].age, ',');
		getline(dataFile, data[i].workclass, ',');
		getline(dataFile, data[i].fnlwgt, ',');
		getline(dataFile, data[i].education, ',');
		getline(dataFile, data[i].educationNum, ',');
		getline(dataFile, data[i].maritalStatus, ',');
		getline(dataFile, data[i].occupation, ',');
		getline(dataFile, data[i].relationship, ',');
		getline(dataFile, data[i].race, ',');
		getline(dataFile, data[i].sex, ',');
		getline(dataFile, data[i].capitalGain, ',');
		getline(dataFile, data[i].capitalLoss, ',');
		getline(dataFile, data[i].hoursPerWeek, ',');
		getline(dataFile, data[i].nativeCountry, ',');
		getline(dataFile, data[i].earning, '\n');
		//cout << data[i].age << "\n";
		i++;
	}
	dataFile.close();
	Adult results[16282];
	int n = 14;
	for(size_t i = 0; i < sizeof(input); i++){
		for(size_t j = 0; j < sizeof(data); j++){
			int ageInput = stoi(input[i].age, nullptr, 10);
			int ageData = stoi(data[j].age, nullptr, 10);
			//int workclassInput = stoi(input[i].workclass, nullptr, 10);
			//int workclassData = stoi(data[j].workclass, nullptr, 10);
			string workclassInput = input[i].workclass;
			string workclassData = data[j].workclass;
			int fnlwgtInput = stoi(input[i].fnlwgt, nullptr, 10);
			int fnlwgtData = stoi(data[j].fnlwgt, nullptr, 10);
			//int educationInput = stoi(input[i].education, nullptr, 10);
			//int educationData = stoi(data[j].education, nullptr, 10);
			string educationInput = input[i].education;
			string educationData = data[j].education;
			int educationNumInput = stoi(input[i].educationNum, nullptr, 10);
			int educationNumData = stoi(data[j].educationNum, nullptr, 10);
			//int maritalStatusInput = stoi(input[i].maritalStatus, nullptr, 10);
			//int maritalStatusData = stoi(data[j].maritalStatus, nullptr, 10);
			string maritalStatusInput = input[i].maritalStatus;
			string maritalStatusData = data[j].maritalStatus;
			//int occupationInput = stoi(input[i].occupation, nullptr, 10);
			//int occupationData = stoi(data[j].occupation, nullptr, 10);
			string occupationInput = input[i].occupation;
			string occupationData = data[j].occupation;
			//int relationshipInput = stoi(input[i].relationship, nullptr, 10);
			//int relationshipData = stoi(data[j].relationship, nullptr, 10);
			string relationshipInput = input[i].relationship;
			string relationshipData = data[j].relationship;
			//int raceInput = stoi(input[i].race, nullptr, 10);
			//int raceData = stoi(data[j].race, nullptr, 10);
			string raceInput = input[i].race;
			string raceData = data[j].race;
			//int sexInput = stoi(input[i].sex, nullptr, 10);
			//int sexData = stoi(data[j].sex, nullptr, 10);
			string sexInput = input[i].sex;
			string sexData = data[j].sex;
			int capitalGainInput = stoi(input[i].capitalGain, nullptr, 10);
			int capitalGainData = stoi(data[j].capitalGain, nullptr, 10);
			int capitalLossInput = stoi(input[i].capitalLoss, nullptr, 10);
			int capitalLossData = stoi(data[j].capitalLoss, nullptr, 10);
			int hoursPerWeekInput = stoi(input[i].hoursPerWeek, nullptr, 10);
			int hoursPerWeekData = stoi(data[j].hoursPerWeek, nullptr, 10);
			//int nativeCountryInput = stoi(input[i].nativeCountry, nullptr, 10);
			//int nativeCountryData = stoi(data[j].nativeCountry, nullptr, 10);
			string nativeCountryInput = input[i].nativeCountry;
			string nativeCountryData = data[j].nativeCountry;
			above50k = data[j].earning;
			double dist = distance(ageInput, ageData, workclassInput, workclassData, fnlwgtInput, fnlwgtData, educationInput, educationData, educationNumInput, educationNumData, maritalStatusInput, maritalStatusData, occupationInput, occupationData, relationshipInput, relationshipData, raceInput, raceData, sexInput, sexData, capitalGainInput, capitalGainData, capitalLossInput, capitalLossData, hoursPerWeekInput, hoursPerWeekData, nativeCountryInput, nativeCountryData, n);

			qsort(dist, n, sizeof(results), comparison);
		}

		if(classification(input[i], above50k)){
			cout << input[i] << " classified above 50k\n";
		}
		else{
			cout << input[i] << " classified below 50k\n";
		}
	}

    return 0;
}
