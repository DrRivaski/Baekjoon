#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{
	int n;
	cin >> n;

	int m;
	cin >> m;

	int *vips = new int[m + 2];
	vips[0] = 0;
	for (int i = 1; i < m + 1; i++)
		cin >> vips[i];
	vips[m + 1] = n + 1;

	long long int dp[41];
	dp[0] = 1;
	dp[1] = 2;
	for (int i = 2; i < 41; i++)
		dp[i] = dp[i - 1] + dp[i - 2];

	vector<long long int> cnts;
	for (int i = 0; i < m + 1; i++)
	{
		int dest = vips[i + 1] - vips[i] - 1;
		if (dest != 0)
			cnts.push_back(dp[dest - 1]);
	}

	long long int result = 1;
	for (int i = 0; i < cnts.size(); i++)
		result *= cnts[i];

	cout << result;
}