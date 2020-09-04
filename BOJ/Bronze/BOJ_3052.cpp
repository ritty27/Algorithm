#include <iostream>


int main(int argc, char* argv[]) {
	int temp, answer=0, check[42]={0,};
	for(int i=0; i<10;i++){
		std::cin >> temp;
		check[temp%42] +=1;
	}
	for(int i=0;i<42;i++){
		if(check[i] > 0)
			answer += 1;
	}
	std::cout <<  answer;
}
