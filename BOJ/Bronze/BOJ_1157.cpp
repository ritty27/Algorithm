#include <iostream>


int main(int argc, char* argv[]) {
	int max=0, alphabet[26] = {0,};
	std::string inputWord;
	std::cin >> inputWord;
	
	for(int i=0;i<inputWord.length();i++)
	{
		if(inputWord.at(i) >= 'a')
			alphabet[inputWord.at(i) - 'a']++;
		else alphabet[inputWord.at(i) - 'A']++;
	}
	
	
	int idx = -1,check=0;
	
	for(int i=0;i<26;i++){
		if(alphabet[i] > max){
			max = alphabet[i];
			idx = i;
			check=0;
		}
		if(max==alphabet[i]){
			check++;
		}
	}
	
	if(check==1)
		printf("%c\n", idx+'A');	
	else
		printf("?\n");
	
		return 0;
}
