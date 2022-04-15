#include <iostream>
using namespace std;

int findMax(int arr[])
{
	int max = 0;
	for (int i = 0; i < 19; i++)
	{
		if (arr[i] > max)
			max = arr[i];
	}

	return max;
}

int checkBoard_0(int **board, int n, int m)		//square
{
	int tempSum = 0;
	int sum = 0;

	for (int i = 0; i < n - 1; i++)
	{
		for (int j = 0; j < m - 1; j++)
		{
			tempSum = board[i][j] + board[i][j + 1] + board[i + 1][j] + board[i + 1][j + 1];
			if (tempSum > sum)
				sum = tempSum;
		}
	}

	return sum;
}

int checkBoard_1(int **board, int n, int m)		//horizontal stick
{
	int tempSum = 0;
	int sum = 0;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m - 3; j++)
		{
			tempSum = board[i][j] + board[i][j + 1] + board[i][j + 2] + board[i][j + 3];
			if (tempSum > sum)
				sum = tempSum;
		}
	}

	return sum;
}

int checkBoard_2(int **board, int n, int m)		//vertical stick
{
	int tempSum = 0;
	int sum = 0;

	for (int i = 0; i < n - 3; i++)
	{
		for (int j = 0; j < m; j++)
		{
			tempSum = board[i][j] + board[i + 1][j] + board[i + 2][j] + board[i + 3][j];
			if (tempSum > sum)
				sum = tempSum;
		}
	}

	return sum;
}

int checkBoard_3(int **board, int n, int m)		//T-block 1
{
	int tempSum = 0;
	int sum = 0;

	for (int i = 0; i < n - 1; i++)
	{
		for (int j = 0; j < m - 2; j++)
		{
			tempSum = board[i][j + 1] + board[i + 1][j] + board[i + 1][j + 1] + board[i + 1][j + 2];
			if (tempSum > sum)
				sum = tempSum;
		}
	}

	return sum;
}

int checkBoard_4(int **board, int n, int m)		//T-block 2
{
	int tempSum = 0;
	int sum = 0;

	for (int i = 0; i < n - 1; i++)
	{
		for (int j = 0; j < m - 2; j++)
		{
			tempSum = board[i][j] + board[i][j + 1] + board[i][j + 2] + board[i + 1][j + 1];
			if (tempSum > sum)
				sum = tempSum;
		}
	}

	return sum;
}

int checkBoard_5(int **board, int n, int m)		//T-block 3
{
	int tempSum = 0;
	int sum = 0;

	for (int i = 0; i < n - 2; i++)
	{
		for (int j = 0; j < m - 1; j++)
		{
			tempSum = board[i][j] + board[i + 1][j] + board[i + 2][j] + board[i + 1][j + 1];
			if (tempSum > sum)
				sum = tempSum;
		}
	}

	return sum;
}

int checkBoard_6(int **board, int n, int m)		//T-block 4
{
	int tempSum = 0;
	int sum = 0;

	for (int i = 0; i < n - 2; i++)
	{
		for (int j = 0; j < m - 1; j++)
		{
			tempSum = board[i + 1][j] + board[i][j + 1] + board[i + 1][j + 1] + board[i + 2][j + 1];
			if (tempSum > sum)
				sum = tempSum;
		}
	}

	return sum;
}

int checkBoard_7(int **board, int n, int m)		//S-block 1
{
	int tempSum = 0;
	int sum = 0;

	for (int i = 0; i < n - 1; i++)
	{
		for (int j = 0; j < m - 2; j++)
		{
			tempSum = board[i][j] + board[i][j + 1] + board[i + 1][j + 1] + board[i + 1][j + 2];
			if (tempSum > sum)
				sum = tempSum;
		}
	}

	return sum;
}

int checkBoard_8(int **board, int n, int m)		//S-block 2
{
	int tempSum = 0;
	int sum = 0;

	for (int i = 0; i < n - 1; i++)
	{
		for (int j = 0; j < m - 2; j++)
		{
			tempSum = board[i][j + 1] + board[i][j + 2] + board[i + 1][j] + board[i + 1][j + 1];
			if (tempSum > sum)
				sum = tempSum;
		}
	}

	return sum;
}

int checkBoard_9(int **board, int n, int m)		//S-block 3
{
	int tempSum = 0;
	int sum = 0;

	for (int i = 0; i < n - 2; i++)
	{
		for (int j = 0; j < m - 1; j++)
		{
			tempSum = board[i][j] + board[i + 1][j] + board[i + 1][j + 1] + board[i + 2][j + 1];
			if (tempSum > sum)
				sum = tempSum;
		}
	}

	return sum;
}

int checkBoard_10(int **board, int n, int m)		//S-block 4
{
	int tempSum = 0;
	int sum = 0;

	for (int i = 0; i < n - 2; i++)
	{
		for (int j = 0; j < m - 1; j++)
		{
			tempSum = board[i + 1][j] + board[i + 2][j] + board[i][j + 1] + board[i + 1][j + 1];
			if (tempSum > sum)
				sum = tempSum;
		}
	}

	return sum;
}

int checkBoard_11(int **board, int n, int m)		//L-block 1
{
	int tempSum = 0;
	int sum = 0;

	for (int i = 0; i < n - 1; i++)
	{
		for (int j = 0; j < m - 2; j++)
		{
			tempSum = board[i][j + 2] + board[i + 1][j] + board[i + 1][j + 1] + board[i + 1][j + 2];
			if (tempSum > sum)
				sum = tempSum;
		}
	}

	return sum;
}

int checkBoard_12(int **board, int n, int m)		//L-block 2
{
	int tempSum = 0;
	int sum = 0;

	for (int i = 0; i < n - 1; i++)
	{
		for (int j = 0; j < m - 2; j++)
		{
			tempSum = board[i][j] + board[i][j + 1] + board[i][j + 2] + board[i + 1][j];
			if (tempSum > sum)
				sum = tempSum;
		}
	}

	return sum;
}

int checkBoard_13(int **board, int n, int m)		//L-block 3
{
	int tempSum = 0;
	int sum = 0;

	for (int i = 0; i < n - 1; i++)
	{
		for (int j = 0; j < m - 2; j++)
		{
			tempSum = board[i][j] + board[i][j + 1] + board[i][j + 2] + board[i + 1][j + 2];
			if (tempSum > sum)
				sum = tempSum;
		}
	}

	return sum;
}

int checkBoard_14(int **board, int n, int m)		//L-block 4
{
	int tempSum = 0;
	int sum = 0;

	for (int i = 0; i < n - 1; i++)
	{
		for (int j = 0; j < m - 2; j++)
		{
			tempSum = board[i][j] + board[i + 1][j] + board[i + 1][j + 1] + board[i + 1][j + 2];
			if (tempSum > sum)
				sum = tempSum;
		}
	}

	return sum;
}

int checkBoard_15(int **board, int n, int m)		//L-block 5
{
	int tempSum = 0;
	int sum = 0;

	for (int i = 0; i < n - 2; i++)
	{
		for (int j = 0; j < m - 1; j++)
		{
			tempSum = board[i][j] + board[i + 1][j] + board[i + 2][j] + board[i + 2][j + 1];
			if (tempSum > sum)
				sum = tempSum;
		}
	}

	return sum;
}

int checkBoard_16(int **board, int n, int m)		//L-block 6
{
	int tempSum = 0;
	int sum = 0;

	for (int i = 0; i < n - 2; i++)
	{
		for (int j = 0; j < m - 1; j++)
		{
			tempSum = board[i][j] + board[i][j + 1] + board[i + 1][j + 1] + board[i + 2][j + 1];
			if (tempSum > sum)
				sum = tempSum;
		}
	}

	return sum;
}

int checkBoard_17(int **board, int n, int m)		//L-block 7
{
	int tempSum = 0;
	int sum = 0;

	for (int i = 0; i < n - 2; i++)
	{
		for (int j = 0; j < m - 1; j++)
		{
			tempSum = board[i + 2][j] + board[i][j + 1] + board[i + 1][j + 1] + board[i + 2][j + 1];
			if (tempSum > sum)
				sum = tempSum;
		}
	}

	return sum;
}

int checkBoard_18(int **board, int n, int m)		//L-block 8
{
	int tempSum = 0;
	int sum = 0;

	for (int i = 0; i < n - 2; i++)
	{
		for (int j = 0; j < m - 1; j++)
		{
			tempSum = board[i][j] + board[i + 1][j] + board[i + 2][j] + board[i][j + 1];
			if (tempSum > sum)
				sum = tempSum;
		}
	}

	return sum;
}

int main(void)
{
	int n, m;
	int sumArr[19];
	cin >> n >> m;
	int **board = new int*[n];
	for (int i = 0; i < n; i++)
		board[i] = new int[m];

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
			cin >> board[i][j];
	}

	int sum = 0;
	sumArr[0] = checkBoard_0(board, n, m);	//square
	sumArr[1] = checkBoard_1(board, n, m);	//horizontal stick
	sumArr[2] = checkBoard_2(board, n, m);	//vertical stick
	sumArr[3] = checkBoard_3(board, n, m);	//T-block 1
	sumArr[4] = checkBoard_4(board, n, m);	//T-block 2
	sumArr[5] = checkBoard_5(board, n, m);	//T-block 3
	sumArr[6] = checkBoard_6(board, n, m);	//T-block 4
	sumArr[7] = checkBoard_7(board, n, m);	//S-block 1
	sumArr[8] = checkBoard_8(board, n, m);	//S-block 2
	sumArr[9] = checkBoard_9(board, n, m);	//S-block 3
	sumArr[10] = checkBoard_10(board, n, m);	//S-block 4
	sumArr[11] = checkBoard_11(board, n, m);	//L-block 1
	sumArr[12] = checkBoard_12(board, n, m);	//L-block 2
	sumArr[13] = checkBoard_13(board, n, m);	//L-block 3
	sumArr[14] = checkBoard_14(board, n, m);	//L-block 4
	sumArr[15] = checkBoard_15(board, n, m);	//L-block 5
	sumArr[16] = checkBoard_16(board, n, m);	//L-block 6
	sumArr[17] = checkBoard_17(board, n, m);	//L-block 7
	sumArr[18] = checkBoard_18(board, n, m);	//L-block 8

	int max = findMax(sumArr);
	cout << max;
	return 0;
}