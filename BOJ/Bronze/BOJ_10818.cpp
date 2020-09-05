#include <iostream>

using namespace std;
int main(int argc, char* argv[]) {
	int count ,temp, max = - 1000001, min = 1000001;
	cin >> count;
	for(int i=0;i<count;i++){
		cin >> temp;
		if(max < temp){
			max = temp;
		}
		if(min > temp){
			min =temp;
		}
	}
	cout << min << ' ' << max;
	

}
