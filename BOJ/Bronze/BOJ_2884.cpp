#include <iostream>


int main(int argc, char* argv[]) {
	int hour, minute;
	std::cin >> hour >> minute;
	minute -=45;
	if(minute < 0){
		minute += 60;
		hour -=1;
	}
	if(hour < 0){
		hour += 24;
	}
	std::cout <<  hour <<' ' <<  minute;
}
