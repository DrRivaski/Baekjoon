#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int cnt;
	cin >> cnt;

	vector<int> a;
	vector<int> b;
	int temp;
	for (int i = 0; i < cnt; i++)
	{
		cin >> temp;
		a.push_back(temp);
	}
	for (int i = 0; i < cnt; i++)
	{
		cin >> temp;
		b.push_back(temp);
	}
	sort(a.begin(), a.end());
	sort(b.begin(), b.end());
	int sum = 0;
	int size = a.size();
	for (int i = 0; i < size; i++)
		sum += a[i] * b[size - i - 1];

	cout << sum;
	return 0;
}