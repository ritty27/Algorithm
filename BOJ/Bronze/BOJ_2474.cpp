#include <iostream>


int main(int argc, char* argv[]) {
	int temp, sum=0;;
	for(int i=0;i<5;i++){
		std::cin >> temp;
		sum = sum + temp*temp;
	}
	std::cout << sum%10;	
}
