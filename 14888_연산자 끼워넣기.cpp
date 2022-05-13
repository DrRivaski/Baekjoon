#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int Max = -1000000000;
int Min = 1000000000;

int main(void)
{
	int n;
	cin >> n;
	
	vector<int> numbers;
	vector<int> ops;
	for (int i = 0; i < n; i++)
	{
		int num;
		cin >> num;
		numbers.push_back(num);
	}
	for (int i = 0; i < 4; i++)
	{
		int op;
		cin >> op;
		ops.push_back(op);
	}

	vector<char> charOps;
	for (int i = 0; i < ops[0]; i++)
		charOps.push_back('+');
	for (int i = 0; i < ops[1]; i++)
		charOps.push_back('-');
	for (int i = 0; i < ops[2]; i++)
		charOps.push_back('*');
	for (int i = 0; i < ops[3]; i++)
		charOps.push_back('/');

	sort(charOps.begin(), charOps.end());
	do
	{
		int result = numbers[0];
		for (int i = 0; i < charOps.size(); i++)
		{
			switch (charOps[i])
			{
			case '+':
				result += numbers[i + 1];
				break;
			case '-':
				result -= numbers[i + 1];
				break;
			case '*':
				result *= numbers[i + 1];
				break;
			case '/':
				if(result > 0)
					result /= numbers[i + 1];
				else
				{
					result = -1 * (-1 * result / numbers[i + 1]);
				}
				break;
			}
		}
		if (result > Max)
			Max = result;
		if (result < Min)
			Min = result;
	} while (next_permutation(charOps.begin(), charOps.end()));

	cout << Max << "\n" << Min;

	return 0;
}