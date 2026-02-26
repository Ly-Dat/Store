#include <bits/stdc++.h>

using namespace std;
struct item
{
    int w;
    int v;
    int t = false;
};

void enter(int &n, int &w, int &h, vector < item > &items)
{
    cin >> n >> w >> h;

    items.resize(n + 1);
    for (int i = 1; i <= n; ++i)
        cin >> items[i].w >> items[i].v;
}

void trace_back(int n, int w, int h, vector < int > &dp, vector < item> &items)
{
    vector < int > chosen_times(n + 1, 0);
    while (w != 0)
    {
        for (int i = 1; i <= n; ++i)
            if (dp[w] == dp[w - items[i].w] + items[i].v)
            {
                w -= items[i].w;
                ++chosen_times[i];
                break;
            }
    }

    for (int e: chosen_times)
        cout << e << ' ';
}

void solution(int n, int w, int h, vector < item > items)
{
    vector < int > dp(w + 1, 0);
    for (int i = 0; i <= w; ++i)
        for (int j = 1; j <= n; ++j)
            if (i >= items[j].w)
                dp[i] = max(dp[i], dp[i - items[j].w] + items[j].v);

    cout << dp[w] << endl;
    trace_back(n, w, h, dp, items);
}

main()
{
    int n, w, h;
    vector < item> items;

    enter(n, w, h, items);
    solution(n, w, h, items);
}
