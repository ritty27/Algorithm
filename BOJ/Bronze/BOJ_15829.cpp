#include <iostream>

using namespace std;
int main(int argc, char* argv[]) {
	long length, coefficient=1, sum=0;
	cin >> length;
	char * word = new char[length];
	cin >> word;
	
	for(int i =0;i<length;i++){
		sum = (sum + coefficient * (word[i] - 'a' + 1)) % 1234567891;
		coefficient = coefficient * 31 % 1234567891;
	}
	cout << sum;

}
