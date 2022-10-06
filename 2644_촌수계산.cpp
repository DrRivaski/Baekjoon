#include <iostream>
#include <vector>

using namespace std;

int mat[101][101];
int visited[101];
int depth = -1;

void DFS(int n, int x1, int x2, int tempDepth)
{
	if (x1 == x2)
	{
		depth = tempDepth;
		return;
	}

	if (x1 == n)
		return;

	for (int i = 1; i < n + 1; i++)
	{
		if (mat[x1][i] == 1 && visited[i] == 0)
		{
			visited[i] = 1;
			tempDepth++;
			DFS(n, i, x2, tempDepth);
			tempDepth--;
		}
	}
}

int main(void)
{
	int n, x1, x2, m;
	cin >> n >> x1 >> x2 >> m;

	int p1, p2;

	for (int i = 0; i < m; i++)
	{
		cin >> p1 >> p2;
		mat[p1][p2] = 1;
		mat[p2][p1] = 1;
	}
	DFS(n, x1, x2, 0);

	cout << depth;
	return 0;