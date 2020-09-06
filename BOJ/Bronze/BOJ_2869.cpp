#include <iostream>

using namespace std;
int main(int argc, char* argv[]) {
	int a,b,height,count=0;
	cin >> a >> b >> height;
	if((height - a) % (a-b) == 0){
		count = (height - a) / (a-b) + 1;
	}else{ 
		count = (height - a) / (a-b) + 2;
	}
	cout << count;
}
