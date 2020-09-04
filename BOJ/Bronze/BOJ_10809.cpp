#include <iostream>
#include <cstring>

using namespace std;
int main(int argc, char* argv[]) {
	int alphabet[26];
	fill(alphabet, alphabet+26, -1);
	char s[100];
	std::cin >> s;
	for(int i=0;i<strlen(s);i++){
		if(alphabet[s[i]-'a'] == -1){
			//std::cout << s[i] - 'a' << std::endl;
			alphabet[s[i] -'a'] = i;
		}
	}
	for(int i=0;i<26;i++){
		cout << alphabet[i] << ' ';
	}
}
