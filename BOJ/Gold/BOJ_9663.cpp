#include <iostream>
#include <algorithm>

using namespace std;
int ans = 0, n = 0, row[15];

bool confirm(int here){
	for(int i = 1; i < here; i++){
		if(row[here] == row[i])
			return false;			
		if(abs(row[here]-row[i]) == abs(here-i))
			return false;
	}
	return true;
}

void dfs(int col){
	if(col == n){
		ans++;
	}
	else{
		for(int i = 1; i <= n; i++){
			row[col+1] = i;
			if(confirm(col+1)){
				dfs(col+1);
			}
			else{
				row[col+1] = 0;
			}
		}
	}
	row[col] = 0;
}


int main(int argc, char* argv[]) {
	cin >> n;
	
	for(int i=1; i<=n; i++){
		row[1] = i;
		dfs(1);
	}
	cout << ans;
}
