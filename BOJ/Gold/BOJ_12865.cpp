#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int n, k, need[100], weight[100], cache[101][100001];
	
int pack(int item, int nowWeight){
	if(item == n)
		return 0;
	int& ret = cache[item][nowWeight];
	if(ret != -1)
		return ret;
	ret = pack(item +1, nowWeight);
	if(k-nowWeight >= weight[item]){
		ret = max(ret, pack(item+1, nowWeight+ weight[item]) + need[item]);
	}
	return ret;
}

int main(int argc, char* argv[]) {
	memset(cache, -1, sizeof(cache));
	
	cin >> n >> k;
	for(int i=0; i < n; ++i){
		cin >> weight[i] >> need[i];
	}
	cout << pack(0,0);
}
