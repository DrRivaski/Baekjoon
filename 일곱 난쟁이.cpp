#include <iostream>
using namespace std;

void calculate(int i, int j, int height[], int newHeight[])
{
	int sum = 0;
	for (int n = 0; n < 9; n++)
	{
		if (n == i || n == j)
			continue;
		sum += height[n];
	}

	if (sum == 100)
	{
		int m = 0;
		for (int n = 0; n < 9; n++)
		{
			if (n != i && n != j)
			{
				newHeight[m] = height[n];
				m++;
			}
		}
	}
}

void accending(int newHeight[])
{
	for (int i = 0; i < 6; i++)
	{
		int min = newHeight[i];
		for (int j = i + 1; j < 7; j++)
		{
			if (min > newHeight[j])
			{
				min = newHeight[j];
				newHeight[j] = newHeight[i];
				newHeight[i] = min;
			}
		}
	}
}

int main(void)
{
	int height[9];
	int newHeight[7];
	for (int i = 0; i < 9; i++)
		cin >> height[i];

	for (int i = 0; i < 9; i++)
	{
		int n = 0;
		for (int j = i + 1; j < 9; j++)
		{
			calculate(i, j, height, newHeight);
		}
	}

	accending(newHeight);
	cout << "\n";

	for (int i = 0; i < 7; i++)
		cout << newHeight[i] << "\n";
}