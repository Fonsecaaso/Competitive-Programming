class Solution {
public:
    typedef pair<double, vector<int>> p;
    
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        vector<vector<int>> vec;
        priority_queue<p, vector<p>, greater<p> > p1;
        for(int i=0; i<points.size(); i++){
            double distance = sqrt(points[i][0]*points[i][0] + points[i][1]*points[i][1]);
            //printf("%d ", distance);
            p1.push(make_pair(distance, points[i]));
        }
        int i=0;
        while (i<k) {
            vector<int> n = p1.top().second;
            vec.push_back(n);
            p1.pop();
            i++;
        }
        return vec;
    }
};



// 1. catch a point (x,y)
// 2. calculate the distance to the origin
// 3. create a pair <distance, [x,y]> 
// 4. insert this pair in a priority queue
// 5. return the k first elements from this priority queue
