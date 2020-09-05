#include <iostream>
#include <cmath>

using namespace std;
int main(int argc, char* argv[]) {
	int target,sum,temp;
	cin >> target;
	for(int i=target - (int)(log10(target)+1)*9; i<target;i++){
		sum = i,temp =i;
		for(int j=0;j<(int)log10(i)+1;j++){
			sum = sum + temp%10;
			temp/=10;
		}
		if(sum == target){
			cout << i;
			return 0;
		}
	}
	cout << "0";
}
