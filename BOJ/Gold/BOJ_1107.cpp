#include <iostream>
#include <math.h>

using namespace std;

bool broken[10]={0,};
int targetLength = 0;

bool check(int i){
	while(i>=10){
		if(broken[i%10] == 1)
			return 0;
		i/=10;
	}
	if(broken[i] == 1)
		return 0;
	return 1;
}

int length(int target){
	int targetLength = log10(target) + 1;
		if(target==0)
			targetLength = 1;
	return targetLength;
}

int main(int argc, char* argv[]) {
	int target, brokenNum=0, myMin = 1000000;
	
	cin >> target >> brokenNum;
	for(int i=0;i<brokenNum;i++){
		int temp;
		cin >> temp;
		broken[temp] = 1;
	}
	
	//1.compare with 100
	myMin = min(abs(target-100), myMin);

	//2.bigButtom
	for(int i=target;i<=1000000;i++){
		if(check(i) == 1){
			targetLength = length(i);
			myMin = min (myMin, i - target + targetLength);
			break;
		}		
	}

	//3.smallTop
	for(int i=target; i >= 0; i--){
		if(check(i) == 1){
			targetLength = length(i);
			myMin = min (myMin, target - i + targetLength);
			break;
		}
	}
	cout << myMin << endl;
	
}
