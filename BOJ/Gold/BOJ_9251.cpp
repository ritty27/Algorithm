#include <iostream>
#include <cstring>
#include <string>

using namespace std;

int cache[1002][1002];
char A[1001], B[1001];

int lcs(int indexA, int indexB){
	int& ret = cache[indexA][indexB];
	if(ret != -1)
		return ret;
	if(indexB ==0 || indexA == 0) 
		return ret = 0;
	if(A[indexA-1] == B[indexB-1]){
		ret = lcs(indexA-1, indexB-1) + 1;
	}
	else{
		ret = max(lcs(indexA-1, indexB), lcs(indexA,indexB-1));
	}
	
	return ret;
}


int main(int argc, char* argv[]) {
	memset(cache, -1, sizeof(cache));	
	cin >> A >> B;
	cout << lcs(strlen(A),strlen(B));	
	
}
