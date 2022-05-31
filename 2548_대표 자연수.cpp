#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int cnt;
	cin >> cnt;

	int *nums = new int[cnt];

	for (int i = 0; i < cnt; i++)
		cin >> nums[i];

	int max = 300000000;
	int sum;
	int stdNum;
	vector<int> stdNums;
	for (int i = 0; i < cnt; i++)
	{
		sum = 0;
		stdNum = nums[i];
		for (int j = 0; j < cnt; j++)
			sum += abs(nums[j] - stdNum);
		if (sum == max)
			stdNums.push_back(stdNum);
		if (sum < max)
		{
			max = sum;
			stdNums.clear();
			stdNums.push_back(stdNum);
		}
	}
	sort(stdNums.begin(), stdNums.end());
	cout << stdNums[0];
	return 0;
}