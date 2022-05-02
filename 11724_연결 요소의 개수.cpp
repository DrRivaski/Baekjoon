#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>

using namespace std;

int board[1001][1001];
int visited[1001];
int nodes[1001];
int N, M;

int main(void)
{
	for (int i = 0; i < 1001; i++)
	{
		for (int j = 0; j < 1001; j++)
			board[i][j] = 0;
		visited[i] = 0;
		nodes[i] = 0;
	}

	cin >> N >> M;
	for (int i = 0; i < M; i++)
	{
		int num1, num2;
		cin >> num1 >> num2;

		if (nodes[num1] == 0)
			nodes[num1] = 1;
		if (nodes[num2] == 0)
			nodes[num2] = 1;

		board[num1][num2] = 1;
		board[num2][num1] = 1;
	}

	int count = 0;
	vector<int> queue;
	int root;

	for (int i = 1; i < N + 1; i++)
	{
		root = i;
		if (visited[i] == 1)
			continue;
		else
		{
			//starting node push
			queue.push_back(root);
			visited[root] = 1;
			while (!queue.empty())
			{
				root = queue.front();
				queue.erase(queue.begin());
				for (int i = 0; i < N + 1; i++)
				{
					if (board[root][i] == 1 && visited[i] == 0)
					{
						queue.push_back(i);
						visited[i] = 1;
					}
				}

			}
			count++;
		}
	}
	cout << count;
	return 0;
}