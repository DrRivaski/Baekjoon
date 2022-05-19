#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int board[21][21];
int Min = 1000000000;
int sum1, sum2;

int main(void)
{
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);

	for (int i = 0; i < 21; i++)
	{
		for (int j = 0; j < 21; j++)
			board[i][j] = 0;
	}

	int n;
	cin >> n;

	for (int i = 1; i < n + 1; i++)
	{
		for (int j = 1; j < n + 1; j++)
			cin >> board[i][j];
	}

	vector<bool> temp(n, false);

	for (int i = 0; i < n / 2; i++)
		temp[i] = true;
	do
	{
		sum1 = 0;
		sum2 = 0;

		vector<int> team1;
		vector<int> team2;

		//create team
		for (int i = 0; i < n; i++)
		{
			if (temp[i])
				team1.push_back(i + 1);
			else
				team2.push_back(i + 1);
		}

		vector<bool> temp2(n / 2, false);

		for (int i = 0; i < 2; i++)
			temp2[i] = true;

		do
		{
			vector<int> partner1;
			vector<int> partner2;
			for (int i = 0; i < n / 2; i++)
			{
				if (temp2[i])
				{
					partner1.push_back(team1[i]);
					partner2.push_back(team2[i]);
				}
			}
			sum1 += board[partner1[0]][partner1[1]] + board[partner1[1]][partner1[0]];
			sum2 += board[partner2[0]][partner2[1]] + board[partner2[1]][partner2[0]];
		} while (prev_permutation(temp2.begin(), temp2.end()));


		int sub;
		if (sum1 > sum2)
			sub = sum1 - sum2;
		else
			sub = sum2 - sum1;

		if (sub < Min)
			Min = sub;

	} while (prev_permutation(temp.begin(), temp.end()));

	cout << Min;

	return 0;
}