#include <iostream>
#include <vector>

using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int H, W, X, Y;
	cin >> H >> W >> X >> Y;

	vector<int> *board1 = new vector<int>[H + X];
	vector<int> *board2 = new vector<int>[H];
	for (int i = 0; i < H + X; i++)
	{
		for (int j = 0; j < W + Y; j++)
		{
			int tempNum; 
			cin >> tempNum;
			board1[i].push_back(tempNum);
		}
	}

	for (int i = 0; i < H; i++)
	{
		for (int j = 0; j < W; j++)
		{
			if (i >= X && j >= Y)
				board2[i].push_back(board1[i][j] - board2[i - X][j - Y]);
			else
				board2[i].push_back(board1[i][j]);
		}
	}

	for (int i = 0; i < H; i++)
	{
		for (int j = 0; j < W; j++)
		{
			cout << board2[i][j] << " ";
		}
		cout << "\n";
	}
	return 0;
}