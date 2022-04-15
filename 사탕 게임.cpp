#include <iostream>
using namespace std;

int checkBoard(char **board, int n)
{
	int count = 0;
	int tempCount;
	for (int i = 0; i < n; i++)		//세로 체크
	{
		char first;
		int j = 0;
		while (j != n - 1)
		{
			first = board[j][i];
			tempCount = 1;
			for (int k = j + 1; k < n; k++)
			{
				if (first == board[k][i])
					tempCount++;
				else
					break;
			}
			if (tempCount > count)
				count = tempCount;
			j++;
		}
	}
	for (int i = 0; i < n; i++)		//가로 
	{
		char first;
		int j = 0;
		while (j != n - 1)
		{
			first = board[i][j];
			tempCount = 1;
			for (int k = j + 1; k < n; k++)
			{
				if (first == board[i][k])
					tempCount++;
				else
					break;
			}
			if (tempCount > count)
				count = tempCount;
			j++;
		}
	}
	return count;
}

void toTempBoard(char **tempBoard, char **board, int n)
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
			tempBoard[i][j] = board[i][j];
	}
}

int main(void)
{
	int n;
	cin >> n;
	int count = 0;
	char **board = new char* [n];
	char **tempBoard = new char* [n];
	for (int i = 0; i < n; i++)
	{
		board[i] = new char[n];
		tempBoard[i] = new char[n];
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
			cin >> board[i][j];
	}

	toTempBoard(tempBoard, board, n);

	for (int i = 0;i < n - 1; i++)
	{
		for (int j = 0; j < n; j++)
		{
			toTempBoard(tempBoard, board, n);
			if (board[i][j] != board[i + 1][j])
			{
				tempBoard[i][j] = board[i + 1][j];
				tempBoard[i + 1][j] = board[i][j];
				int tempCount = checkBoard(tempBoard, n);
				if (tempCount > count)
					count = tempCount;
			}
		}
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n - 1; j++)
		{
			toTempBoard(tempBoard, board, n);
			if (board[i][j] != board[i][j + 1])
			{
				tempBoard[i][j] = board[i][j + 1];
				tempBoard[i][j + 1] = board[i][j];
				int tempCount = checkBoard(tempBoard, n);
				if (tempCount > count)
					count = tempCount;
			}
		}
	}
	
	cout << count;
	return 0;
}
