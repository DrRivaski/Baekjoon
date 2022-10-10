#include <iostream>

using namespace std;

int Max = 0;
int t[16];
int p[16];

void search(int depth, int n, int sum)
{
	int nextDepth = depth + t[depth];
	//cout << "nextDepth = " << nextDepth << endl;
	if (nextDepth > n)
	{
		if (t[depth] == n - depth + 1)
			sum += p[depth];
		if (sum > Max)
			Max = sum;
		//cout << "MAX = " << Max << endl;
		return;
	}
	else
	{
		sum += p[depth];
		for (int i = nextDepth; i <= n; i++)
			search(i, n, sum);
	}
		
}

int main(void)
{
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++)
	{
		cin >> t[i] >> p[i];
	}

	for (int i = 1; i <= n; i++)
		search(i, n, 0);

	cout << Max << endl;
}