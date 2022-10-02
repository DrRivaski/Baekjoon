#include <iostream>
#include <queue>

using namespace std;

int mat[102][102];
int visited[101];

int main(void)
{
	int numCom;
	cin >> numCom;
	int numNet;
	cin >> numNet;

	for (int i = 0; i < numNet; i++)
	{
		int x1, x2;
		cin >> x1;
		cin >> x2;

		mat[x1][x2] = 1;
		mat[x2][x1] = 1;
	}

	int countInfested = 0;

	queue<int> queue;

	queue.push(1);
	while (!queue.empty())
	{
		int cur = queue.front();
		queue.pop();
		for (int i = 1; i < numCom + 1; i++)
		{
			if (mat[cur][i] == 1 && visited[i] != 1)
			{
				queue.push(i);
				visited[i] = 1;
			}
		}
	}

	for (int i = 0; i < numCom + 1; i++)
	{
		if (visited[i] == 1)
			countInfested++;
	}

	cout << countInfested - 1;
	return 0;
}