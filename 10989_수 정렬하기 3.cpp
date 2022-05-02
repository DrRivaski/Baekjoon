#include<iostream>

using namespace std;

int main(void)
{
	int N;
	cin >> N;
	int cnt[10001];
	for (int i = 0; i < 10001; i++)
		cnt[i] = 0;

	for (int i = 0; i < N; i++)
	{
		int input;
		cin >> input;
		cnt[input]++;
	}

	for (int i = 1; i < 10001; i++)
	{
		if (cnt[i] != 0)
		{
			for (int j = 0; j < cnt[i]; j++)
				cout << i << "\n";
		}
	}
	return 0;
}