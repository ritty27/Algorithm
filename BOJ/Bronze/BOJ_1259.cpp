#include <iostream>
#include <vector>

int main() {
  int inputNum =0, answer =0;
  std::vector <int> point;
  
  while(true){

    std::cin >> inputNum;
    if(inputNum==0)
      return 0;
  
  
    for(int i=0;i<5;i++)
    {
      point.push_back(inputNum%10);
      inputNum/=10;
    }
    while(point.back()==0)
    {
      point.pop_back();
    }

    for(int i=0;i<point.size()/2;i++)
    {
      if(point[i] !=point[point.size()-i-1])
      {
      answer = 1;
      break;
      }
    }
    answer == 1 ? std::cout << "no" << std::endl : std::cout << "yes" << std::endl;
    answer =0;
    point.clear();
  }
}
