#include <iostream>
#include <cmath>

using namespace std;
int main(int argc, char* argv[]) {
	int room, temp=1,count=1;
	cin >> room;
		
	for(int i=1;;i++){
		if(temp >= room){
			cout << count << endl;
			break;
		}
		temp = temp + 6 * i;
		count++;
	}
}
