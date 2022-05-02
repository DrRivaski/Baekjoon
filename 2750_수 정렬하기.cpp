#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int main(void)
{
	vector<int> stack;
	int N, input;
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		cin >> input;
		stack.push_back(input);
	}
	sort(stack.begin(), stack.end());
	for (int i = 0; i < stack.size(); i++)
		cout << stack[i] << "\n";

	return 0;
}