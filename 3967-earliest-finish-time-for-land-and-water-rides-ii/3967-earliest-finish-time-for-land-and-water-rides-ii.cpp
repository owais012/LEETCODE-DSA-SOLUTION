class Solution {
public:
    int earliestFinishTime(vector<int>& lst, vector<int>& ld, vector<int>& wst, vector<int>& wd) {
        //for the given choice
        //i have to find the best answer in 
        //for each time, we try to check if it is possible to end this here 
        int land = INT_MAX, water = INT_MAX, land_water = INT_MAX, water_land = INT_MAX;
        int n = lst.size(), m = wst.size();
        for(int i = 0; i < n; i++){
            land = min(land, lst[i]+ld[i]);
        } 
        for(int i = 0; i < m; i++){
            water = min(water, wst[i]+wd[i]);
            land_water = min(land_water, (land >= wst[i] ? land+ wd[i] : wst[i]+wd[i]));
        }

        for(int i = 0; i < n; i++){
            water_land = min(water_land,  (water >= lst[i] ? water + ld[i] : lst[i]+ld[i]));
        }

        return min(water_land, land_water);
    }
};