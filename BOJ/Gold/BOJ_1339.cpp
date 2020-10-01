#include <iostream>
#include <algorithm>

using namespace std;

bool compare(int a, int b){
	return b < a;
}


int main(int argc, char* argv[]) {
	int input = 0, sum = 0, alphabet[26] = {0, };
	string s1;
	cin >> input;
	for(int i = 0;i < input ;i++){
		int temp = 1;
		cin >> s1;
		for(int j = 1;j <= s1.length(); j++){
			alphabet[s1[s1.length()-j] - 'A'] += temp;
			temp *= 10;
		}
	}
	
	sort(alphabet,alphabet+26,compare);
	
	for(int i = 0; i< 9; i++){
		sum = alphabet[i]*(9-i) + sum;
	}
	cout << sum;
}
