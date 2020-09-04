#include <iostream>


int main(int argc, char* argv[]) {
	int max=0, temp=0, number=0;
	for(int i=0;i<9;i++){
		std::cin >> temp;
		if(max < temp){
			max = temp;
			number = i;
		}
	}
	std::cout << max << std::endl << number+1;
}
