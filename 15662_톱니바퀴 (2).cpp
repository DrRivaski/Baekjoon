#include <iostream>
#include <string>

using namespace std;

int arr[1000][8];
int t;

void rotate(int arr[], int dir)
{
	if (dir == 1) //clockwise
	{
		int temp = arr[7];
		for (int i = 7; i > 0; i--)
			arr[i] = arr[i - 1];
		arr[0] = temp;
		
	}
	else //counter-clockwise
	{
		int temp = arr[0];
		for (int i = 0; i < 7; i++)
			arr[i] = arr[i + 1];
		arr[7] = temp;
	}
}

void recursionLeft(int idx, int dir)
{
	if (idx == 0)
	{
		rotate(arr[idx], dir);
		return;
	}
	if (arr[idx][6] != arr[idx - 1][2])
	{
		if (dir == 1) //clockwise
			recursionLeft(idx - 1, -1);
		else //counter clockwise
			recursionLeft(idx - 1, 1);
		rotate(arr[idx], dir);
	}
	else
	{
		rotate(arr[idx], dir);
		return;
	}
}

void recursionRight(int idx, int dir)
{
	if (idx == t - 1)
	{
		rotate(arr[idx], dir);
		return;
	}
	if (arr[idx][2] != arr[idx + 1][6])
	{
		if (dir == 1) //clockwise
			recursionRight(idx + 1, -1);
		else //counter clockwise
			recursionRight(idx + 1, 1);
		rotate(arr[idx], dir);
	}
	else
	{
		rotate(arr[idx], dir);
		return;
	}
}

int main(void)
{
	cin >> t;

	for (int i = 0; i < t; i++)
	{
		string str;
		cin >> str;
		for (int j = 0; j < 8; j++)
		{
			arr[i][j] = str[j] - '0';
		}
	}

	int k;
	cin >> k;
	
	for (int i = 0; i < k; i++)
	{
		int num, dir;
		cin >> num >> dir;
		recursionLeft(num - 1, dir);
		if (dir == -1)
			rotate(arr[num - 1], 1);
		else
			rotate(arr[num - 1], -1);
		recursionRight(num - 1, dir);
	}

	int cnt = 0;
	for (int i = 0; i < t; i++)
	{
		if (arr[i][0] == 1)
			cnt++;
	}
	cout << cnt;
	return 0;
}