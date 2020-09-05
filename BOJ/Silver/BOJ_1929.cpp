#include <iostream>
#include <cmath>

using namespace std;
int main(int argc, char* argv[]) {
	int a,b;
	cin >> a >> b;
	
	bool * arr = new bool[b+1];
	fill(arr,arr+b+1,true);
	
	for(int i=2; i<b+1; i++)
	{
		if(arr[i]){
			if(pow(i,2) > 1000001){
				break;
			}
			else{
				for(int j= pow(i,2); j<b+1;j+=i){
					arr[j] = false;
				}
			}
		}
		
	}
	
	if(a==1){
		a +=1;
	}
	
	for(int i=a;i<b+1;i++){
		if(arr[i] == true){
			cout << i << ' ';
		}
	}
	
	delete []arr;
}
