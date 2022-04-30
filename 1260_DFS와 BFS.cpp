#include <iostream>
#include <vector>
using namespace std;

int graph[1001][1001];
int visited[1001];
int N, M, V;

void DFS(int root)
{
	visited[root] = 1;
	cout << root << " ";
	for (int i = 0; i < 1001; i++)
	{
		if (graph[root][i] == 1 && visited[i] == 0)
		{
			DFS(i);
		}
	}
}

void BFS(int root)
{
	visited[root] = 1;
	vector<int> queue;
	queue.push_back(root);
	while (!queue.empty())
	{
		int searching = queue.front();
		
		queue.erase(queue.begin());
		for (int i = 0; i < 1001; i++)
		{
			if (graph[searching][i] == 1 && visited[i] == 0)
			{
				queue.push_back(i);
				visited[i] = 1;
			}
		}
		cout << searching << " ";
	}
}

int main(void)
{
	cin >> N >> M >> V;
	for (int i = 0; i < 1001; i++)
		visited[i] = 0;

	for (int i = 0; i < M; i++)			//연결된 vertex는 1로 표시
	{
		int num1, num2;
		cin >> num1 >> num2;
		graph[num1][num2] = 1;
		graph[num2][num1] = 1;
	}

	DFS(V);

	for (int i = 0; i < 1001; i++)
		visited[i] = 0;

	cout << "\n";
	BFS(V);
	
	return 0;
}